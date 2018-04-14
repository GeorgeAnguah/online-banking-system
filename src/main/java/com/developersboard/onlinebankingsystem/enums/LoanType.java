package com.developersboard.onlinebankingsystem.enums;

//This is to be used in the Loan Entity class to
// indicate that a particular loan we are processing.

public enum LoanType {
    CAR(1, "car"),
    STUDY(2, "study"),
    HOME(3, "home"),
    PERSONAL(4, "personal");

    private final int id;
    private final String name;

    LoanType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
