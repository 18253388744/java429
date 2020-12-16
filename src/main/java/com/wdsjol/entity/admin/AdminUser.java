package com.wdsjol.entity.admin;

public class AdminUser{


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


    public AdminUser() {
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

    @Override
    public String toString() {
        return "AdminUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mima='" + mima + '\'' +
                '}';
    }
}
