package com.overwatch.statistics;

import com.overwatch.statistics.filehandler.ExcelReader;
import com.overwatch.statistics.gameround.GameRound;
import com.overwatch.statistics.gameround.logic.Logic;
import com.overwatch.statistics.gameround.model.ChampionRoster;
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

    protected void run() {
        System.out.println("initializing");
        initializeReader();
        System.out.println("populating models");
        populateModels();
        loadData();
        parseFile();
        initializeLogic();
        computeData();
    }

    protected LineChart generateLineChart() {
        ChartRenderer lineChart = new ChartRenderer(gameRounds);
        return lineChart.getSkillOverRoundsPlayed();
    }

    protected BarChart generateBarChart(String role) {
        ChartRenderer barChart = new ChartRenderer(gameRounds);
        return barChart.getSupportWinRateByMap(championRoster.getChampions(), maps.getMaps());
    }

    private void initializeReader() {
        try {
            excelReader = new ExcelReader();
        } catch (IOException e) {
            System.out.println("File not found...");
            e.printStackTrace();
        }
    }

    private void populateModels() {
        maps.addMapsToList();
        championRoster.setMaps(maps.getMaps());
        championRoster.addChampionsToList();
    }

    private void loadData() {
        // Load data
        excelReader.setMaps(maps.getMaps());
        excelReader.setChampions(championRoster.getChampions());
    }

    private void parseFile() {
        excelReader.readWorkbook();
        gameRounds = excelReader.getGameRounds();
    }

    private void initializeLogic() {
        logic = new Logic();
    }

    private void computeData() {
        logic.calculateSkillRatingChange(gameRounds);
        logic.calculateTotalWinRate(championRoster.getChampions(), gameRounds);
        logic.calculateWinRates(championRoster.getChampions(), maps.getMaps(), gameRounds);
    }

  }
