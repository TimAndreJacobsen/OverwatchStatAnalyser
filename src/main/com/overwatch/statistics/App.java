package com.overwatch.statistics;

import javafx.application.Application;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class App extends Application {

    private static ui ui = new ui();
    private String role;
    public static void main(String[] args ) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Overwatch Statistical analysis utility");
        BorderPane root = new BorderPane();
        ui.run();

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
        buttonShowLineChart.setText("Skill Rating");
        buttonShowLineChart.setOnAction(event -> renderLineChart(root));


        // Button 2 - BarChart
        Button RenderChartByRole = new Button();
        RenderChartByRole.setPrefSize(200, 20);
        RenderChartByRole.setText("Render");
        RenderChartByRole.setOnAction(event -> renderBarChartOnSelection(root));

        // Dropdown 1 - ComboBox - Role selection
        ComboBox roleSelectionComboBox = new ComboBox();
        roleSelectionComboBox.getItems().addAll(
                "Support",
                "Tank",
                "DPS",
                "All Roles"
        );
        roleSelectionComboBox.setPromptText("Champion Role");
        roleSelectionComboBox.setEditable(true);
        roleSelectionComboBox.setOnAction((Event ev) -> {
            role = roleSelectionComboBox.getSelectionModel().getSelectedItem().toString();
        });
        roleSelectionComboBox.setValue("Pick a role");

        // Add all elements to HXBox - Top of screen
        hbox.getChildren().addAll(roleSelectionComboBox, buttonShowLineChart, RenderChartByRole);

        return hbox;
    }

    private void renderLineChart(BorderPane root) {
        LineChart lineChart = ui.generateLineChart();
        root.setCenter(lineChart);
    }

    private void renderBarChartOnSelection(BorderPane root) {
        BarChart barChart = ui.generateBarChartNEW(role);
        root.setCenter(barChart);
    }

}