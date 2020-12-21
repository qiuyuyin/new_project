package com.yili.servlet;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.InvalidFileNameException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断上传的信息流是普通的表单还是一个带有文件流的数据域
        if(!ServletFileUpload.isMultipartContent(req)){
            return;
        }


        String realPath = this.getServletContext().getRealPath("WEB-INF/upload");
        File uploadFile = new File(realPath);
        System.out.println(realPath+"");
        System.out.println("---------");
        if(!uploadFile.exists()){
            uploadFile.mkdir();
        }

        String tmpPath = this.getServletContext().getRealPath("WEB-INF/tmp");
        File tmpFile = new File(tmpPath);
        System.out.println(tmpPath+"");

        if(!tmpFile.exists()){
            tmpFile.mkdir();
        }

        //1.创建一个工厂对象，处理文件的上传路径并且限制文件的大小
        DiskFileItemFactory diskFileItemFactory = getDiskFileItemFactory(tmpFile);
        //2.获取ServletFileUpload
        ServletFileUpload servletFileUpload = getServletFileUpload(diskFileItemFactory);
        //3.处理上传文件
        String msg = null;
        try {
            msg = uploadParseRequest(servletFileUpload,req,realPath);
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        //Servlet请求转发消息
        req.setAttribute("msg",msg);
        req.getRequestDispatcher("/info.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }


    public static DiskFileItemFactory getDiskFileItemFactory(File file){
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置缓冲区的文件大小，当文件大小大于缓冲区的时候，将它放到临时文件中
        factory.setSizeThreshold(1024*1024);
        factory.setRepository(file);
        return factory;
    }
    public static ServletFileUpload getServletFileUpload(DiskFileItemFactory factory){
        ServletFileUpload servletFileUpload = new ServletFileUpload();
        servletFileUpload.setFileItemFactory(factory);
        servletFileUpload.setProgressListener(new ProgressListener() {
            @Override
            public void update(long l, long l1, int i) {
                // 总大小表示为l1，已经上传的大小为l
                System.out.println("总大小："+l1+"已经上传了："+l);
            }
        });
        servletFileUpload.setHeaderEncoding("utf-8");
        servletFileUpload.setFileSizeMax(1024*1024*10);
        servletFileUpload.setSizeMax(1024*1024*10);
        return servletFileUpload;
    }
    public static String uploadParseRequest(ServletFileUpload servletFileUpload,HttpServletRequest req,String uploadPath) throws IOException, FileUploadException {
        String msg = "";
        List<FileItem> fileItems = servletFileUpload.parseRequest(req);
        for(FileItem fileItem:fileItems){
            if(fileItem.isFormField()){
                String name = fileItem.getFieldName();
                String value = fileItem.getString("utf-8");
                System.out.println(name+":"+value);
            }else {
                String name = fileItem.getName();
                System.out.println("上传的文件名："+name);
                if(name==null||name.trim().equals("")){
                    continue;
                }
                String filename = name.substring(name.lastIndexOf("/") + 1);
                String fileExtName = name.substring(name.lastIndexOf(".") + 1);

                String uuidPath = UUID.randomUUID().toString();
                String uuidFileName = UUID.randomUUID().toString();

                System.out.println(filename+"."+fileExtName);
                //传递文件。。。。。。。。。。。。。。。。。。。
                //获得一个文件上传的流
                InputStream inputStream = fileItem.getInputStream();
                //创建一个文件输入流
                FileOutputStream fileOutputStream = new FileOutputStream(uploadPath + "/" + uuidFileName + "." + fileExtName);
                System.out.println(uploadPath + "/" + uuidFileName + "." + fileExtName);

                byte[] buffer = new byte[1024 * 1024];

                int len = 0;

                while ((len=inputStream.read(buffer))>0){
                    fileOutputStream.write(buffer,0,len);
                }

                fileOutputStream.close();
                inputStream.close();
                msg="文件上传成功！";
//                fileItem.delete();
            }
        }
        return msg;
    }
}


