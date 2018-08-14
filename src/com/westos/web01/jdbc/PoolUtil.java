package com.westos.web01.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.westos.web01.constants.Constants;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class PoolUtil {

    public static Connection getConnection() throws NamingException, SQLException {
        //上下文环境
        Context ctx=new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/xiong");
        Connection conn = ds.getConnection();
        return conn;
    }

    public static Connection getDruidConnection() throws SQLException {
        DruidDataSource dataSource=new DruidDataSource();
        dataSource.setDriverClassName(Constants.DRIVER);
        dataSource.setUrl(Constants.URL);
        dataSource.setUsername(Constants.USERNAME);
        dataSource.setPassword(Constants.PASSWORD);
        dataSource.setMaxActive(50);
        dataSource.setMinIdle(1);
        DruidPooledConnection conn = dataSource.getConnection();
        return conn;
    }
}
