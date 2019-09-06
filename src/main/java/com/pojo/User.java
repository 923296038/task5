package com.pojo;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class User {
    private int id;
    @NotBlank(message = "用户名不为空")
    private String user_name;
    @Size(min = 8,max = 20,message = "密码长度应在8-20")
    private String password;
    @Size(min = 8,max = 20,message = "密码长度应在8-20")
    private String password_repeat;
    private String salt;
    private String password_md5;
    private String nick_name;
    private String email;
    @Min(value = 1,message = "手机号格式错误")
    private long mobile_number;
    private String create_at;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", password_repeat='" + password_repeat + '\'' +
                ", salt='" + salt + '\'' +
                ", password_md5='" + password_md5 + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", email='" + email + '\'' +
                ", mobile_number=" + mobile_number +
                ", create_at='" + create_at + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_repeat() {
        return password_repeat;
    }

    public void setPassword_repeat(String password_repeat) {
        this.password_repeat = password_repeat;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword_md5() {
        return password_md5;
    }

    public void setPassword_md5(String password_md5) {
        this.password_md5 = password_md5;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(long mobile_number) {
        this.mobile_number = mobile_number;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public User() {
    }
}
