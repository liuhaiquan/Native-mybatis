package com.kavin.pojo;

import java.io.Serializable;
import java.sql.Date;

public class Role implements Serializable {

    private String userCode;
    private String roleId;
    private String inputUserCode;
    private Date inputTime;

    public String getUserCode() {
        return userCode;
    }

    @Override
    public String toString() {
        return "Role{" +
                "userCode='" + userCode + '\'' +
                ", roleId='" + roleId + '\'' +
                ", inputUserCode='" + inputUserCode + '\'' +
                ", inputTime=" + inputTime +
                '}';
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getInputUserCode() {
        return inputUserCode;
    }

    public void setInputUserCode(String inputUserCode) {
        this.inputUserCode = inputUserCode;
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }
}
