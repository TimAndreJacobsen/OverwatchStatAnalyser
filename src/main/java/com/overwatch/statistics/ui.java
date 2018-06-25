package com.overwatch.statistics;

import com.overwatch.statistics.filehandler.ExcelReader;
import com.overwatch.statistics.gamesession.GameRound;
import com.overwatch.statistics.graphics.ChartRender;
import javafx.scene.chart.LineChart;

import java.io.IOException;
import java.util.List;

public class ui {

    private ExcelReader excelReader;
    private ChartRender chartRender;
    private List<GameRound> gameRounds;


    // Getters
    public ExcelReader getExcelReader() {
        return excelReader;
    }
    public ChartRender getChartRender() {
        return chartRender;
    }

    //TODO: Change to initialize
    //TODO: Factor out lineChart initialization and creation.
    protected LineChart run() {
        initializeReader();
        excelReader.readWorkbook();
        gameRounds = excelReader.getGameRounds();
        ChartRender chartRender = new ChartRender(gameRounds);
        LineChart<String, Number> skillOverTime = chartRender.getSkillOverTime();
        return skillOverTime;
    }

    //TODO: Create generic chartRenderer that takes 2 params: X, Y axis values
    public void createLineChart() {
    }

    private ExcelReader initializeReader() {
        System.out.println("initializing reader");
        try {
            excelReader = new ExcelReader();
        } catch (IOException e) {
            System.out.println("File not found...");
            e.printStackTrace();
        }
        System.out.println("file loaded successfully");
        return excelReader;
    }


}
