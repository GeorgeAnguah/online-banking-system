package com.developersboard.onlinebankingsystem.enums;

//This is to be used in the Loan Entity class to
// indicate that a particular loan we are processing.

public enum LoanType {
    CAR("car"),
    STUDY("study"),
    HOME("home"),
    PERSONAL("personal");

    private final String name;

    LoanType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
