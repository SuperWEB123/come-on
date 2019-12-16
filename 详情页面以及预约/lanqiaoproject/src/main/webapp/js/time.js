function createXHR() {
    var xmlhttp;
    if (window.XMLHttpRequest)
    {// code for IE7+, Firefox, Chrome, Opera, Safari
        xmlhttp=new XMLHttpRequest();
    }
    else
    {// code for IE6, IE5
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
    return xmlhttp;
}

function datetime() {
   // alert("点击事件触发")
    //1创建xhmhttprequst对象
    var xmlhttp = createXHR();


    //获取文本框的值
    var date =document.getElementById("date").value;
   // alert("日期"+date)
    var time =document.getElementById("time").value;
    //alert("时间"+time)
    //2设置对象状态改变触发一个函数
    xmlhttp.onreadystatechange=function () {
        if(xmlhttp.readyState == 4){
            if(xmlhttp.status == 200){
                //获取数据
                var jieguo = xmlhttp.responseText;
                //如果是0所选时间小于当前时间
                if(jieguo==1){
                    document.getElementById("un1").innerHTML = "<font color='green'>无效时间，重新预约</font>";
                    //  document.getElementById("un1").innerHTML = "alert(\"无效时间，重新预约\")";
                }else{
                    document.getElementById("un1").innerHTML = "<font color='black'></font>";
                }
            }
        }
    }
    //3向后台提交数据
    //xmlhttp.open("GET","/zy20191125/chaxunServlet?date=111",true)
    xmlhttp.open("GET","/lanqiaoproject/chaxunServlet?date="+date+"&time="+time,true);
    //4发送请求
    xmlhttp.send();
}

function datetime1() {
   // alert("点击事件触发")
    //1创建xhmhttprequst对象
    var xmlhttp = createXHR();


    //获取文本框的值
    var date =document.getElementById("date").value;
   // alert("日期"+date)
    var time =document.getElementById("time1").value;
   // alert("时间"+time)
    //2设置对象状态改变触发一个函数
    xmlhttp.onreadystatechange=function () {
        if(xmlhttp.readyState == 4){
            if(xmlhttp.status == 200){
                //获取数据
                var jieguo = xmlhttp.responseText;
                //如果是0所选时间小于当前时间
                if(jieguo==1){
                    document.getElementById("un1").innerHTML = "<font color='green'>无效时间，重新预约</font>";
                }else{
                    document.getElementById("un1").innerHTML = "<font color='black'></font>";
                }
            }
        }
    }
    //3向后台提交数据
    //xmlhttp.open("GET","/zy20191125/chaxunServlet?date=111",true)
    xmlhttp.open("GET","/lanqiaoproject/chaxunServlet?date="+date+"&time="+time,true);
    //4发送请求
    xmlhttp.send();
}

function datetime2() {
   // alert("点击事件触发")
    //1创建xhmhttprequst对象
    var xmlhttp = createXHR();


    //获取文本框的值
    var date =document.getElementById("date").value;
    //alert("日期"+date)
    var time =document.getElementById("time2").value;
   //alert("时间"+time)
    //2设置对象状态改变触发一个函数
    xmlhttp.onreadystatechange=function () {
        if(xmlhttp.readyState == 4){
            if(xmlhttp.status == 200){
                //获取数据
                var jieguo = xmlhttp.responseText;
                //如果是0所选时间小于当前时间
                if(jieguo==1){
                    document.getElementById("un1").innerHTML = "<font color='green'>无效时间，重新预约</font>";
                }else{
                    document.getElementById("un1").innerHTML = "<font color='black'></font>";
                }
            }
        }
    }
    //3向后台提交数据
    //xmlhttp.open("GET","/zy20191125/chaxunServlet?date=111",true)
    xmlhttp.open("GET","/lanqiaoproject/chaxunServlet?date="+date+"&time="+time,true);
    //4发送请求
    xmlhttp.send();
}

function datetime3() {
    //alert("点击事件触发")
    //1创建xhmhttprequst对象
    var xmlhttp = createXHR();


    //获取文本框的值
    var date =document.getElementById("date").value;
    //alert("日期"+date)
    var time =document.getElementById("time3").value;
    //alert("时间"+time)
    //2设置对象状态改变触发一个函数
    xmlhttp.onreadystatechange=function () {
        if(xmlhttp.readyState == 4){
            if(xmlhttp.status == 200){
                //获取数据
                var jieguo = xmlhttp.responseText;
                //如果是0所选时间小于当前时间
                if(jieguo==1){
                    document.getElementById("un1").innerHTML = "<font color='green'>无效时间，重新预约</font>";
                }else{
                    document.getElementById("un1").innerHTML = "<font color='black'></font>";
                }
            }
        }
    }
    //3向后台提交数据
    //xmlhttp.open("GET","/zy20191125/chaxunServlet?date=111",true)
    xmlhttp.open("GET","/lanqiaoproject/chaxunServlet?date="+date+"&time="+time,true);
    //4发送请求
    xmlhttp.send();
}

//检查手机号是否合法
function checkmobile() {
    //获取XHP对象
    var xhr = createXHR();

    var mobile = document.getElementById('mobile').value;//获取页面手机号
    alert(mobile);

    if (mobile.length != 11) {
        document.getElementById("mb").innerHTML = "<font color='red'>手机号不合法</font>";
    } else {
        document.getElementById("mb").innerHTML = "<font color='red'></font>";
    }
}
