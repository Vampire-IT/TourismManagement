package com.priv.tm.active;


import com.priv.tm.base.User;
import com.priv.tm.dao.UserDAO;
import com.priv.tm.util.SQLUtils;

import java.sql.SQLException;
import java.util.List;

public class UserActive {
    private UserDAO userDAO;
    public UserActive() {
        userDAO = new UserDAO();
    }

    //添加方法
    public void insertU(User u) {
        try {
            userDAO.insert(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除方法
    public void deleteU(String id) {
        try {
            userDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改方法
    public void updateU(User u) {
        try {
            userDAO.update(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void upLookU(User u){
        try {
            userDAO.upLook(u);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<User> findU(String realName,String userType,String lock){
        return userDAO.find(realName, userType, lock);
    }

    public User queryU(String username){
        return userDAO.query(username);
    }

    public List<String> findUsername() {
        return userDAO.findUsername();
    }
}

