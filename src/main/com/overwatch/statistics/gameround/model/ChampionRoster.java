package com.overwatch.statistics.gameround.model;

import java.util.HashSet;
import java.util.Set;

public class ChampionRoster {

    private Set<Champion> champions = new HashSet<>();
    private Set<Map> maps = new HashSet<>();

    // Getters
    public Set<Champion> getChampions() {
        return champions;
    }
    public Set<Map> getMaps() {
        return maps;
    }

    // Setters
    public void setMaps(Set<Map> maps) {
        this.maps = maps;
    }

    // populate Champions set
    public void addChampionsToList() {
        Champion ana = new Champion("Ana", "Support", maps);
        Champion brigitte = new Champion("Brigitte", "Support", maps);
        Champion zenyatta = new Champion("Zenyatta", "Support", maps);
        Champion other = new Champion("Other", "Other", maps);

        champions.add(ana);
        champions.add(brigitte);
        champions.add(zenyatta);
        champions.add(other);
    }
}
