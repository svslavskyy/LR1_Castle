package com.Castle;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        System.out.println("BedroomType: " + RoomType.getList());

        Castle castle = assembleCastle();
        presentCastle(castle);
        syphonRandomAmountOfFuelFromcastle(castle);
        float guardsRequirement = castle.checkTowerGuardRequirement();
        System.out.println("There are " + guardsRequirement + " guards in the castle now");

        Castle nullCastle = nullCastle();
    }

    public static Castle assembleCastle(){
        Castle castle = new Castle("King Arthur`s Castle ");
        Tower tower = new Tower("Main Tower",
                new Security(new Squad(60, "Alpha"), 150));
        Corridor corridor = new Corridor(15,5,3);
        tower.addCorridor(corridor);
        corridor.addConnectedRoom(new Bedroom(20,15,3, RoomType.Royal));
        corridor.addConnectedRoom(new Bedroom(5,5,3, RoomType.Security));
        corridor = new Corridor(10,5,3);
        tower.addCorridor(corridor);
        tower.getCorridors().get(0).addConnectedRoom(tower.getCorridors().get(1));
        tower.getCorridors().get(1).addConnectedRoom(tower.getCorridors().get(0));
        castle.addTower(tower);


        Map<String, KingFamily> familyMap = new HashMap<>();
        familyMap.put("King", new KingFamily("Arthur",33,"King"));
        familyMap.put("Queen", new KingFamily("Guinevere",30, "Queen"));
        castle.addMap(familyMap);
        return castle;
    }
    public static Castle nullCastle(){
        System.out.println();
        Castle castle = new Castle("Null");
        Tower tower = new Tower("Main Tower",
                new Security(new Squad(60, "Alpha"), 150));
        castle.addTower(tower);
        castle.addTower(tower);
        castle.addTower(null);
        return castle;
    }
    private static void syphonRandomAmountOfFuelFromcastle(Castle castle){
        for(int i = 0; i < castle.getTowers().size(); i++) {
            castle.getTowers().get(i).getSecurity().sleepGuardians(ThreadLocalRandom.current().nextInt(0, 150));
        }
    }

    private static void presentCastle(Castle castle){
        System.out.println("Welcome to medieval castle " + castle.getCastleName());
        System.out.println("Who lives in the castle: ");
        castle.getMap().get(0).get("King").printInfo();
        castle.getMap().get(0).get("Queen").printInfo();
        System.out.println("The castle consists of:");
        System.out.print(castle.getTowers().size() + " towers: ");
        for(int i = 0; i < castle.getTowers().size(); i++){
            System.out.print(castle.getTowers().get(i).getTowerName()+ "; ");
        }
        System.out.println();
        for(int i = 0; i < castle.getTowers().size(); i++){
            Tower tower = castle.getTowers().get(i);
            System.out.println("Tower: " + tower.getTowerName() + " has security with " +
                    tower.getSecurity().getSquad().getsquadName() + " squad and consists of:");
            System.out.println(tower.getCorridors().size() + " corridors" );
            for(int j = 0; j < tower.getCorridors().size(); j++){
                Corridor corridor = tower.getCorridors().get(j);
                System.out.println("Corridor " + (j + 1) + " contains");
                for(int k = 0; k < corridor.getConnectedRooms().size(); k++){
                    Room room = corridor.getConnectedRooms().get(k);
                    if(room.getClass() != Corridor.class) {
                        System.out.println(room);
                    }
                }
            }
        }
    }
}
