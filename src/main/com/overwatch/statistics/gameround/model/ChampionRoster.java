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

    private Champion ashe = new Champion("Ashe", "DPS", maps);
    private Champion bastion = new Champion("Bastion", "DPS", maps);
    private Champion doomfist = new Champion("Doomfist", "DPS", maps);
    private Champion genji = new Champion("Genji", "DPS", maps);
    private Champion hanzo = new Champion("Hanzo", "DPS", maps);
    private Champion junkrat = new Champion("Junkrat", "DPS", maps);
    private Champion mccree = new Champion("McCree", "DPS", maps);
    private Champion mei = new Champion("Mei", "DPS", maps);
    private Champion pharah = new Champion("Pharah", "DPS", maps);
    private Champion reaper = new Champion("Reaper", "DPS", maps);
    private Champion soldier76 = new Champion("Soldier: 76", "DPS", maps);
    private Champion sombra = new Champion("Sombra", "DPS", maps);
    private Champion symmetra = new Champion("Symmetra", "DPS", maps);
    private Champion torbjorn = new Champion("Torbjorn", "DPS", maps);
    private Champion tracer = new Champion("Tracer", "DPS", maps);
    private Champion widowmaker = new Champion("Widowmaker", "DPS", maps);

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
        champions.add(ashe);
        champions.add(bastion);
        champions.add(doomfist);
        champions.add(genji);
        champions.add(hanzo);
        champions.add(junkrat);
        champions.add(mccree);
        champions.add(mei);
        champions.add(pharah);
        champions.add(reaper);
        champions.add(soldier76);
        champions.add(sombra);
        champions.add(symmetra);
        champions.add(torbjorn);
        champions.add(tracer);
        champions.add(widowmaker);

        champions.add(other);
    }

    public Set<Champion> getChampionsByRole(String role) {
        Set<Champion> championRoleSelection = new HashSet<>();

        if (role != null && !role.equals("All Roles")) {
            for (Champion c : champions) {
                if (c.getRole().equals(role)){
                    championRoleSelection.add(c);
                }
            }
        } else {
            championRoleSelection = getChampions();
        }
        return championRoleSelection;
    }

}
