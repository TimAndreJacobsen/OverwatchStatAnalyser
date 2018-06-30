package com.overwatch.statistics.gameround.model;

import java.util.HashMap;
import java.util.Set;

public class Champion {

    private String name;
    private String role;
    private double totalWinRate;

    private Set<Map> maps;
    private HashMap<Map, Double> winRateEachMap;

    public Champion(String name, String role, Set<Map> maps) {
        this.name = name;
        this.role = role;
        this.totalWinRate = 0;
        this.winRateEachMap = new HashMap<>();
        this.maps = maps;

        for (Map m : maps) {
            winRateEachMap.put(m, 0.0);
        }
    }
}
