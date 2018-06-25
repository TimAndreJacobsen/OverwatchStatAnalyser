package com.overwatch.statistics.graphics;

import com.overwatch.statistics.gamesession.GameRound;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.List;


public class ChartRender {

    private List<GameRound> gameRounds;

    public ChartRender(List<GameRound> gameRounds) {
        this.gameRounds = gameRounds;
    }


    public void setGameRounds(List<GameRound> gameRounds) {
        this.gameRounds = gameRounds;
    }

    //TODO: Create overloaded methods to be able to generate charts for all possible values?
    public LineChart<String, Number> getSkillOverTime() {
        // initializing and labeling the X and Y axis
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Time ->");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Skill Rating");

        // initializing chart and a data series
        LineChart chart = new LineChart<String, Number>(xAxis,yAxis);
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        // Initializing variables to be used in the for each loop
        String dateTime = "";
        Integer skillRating = 0;
        Integer i = 1;

        for (GameRound round : gameRounds) {
            dateTime = i.toString();
            skillRating = round.getSkillRating();
            series.getData().add(new XYChart.Data<String, Number>(dateTime, skillRating));
            i++;
        }
        chart.getData().add(series);

        return chart;
    }
}