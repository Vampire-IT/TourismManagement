package com.priv.tm.active;


import com.priv.tm.base.Scenic;
import com.priv.tm.dao.ScenicDAO;

import java.sql.SQLException;
import java.util.List;

public class ScenicActive {
    private ScenicDAO scenicDAO;
    public ScenicActive() {
        scenicDAO = new ScenicDAO();
    }

    //添加方法
    public void insertS(Scenic s) {
        try {
            scenicDAO.insert(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除方法
    public void deleteS(String id) {
        try {
            scenicDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改方法
    public void updateS(Scenic s) {
        try {
            scenicDAO.update(s);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Scenic> findS(String sAddr, String sName){
        return scenicDAO.find(sAddr, sName);
    }

    public Scenic queryS(String sId){
        return scenicDAO.query(sId);
    }
}

