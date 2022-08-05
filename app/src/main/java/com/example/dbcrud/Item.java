package com.example.dbcrud;

import java.io.Serializable;

public class Item implements Serializable {
    private String key;
    private String name;
    private String desc;
    private Integer qty;

    public Item(String key, String name, String desc, Integer qty) {
        this.key =key;
        this.name=name;
        this.desc=desc;
        this.qty=qty;
    }
    public Item(){

    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }


}
