package org.lanqiao.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.lanqiao.bean.Housing;
import org.lanqiao.bean.appotionment;
import org.lanqiao.utils.JDBCUtils;

import java.sql.SQLException;

public class appotionmentdao  {
    QueryRunner qr=new QueryRunner(JDBCUtils.getDS());

    public int addappotionment(appotionment apt) throws SQLException {
        String sql="INSERT INTO appotionment VALUES (NULL,?,?,?,?,?,?,?)";
        Object[] params={apt.getUname(),apt.getSex(),apt.getTelephone(),apt.getDate(),apt.getTime(),apt.getHid(),apt.getHaddress()};
        int update = qr.update(sql, params);
        return update;
    }


    public appotionment findappotionment(appotionment aap) throws SQLException {
        String sql = "SELECT * FROM appotionment WHERE date=? and time=? and hid=? ";
        Object[] params = {aap.getDate(),aap.getTime(),aap.getHid()};
        appotionment datetime = qr.query(sql, new BeanHandler<>(appotionment.class), params);
        return datetime;
}

    public String  chaxundizhi(Housing house) throws SQLException {
        String sql = "SELECT haddress FROM housing WHERE hid=?";
        Object[] params = {house.getHid()};
        Housing housing = qr.query(sql, new BeanHandler<Housing>(Housing.class), params);
        String haddress=housing.getHaddress();
        System.out.println(haddress);
        return haddress;
    }
    public int addhorder(Housing hous) throws SQLException {
        String sql = "UPDATE housing SET horder = horder+1 WHERE hid=?;";
        Object[] params = {hous.getHid()};
        int update = qr.update(sql, params);
        return update;
    }

}