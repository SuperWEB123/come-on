package org.lanqiao.servlet;
import org.lanqiao.utils.TimeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/chaxunServlet")
public class chaxunServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //0乱码
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        System.out.println("进入chaxunServlet了。。。");

        //获取页面的日期与时间
        String wydate = request.getParameter("date");
        System.out.println(wydate);
        String wytime = request.getParameter("time");
        System.out.println(wytime);


        //获取当前时间
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date1 = df.format(date);
        System.out.println(date1);

        //把预约人预约的时间段用“-”切割，（列如：预约时间段为10:00-12:00,则切割为10:00和12:00）
        String[] split = wytime.split("\\-");
        // 把系统拿到的当前时间作为有效时间的开始时间
        Date effectivetime = TimeUtils.strToDate(df.format(date));
        // 把预约人预约的时间段的结束时间作为有效时间的失效时间时间
        Date invalidtime = TimeUtils.strToDate(wydate + " " + split[0]);
        //判断预约人的预约时间是否在有效时间段里
        boolean b = TimeUtils.belongCalendar(date, effectivetime, invalidtime);
        if(b==true){
            System.out.println("返回结果"+0);
            response.getWriter().print(0);
        }else {
            System.out.println("返回结果"+1);
            response.getWriter().print(1);
        }

     }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
