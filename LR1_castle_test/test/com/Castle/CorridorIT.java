package com.Castle;


import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CorridorIT {

    @Test
    public void AreCorridorsAddedToList() {

        ArrayList<Corridor> list = spy(new ArrayList<>());
        Tower tower = new Tower("Tower", list);
        Corridor coridor1 = new Corridor("Coridor1",10,10,3);
        Corridor coridor2 = new Corridor("Coridor2",20,20,3);

        tower.addCorridor(coridor1);
        tower.addCorridor(coridor2);

        verify(list).add(coridor1);
        verify(list).add(coridor2);

        assertEquals(2,list.size());
    }
}
