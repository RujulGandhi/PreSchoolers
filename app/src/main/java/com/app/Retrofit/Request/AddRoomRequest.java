package com.app.Retrofit.Request;

/**
 * Created by archirayan on 05-May-17.
 */

public class AddRoomRequest {
    String className, name;
    UserRequest user;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserRequest getUser() {
        return user;
    }

    public void setUser(UserRequest user) {
        this.user = user;
    }
}
