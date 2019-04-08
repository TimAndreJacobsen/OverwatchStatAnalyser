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

    private Champion reinhardt = new Champion("Reinhardt", "Tank", maps);
    private Champion dva = new Champion("D.Va", "Tank", maps);
    private Champion orisa = new Champion("Orisa", "Tank", maps);
    private Champion roadhog = new Champion("Roadhog", "Tank", maps);
    private Champion winston = new Champion("Winston", "Tank", maps);
    private Champion wreckingBall = new Champion("Wrecking Ball", "Tank", maps);
    private Champion zarya = new Champion("Zarya", "Tank", maps);



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
    public void addChampionsToList() {

        // supports
        champions.add(ana);
        champions.add(brigitte);
        champions.add(zenyatta);
        champions.add(baptiste);
        champions.add(lucio);
        champions.add(mercy);
        champions.add(moira);

        // tanks
        champions.add(reinhardt);
        champions.add(dva);
        champions.add(orisa);
        champions.add(roadhog);
        champions.add(winston);
        champions.add(wreckingBall);
        champions.add(zarya);

        // dps


        champions.add(other);
    }

    private void supportChampions() {

    }


    private void tankChampions() {

    }


    private void dpsChampions() {

    }
}
