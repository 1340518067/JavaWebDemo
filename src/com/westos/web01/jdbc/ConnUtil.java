package com.westos.web01.jdbc;


import com.westos.web01.constants.Constants;

import java.sql.*;

public class ConnUtil {

    //获取系统数据源连接
    public static Connection getConn(){
//        //获取数据库连接
//        String driverName= Constants.DRIVER;
//        // jdbc:mysql://<数据库服务器Ip>:<数据库服务器端口>/<数据库名>
//        String url=Constants.URL;
//        String username=Constants.USERNAME;
//        String password=Constants.PASSWORD;
//        try {
//            Class.forName(driverName);
//            //使用DriverManager获取连接
//            Connection conn = DriverManager.getConnection(url, username, password);
//            return conn;
//        }catch (Exception ex){
//            ex.printStackTrace();
//            return null;
//        }
        try{
            return PoolUtil.getDruidConnection();
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }

    }

    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        //1. 使用class.forname创建数据库驱动的实例
        String driverName="com.mysql.jdbc.Driver";
        // jdbc:mysql://<数据库服务器Ip>:<数据库服务器端口>/<数据库名>
        String url="jdbc:mysql://localhost:3306/hero1?useUnicode=true&characterEncoding=utf-8";
        String username="root";
        String password="123456";
        Class.forName(driverName);
        //设置连接超时时间，一般情况下不用设置，仅在网络条件比较差的时候使用
        DriverManager.setLoginTimeout(100);
        //使用DriverManager获取连接
        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("conn.isclosed:"+conn.isClosed());

        //创建一个statment对象
        Statement st = conn.createStatement();
        //执行sql语句
        ResultSet rs = st.executeQuery("select * from student where id<3");
        //输出查询结果
        while(rs.next()){

            System.out.println(rs.getInt("id"));
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("username"));
            System.out.println(rs.getString("pwd"));
            System.out.println("----------------");
        }
        //关闭statment对象

        rs.close();
        st.close();
        //preparedStatment的使用
        //创建preparedStatment对象
        PreparedStatement ps = conn.prepareStatement("select * from student where id<?");
        //设置参数绑定，参数名的序号从1开始
        ps.setInt(1,3);
        ResultSet rs2 = ps.executeQuery();
        //输出查询结果
        while(rs2.next()){

            System.out.println(rs2.getInt("id"));
            System.out.println(rs2.getString("name"));
            System.out.println(rs2.getString("username"));
            System.out.println(rs2.getString("pwd"));
            //日期型字段查询结果的处理，将java.sql.Date转换为java.util.Date
            //new java.util.Date(rs2.getDate("birth").getTime());
            //获取输入流
            //rs2.getBinaryStream();
            System.out.println("----------------");
        }
        rs2.close();
        ps.close();

        //like函数的处理
        PreparedStatement ps2 = conn.prepareStatement("select * from student where name like ?");
        ps2.setString(1,"%3%");
        PreparedStatement ps3 = conn.prepareStatement("select * from student where name like concat('%',?,'%') limit ?,?");
        ps3.setString(1,"3");
        //分页参数处理
        ps3.setInt(2,5);
        ps3.setInt(3,10);
        //设置二进制字段blob的值
        //ps3.setBinaryStream();
        //插入一条学生信息
        ps=conn.prepareCall("insert into student(id,name,username,pwd) values(?,?,?,?)");
        //绑定参数
        ps.setInt(1,6);
        ps.setString(2,"学生6");
        ps.setString(3,"st6");
        ps.setString(4,"123456");
        //日期型字段的处理,将java.util.Date转换为java.sql.Date
        //ps.setDate(4,new java.sql.Date((new java.util.Date()).getTime()));

        //执行插入,返回值为int，表示插入了多少行数据
        int r = ps.executeUpdate();
        System.out.println("插入数据条数:"+r);
        ps.close();

        //关闭数据库连接这一步非常重要
        conn.close();
        System.out.println("conn.isclosed:"+conn.isClosed());
    }
}
