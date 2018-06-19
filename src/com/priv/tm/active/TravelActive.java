package com.priv.tm.active;


import com.priv.tm.base.Travel;
import com.priv.tm.dao.TravelDAO;

import java.sql.SQLException;
import java.util.List;

public class TravelActive {
    private TravelDAO travelDAO;
    public TravelActive() {
        travelDAO = new TravelDAO();
    }

    //添加方法
    public void insertT(Travel t) {
        try {
            travelDAO.insert(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除方法
    public void deleteT(String id) {
        try {
            travelDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改方法
    public void updateT(Travel t) {
        try {
            travelDAO.update(t);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Travel> findT(String tName){
        return travelDAO.find(tName);
    }

    public Travel queryT(String tId){
        return travelDAO.query(tId);
    }
}

