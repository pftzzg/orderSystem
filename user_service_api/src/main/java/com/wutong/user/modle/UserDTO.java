package com.wutong.user.modle;

import java.io.Serializable;

/**
 * Created by zzg on 2018/6/2.
 */
public class UserDTO  implements Serializable {
    public int id; // required

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String username; // required
    public String password; // required

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String realName; // required
    public String mobile; // required
    public String email; // required

    @Override
    public String toString() {
        return super.toString();
    }
}
