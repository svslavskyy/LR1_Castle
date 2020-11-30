package com.Castle;

public class AddNullTowerException extends Throwable {
    AddNullTowerException() {
        super("Can`t add empty Tower!");
    }
    AddNullTowerException(String massage){
        super(massage);
    }
}
