package com.overwatch.statistics.gamesession;

public class GameRound {

    private int skillRating;
    private String champion;
    private boolean isWin;
    private String mapName;
    private String mapType;
    private String date;
    private String audioType;

    public GameRound() {
        this.skillRating = -1;
        this.champion = "";
        this.isWin = false;
        this.mapName = "";
        this.mapType = "";
        this.date = "";
        this.audioType = "";
    }


    // Getters
    public int getSkillRating() {
        return skillRating;
    }
    public String getChampion() {
        return champion;
    }
    public boolean isWin() {
        return isWin;
    }
    public String getMapName() {
        return mapName;
    }
    public String getMapType() {
        return mapType;
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
    public void setChampion(String champion) {
        this.champion = champion;
    }
    public void setWin(boolean win) {
        isWin = win;
    }
    public void setMapName(String mapName) {
        this.mapName = mapName;
    }
    public void setMapType(String mapType) {
        this.mapType = mapType;
    }
    public void setAudioType(String audioType) {
        this.audioType = audioType;
    }
    public void setDate(String text) {
        this.date = text;
    }

//    public void setSkillRatingAfter(int skillRatingAfter) {
//        this.skillRatingAfter = skillRatingAfter;
//    }
//    public void setSkillRatingDelta(int skillRatingDelta) {
//        this.skillRatingDelta = skillRatingDelta;
//    }


}
