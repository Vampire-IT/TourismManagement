package com.priv.tm.active;

import com.priv.tm.base.Assign;
import com.priv.tm.dao.AssignDAO;
import com.priv.tm.util.SQLUtils;

import java.sql.SQLException;
import java.util.List;

public class AssignActive {
    private AssignDAO assignDAO;
    public AssignActive() {
        assignDAO = new AssignDAO();
    }

    //添加方法
    public void insertA(Assign a) {
        try {
            assignDAO.insert(a);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateResult(String result, String id){
        try {
            assignDAO.updateResult(result,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Assign> findA(String Username,String cTarget,String cName) {
        return assignDAO.find(Username,cTarget,cName);
    }
}

