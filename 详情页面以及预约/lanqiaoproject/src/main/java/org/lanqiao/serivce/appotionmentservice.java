package org.lanqiao.serivce;
import org.lanqiao.bean.Housing;
import org.lanqiao.bean.appotionment;
import org.lanqiao.dao.appotionmentdao;

import java.sql.SQLException;

public class appotionmentservice {
    appotionmentdao dao=new appotionmentdao();
    public int addappotionment(appotionment apt) throws SQLException {
         return dao.addappotionment(apt);
    }


    public appotionment findappotionment(appotionment aap) throws SQLException {

        return dao.findappotionment(aap);
    }


    public String chaxundizhi(Housing house) throws SQLException {
        return dao.chaxundizhi(house);
    }
    public int addhorder(Housing hous) throws SQLException {
        return dao.addhorder(hous);
    }
}
