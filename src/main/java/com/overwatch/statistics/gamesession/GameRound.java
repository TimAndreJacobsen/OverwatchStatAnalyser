package com.overwatch.statistics.gamesession;

public class GameRound {

    private int skillRating;
    private String champion;
    private boolean isWin;
    private String mapName;
    private String mapType;
    //private Date date;
    private String audioType;
    private int beerCount;

    public GameRound() {
        this.skillRating = -1;
        this.champion = "";
        this.isWin = false;
        this.mapName = "";
        this.mapType = "";
        //this.date = today;
        this.audioType = "";
        this.beerCount = -1;
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

    public int getBeerCount() {
        return beerCount;
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
    public void setBeerCount(int beerCount) {
        this.beerCount = beerCount;
    }
//    public void setSkillRatingAfter(int skillRatingAfter) {
//        this.skillRatingAfter = skillRatingAfter;
//    }
//    public void setSkillRatingDelta(int skillRatingDelta) {
//        this.skillRatingDelta = skillRatingDelta;
//    }
}
