package com.Castle;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SequrityTest {
    @Test
    public void EmbeddedSecurityInfoShouldBeCorrect() {
        Security security = new Security(new Squad(20, "Alpha"),150);

        assertEquals(security.getSquad().getsquadName(), "Alpha");
        assertEquals(security.getSquad().getSquadCount(),20);
        assertEquals(security.getGuardianTower().getmaxCount() ,150,0.01 );
    }

    @Test
    public void SqudInfo() {
        Squad squad = mock(Squad.class);
        Security security = new Security(squad,150);

        when(squad.getsquadName()).thenReturn("Alpha");
        when(squad.getSquadCount()).thenReturn(20);

        assertEquals(security.getSquadlInfo(), "The Squad: Alpha, 20 person.");
        verify(squad).getsquadName();
        verify(squad).getSquadCount();
    }
}
