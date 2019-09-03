package com.pojo;

public class User {
    private int id;
    private String username;
    private String password;
    private String password_md5;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", password_md5='" + password_md5 + '\'' +
                '}';
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

    public String getPassword_md5() {
        return password_md5;
    }

    public void setPassword_md5(String password_md5) {
        this.password_md5 = password_md5;
    }

    public User() {
    }

    public User(int id, String username, String password, String password_md5) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.password_md5 = password_md5;
    }
}
