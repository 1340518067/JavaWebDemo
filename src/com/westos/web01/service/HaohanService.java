package com.westos.web01.service;

import com.westos.web01.bean.Haohan;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于处理好汉排行榜的添加\修改等
 */
public class HaohanService implements HaohanServiceInterface {

    //定义好汉数据列表
    private static List<Haohan> haohanlist=new ArrayList<>();


    /**
     * 根据序号查找一个好汉
     * @param xuhao 好汉的序号
     * @return
     */
    public Haohan findaHaohan(Integer xuhao){
        return null;
    }

    /**
     * 获取所有好汉信息
     * @return
     */
    public List<Haohan> listHaohan(){
        return haohanlist;
    }

    /**
     * 添加一个好汉
     * @param haohan 要添加的好汉信息
     * @return 新添加的好汉
     */
    public Haohan addHaohan(Haohan haohan){
        haohanlist.add(haohan);
        return  haohan;
    }

    /**
     * 修改一个好汉
     * @param haohan
     * @return
     */
    public Haohan updateHaohan(Haohan haohan){
        Haohan ahaohan = findaHaohan(haohan.getXuhao());
        ahaohan.setXingming(haohan.getXingming());
        return ahaohan;
    }

    /**
     * 删除好汉
     * @param xuhao 好汉的序号
     * @return
     */
    public Haohan removeHaohan(Integer xuhao){
        //find
        // remove
        return null;
    }

}
