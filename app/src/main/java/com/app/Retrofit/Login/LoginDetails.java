package com.app.Retrofit.Login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginDetails {

    @SerializedName("name")
    @Expose
    private Object name;
    @SerializedName("email")
    @Expose
    private Object email;
    @SerializedName("password")
    @Expose
    private Object password;
    @SerializedName("Schools")
    @Expose
    private Object schools;
    @SerializedName("securityToken")
    @Expose
    private String securityToken;
    @SerializedName("validationResult")
    @Expose
    private String validationResult;
    @SerializedName("id")
    @Expose
    private String id;

    public Object getName() {
        return name;
    }

    public void setName(Object name) {
        this.name = name;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
        this.email = email;
    }

    public Object getPassword() {
        return password;
    }

    public void setPassword(Object password) {
        this.password = password;
    }

    public Object getSchools() {
        return schools;
    }

    public void setSchools(Object schools) {
        this.schools = schools;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public String getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(String validationResult) {
        this.validationResult = validationResult;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}