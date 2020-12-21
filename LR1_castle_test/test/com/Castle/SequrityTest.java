package com.Castle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SequrityTest {
    @Test
    public void EmbeddedSecurityInfoShouldBeCorrect() {
        Security security = new Security(new Squad(20, "Alpha"),150);

        assertEquals(security.getSquad().getsquadName(), "Alpha");
        assertEquals(security.getSquad().getSquadCount(),20);
        assertEquals(security.getGuardianTower().getmaxCount() ,150,0.01 );
    }
}
