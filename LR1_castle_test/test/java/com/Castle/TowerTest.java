package com.Castle;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TowerTest {
    @Test
    public void AreCorridorsAddedToTower() {

        Tower tower = new Tower("Main Tower",
                new Security(new Squad(60, "Alpha"), 150));
        Corridor corridor1 = new Corridor(15,5,3);
        Corridor corridor2 = new Corridor(10,10,5);

        tower.addCorridor(corridor1);
        tower.addCorridor(corridor2);


        assertEquals(tower.getCorridors(), new ArrayList<>(Arrays.asList(corridor1,corridor2)));
    }

}
