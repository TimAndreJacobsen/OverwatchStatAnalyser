package com.overwatch.statistics;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
        LineChart chart = ui.generateLineChart();

        // Adding all elements
        root.setLeft(addVBox());
        root.setTop(addHBox(root, chart));

        primaryStage.setScene(new Scene(root, 900, 720));
        primaryStage.show();
    }

    private HBox addHBox(BorderPane root, LineChart chart) {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 12, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");


        // Button 1
        Button btn = new Button();
        btn.setPrefSize(100, 20);
        btn.setText("Render chart");
        btn.setOnAction(event -> root.setCenter(chart));


        hbox.getChildren().addAll(btn);

        return hbox;
    }

    private VBox addVBox() {
        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10));
        vbox.setSpacing(8);

        Text title = new Text("Filters");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        vbox.getChildren().add(title);

        Hyperlink options[] = new Hyperlink[] {
                new Hyperlink("Skill Rating"),
                new Hyperlink("Heroes"),
                new Hyperlink("Win Percent"),
                new Hyperlink("Time Played")};

        for (int i=0; i<4; i++) {
            VBox.setMargin(options[i], new Insets(0, 0, 0, 8));
            vbox.getChildren().add(options[i]);
        }
        return vbox;
    }


}