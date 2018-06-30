package com.overwatch.statistics.gameround.logic;

import com.overwatch.statistics.gameround.GameRound;
import com.overwatch.statistics.gameround.model.Champion;
import com.overwatch.statistics.gameround.model.Map;

import java.util.List;
import java.util.Set;

public class Logic {

    // REQUIRES: gameRounds != null
    // MODIFIES: gameRound in gameRounds
    // EFFECTS : calculate change in skill rating from the round
    public void calculateSkillRatingChange(List<GameRound> gameRounds) {
        for (int i = 1; i < gameRounds.size(); i++) {
            int previousRound = gameRounds.get(i - 1).getSkillRating();
            int thisRound = gameRounds.get(i).getSkillRating();
            gameRounds.get(i).setSkillRatingChange(thisRound - previousRound);
        }
    }

    // REQUIRES: champions != null
    // MODIFIES: Champion.totalWinRate for each in champions
    // EFFECTS : calculates and sets total win rate for each champion
    public void calculateTotalWinRate(Set<Champion> champions, List<GameRound> gameRounds) {
        for (Champion c : champions) {
            c.setWinRate(calculateTotalWinRates(c, gameRounds));
        }
    }

    public double calculateTotalWinRates(Champion c, List<GameRound> gameRounds) {
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
        return (double) roundsWon / roundsPlayed;
    }

    public double calculateWinRatesEachMap(Champion c, Map m, List<GameRound> gameRounds) {
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
        return (double) roundsWon/ roundsPlayed;
    }

    public void calculateWinRateEachMapAllChampions(Set<Champion> champions, Set<Map> maps, List<GameRound> gameRounds) {
        for (Champion c : champions) {

            for (Map m : maps) {
                double winRate = calculateWinRatesEachMap(c, m, gameRounds);
                c.getWinRateEachMap().put(m, winRate);
            }
        }
    }



    // Helper method for calculateTotalWinRate()
}
