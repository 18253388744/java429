package com.wdsjol.entity;
/**
 *  teacher_user
 * @author 翔哥 2020-12-04
 */
public class TeacherUser {
    /**
     * id
     */
    private Integer id;

    /**
     * name
     */
    private String name;

    /**
     * mima
     */
    private String mima;

    /**
     * sexid
     */
    private Integer sexid;

    /**
     * zyid
     */
    private Integer zyid;

    /**
     * classid
     */
    private Integer classid;

    /**
     * text
     */
    private String text;


    public TeacherUser() {
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

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima;
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

    public Integer getClassid() {
        return classid;
    }

    public void setClassid(Integer classid) {
        this.classid = classid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
