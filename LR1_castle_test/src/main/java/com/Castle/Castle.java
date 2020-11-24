package com.Castle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Castle {

    private ArrayList<Tower> towers;
    private ArrayList<KingFamily> families;
    private ArrayList<Map<String, KingFamily>> map;
    private String castleName;

    public Castle(String castleName){
        this.castleName = castleName;
        towers = new ArrayList<>();
        families = new ArrayList<>();
        map = new ArrayList<>();
    }

    public String getCastleName() {
        return castleName;
    }

    public void addTower(Tower tower){
        try{
            if(tower == null){
                throw new AddNullTowerException();
            }
            for(Tower towerCount: towers){
                if(towerCount.equals(tower)){
                    System.out.println("Can`t add new Tower to Castle because this Tower is already exist!");
                    return;
                }
            }
            this.towers.add(tower);
            System.out.println("New Tower\"" + tower.getTowerName() + "\" add successfully");
        }catch (AddNullTowerException ex) {
            System.err.println(ex.getMessage());
        }

    }
    public void addKingFamily(KingFamily family){
        families.add(family);
    }
    public void addMap(Map<String, KingFamily> loc){
        map.add(loc);
    }
    public ArrayList<Map<String, KingFamily>> getMap(){
        return map;
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }
    public ArrayList<KingFamily> getFamilies() {
        return families;
    }

    public float checkTowerGuardRequirement(){
        float guardsRequirement = 0;
        Iterator iterator = towers.iterator();
        while(iterator.hasNext()){
            Tower tower = (Tower)iterator.next();
            Security security = tower.getSecurity();
            guardsRequirement += security.getThrusterQuardingCastle();
        }
        return guardsRequirement;
    }

}
