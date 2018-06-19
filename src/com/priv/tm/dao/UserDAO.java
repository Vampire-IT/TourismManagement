package com.priv.tm.dao;

import com.priv.tm.base.User;
import com.priv.tm.util.DBUtils;
import com.priv.tm.util.DaoUtil;
import com.priv.tm.util.SQLUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private DaoUtil daoUtil;

    public UserDAO() {
        daoUtil = new DaoUtil();
    }
    //添加方法

    private String username;//用户名
    private String password;//密码
    private String realName;//真实姓名
    private String userType;//用户类别
    private String lock;//锁定标志
    private String lastLoginTime;//最后登陆时间

    public void insert(User u) throws SQLException {
        String sql = SQLUtils.getSQLInsert("user");
        daoUtil.update(sql, u.getUsername(), u.getPassword(), u.getRealName(), u.getUserType(), u.getLock(), u.getLastLoginTime());
    }

    //删除方法
    public void delete(String id) throws SQLException {
        String sql = SQLUtils.getSQLDelete("user");
        daoUtil.update(sql, id);
    }

    //修改方法
    public void update(User u) throws SQLException {
        String sql = SQLUtils.getSQLUpdate("user");
        daoUtil.update(sql, u.getPassword(), u.getRealName(), u.getUserType(), u.getLock(), u.getLastLoginTime(), u.getUsername());
    }

    public void upLook(User u) throws SQLException {
        String sql = SQLUtils.getSQLupLock();
        daoUtil.update(sql, u.getLock(), u.getUsername());
    }

    public List<User> find(String realName, String userType, String lock) {
        List<User> userList = new ArrayList<User>();
        String sql = SQLUtils.getSQLSelect("user");
        if (realName != null) {
            sql += " AND RealName like '%" + realName + "%'";
        }
        if (userType != null) {
            sql += " AND UserType = '" + userType + "'";
        }
        if (lock != null) {
            sql += " AND UserLock = " + lock;
        }
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while (rs.next()) {
                User u = new User();
                u.setUsername(rs.getString("Username"));
                u.setPassword(rs.getString("Password"));
                u.setRealName(rs.getString("RealName"));
                u.setUserType(rs.getString("UserType"));
                u.setLock(rs.getString("UserLock"));
                u.setLastLoginTime(rs.getString("LastLoginTime"));
                userList.add(u);
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return userList;
    }

    public User query(String username){
        User u = new User();
        String sql = SQLUtils.getSQLSelect("user");
        sql += " AND Username = '" + username + "'";
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                u.setUsername(rs.getString("Username"));
                u.setPassword(rs.getString("Password"));
                u.setRealName(rs.getString("RealName"));
                u.setUserType(rs.getString("UserType"));
                u.setLock(rs.getString("UserLock"));
                u.setLastLoginTime(rs.getString("LastLoginTime"));
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return u;
    }

    public List<String> findUsername() {
        List<String> list = new ArrayList<String>();
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        String sql = SQLUtils.getSQLCheck();
        try {
            conn = DBUtils.getConnection();
            stat = conn.createStatement();
            rs = stat.executeQuery(sql);
            while(rs.next()) {
                String s = rs.getString("Username");
                list.add(s);
            }
            DBUtils.close(rs, stat, conn);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        return list;

    }
}

