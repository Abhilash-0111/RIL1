package com.example.ril1;

public class InsClass {
    String name , detail , inventory , picurl , vurl ;

    public InsClass(String name, String detail, String inventory, String picurl, String vurl) {
        this.name = name;
        this.detail = detail;
        this.inventory = inventory;
        this.picurl = picurl;
        this.vurl = vurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    public String getVurl() {
        return vurl;
    }

    public void setVurl(String vurl) {
        this.vurl = vurl;
    }
}
