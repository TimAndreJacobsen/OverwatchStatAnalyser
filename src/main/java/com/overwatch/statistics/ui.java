package com.overwatch.statistics;

import com.overwatch.statistics.filehandler.ExcelReader;
import com.overwatch.statistics.gameround.GameRound;
import com.overwatch.statistics.gameround.logic.Logic;
import com.overwatch.statistics.graphics.ChartRender;
import javafx.scene.chart.LineChart;

import java.io.IOException;
import java.util.List;

public class ui {

    private ExcelReader excelReader;
    private ChartRender chartRender;
    private Logic logic;
    private List<GameRound> gameRounds;

    // Getters
    public ExcelReader getExcelReader() {
        return excelReader;
    }

    public ChartRender getChartRender() {
        return chartRender;
    }

    protected void initialize() {

        //Initialize Reader
        initializeReader();
        //Initialize Map and Champion types
        excelReader.addMapsToList();
        excelReader.addChampionsToList();

        excelReader.readWorkbook();
        gameRounds = excelReader.getGameRounds();

        // Initialize logic
        Logic logic = new Logic();
        logic.setGameRounds(gameRounds);
        logic.calculateSkillRatingChange();
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
