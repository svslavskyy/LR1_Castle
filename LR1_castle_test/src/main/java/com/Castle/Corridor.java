package com.Castle;

import java.util.ArrayList;

public class Corridor extends Room{
    private ArrayList<Room> connectedRooms;

    public Corridor(float length, float width, float height){
        super(length, width, height);
        connectedRooms = new ArrayList<>();
    }

    public ArrayList<Room> getConnectedRooms() {
        return connectedRooms;
    }

    public void addConnectedRoom(Room room){
        connectedRooms.add(room);
    }
}
