package org.lanqiao.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.lanqiao.bean.Housing;
import org.lanqiao.utils.JDBCUtils;

import java.sql.SQLException;
import java.util.List;

public class HousingDao {
    QueryRunner qr = new QueryRunner(JDBCUtils.getDS());
    public List<Housing> selecthousing(String hid) throws SQLException {
        String sql = "select * from housing where hid = ?";
        List<Housing> housings = qr.query(sql, new BeanListHandler<Housing>(Housing.class), hid);
        System.out.println("返回值"+housings);
        return housings;

    }
}
