package com.wdsjol.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *  user_type
 * @author 大狼狗 2020-11-27
 */
public class UserType implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户类型编号
     */
    private String typeno;

    /**
     * 用户类型名称
     */
    private String typename;


    public UserType() {
    }

    public String getTypeno() {
        return typeno;
    }

    public void setTypeno(String typeno) {
        this.typeno = typeno;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

}
