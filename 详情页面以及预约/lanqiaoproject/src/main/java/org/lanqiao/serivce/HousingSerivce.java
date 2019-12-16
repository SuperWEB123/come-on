package org.lanqiao.serivce;

import org.lanqiao.bean.Housing;
import org.lanqiao.dao.HousingDao;

import java.sql.SQLException;
import java.util.List;

public class HousingSerivce {
    HousingDao dao = new HousingDao();

    public List<Housing> selectHousing(String hid) throws SQLException {
        return dao.selecthousing(hid);
    }
}
