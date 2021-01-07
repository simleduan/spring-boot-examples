package com.neo.designmode.threekuai;

/**
 * create by xiaocai on 2021/1/4 10:01
 **/
public class GodUser {
    private long userId;
    private String userType;

    public GodUser(long userId, String userType) {
        this.userId = userId;
        this.userType = userType;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
}
