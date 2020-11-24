package com.Castle;

public class KingFamily extends Person implements Work {

    private String nameWork;
    public KingFamily(String name, int age, String nameWork) {
        super(name, age);
        this.nameWork = nameWork;
    }

    public KingFamily(String name, int age) {
        super(name, age);
    }

    @Override
    public String getNameWork() {
        return nameWork;
    }

    @Override
    public void setNameWork(String nameWork) {
        this.nameWork = nameWork;
    }

    @Override
    public void printInfo() {
        StringBuilder kingInfo = new StringBuilder();
        kingInfo.append("\tName of work: ").append(nameWork);
        kingInfo.append("\n\tName of people ").append(getName());
        kingInfo.append("\n\tAge: ").append(getAge());
        System.out.println(kingInfo);
    }
}
