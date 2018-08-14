package com.westos.web01.service;

import com.westos.web01.bean.Haohan;

import java.util.List;

//好汉的接口定义
public interface HaohanServiceInterface {

    Haohan findaHaohan(Integer xuhao);
    List<Haohan> listHaohan();
    Haohan addHaohan(Haohan haohan);
    Haohan updateHaohan(Haohan haohan);
    Haohan removeHaohan(Integer xuhao);
}
