package com.overwatch.statistics.gameround;

import com.overwatch.statistics.gameround.model.Champion;
import com.overwatch.statistics.gameround.model.Map;

public class GameRound {

    private int skillRatingChange;
    private int skillRating;
    private boolean isWin;
    private String date;
    private String audioType;
    private Map map;
    private Champion champion;

    public GameRound() {
        this.skillRating = -1;
        this.champion = null;
        this.isWin = false;
        this.map = null;
        this.date = "";
        this.audioType = "";
        this.skillRatingChange = 0;
    }

    public GameRound(Champion c, Map m, boolean isWin) {
        this.skillRating = -1;
        this.champion = c;
        this.isWin = isWin;
        this.map = m;
        this.date = "";
        this.audioType = "";
        this.skillRatingChange = 0;
    }

    // Getters
    public int getSkillRating() {
        return skillRating;
    }
    public Champion getChampion() {
        return this.champion;
    }
    public boolean isWin() {
        return isWin;
    }
    public Map getMap() {
        return map;
    }
    public String getAudioType() {
        return audioType;
    }
    public String getDate() {
        return this.date;
    }

    // Setters
    public void setSkillRating(int skillRating) {
        this.skillRating = skillRating;
    }
    public void setChampion(Champion champion) {
        this.champion = champion;
    }
    public void setIsWin(boolean win) {
        isWin = win;
    }
    public void setMap(Map map) {
        this.map = map;
    }
    public void setAudioType(String audioType) {
        this.audioType = audioType;
    }
    public void setDate(String text) {
        this.date = text;
    }
    public void setSkillRatingChange(int skillRatingChange) {
        this.skillRatingChange = skillRatingChange;
    }

}
