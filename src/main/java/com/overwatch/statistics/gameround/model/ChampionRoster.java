package com.overwatch.statistics.gameround.model;

import java.util.HashSet;
import java.util.Set;

public class ChampionRoster {

    private Set<Champion> champions = new HashSet<>();
    private Champion ana = new Champion("Ana", "Support");
    private Champion brigitte = new Champion("Brigitte", "Support");
    private Champion zenyatta = new Champion("Zenyatta", "Support");
    private Champion mix = new Champion("unknown", "unknown");

    // Getters
    public Set<Champion> getChampions() {
        return champions;
    }

    // populate Champions set
    public void addChampionsToList() {
        champions.add(ana);
        champions.add(brigitte);
        champions.add(zenyatta);
        champions.add(mix);

    }
}
