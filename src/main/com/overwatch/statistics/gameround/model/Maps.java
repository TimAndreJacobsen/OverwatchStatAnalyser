package com.overwatch.statistics.gameround.model;

import java.util.HashSet;
import java.util.Set;


public class Maps {

    private Set<Map> maps = new HashSet<>();
    private Map blizzardWorld = new Map("Blizzard World", "Hybrid Payload");
    private Map dorado = new Map("Dorado", "Payload");
    private Map eichenwalde = new Map("Eichenwalde", "Hybrid Payload");
    private Map hanamura = new Map("Hanamura", "2 Capture Points");
    private Map junkertown = new Map("Junkertown", "Payload");
    private Map kingsRow = new Map("Kings Row", "Hybrid Payload");
    private Map liangTowers = new Map("Liang Towers", "King of the Hill");
    private Map lunarColony = new Map("Lunar Colony", "2 Capture Points");
    private Map nepal = new Map("Nepal", "King of the Hill");
    private Map rialto = new Map("Rialto", "Payload");
    private Map route66 = new Map("Route 66", "Payload");
    private Map templeOfAnubis = new Map("Temple of Anubis", "2 Capture Points");
    private Map volskayaIndustries = new Map("Volskaya Industries", "2 Capture Points");
    private Map numbani = new Map("Numbani", "Hybrid Payload");

    // Getters
    public Set<Map> getMaps() {
        return maps;
    }

    // Populate map set
    public void addMapsToList() {
        maps.add(blizzardWorld);
        maps.add(dorado);
        maps.add(eichenwalde);
        maps.add(hanamura);
        maps.add(junkertown);
        maps.add(kingsRow);
        maps.add(liangTowers);
        maps.add(lunarColony);
        maps.add(nepal);
        maps.add(rialto);
        maps.add(route66);
        maps.add(templeOfAnubis);
        maps.add(volskayaIndustries);
        maps.add(numbani);
    }

}
