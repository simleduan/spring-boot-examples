package com.neo.designmode.threekuai;

public enum UserTypeEnum {
    NEW_USER("NEW_USER"),
    OLD_USER("OLD_USER"),
    ;
    private String userType;

    UserTypeEnum(String userType) {
        this.userType = userType;
    }
}
