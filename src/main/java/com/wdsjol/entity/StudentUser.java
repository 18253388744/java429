package com.wdsjol.entity;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *  student_user
 * @author 翔哥 2020-12-04
 */

public class StudentUser {
    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * classid
     */
    private Integer classid;

    /**
     * birthday
     */
    private String birthday;

    /**
     * sexid
     */
    private Integer sexid;

    /**
     * zyid
     */
    private Integer zyid;

    /**
     * tel
     */
    private String tel;

    /**
     * text
     */
    private String text;


    public StudentUser() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getSexid() {
        return sexid;
    }

    public void setSexid(Integer sexid) {
        this.sexid = sexid;
    }

    public Integer getZyid() {
        return zyid;
    }

    public void setZyid(Integer zyid) {
        this.zyid = zyid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
