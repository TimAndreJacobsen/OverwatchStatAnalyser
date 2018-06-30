package com.overwatch.statistics;

import com.overwatch.statistics.gameround.GameRound;
import com.overwatch.statistics.gameround.logic.Logic;
import com.overwatch.statistics.gameround.model.Champion;
import com.overwatch.statistics.gameround.model.Map;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static junit.framework.TestCase.*;

public class LogicTest {
    private Map map1;
    private Map map2;
    private Map map3;
    private Map map4;
    private Set<Map> maps;
    private Champion c1;
    private Champion c2;
    private Champion c3;
    private Champion c4;
    private Set<Champion> champions;
    private Logic logic;

    @Before
    public void setUp() {
        maps = new HashSet<>();
        map1 = new Map("map1", "Hybrid Payload");
        map2 = new Map("map2", "Payload");
        map3 = new Map("map3", "King of the Hill");
        map4 = new Map("map4", "2 Capture Points");
        maps.add(map1);
        maps.add(map2);
        maps.add(map3);
        maps.add(map4);

        champions = new HashSet<>();
        c1 = new Champion("c1", "Tank", maps);
        c2 = new Champion("c2", "DPS", maps);
        c3 = new Champion("c3", "Support", maps);
        c4 = new Champion("c4", "Support", maps);
        champions.add(c1);
        champions.add(c2);
        champions.add(c3);
        champions.add(c4);

        logic = new Logic();
    }

    @Test
    public void testGetters() {
        List<GameRound>gameRounds = new ArrayList<>();
        GameRound r1 = new GameRound();
        r1.setChampion(c1);
        r1.setMap(map1);
        r1.setIsWin(true);
        GameRound r2 = new GameRound();
        r2.setChampion(c1);
        r2.setMap(map1);
        r2.setIsWin(false);
        GameRound r3 = new GameRound();
        r3.setChampion(c1);
        r3.setMap(map2);
        r3.setIsWin(true);
        GameRound r4 = new GameRound();
        r4.setChampion(c1);
        r4.setMap(map2);
        r4.setIsWin(true);
        gameRounds.add(r1);
        gameRounds.add(r2);
        gameRounds.add(r3);
        gameRounds.add(r4);

        assertEquals(r1.getChampion(), c1);
        assertEquals(r2.getChampion(), c1);
        assertEquals(r1.getMap(), map1);
        assertEquals(r2.getMap(), map1);
        assertEquals(r3.getMap(), map2);
        assertTrue(r1.isWin());
        assertFalse(r2.isWin());
    }

    @Test
    public void testCalculateTotalWinRates() {
        List<GameRound>gameRounds = new ArrayList<>();
        GameRound r1 = new GameRound(c1, map1, true);
        GameRound r2 = new GameRound(c1, map1, false);
        GameRound r3 = new GameRound(c1, map2, true);
        GameRound r4 = new GameRound(c1, map2, true);
        gameRounds.add(r1);
        gameRounds.add(r2);
        gameRounds.add(r3);
        gameRounds.add(r4);

        assertEquals(0.75 , logic.calculateTotalWinRates(c1, gameRounds) , 0.001);
    }

    @Test
    public void testCalculateWinRateEachMap() {
        List<GameRound>gameRounds = new ArrayList<>();
        GameRound r1 = new GameRound(c1, map1, true);
        GameRound r2 = new GameRound(c1, map1, false);
        GameRound r3 = new GameRound(c1, map2, true);
        GameRound r4 = new GameRound(c1, map2, true);
        gameRounds.add(r1);
        gameRounds.add(r2);
        gameRounds.add(r3);
        gameRounds.add(r4);

        assertEquals(0.5, logic.calculateWinRatesEachMap(c1, map1, gameRounds) , 0.01);
        assertEquals(1, logic.calculateWinRatesEachMap(c1, map2, gameRounds), 0.01);
    }
}
