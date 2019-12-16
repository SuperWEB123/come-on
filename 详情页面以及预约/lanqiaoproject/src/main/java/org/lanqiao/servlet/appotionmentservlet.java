package org.lanqiao.servlet;
import org.lanqiao.bean.Housing;
import org.lanqiao.bean.appotionment;
import org.lanqiao.serivce.appotionmentservice;
import org.lanqiao.utils.TimeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/appotionmentservlet")
public class appotionmentservlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //中文乱码
            response.setContentType("text/html;charset=utf-8");
            request.setCharacterEncoding("utf-8");
            //获取v 姓名
            String uname = request.getParameter("uname");
            System.out.println(uname);
            //获取电话
            String telephone = request.getParameter("telephone");
            System.out.println(telephone);
            //获取房源id
            int hid1 =  Integer.parseInt( request.getParameter("hid"));
            System.out.println(hid1);

            Housing house=new Housing();
            house.setHid(hid1);

            appotionmentservice hou=new appotionmentservice();
            String  hid = hou.chaxundizhi(house);




            //获取性别
           String sex = request.getParameter("sex");
            System.out.println(sex);
            //获取日期
            String date3 =  request.getParameter("date");
            System.out.println(date3);
          //时间转换成time
           String time = request.getParameter("time");
            System.out.println(time);

            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            //SimpleDateFormat df1 = new SimpleDateFormat("HH:mm:ss");
            String date1 = df.format(date);
           // String time = df1.format(date);
            System.out.println(date1);
        //    System.out.println(time);
            //上传数据
            appotionment apt=new appotionment();
            apt.setUname(uname);
            apt.setTelephone(telephone);
            apt.setSex(sex);
            apt.setDate(date3);
            apt.setTime(time);
            apt.setHid(hid1);
            apt.setHaddress(hid);


            appotionment aap=new appotionment();
            aap.setDate(date3);
            aap.setTime(time);
            aap.setHid(hid1);

            //查询数据库
            //数据库有无同一时间选择同一套房
            appotionmentservice ap=new appotionmentservice();
            appotionment aa= ap.findappotionment(aap);
            //提交预约
            appotionmentservice aps=new appotionmentservice();
                int i=aps.addappotionment(apt);
            System.out.println(i);

            //把预约人预约的时间段用“-”切割，（列如：预约时间段为10:00-12:00,则切割为10:00和12:00）
            String[] split = time.split("\\-");
            // 把系统拿到的当前时间作为有效时间的开始时间
            Date effectivetime = TimeUtils.strToDate(df.format(date));
            // 把预约人预约的时间段的结束时间作为有效时间的失效时间时间
            Date invalidtime = TimeUtils.strToDate(date3 + " " + split[1]);
            //判断预约人的预约时间是否在有效时间段里
            boolean b = TimeUtils.belongCalendar(date, effectivetime, invalidtime);
            PrintWriter out = response.getWriter();
            if(b==true){
                if(aa==null){
                    if(i==1){
                        Housing hous=new Housing();
                        hous.setHid(hid1);

                        appotionmentservice hou1=new appotionmentservice();
                        int addhorder = hou1.addhorder(hous);
                        if(addhorder==1){
                            System.out.println("修改成功");
                        }else {
                            System.out.println("修改失败");
                        }
                        out.write("<html>"
                                + "<head><script type='text/javascript'> alert('预约成功');location='housing.html';</script></head>"
                                + "<body></body><ml>");

                        return  ;

                    }else{
                        out.write("<html>"
                                + "<head><script type='text/javascript'> alert('预约失败');location='time.html';</script></head>"
                                + "<body></body><ml>");

                        return;
                    }
                }else{
                    out.write("<html>"
                            + "<head><script type='text/javascript'> alert('该房子在这一时间段已经被预约');location='housing.html';</script></head>"
                            + "<body></body><ml>");

                    return;

                }
            }else {
                out.write("<html>"
                        + "<head><script type='text/javascript'> alert('您预约的时间处于无效时间段，请您重新预约');location='housing.html';</script></head>"
                        + "<body></body><ml>");

                return;

            }

            } catch (SQLException e) {
                e.printStackTrace();
            }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }



}
