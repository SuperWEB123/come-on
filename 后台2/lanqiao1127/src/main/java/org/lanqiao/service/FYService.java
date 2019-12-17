package org.lanqiao.service;

import org.lanqiao.dao.FYdao;

import java.sql.SQLException;

public class FYService {
    FYdao dao = new FYdao();

    public int add(double hmoney, double harea,String hregion, String haddress, String housetype, String hsynopsis,String substring) throws SQLException {
        return dao.fy(hmoney,harea,hregion, haddress,  housetype,substring, hsynopsis);
    }



//    public int add(Fang f) throws SQLException {
//
//    }

//    public int add(double hmoney, double harea, String haddress, String housetype, String hsynopsis) {
//    }
}
