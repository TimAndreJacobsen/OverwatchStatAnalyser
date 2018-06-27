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
import java.util.List;

public class ExcelReader {

    private XSSFWorkbook workbook;
    private ArrayList<GameRound> gameRounds = new ArrayList<>();

    // TODO: refactor this out of excelreader and into a new class Champions
    private List<Champion> champions = new ArrayList<>();
    private Champion ana = new Champion("Ana", "Support");
    private Champion brigitte = new Champion("Brigitte", "Support");
    private Champion zenyatta = new Champion("Zenyatta", "Support");
    private Champion mix = new Champion("unknown", "unknown");

    // TODO: refactor this out of excelreader and into a new class Maps
    private List<Map> maps = new ArrayList<>();
    private Map blizzardWorld = new Map("Blizzard World", "Hybrid Payload");
    private Map dorado = new Map("Dorado", "Payload");
    private Map eichenwalde = new Map("Eichenwalde", "Hybrid Payload");
    private Map hanamura = new Map("Hanamura", "2 Capture Points");
    private Map junkertown = new Map("Junkertown", "Payload");
    private Map kingsRow = new Map("Kings Row", "Hybrid Payload");
    private Map liangTowers = new Map("Liang Towers", "King of the Hill");
    private Map lunarColony = new Map("Lunar Colony", "2 Capture Points");
    private Map nepal = new Map("Nepal", "King of the Hill");
    private Map rialto = new Map("Rialto", "Payload");
    private Map route66 = new Map("Route 66", "Payload");
    private Map templeOfAnubis = new Map("Temple of Anubis", "2 Capture Points");
    private Map volskayaIndustries = new Map("Volskaya Industries", "2 Capture Points");


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
    public List<Champion> getChampions(List<Champion> champions) {
        return champions;
    }
    public List<Map> getMaps(List<Map> maps) {
        return maps;
    }

    // populate list
    // TODO: refactor this out of excelreader and into a new class Champions
    public void addChampionsToList() {
        champions.add(ana);
        champions.add(brigitte);
        champions.add(zenyatta);
        champions.add(mix);
    }
    // TODO: refactor this out of excelreader and into a new class Maps
    public void addMapsToList() {
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


    //TODO: refactor parts of this method out of ExcelReader. Currently its both reading and assigning, can this be split up?
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
