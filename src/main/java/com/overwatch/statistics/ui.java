package com.overwatch.statistics;

import com.overwatch.statistics.filehandler.ExcelReader;
import com.overwatch.statistics.gameround.GameRound;
import com.overwatch.statistics.gameround.logic.Logic;
import com.overwatch.statistics.gameround.model.Champion;
import com.overwatch.statistics.gameround.model.ChampionRoster;
import com.overwatch.statistics.gameround.model.Map;
import com.overwatch.statistics.gameround.model.Maps;
import com.overwatch.statistics.graphics.ChartRenderer;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;

import java.io.IOException;
import java.util.List;

public class ui {
    private ExcelReader excelReader;
    private ChartRenderer chartRender;
    private Logic logic;
    private List<GameRound> gameRounds;
    private Maps maps = new Maps();
    private ChampionRoster championRoster = new ChampionRoster();

    protected void initialize() {
        initializeReader();        // Initialize Reader
        populateModels();        // Initialize Map and Champion types
        readExcelWorkBook();        // Load data into excelReader
        initLogic();        // Initialize logic & load game data
        computeData();        // Calculate Champion data
        //printData();
    }

    public void printData() {
        for (Champion c : championRoster.getChampions()) {
            String winRateByMap = "";
            System.out.println("Champion: " + c.getName());
            for (Map m : maps.getMaps()) {
                winRateByMap += m.getName() + ": " + c.getWinRateEachMap().get(m).toString() + "\n";
                System.out.print(winRateByMap);
                winRateByMap = "";
            }
            System.out.println();
        }
    }

    protected LineChart generateLineChart() {
        ChartRenderer lineChart = new ChartRenderer(gameRounds);
        return lineChart.getSkillOverRoundsPlayed();
    }

    protected BarChart generateBarChart() {
        ChartRenderer barChart = new ChartRenderer(gameRounds);
        return barChart.getSupportWinRateByMap(championRoster.getChampions(), maps.getMaps());
    }

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

    private void populateModels() {
        maps.addMapsToList();
        championRoster.setMaps(maps.getMaps());
        championRoster.addChampionsToList();
    }

    private void readExcelWorkBook() {
        // Load data
        excelReader.setMaps(maps.getMaps());
        excelReader.setChampions(championRoster.getChampions());

        // Parse .xlsx file to ArrayList
        excelReader.readWorkbook();
        gameRounds = excelReader.getGameRounds();
    }

    private void initLogic() {
        logic = new Logic();
    }

    private void computeData() {
        logic.calculateSkillRatingChange(gameRounds);
        logic.calculateTotalWinRate(championRoster.getChampions(), gameRounds);
        logic.calculateWinRateEachMapAllChampions(championRoster.getChampions(), maps.getMaps(), gameRounds);
    }

  }
