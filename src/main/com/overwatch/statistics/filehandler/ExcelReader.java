package com.overwatch.statistics.filehandler;

import com.overwatch.statistics.gameround.GameRound;
import com.overwatch.statistics.gameround.model.Champion;
import com.overwatch.statistics.gameround.model.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

public class ExcelReader {

    private XSSFWorkbook workbook;
    private ArrayList<GameRound> gameRounds = new ArrayList<>();
    private Set<Champion> champions;
    private Set<Map> maps;
    private final String PATH;

    // REQUIRES: .xlsx document at correct path
    // MODIFIES: this
    // EFFECTS : Initializes Workbook and reads document
    public ExcelReader() throws IOException {
        PATH = "C:/Users/Desktop/Desktop/div/OverwatchS11.xlsx";
        System.out.println("loading file:" + PATH);
        this.workbook = new XSSFWorkbook(new FileInputStream(PATH));
        System.out.println("file loaded");

    }

    // Getters
    public ArrayList<GameRound> getGameRounds() {
        return gameRounds;
    }

    // Setters
    public void setChampions(Set<Champion> champions) {
        this.champions = champions;
    }
    public void setMaps(Set<Map> maps) {
        this.maps = maps;
    }

    // REQUIRES: Workbook initialized, Workbook has read file
    // MODIFIES: gameRounds
    // EFFECTS : parses file and populates gameRounds with data
    public void readWorkbook() {
        DataFormatter formatter = new DataFormatter();
        Sheet sheet = workbook.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue; // Row 0 contains table headers
            }
            gameRounds.add(new GameRound());

            for (Cell cell : row) {
                String text = formatter.formatCellValue(cell);
                int rowIndex = row.getRowNum() - 1;

                switch (cell.getColumnIndex()) {

                    case 0: // Current Skill Rating
                        gameRounds.get(rowIndex).setSkillRating(Integer.parseInt(text));
                        break;
                    case 1: // Champion Name
                        for (Champion c : champions) {
                            if (text.equalsIgnoreCase(c.getName())) {
                                gameRounds.get(rowIndex).setChampion(c);
                                break;
                            }
                        }
                        break;
                    case 2: // Win or Loss
                        if (text.equalsIgnoreCase("win")) {
                            gameRounds.get(rowIndex).setIsWin(true);
                        } else {
                            gameRounds.get(rowIndex).setIsWin(false);
                            break;
                        }
                    case 3: // Map
                        for (Map m : maps) {
                            if (text.equalsIgnoreCase(m.getName())) {
                                gameRounds.get(rowIndex).setMap(m);
                                break;
                            }
                        }
                    case 5: // Date
                        gameRounds.get(rowIndex).setDate(text);
                        break;
                }
            }
        }
        System.out.print("Total games: ");
        System.out.println(gameRounds.size());
    }
}
