package com.wdsjol.entity;

/**
 *  zy
 * @author 翔哥 2020-12-04
 */
public class Zy {
    /**
     * zyid
     */
    private Integer zyid;

    /**
     * zy
     */
    private String zy;


    public Zy() {
    }

    public Integer getZyid() {
        return zyid;
    }

    public void setZyid(Integer zyid) {
        this.zyid = zyid;
    }

    public String getZy() {
        return zy;
    }

    public void setZy(String zy) {
        this.zy = zy;
    }

    @Override
    public String toString() {
        return "Zy{" +
                "zyid=" + zyid +
                ", zy='" + zy + '\'' +
                '}';
    }
}