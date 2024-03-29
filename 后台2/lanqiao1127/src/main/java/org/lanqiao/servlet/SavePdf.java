package org.lanqiao.servlet;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.lanqiao.service.FYService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/* 上传图片*/
@WebServlet( "/SavePdf")
public class SavePdf extends HttpServlet {
    private double hmoney;//价格
    private double harea;//面积
    private String haddress;//地区
    private String housetype;//类型
    private String hphoto;//图片地址
    private String hsynopsis;//详情
    private String hregion;//区

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("utf-8");

        //得到上传文件的保存目录
        String savePath = "D:\\LJ1\\lanqiao1127\\src\\main\\webapp\\img\\";
        String savePath2="img/";
        String filename="";
        File file = new File(savePath);
        //判断上传文件的保存目录是否存在
        if (!file.exists() && !file.isDirectory()) {
            System.out.println(savePath + "目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }
        //消息提示
        String message = "";

        try {
            //使用Apache文件上传组件处理文件上传步骤：
            //1、创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2、创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UTF-8");
            //3、判断提交上来的数据是否是上传表单的数据
            if (!ServletFileUpload.isMultipartContent(request)) {
                //按照传统方式获取数据
                System.out.println("我进来了");
            }
            //4、使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem item : list) {
                //如果fileitem中封装的是普通输入项的数据
                //其实就是判断from表单中除文件以外的数据
                if (item.isFormField()) {
                    String name = item.getFieldName();
                    if("hmoney".equals(name)){
                        hmoney= Double.parseDouble(item.getString("UTF-8"));
                        System.out.println(hmoney);
                    }else if("harea".equals(name)){
                        harea=Double.parseDouble(item.getString("UTF-8"));
                        System.out.println(harea);
                    } else if("hregion".equals(name)){
                        hregion=item.getString("UTF-8");
                        System.out.println(haddress);
                    }else if("haddress".equals(name)){
                        haddress=item.getString("UTF-8");
                        System.out.println(haddress);
                    }else if("housetype".equals(name)){
                        housetype=item.getString("UTF-8");
                        System.out.println(housetype);
                    }else if("hsynopsis".equals(name)){
                        hsynopsis=item.getString("UTF-8");
                        System.out.println(hsynopsis);
                    }
                    //解决普通输入项的数据的中文乱码问题
                    /*String value = item.getString("UTF-8");
                    value = new String(value.getBytes("iso8859-1"),"UTF-8");
                    System.out.println(name + "=" + value)*/;
                } else {//如果fileitem中封装的是上传文件
                    //得到上传的文件名称
                    filename = item.getName();
                    hphoto+=savePath2+filename+"-";
                    //System.out.println(filename);//文件名
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交上来的文件名是带有路径的，如：  c:\a\b\1.txt，而有些只是单纯的文件名，如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    filename = filename.substring(filename.lastIndexOf("\\") + 1);
                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //创建一个文件输出流
                    FileOutputStream out = new FileOutputStream(savePath + filename);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while ((len = in.read(buffer)) > 0) {
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        out.write(buffer, 0, len);
                    }
                    //关闭输入流
                    in.close();
                    //关闭输出流
                    out.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    message="{\"code\":\"0\",\"msg\":\"上传成功\"}";

                    JSONObject jsonsb = JSONObject.parseObject(message);
                    response.getWriter().write(String.valueOf(jsonsb));

                }
            }

            //图片路径
            String substring = hphoto.substring(0, hphoto.length()-1);
            System.out.println(substring);

            //调用Service
            FYService service = new FYService();
            int i = service.add(hmoney,harea,hregion,haddress,housetype,substring,hsynopsis);
            //判断房源信息是否添加成功
            if(i==0){
                System.out.println("添加失败");
            }else{
                System.out.println("添加成功");
            }
        } catch (Exception e) {
            message="{\"code\":\"1\",\"msg\":\"上传失败\"}";
            JSONObject jsonsb = JSONObject.parseObject(message);
            response.getWriter().write(String.valueOf(jsonsb));
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}