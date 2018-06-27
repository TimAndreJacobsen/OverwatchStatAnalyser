package com.overwatch.statistics.gameround.model;

public class Map {

    private String name;
    private String type;

    public Map(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setType(String type) {
        this.type = type;
    }

}
