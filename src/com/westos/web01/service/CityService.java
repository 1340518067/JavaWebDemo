package com.westos.web01.service;

import com.westos.web01.bean.Shengfen;

import java.util.ArrayList;
import java.util.List;

public class CityService {

    public List<Shengfen> initShengfen(){
        List<Shengfen> list=new ArrayList<>();
        Shengfen s1=new Shengfen();
        s1.setName("陕西");
        s1.addCity("西安");
        s1.addCity("咸阳");
        s1.addCity("铜川");
        list.add(s1);
        Shengfen s2=new Shengfen();
        s2.setName("河南");
        s2.addCity("郑州");
        s2.addCity("洛阳");
        list.add(s2);
        return list;
    }
}
