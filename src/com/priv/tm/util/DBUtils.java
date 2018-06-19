package com.priv.tm.util;


import java.sql.*;
import java.util.ResourceBundle;

public class DBUtils {

    public static String URL;//数据库链接地址
    public static String USERNAME;//用户名
    public static String PASSWORD;//密码
    public static String DRIVER;//MySQL驱动

    //读取资源属性文件（properties）
    private static ResourceBundle rb = ResourceBundle.getBundle("com.priv.tm.util.DB-config");

    //禁止外部实例化
    private DBUtils(){}

    //使用静态块加载驱动
    static {
        URL = rb.getString("jdbc.url");
        USERNAME = rb.getString("jdbc.username");
        PASSWORD = rb.getString("jdbc.password");
        DRIVER = rb.getString("jdbc.driver");
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //定义一个获取数据库链接的方法
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("获取数据库连接失败");
        }
        return conn;
    }

    //关闭数据库链接
    public static void close(ResultSet rs, Statement stat, Connection conn) {
        try {
            if(rs != null)rs.close();
            if(stat != null)stat.close();
            if(conn != null)conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

