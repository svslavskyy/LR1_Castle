package com.Castle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;



public class CastleTest {

    @Test
    public void CastleInfoShouldBeCorrect() {
        Castle castle = new Castle("Null");
        Tower tower = new Tower("Main Tower",
                new Security(new Squad(60, "Alpha"), 150));
        try {
            castle.addTower(tower);
        } catch (AddNullTowerException e) {
            e.printStackTrace();
        }

        assertEquals(castle.getCastleName(), "Null");
        assertEquals(castle.getTowers().get(0).getTowerName(), "Main Tower");
        assertEquals(castle.getTowers().get(0).getSecurity().getSquad().getsquadName(), "Alpha");
        assertEquals(castle.getTowers().get(0).getSecurity().getSquad().getSquadCount(), 60, 0.01);

    }

}
