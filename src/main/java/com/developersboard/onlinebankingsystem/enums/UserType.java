package com.developersboard.onlinebankingsystem.enums;

public enum UserType {
    ADMIN("admin"),
    CUSTOMER("customer");

    private final String name;

    UserType(String name) {
        this.name = name;
    }

    public String getRole() {
        return name;
    }
}
