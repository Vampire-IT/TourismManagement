package com.priv.tm.active;


import com.priv.tm.base.Hotel;
import com.priv.tm.dao.HotelDAO;

import java.sql.SQLException;
import java.util.List;

public class HotelActive {
    private HotelDAO HotelDAO;
    public HotelActive() {
        HotelDAO = new HotelDAO();
    }

    //添加方法
    public void insertH(Hotel h) {
        try {
            HotelDAO.insert(h);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //删除方法
    public void deleteH(String id) {
        try {
            HotelDAO.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //修改方法
    public void updateH(Hotel h) {
        try {
            HotelDAO.update(h);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Hotel> findH(String hAddr, String hName,String hRatin){
        return HotelDAO.find(hAddr, hName, hRatin);
    }

    public Hotel queryH(String hId){
        return HotelDAO.query(hId);
    }
}

