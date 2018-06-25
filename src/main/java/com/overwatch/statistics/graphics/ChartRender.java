package com.overwatch.statistics.graphics;

import com.overwatch.statistics.gamesession.GameRound;
import javafx.application.Application;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.List;


public class ChartRender extends Application {
    private List<GameRound> gameRounds;
    private com.overwatch.statistics.ui ui;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Line Chart");

        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Game rounds played");
        yAxis.setLabel("SR rating");

        //creating the chart
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);

        lineChart.setTitle("SR over game rounds");

        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Skill rating");

        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 45));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));
//
//        this.gameRounds = ui.getExcelReader().getGameRounds();
//        for (int i = 0; i < gameRounds.size(); i++) {
//            GameRound g = gameRounds.get(i);
//            series.getData().add(new XYChart.Data(i, g.getSkillRating()));
//        }
//        Scene scene  = new Scene(lineChart,800,600);
//        lineChart.getData().add(series);
//
//        stage.setScene(scene);
//        stage.show();
}

    public void main() {
        launch();
    }

    public void setUI(com.overwatch.statistics.ui ui) {
        this.ui = ui;
    }
}