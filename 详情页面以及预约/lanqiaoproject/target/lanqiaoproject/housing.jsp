<%@ page import="org.lanqiao.bean.Housing" %><%--
  Created by IntelliJ IDEA.
  User: 16067
  Date: 2019/12/2
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>房源详情</title>
</head>
<head>
    <meta charset="UTF-8">
    <title>房源详情</title>
    <link rel="stylesheet" href="layui-v2.5.5/layui/css/layui.css" media="all">
</head>
<body>
<script src="layui-v2.5.5/layui/layui.all.js"></script>
<%
    Housing housing = (Housing) request.getAttribute("housing");
%>
<form action="/lanqiaoproject/HousingServlet?id=<%=housing.getHid()%>&money=<%= housing.getHmoney()%>&mianji=<%= housing.getHarea()%>&address=<%= housing.getHaddress()%>&ousetype=<%=housing.getHousetype()%>&order=<%=housing.getHorder()%>&synopsis=<%=housing.getHsynopsis()%>" method="post" >
    <div style="width: 23%;float: left;border: 0px solid #A9A9A9;text-align: center">
        <%
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("utf-8");
            request.setCharacterEncoding("utf-8");

            System.out.println("房源的值"+housing);
        %>
        <img src="<%=housing.getHphoto()%>"><br>

    </div>
    <div style="width: 23%;float: left;border: 0px solid #A9A9A9;text-align: left">
        <font size="3">价格：<%= housing.getHmoney()%>/m2</font><br>
        <font size="3">面积：<%= housing.getHarea()%>/m2</font><br>
        <font size="3" >地址：<%= housing.getHaddress()%></font><br>
        <font size="3">房型:<font color="#dc143c"><%= housing.getHousetype()%></font>册</font><br>
        <font size="3" >预约量：<%= housing.getHorder()%>个</font><br>
        <font size="3">房源详情：</font>
        <textarea rows="2" cols="23" name="myself"></textarea><br>
    </div>
    <button class="layui-btn layui-btn-normal">预约看房</button>
    <!--    清除悬浮-->
    <div style="clear: both"></div>
</form>
</body>
</html>
