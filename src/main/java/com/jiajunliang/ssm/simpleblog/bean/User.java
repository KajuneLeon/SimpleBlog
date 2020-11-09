package com.jiajunliang.ssm.simpleblog.bean;

import java.io.Serializable;

/**
 * @project: SimpleBlog
 * @program: User
 * @description: User Bean
 * @author: JIAJUN LIANG
 * @create: 2020-10-27 15:39
 **/
public class User implements Serializable {

    private static final long serialVersionUID = 2517018146063411581L;
    private int userId;
    private String userName;
    private String userPassword;
    private String userEmail;
    private String userGithub;
    private String userDescript;
    private String userPortrait;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userGithub='" + userGithub + '\'' +
                ", userDescript='" + userDescript + '\'' +
                ", userPortrait='" + userPortrait + '\'' +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserGithub() {
        return userGithub;
    }

    public void setUserGithub(String userGithub) {
        this.userGithub = userGithub;
    }

    public String getUserDescript() {
        return userDescript;
    }

    public void setUserDescript(String userDescript) {
        this.userDescript = userDescript;
    }

    public String getUserPortrait() {
        return userPortrait;
    }

    public void setUserPortrait(String userPortrait) {
        this.userPortrait = userPortrait;
    }
}
