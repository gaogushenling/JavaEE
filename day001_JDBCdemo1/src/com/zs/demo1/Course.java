package com.zs.demo1;

public class Course {
    private String con;
    private String cname;
    private int credit;
    private int semester;

    public Course() {
    }

    public Course(String con, String cname, int credit, int semester) {
        this.con = con;
        this.cname = cname;
        this.credit = credit;
        this.semester = semester;
    }

    public String getCon() {
        return con;
    }

    public void setCon(String con) {
        this.con = con;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Course{" +
                "con='" + con + '\'' +
                ", cname='" + cname + '\'' +
                ", credit=" + credit +
                ", semester=" + semester +
                '}';
    }
}
