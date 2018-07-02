package com.overwatch.statistics.graphics;

import com.overwatch.statistics.gameround.GameRound;
import com.overwatch.statistics.gameround.model.Champion;
import com.overwatch.statistics.gameround.model.Map;
import javafx.scene.chart.*;

import java.util.List;
import java.util.Set;


public class ChartRenderer {

    private List<GameRound> gameRounds;

    public ChartRenderer(List<GameRound> gameRounds) {
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
        LineChart chart = new LineChart<>(xAxis, yAxis);
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        // Initializing variables to be used in the for each loop
        String dateTime;
        Integer skillRating;
        Integer i = 1;

        for (GameRound round : gameRounds) {
            dateTime = i.toString();
            skillRating = round.getSkillRating();
            series.getData().add(new XYChart.Data<>(dateTime, skillRating));
            i++;
        }
        chart.getData().add(series);

        return chart;
    }

    public BarChart getSupportWinRateByMap(Set<Champion> champions, Set<Map> maps) {
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Map Name");
        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Win %");
        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Win Rate of Champions by Map");

        for (Champion c : champions) {
            if (!c.getRole().equals("Support")) {
                continue; // Trimming away champions that are not supports
            }
            XYChart.Series seriesBuffer = new XYChart.Series();
            seriesBuffer.setName(c.getName());

            for (Map m : maps) {
                seriesBuffer.getData().add(new XYChart.Data(m.getName(), c.getWinRateEachMap().get(m)));
            }
            barChart.getData().add(seriesBuffer);
        }
        return barChart;
    }
}