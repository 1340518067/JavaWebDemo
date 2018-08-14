package com.westos.web01.bean;

import java.util.ArrayList;
import java.util.List;

public class Shengfen {
    private String name;
    private List<String> citys;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCitys() {
        return citys;
    }

    public void setCitys(List<String> citys) {
        this.citys = citys;
    }

    public void addCity(String city){
        if(this.citys==null){
            this.citys=new ArrayList<>();
        }
        this.citys.add(city);
    }

    @Override
    public String toString() {
        return "Shengfen{" +
                "name='" + name + '\'' +
                ", citys=" + citys +
                '}';
    }
}
