package com.priv.tm.active;

import com.priv.tm.base.Complain;
import com.priv.tm.dao.ComDAO;
import java.sql.SQLException;
import java.util.List;

public class ComActive {
    private ComDAO comDAO;
    public ComActive() {
        comDAO = new ComDAO();
    }

    //添加方法
    public void insertC(Complain c) {
        try {
            comDAO.insert(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除方法
    public void deleteC(String id) {
        try {
            comDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改方法
    public void updateC(Complain c) {
        try {
            comDAO.update(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateMack(String cId) {
        try {
            comDAO.updateMack(cId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Complain> findC(String cTarget, String cName, String mark) {
        return comDAO.find(cTarget, cName,mark);
    }

    public Complain queryC(String cId){
        return comDAO.query(cId);
    }
}

