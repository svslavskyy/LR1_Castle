package com.Castle;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KingFamilyTest {
    @Test
    public void IsTheKingFamilyInfoAddedCorrectly() {
        String name1 = "Arthur";
        String name2 = "Elena";
        String work = "King";

        KingFamily kingFamily1 = new KingFamily(name1,33,work);
        KingFamily kingFamily2 = new KingFamily(name2, 31);

        assertEquals(name1, kingFamily1.getName());
        assertEquals(work, kingFamily1.getNameWork());
        assertEquals(name2, kingFamily2.getName());
    }

}
