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

    //REQUIRES: .xlsx document in correct hardcoded os address
    //MODIFIES: this
    //EFFECTS : loads the workbook into memory
    public ExcelReader() throws IOException {
        System.out.println("loading file...");
        this.workbook = new XSSFWorkbook(new FileInputStream("C:/Users/Desktop/Desktop/OverwatchS10.xlsx"));
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

    //TODO: refactor parts of this method. Currently its both reading and assigning, can this be split up into smaller components?
    //REQUIRES: workbook set through class constructor
    //MODIFIES: GameRound objects, gameRounds list
    //EFFECTS : iterates over cells and stores values into gameSession Objects. Creating new
    public void readWorkbook() {
        DataFormatter formatter = new DataFormatter();
        Sheet sheet1 = workbook.getSheetAt(0);

        for (Row row : sheet1) {
            if (row.getRowNum() == 0) {
                continue; //just skip the row if row number is 0, row number 0 only contains text headers
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
                        for (Champion c : champions) {
                            if (text.equalsIgnoreCase(c.getName())) {
                                gameRounds.get(gameRoundIndex).setChampion(c);
                            }
                        }
                        break;
                    case 2:
                        if (text.equalsIgnoreCase("win")) {
                            gameRounds.get(gameRoundIndex).setIsWin(true);
                        } else {
                            gameRounds.get(gameRoundIndex).setIsWin(false);
                            break;
                        }
                    case 3:
                        for (Map m : maps) {
                            if (text.equalsIgnoreCase(m.getName())) {
                                gameRounds.get(gameRoundIndex).setMap(m);
                            }
                        }
                    case 5:
                        gameRounds.get(gameRoundIndex).setDate(text);
                        break;
                    case 6:
                        gameRounds.get(gameRoundIndex).setAudioType(text);
                        break;
                }
            }
        }
    }
}
