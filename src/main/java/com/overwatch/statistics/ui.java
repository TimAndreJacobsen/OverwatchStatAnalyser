package com.overwatch.statistics;

import com.overwatch.statistics.filehandler.ExcelReader;

import java.io.IOException;

public class ui {

    private ExcelReader excelReader;

    protected void run() {
        initializeReader();
        excelReader.readWorkbook();
        //ChartRender skillRatingOverRounds = new ChartRender();
        //skillRatingOverRounds.setUI(this);
        //skillRatingOverRounds.main();
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

    public ExcelReader getExcelReader() {
        return excelReader;
    }



}
