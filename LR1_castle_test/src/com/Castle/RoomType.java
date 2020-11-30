package com.Castle;

public enum RoomType {

    Royal(10,5) {
        @Override
        public String toString() {
            return "Royal (" +
                    levels + " levels access to " +
            countPeople + " person)";
        }
    },
    Security((float)5) {
        @Override
        public String toString() {
            return "Security (" +
                    levels + " levels)";
        }
    },
    Servant((float)1) {
        @Override
        public String toString() {
            return "Servant (" +
                    levels + " levels)";
        }
    },
    DiningRoom(50){
        @Override
        public String toString() {
            return " Dining room for(" +
                    countPeople + " person)";
        }
    };

    float levels;
    int countPeople;

    RoomType(float levels, int countPeople) {
        this.levels = levels;
        this.countPeople = countPeople;
    }
    RoomType(int countPeople) {
        this.countPeople = countPeople;
    }
    RoomType(float levels){
        this.levels = levels;
    }
    static String getList() {
        StringBuilder sb = new StringBuilder();
        for (var value : RoomType.values()) {
            sb.append(value);
            sb.append(", ");
        }
        return sb.toString();
    }
}
