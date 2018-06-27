package com.overwatch.statistics;

import com.overwatch.statistics.filehandler.ExcelReader;
import com.overwatch.statistics.gameround.GameRound;
import com.overwatch.statistics.gameround.logic.Logic;
import com.overwatch.statistics.gameround.model.Champion;
import com.overwatch.statistics.gameround.model.Map;
import com.overwatch.statistics.graphics.ChartRender;
import javafx.scene.chart.LineChart;

import java.io.IOException;
import java.util.List;

public class ui {

    private ExcelReader excelReader;
    private ChartRender chartRender;
    private List<GameRound> gameRounds;
    private Logic logic;
    private List<Map> maps;
    private List<Champion> champions;


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
        excelReader.readWorkbook();
        gameRounds = excelReader.getGameRounds();

        //Initialize Map and Champion types
        initializeMaps();
        initializeChampions();

        // Initialize logic
        Logic logic = new Logic();
        loadData();



    }

    private void loadData() {
        logic.loadGameRounds(gameRounds);
        logic.setChampionList(champions);
        logic.setMapList(maps);
        logic.calculateSkillRatingChange();
    }

    private void initializeChampions() {
        Champion ana = new Champion("Ana", "Support");
        Champion brigitte = new Champion("Brigitte", "Support");
        Champion zenyatta = new Champion("Zenyatta", "Support");

        champions.add(ana);
        champions.add(brigitte);
        champions.add(zenyatta);
    }

    private void initializeMaps() {
        Map blizzardWorld = new Map("Blizzard World", "Hybrid Payload");
        Map dorado = new Map("Dorado", "Payload");
        Map eichenwalde = new Map("Eichenwalde", "Hybrid Payload");
        Map hanamura = new Map("Hanamura", "2 Capture Points");
        Map junkertown = new Map("Junkertown", "Payload");
        Map kingsRow = new Map("Kings Row", "Hybrid Payload");
        Map liangTowers = new Map("Liang Towers", "King of the Hill");
        Map lunarColony = new Map("Lunar Colony", "2 Capture Points");
        Map nepal = new Map("Nepal", "King of the Hill");
        Map rialto = new Map("Rialto", "Payload");
        Map route66 = new Map("Route 66", "Payload");
        Map templeOfAnubis = new Map("Temple of Anubis", "2 Capture Points");
        Map volskayaIndustries = new Map("Volskaya Industries", "2 Capture Points");

        maps.add(blizzardWorld);
        maps.add(dorado);
        maps.add(eichenwalde);
        maps.add(hanamura);
        maps.add(junkertown);
        maps.add(kingsRow);
        maps.add(liangTowers);
        maps.add(lunarColony);
        maps.add(nepal);
        maps.add(rialto);
        maps.add(route66);
        maps.add(templeOfAnubis);
        maps.add(volskayaIndustries);
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

    private ExcelReader initializeReader() {
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
