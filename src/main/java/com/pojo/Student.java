package com.pojo;

public class Student {
    private int id;
    private String student_name;
    private String picture;
    private int major_id;
    private String position;
    private int salary;
    private int status;
    private String student_intro;
    private long create_at;
    private long update_at;
    private String create_by;
    private String update_by;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", student_name='" + student_name + '\'' +
                ", picture='" + picture + '\'' +
                ", major_id=" + major_id +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", status=" + status +
                ", student_intro='" + student_intro + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", create_by='" + create_by + '\'' +
                ", update_by='" + update_by + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getMajor_id() {
        return major_id;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStudent_intro() {
        return student_intro;
    }

    public void setStudent_intro(String student_intro) {
        this.student_intro = student_intro;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public Student(int id, String student_name, String picture, int major_id, String position, int salary, int status, String student_intro, long create_at, long update_at, String create_by, String update_by) {
        this.id = id;
        this.student_name = student_name;
        this.picture = picture;
        this.major_id = major_id;
        this.position = position;
        this.salary = salary;
        this.status = status;
        this.student_intro = student_intro;
        this.create_at = create_at;
        this.update_at = update_at;
        this.create_by = create_by;
        this.update_by = update_by;
    }

    public Student() {
    }
}
