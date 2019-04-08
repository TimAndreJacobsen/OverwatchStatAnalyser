package com.overwatch.statistics.gameround.model;

import java.util.HashSet;
import java.util.Set;

public class ChampionRoster {

    private Set<Champion> champions = new HashSet<>();
    private Set<Map> maps = new HashSet<>();

    private Champion ana = new Champion("Ana", "Support", maps);
    private Champion baptiste = new Champion("Baptiste", "Support", maps);
    private Champion lucio = new Champion("Lucio", "Support", maps);
    private Champion mercy = new Champion("Mercy", "Support", maps);
    private Champion moira = new Champion("Moira", "Support", maps);
    private Champion brigitte = new Champion("Brigitte", "Support", maps);
    private Champion zenyatta = new Champion("Zenyatta", "Support", maps);
    private Champion other = new Champion("Other", "Other", maps);

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
    private void addChampionsToList() {

        // supports
        champions.add(ana);
        champions.add(brigitte);
        champions.add(zenyatta);
        champions.add(baptiste);
        champions.add(lucio);
        champions.add(mercy);
        champions.add(moira);
        champions.add(other);
    }

    private void supportChampions() {
        champions.add(ana);
        champions.add(brigitte);
        champions.add(zenyatta);
    }
}
