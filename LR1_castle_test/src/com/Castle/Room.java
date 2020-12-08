package com.Castle;


public abstract class Room {

    protected float length;
    protected float width;
    protected float height;

    public Room(float length, float width, float height){
        this.length = length;
        this.width = width;
        this.height = height;
    };

    public float getVolume(){
        return length * width * height;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }


}
