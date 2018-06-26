package com.overwatch.statistics.gameround.logic;

import com.overwatch.statistics.gameround.GameRound;
import com.overwatch.statistics.gameround.model.Champion;
import com.overwatch.statistics.gameround.model.Map;

import java.util.List;

public class Logic {

    private List<GameRound> gameRounds;
    private List<Map> mapList;
    private List<Champion> championList;

    // Setters
    public void setMapList(List<Map> mapList) {
        this.mapList = mapList;
    }
    public void setChampionList(List<Champion> championList) {
        this.championList = championList;
    }

    public void loadGameRounds(List<GameRound> gameRounds) {
        this.gameRounds = gameRounds;
    }

    public void calculateSkillRatingChange() {
        for (int i = 1; i < gameRounds.size(); i++) {
            int previousRound = gameRounds.get(i - 1).getSkillRating();
            int thisRound = gameRounds.get(i).getSkillRating();
            gameRounds.get(i).setSkillRatingChange(thisRound - previousRound);
        }
    }

    public double calculateWinRate(String map, String champ) {
        int roundsPlayed = 0;
        int roundsWon = 0;

        for (GameRound r : gameRounds) {
            if (r.getMapName().equalsIgnoreCase(map)
                    && r.getChampion().equalsIgnoreCase(champ)) {

                roundsPlayed++;
                if (r.isWin()) {
                    roundsWon++;
                }
            }
        }
        return roundsPlayed / roundsWon;
    }


}
