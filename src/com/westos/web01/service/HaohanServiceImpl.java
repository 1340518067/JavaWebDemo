package com.westos.web01.service;

import com.westos.web01.bean.Haohan;
import com.westos.web01.constants.Constants;
import com.westos.web01.jdbc.ConnUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class HaohanServiceImpl implements HaohanServiceInterface {

    //根据序号查询好汉
    @Override
    public Haohan findaHaohan(Integer xuhao) {

        Haohan result=null;
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{

            conn = ConnUtil.getConn();
            //执行查询语句
            result=new Haohan();
            String sql="select * from heroinfo where xuhao=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,xuhao);
            rs = ps.executeQuery();
            while (rs.next()){
                result.setXuhao(rs.getInt("xuhao"));
                result.setXingming(rs.getString("xingming"));
            }
            //释放资源
            ps.close();

            //关闭连接
            conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("数据库连接获取异常"+ex);
        }finally {
            releaseResource(rs,ps,conn);
        }
        return result;
    }
    private void releaseResource(ResultSet rs,PreparedStatement ps,Connection conn){
        try{
            if(rs!=null){
                rs.close();
            }
            if(ps!=null){
                ps.close();
            }
            if(conn!=null){
                conn.close();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    //显示所有好汉
    @Override
    public List<Haohan> listHaohan() {

        List<Haohan> result=null;
        Connection conn =null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try{

            //使用DriverManager获取连接
            conn = ConnUtil.getConn();
            //执行insert语句
            result=new ArrayList<>();
            String sql="select * from heroinfo";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Haohan haohan=new Haohan();
                haohan.setXuhao(rs.getInt("xuhao"));
                haohan.setXingming(rs.getString("xingming"));
                result.add(haohan);
            }
            //释放资源
            ps.close();

            //关闭连接
            conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("数据库连接获取异常"+ex);
        }finally {
            releaseResource(rs,ps,conn);
        }
        return result;
    }

    //添加好汉
    @Override
    public Haohan addHaohan(Haohan haohan) {
        Connection conn=null;
        PreparedStatement ps=null;
        try{

            //使用DriverManager获取连接
            conn = ConnUtil.getConn();
            //执行insert语句

            String sql="insert into heroinfo(xuhao,xingming) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,haohan.getXuhao());
            ps.setString(2,haohan.getXingming());
            ps.executeUpdate();
            //释放资源
            ps.close();

            //关闭连接
            conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("数据库连接获取异常"+ex);
        }finally {
            releaseResource(null,ps,conn);
        }

        //返回结果
        return haohan;
    }

    @Override
    public Haohan updateHaohan(Haohan haohan) {
        Connection conn=null;
        PreparedStatement ps=null;
        try{

            //使用DriverManager获取连接
             conn = ConnUtil.getConn();
            //执行insert语句

            String sql="update heroinfo set xingming=? where xuhao=?";
             ps = conn.prepareStatement(sql);
            ps.setString(1,haohan.getXingming());
            ps.setInt(2,haohan.getXuhao());
            ps.executeUpdate();
            //释放资源
            ps.close();

            //关闭连接
            conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("数据库连接获取异常"+ex);
            haohan=null;
        }finally {
            releaseResource(null,ps,conn);
        }

        //返回结果
        return haohan;
    }

    @Override
    public Haohan removeHaohan(Integer xuhao) {
        Connection conn=null;
        PreparedStatement ps=null;
        try{

            //使用DriverManager获取连接
            conn = ConnUtil.getConn();
            //执行insert语句

            String sql="delete from  heroinfo  where xuhao=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,xuhao);

            ps.executeUpdate();
            //释放资源
            ps.close();

            //关闭连接
            conn.close();
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println("数据库连接获取异常"+ex);
        }finally {
            releaseResource(null,ps,conn);
        }

        //返回结果
        Haohan haohan=new Haohan();
        haohan.setXuhao(xuhao);
        return haohan;
    }

    public static void main(String[] args){
        HaohanServiceInterface haohanService=new HaohanServiceImpl();
        Haohan result = null;
        //测试删除
//        result=haohanService.removeHaohan(1);
//        System.out.println(result);

        //测试添加
        Haohan haohan=new Haohan();
//        haohan.setXuhao(1);
//        haohan.setXingming("宋江");
//
//        result=haohanService.addHaohan(haohan);
//        System.out.println(result);

//        //测试修改
//        haohan.setXingming("卢俊义");
//        result=haohanService.updateHaohan(haohan);
//        System.out.println(result);
//
        //测试查找
        List<Haohan> list = haohanService.listHaohan();
        System.out.println(list);
//
//        result=haohanService.findaHaohan(1);
//        System.out.println(result);



    }
}
