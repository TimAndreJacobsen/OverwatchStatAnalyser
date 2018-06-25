package com.overwatch.statistics.filehandler;

import com.overwatch.statistics.gamesession.GameRound;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelReader {

    private XSSFWorkbook workbook;
    private ArrayList<GameRound> gameRounds = new ArrayList<>();


    // Getters
    public ArrayList<GameRound> getGameRounds() {
        return gameRounds;
    }


    //REQUIRES: -
    //MODIFIES: this
    //EFFECTS : loads the workbook into memory
    public ExcelReader() throws IOException {
        System.out.println("loading file...");
        this.workbook = new XSSFWorkbook(new FileInputStream("C:/Users/Desktop/Desktop/OverwatchS10.xlsx"));
        System.out.println("file loaded");
    }

    //REQUIRES: workbook set through class constructor
    //MODIFIES: GameRound objects, gameRounds list
    //EFFECTS : iterates over cells and stores values into gameSession Objects. Creating new
    public void readWorkbook() {
        DataFormatter formatter = new DataFormatter();
        Sheet sheet1 = workbook.getSheetAt(0);

        for (Row row : sheet1) {

            if (row.getRowNum() == 0) {
                continue; //just skip the row if row number is 0
            }
            gameRounds.add(new GameRound());

            for (Cell cell : row) {
                System.out.println("Cell Address: " + cell.getAddress());
                String text = formatter.formatCellValue(cell);
                int gameRoundIndex = row.getRowNum() - 1;

                switch (cell.getColumnIndex()) {
                    case 0:
                        System.out.println();
                        gameRounds.get(gameRoundIndex).setSkillRating(Integer.parseInt(text));
                        break;
                    case 1:
                        gameRounds.get(gameRoundIndex).setChampion(text);
                        break;
                    case 2:
                        if (text.equalsIgnoreCase("win")) {
                            gameRounds.get(gameRoundIndex).setWin(true);
                        }
                            gameRounds.get(gameRoundIndex).setWin(false);
                        break;
                    case 3:
                        gameRounds.get(gameRoundIndex).setMapName(text);
                        break;
                    case 4:
                        gameRounds.get(gameRoundIndex).setMapType(text);
                        break;
                    case 5:
                        gameRounds.get(gameRoundIndex).setDate(text);
                    case 6:
                        gameRounds.get(gameRoundIndex).setAudioType(text);
                        break;
                }
            }
        }
    }


}
