package com.Castle;

public class Bedroom extends Room {
    private RoomType roomType;

    public Bedroom(float length, float width, float height, RoomType roomType){
        super(length, width, height);
        this.roomType = roomType;
    }

    public RoomType getbedroomType() {
        return roomType;
    }

    @Override
    public String toString(){
        return roomType.name() + " bedroom with next dimensions: l " + length + " w " + width +
                " h " + height;
    }


}
