package com.overwatch.statistics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class App extends Application {

    private static ui ui = new ui();

    public static void main(String[] args ) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Overwatch Statistical analysis utility");

        // Layout
        BorderPane root = new BorderPane();

        // initializing
        ui.initialize();

        // Adding all elements
        root.setTop(addHBox(root));

        primaryStage.setScene(new Scene(root, 900, 720));
        primaryStage.show();
    }

    private HBox addHBox(BorderPane root) {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #205090;");

        // Button 1 - LineChart
        Button buttonShowLineChart = new Button();
        buttonShowLineChart.setPrefSize(200, 20);
        buttonShowLineChart.setText("Skill rating");
        buttonShowLineChart.setOnAction(event -> renderLineChart(root));

        // Button 2 - BarChart
        Button buttonShowBarChart = new Button();
        buttonShowBarChart.setPrefSize(200, 20);
        buttonShowBarChart.setText("Support win rate by map");
        buttonShowBarChart.setOnAction(event -> renderBarChart(root));

        // Add all elements to HXBox - Top of screen
        hbox.getChildren().addAll(buttonShowLineChart, buttonShowBarChart);

        return hbox;
    }

    private void renderLineChart(BorderPane root) {
        LineChart lineChart = ui.generateLineChart();
        root.setCenter(lineChart);
    }

    private void renderBarChart(BorderPane root) {
        BarChart barChart = ui.generateBarChart();
        root.setCenter(barChart);
    }

}