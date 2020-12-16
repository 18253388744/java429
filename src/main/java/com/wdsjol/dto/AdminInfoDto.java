package com.wdsjol.dto;

import org.springframework.stereotype.Component;

@Component
public class AdminInfoDto {
    private int student;
    private int teacher;
    private int classs;
    private int zy;

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public int getClasss() {
        return classs;
    }

    public void setClasss(int classs) {
        this.classs = classs;
    }

    public int getZy() {
        return zy;
    }

    public void setZy(int zy) {
        this.zy = zy;
    }

    @Override
    public String toString() {
        return "AdminInfoDto{" +
                "student=" + student +
                ", teacher=" + teacher +
                ", classs=" + classs +
                ", zy=" + zy +
                '}';
    }
}
