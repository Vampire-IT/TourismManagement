package com.priv.tm.util;

import java.util.ResourceBundle;

/**
 * 数据库工具类
 * 使用静态方法实现
 * 提供数据库连接方法getConnection()
 * 提供关闭数据库方法close()
 */
public class SQLUtils {
    public static String INSERT;//insert SQL语句
    public static String DELETE;//delete SQL语句
    public static String UPDATE;//update SQL语句
    public static String SELECT;//select SQL语句

    //读取资源属性文件（properties）
    private static ResourceBundle rb = ResourceBundle.getBundle("com.priv.tm.util.SQL-config");

    //禁止外部实例化
    private SQLUtils() {}

    //使用静态块加载驱动
    public static String getSQLInsert(String name){
        INSERT = rb.getString(name+".insert");
        return INSERT;
    }

    public static String getSQLDelete(String name){
        DELETE = rb.getString(name+".delete");
        return DELETE;
    }

    public static String getSQLUpdate(String name){
        UPDATE = rb.getString(name+".update");
        return UPDATE;
    }
    //修改投诉类别状态
    public static String getSQLupState(){
        UPDATE = rb.getString("ctype.upState");
        return UPDATE;
    }

    //修改用户锁定状态
    public static String getSQLupLock(){
        UPDATE = rb.getString("user.upLock");
        return UPDATE;
    }

    //修改分派状态
    public static String getSQLMark(){
        UPDATE = rb.getString("complain.mark");
        return UPDATE;
    }

    //修改处理结果
    public static String getSQLResult(){
        UPDATE = rb.getString("assign.result");
        return UPDATE;
    }

    public static String getSQLCheck(){
        SELECT = rb.getString("user.check");
        return SELECT;
    }

    public static String getSQLSelect(String name){
        SELECT = rb.getString(name+".select");
        return SELECT;
    }

}

