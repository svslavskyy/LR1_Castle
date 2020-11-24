package com.Castle;

public class AddNullTowerException extends Exception {
    AddNullTowerException() {
        super("Can`t add empty Tower!");
    }
    AddNullTowerException(String massage){
        super(massage);
    }
}
