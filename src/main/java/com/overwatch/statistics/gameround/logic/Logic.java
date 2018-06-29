package com.overwatch.statistics.gameround.logic;

import com.overwatch.statistics.gameround.GameRound;
import com.overwatch.statistics.gameround.model.Champion;
import com.overwatch.statistics.gameround.model.Map;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Logic {

    private List<GameRound> gameRounds;
    private Set<Map> maps;
    private Set<Champion> champions;

    // Setters
    public void setMapSet(HashSet<Map> mapList) {
        this.maps = mapList;
    }
    public void setChampionSet(HashSet<Champion> championList) {
        this.champions = championList;
    }

    public void setGameRounds(List<GameRound> gameRounds) {
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
