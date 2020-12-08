package com.Castle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
        System.out.println("BedroomType: " + RoomType.getList());

        Castle castle = assembleCastle();
        presentCastle(castle);
        syphonRandomAmountOfFuelFromcastle(castle);
        float guardsRequirement = castle.checkTowerGuardRequirement();
        System.out.println("There are " + guardsRequirement + " guards in the castle now");
        lambdafunc();
        Castle nullCastle = nullCastle();
    }

    public static void lambdafunc(){
        Tower tower = new Tower("Main Tower",
                new Security(new Squad(60, "Alpha"), 150));
        tower.setPrice(150);
        Corridor corridor = new Corridor("name1",15,5,3);
        corridor.setPrice(200);
        tower.addCorridor(corridor);
        Corridor corridor_1 = new Corridor("name1",50,5,3);
        corridor_1.setPrice(500);
        tower.addCorridor(corridor_1);
        Corridor corridor_2 = new Corridor("name2",50,5,3);
        corridor_2.setPrice(300);
        tower.addCorridor(corridor_2);
        Corridor newCorridor = new Corridor(15,5,3);
        newCorridor.setPrice(200);

        Tower tower1 = new Tower("Second Tower",
                new Security(new Squad(40, "Betta"), 130));
        tower1.addCorridor(corridor);

        int price = tower.getCorridors().stream().filter(corridor1 -> corridor1.getNameCoridor().equals("name1"))
                .mapToInt(corridor1 -> corridor1.getPrice()).reduce(0,(left,right)->left+right);
        System.out.println("\nLambda functional:");
        System.out.println("Price: " + price);

        OptionalInt maxPrice = tower.getCorridors().stream().mapToInt(part -> {
            if (part.getNameCoridor().equals("name1")) {
                return part.getPrice();
            }
            return 0;
        }).max();
        System.out.println("Max Price: " + maxPrice.getAsInt());

        int averagePrice = tower.getCorridors().stream().filter(part -> part.getNameCoridor().equals("name1"))
                .mapToInt(part -> part.getPrice()).reduce(0, (left, right) -> left + right)/
                tower.getCorridors().stream().filter(part -> part.getNameCoridor() == "name1").toArray().length;

        System.out.println("Average Price: " + averagePrice);


        ArrayList<Integer> suitableArray = new ArrayList<>();
        ArrayList<Integer> unsuitableArray = new ArrayList<>();

        tower.getCorridors().stream().filter(part -> {
            if(!part.getNameCoridor().equals("name1")){
                unsuitableArray.add(part.getPrice());
                return false;
            }
            return true;
        }).forEach(part -> suitableArray.add(part.getPrice()));


        System.out.println("Suitable Array: " + suitableArray);
        System.out.println("Unsuitable Array: " + unsuitableArray);


        ArrayList<Tower> towerArrayList = new ArrayList<>();
        towerArrayList.add(tower);
        towerArrayList.add(tower1);

        int totalPrice = towerArrayList.stream().flatMap(towers -> towers.getCorridors().stream())
                .mapToInt(part -> part.getPrice()).reduce(0,Integer::sum);

        System.out.println("Total price: " + totalPrice);

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
        try {
            castle.addTower(tower);
        } catch (AddNullTowerException e) {
            e.printStackTrace();
        }


        Map<String, KingFamily> familyMap = new HashMap<>();
        familyMap.put("King", new KingFamily("Arthur",33,"King"));
        familyMap.put("Queen", new KingFamily("Guinevere",30, "Queen"));
        castle.addMap(familyMap);
        return castle;
    }
    public static Castle nullCastle() {
        System.out.println();
        Castle castle = new Castle("Null");
        Tower tower = new Tower("Main Tower",
                new Security(new Squad(60, "Alpha"), 150));
        try {
            castle.addTower(tower);
            castle.addTower(tower);
            castle.addTower(null);
        } catch (AddNullTowerException e) {
            e.printStackTrace();
        }

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
