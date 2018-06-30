package com.overwatch.statistics.gameround.logic;

import com.overwatch.statistics.gameround.GameRound;
import com.overwatch.statistics.gameround.model.Champion;
import com.overwatch.statistics.gameround.model.Map;

import java.util.List;
import java.util.Set;

public class Logic {

    private List<GameRound> gameRounds;
    private Set<Map> maps;
    private Set<Champion> champions;

    // Setters
    public void setMaps(Set<Map> maps) {
        this.maps = maps;
    }
    public void setChampions(Set<Champion> champions) {
        this.champions = champions;
    }
    public void setGameRounds(List<GameRound> gameRounds) {
        this.gameRounds = gameRounds;
    }

    // REQUIRES: gameRounds != null
    // MODIFIES: gameRound in gameRounds
    // EFFECTS : calculate change in skill rating from the round
    public void calculateSkillRatingChange() {
        for (int i = 1; i < gameRounds.size(); i++) {
            int previousRound = gameRounds.get(i - 1).getSkillRating();
            int thisRound = gameRounds.get(i).getSkillRating();
            gameRounds.get(i).setSkillRatingChange(thisRound - previousRound);
        }
    }

    // REQUIRES: champions != null
    // MODIFIES: Champion.totalWinRate for each in champions
    // EFFECTS : calculates and sets total win rate for each champion
    public void calculateTotalWinRate() {
        for (Champion c : champions) {
            c.setWinRate(calculateTotalWinRates(c));
        }
    }

    private double calculateTotalWinRates(Champion c) {
        int roundsPlayed = 0;
        int roundsWon = 0;

        for (GameRound r : gameRounds) {
            if (c == r.getChampion()) {
                roundsPlayed++;
                if (r.isWin()) {
                    roundsWon++;
                }
            }
        }
        if (roundsPlayed == 0 || roundsWon == 0) {
            return 0.0;
        }
        return roundsPlayed / roundsWon;
    }

    private double calculateTotalWinRates(Champion c, Map m) {
        int roundsPlayed = 0;
        int roundsWon = 0;

        for (GameRound r : gameRounds) {
            if (c == r.getChampion() && m == r.getMap()) {
                roundsPlayed++;
                if (r.isWin()) {
                    roundsWon++;
                }
            }
        }
        if (roundsPlayed == 0 || roundsWon == 0) {
            return 0.0;
        }
        return roundsPlayed / roundsWon;
    }

    public void calculateWinRatePerMap() {
        for (Champion c : champions) {

            for (Map m : maps) {
                double winRate = calculateTotalWinRates(c, m);
                c.getWinRateEachMap().put(m, winRate);
            }
        }
    }



    // Helper method for calculateTotalWinRate()
}
