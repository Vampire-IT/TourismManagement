package com.priv.tm.active;


import com.priv.tm.base.Restaurant;
import com.priv.tm.dao.RestDAO;

import java.sql.SQLException;
import java.util.List;

public class RestActive {
    private RestDAO restDAO;
    public RestActive() {
        restDAO = new RestDAO();
    }

    //添加方法
    public void insertR(Restaurant t) {
        try {
            restDAO.insert(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除方法
    public void deleteR(String id) {
        try {
            restDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改方法
    public void updateR(Restaurant t) {
        try {
            restDAO.update(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Restaurant> findR(String rAddr, String rName){
        return restDAO.find(rAddr, rName);
    }

    public Restaurant queryR(String rId){
        return restDAO.query(rId);
    }
}

