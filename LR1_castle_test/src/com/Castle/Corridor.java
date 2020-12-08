package com.Castle;

import java.util.ArrayList;

public class Corridor extends Room{
    private ArrayList<Room> connectedRooms;
    private int price;
    private String nameCoridor;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Corridor(String nameCoridor,float length, float width, float height){
        super(length, width, height);
        this.nameCoridor = nameCoridor;
        connectedRooms = new ArrayList<>();
    }

    public Corridor(float length, float width, float height){
        super(length, width, height);
        connectedRooms = new ArrayList<>();
    }
    public String getNameCoridor(){
        return nameCoridor;
    }
    public ArrayList<Room> getConnectedRooms() {
        return connectedRooms;
    }

    public void addConnectedRoom(Room room){
        connectedRooms.add(room);
    }
}
