package com.overwatch.statistics.graphics;

import com.overwatch.statistics.gameround.GameRound;
import com.overwatch.statistics.gameround.logic.Logic;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import java.util.List;


public class ChartRenderer {

    private List<GameRound> gameRounds;
    private Logic logic;

    public ChartRenderer(List<GameRound> gameRounds) {
        this.gameRounds = gameRounds;
    }

    public void setGameRounds(List<GameRound> gameRounds) {
        this.gameRounds = gameRounds;
    }

    //TODO: Create overloaded methods to be able to generate charts for all possible values?
    public LineChart<String, Number> getSkillOverRoundsPlayed() {
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

//    public BarChart getSupportWinRateByMap() {
//        CategoryAxis xAxis = new CategoryAxis();
//        xAxis.setLabel("Map Name");
//        NumberAxis yAxis = new NumberAxis();
//        yAxis.setLabel("Win %");
//        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
//
//        barChart.setTitle("Win Rate of Champions by Map");
//
//        // initialize stuff for passing to logic module
//        Map<String, Double> supports = new HashMap<>();
//        supports.add("Ana", );
//        supports.add("Brigitte");
//        supports.add("Zenyatta");
//
//        for (String s : supports) {
//            logic.calculateWinRate(map, champ);
//        }
//
//
//        XYChart.Series series1 = new XYChart.Series();
//        series1.setName("Ana");
//
//        for (GameRound round : gameRounds) {
//            series1.getData().add(new XYChart.Data("Volskaya", 25601.34));
//
//        }
//
//
//        series1.getData().add(new XYChart.Data("Hollywood", 20148.82));
//        series1.getData().add(new XYChart.Data(france, 10000));
//        series1.getData().add(new XYChart.Data(italy, 35407.15));
//        series1.getData().add(new XYChart.Data(usa, 12000));
//
//        XYChart.Series series2 = new XYChart.Series();
//        series2.setName("Brigitte");
//        series2.getData().add(new XYChart.Data(austria, 57401.85));
//        series2.getData().add(new XYChart.Data(brazil, 41941.19));
//        series2.getData().add(new XYChart.Data(france, 45263.37));
//        series2.getData().add(new XYChart.Data(italy, 117320.16));
//        series2.getData().add(new XYChart.Data(usa, 14845.27));
//
//        XYChart.Series series3 = new XYChart.Series();
//        series3.setName("Zenyatta");
//        series3.getData().add(new XYChart.Data(austria, 45000.65));
//        series3.getData().add(new XYChart.Data(brazil, 44835.76));
//        series3.getData().add(new XYChart.Data(france, 18722.18));
//        series3.getData().add(new XYChart.Data(italy, 17557.31));
//        series3.getData().add(new XYChart.Data(usa, 92633.68));
//
//        barChart.getData().addAll(series1, series2, series3);
//        return barChart;
//    }
}