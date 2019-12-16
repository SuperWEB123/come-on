package org.lanqiao.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.lanqiao.bean.Housing;
import org.lanqiao.bean.Housings;
import org.lanqiao.serivce.HousingSerivce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/HousingServlet")
public class HousingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            System.out.println("进入HousingServlet。。。");
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Access-Control-Allow-Origin", "*");


            //获取房源id
            String hid = request.getParameter("hid");
            System.out.println("房源id：" + hid);

            //调用service层执行sql(查询数据库里面对应的房屋信息)
            HousingSerivce housingSerivce = new HousingSerivce();
            List<Housing> housing = housingSerivce.selectHousing(hid);
            //将多张照片切割成为集合
            List<String> photo = Arrays.asList(housing.get(0).getHphoto().split("-"));


            //new Housings对象存值
            Housings hs = new Housings();
            hs.setHousing(housing);
            hs.setPhoto(photo);

            //将对象转为josn格式
            ObjectMapper mapper = new ObjectMapper();
            String res = mapper.writeValueAsString(hs);
            System.out.println("转换为json格式："+res);
            //返回json格式的数据
            response.getWriter().write(res);
            System.out.println("断点");
        } catch (SQLException e) {
            e.printStackTrace();
        }

//            HousingSerivce hs = new HousingSerivce();
//            Housing housing = hs.selectHousing(hid);
//            request.setAttribute("H",housing);
//            request.getRequestDispatcher("/housing.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
