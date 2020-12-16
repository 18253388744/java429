package com.wdsjol.entity;

public class User {

    /**
     * id
     */
    private Integer id;

    /**
     * phone
     */
    private String phone;

    /**
     * mima
     */
    private String mima;

    /**
     * data
     */
    private String data;


    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMima() {
        return mima;
    }

    public void setMima(String mima) {
        this.mima = mima;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
