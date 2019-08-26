package com.pojo;

public class Major {
    private int id;
    private int threshold;
    private int difficulty;
    private int demand;
    private int y0_1;
    private int y1_2;
    private int y2_3;
    private int learning;
    private long create_at;
    private long update_at;
    private String major_name;
    private String major_intro;
    private String major_intro_detailed;
    private String cycle;
    private String tips;
    private String create_by;
    private String update_by;

    @Override
    public String toString() {
        return "Major{" +
                "id=" + id +
                ", threshold=" + threshold +
                ", difficulty=" + difficulty +
                ", demand=" + demand +
                ", y0_1=" + y0_1 +
                ", y1_2=" + y1_2 +
                ", y2_3=" + y2_3 +
                ", learning=" + learning +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", major_name='" + major_name + '\'' +
                ", major_intro='" + major_intro + '\'' +
                ", major_intro_detailed='" + major_intro_detailed + '\'' +
                ", cycle='" + cycle + '\'' +
                ", tips='" + tips + '\'' +
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

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getDemand() {
        return demand;
    }

    public void setDemand(int demand) {
        this.demand = demand;
    }

    public int getY0_1() {
        return y0_1;
    }

    public void setY0_1(int y0_1) {
        this.y0_1 = y0_1;
    }

    public int getY1_2() {
        return y1_2;
    }

    public void setY1_2(int y1_2) {
        this.y1_2 = y1_2;
    }

    public int getY2_3() {
        return y2_3;
    }

    public void setY2_3(int y2_3) {
        this.y2_3 = y2_3;
    }

    public int getLearning() {
        return learning;
    }

    public void setLearning(int learning) {
        this.learning = learning;
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

    public String getMajor_name() {
        return major_name;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public String getMajor_intro() {
        return major_intro;
    }

    public void setMajor_intro(String major_intro) {
        this.major_intro = major_intro;
    }

    public String getMajor_intro_detailed() {
        return major_intro_detailed;
    }

    public void setMajor_intro_detailed(String major_intro_detailed) {
        this.major_intro_detailed = major_intro_detailed;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
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

    public Major(int id, int threshold, int difficulty, int demand, int y0_1, int y1_2, int y2_3, int learning, long create_at, long update_at, String major_name, String major_intro, String major_intro_detailed, String cycle, String tips, String create_by, String update_by) {
        this.id = id;
        this.threshold = threshold;
        this.difficulty = difficulty;
        this.demand = demand;
        this.y0_1 = y0_1;
        this.y1_2 = y1_2;
        this.y2_3 = y2_3;
        this.learning = learning;
        this.create_at = create_at;
        this.update_at = update_at;
        this.major_name = major_name;
        this.major_intro = major_intro;
        this.major_intro_detailed = major_intro_detailed;
        this.cycle = cycle;
        this.tips = tips;
        this.create_by = create_by;
        this.update_by = update_by;
    }

    public Major() {
    }
}
