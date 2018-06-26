package com.overwatch.statistics.gameround.logic;

import com.overwatch.statistics.gameround.GameRound;

import java.util.List;

public class Logic {

    private List<GameRound> gameRounds;

    public void loadGameRounds(List<GameRound> gameRounds) {
        this.gameRounds = gameRounds;
    }

    public void calculateSkillRatingChange() {
        for (int i = 1; i < gameRounds.size(); i++) {
            int previousRound = gameRounds.get(i-1).getSkillRating();
            int thisRound = gameRounds.get(i).getSkillRating();
            gameRounds.get(i).setSkillRatingChange(thisRound - previousRound);
        }
    }

//    public double calculateWinRate(String map, String champ) {
//
//        for (Object o : ) {
//
//        }
//
//        return 0.5;
//    }
}
