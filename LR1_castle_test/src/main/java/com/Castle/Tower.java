package com.Castle;

import java.util.ArrayList;

public class Tower {
    private String towerName;
    private ArrayList<Corridor> corridors;
    private Security security;

    public Tower (String towerName, Security security){
        this.towerName = towerName;
        this.security = security;
        corridors = new ArrayList<>();
    }

    public Security getSecurity() {
        return security;
    }

    public ArrayList<Corridor> getCorridors() {
        return corridors;
    }

    public void addCorridor(Corridor corridor){
        corridors.add(corridor);
    }

    public String getTowerName() {
        return towerName;
    }
}
