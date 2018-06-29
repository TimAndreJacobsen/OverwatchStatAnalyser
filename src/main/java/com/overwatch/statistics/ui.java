package com.overwatch.statistics;

import com.overwatch.statistics.filehandler.ExcelReader;
import com.overwatch.statistics.gameround.GameRound;
import com.overwatch.statistics.gameround.logic.Logic;
import com.overwatch.statistics.gameround.model.ChampionRoster;
import com.overwatch.statistics.gameround.model.Maps;
import com.overwatch.statistics.graphics.ChartRender;
import javafx.scene.chart.LineChart;

import java.io.IOException;
import java.util.List;

public class ui {

    private ExcelReader excelReader;
    private ChartRender chartRender;
    private Logic logic;
    private List<GameRound> gameRounds;
    private Maps maps = new Maps();
    private ChampionRoster champions = new ChampionRoster();



    private void populateModels() {
        maps.addMapsToList();
        champions.setMaps(maps.getMaps());
        champions.addChampionsToList();
    }

    protected void initialize() {
        initializeReader();        // Initialize Reader
        populateModels();        // Initialize Map and Champion types
        readExcelWorkBook();        // Load data into excelReader
        initLogic();        // Initialize logic & load game data
        computeData();        // Calculate Champion data
    }

    private void computeData() {
        logic.calculateSkillRatingChange();
        logic.calculateTotalWinRate();
    }

    private void initLogic() {
        logic = new Logic();
        logic.setGameRounds(gameRounds);
        logic.setMaps(maps.getMaps());
        logic.setChampions(champions.getChampions());
    }

    private void readExcelWorkBook() {
        // Load data
        excelReader.setMaps(maps.getMaps());
        excelReader.setChampions(champions.getChampions());

        // Parse .xlsx file to ArrayList
        excelReader.readWorkbook();
        gameRounds = excelReader.getGameRounds();
    }

    protected LineChart generateLineChart() {
        ChartRender lineChart = new ChartRender(gameRounds);
        return lineChart.getSkillOverRoundsPlayed();
    }

    //TODO: Create generic chartRenderer that takes 2 params: X, Y axis values
//    public BarChart createBarChart(List<String> champion) {
//        ChartRender barChart = new ChartRender(gameRounds);
//        return barChart.getSupportWinRateByMap();
//    }

    private void initializeReader() {
        System.out.println("initializing reader");
        try {
            excelReader = new ExcelReader();
        } catch (IOException e) {
            System.out.println("File not found...");
            e.printStackTrace();
        }
        System.out.println("file loaded successfully");
    }

}
