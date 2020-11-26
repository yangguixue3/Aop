package com.msr.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 上传文件: servlet  request方式
 *          springMVC 方式
 *
 *          前提:   enctype:是表单请求正文的类型
 *                  form 表单的 enctype 取值必须是：multipart/form-data
 *                  (默认值是:application/x-www-form-urlencoded)
 */
@Controller
@RequestMapping("/upload")
public class IndexController {
    /**
     * 上传文件: servlet  request方式
     *        需要: DiskFileItemFactory依赖jar包
     */
    @RequestMapping(value="/servletUpload",method = RequestMethod.POST)
    public String servletUpload(HttpServletRequest request) throws Exception {
        System.out.println("servlet  request方式上传开始...");
        // 1.设置文件存储位置  tomcat部署de工程ROOT
        String path = request.getServletContext().getRealPath("/uploads22/");
        System.out.println("文件存储位置  path = " + path);
        // 2. 判断目录是否存在
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        // 3. 解析request请求对象,获取所有表单项
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
        List<FileItem> fileItems = upload.parseRequest(request);
        // 4.筛选 : 表单项还是上传项
        for (FileItem fileItem : fileItems) {
            if (fileItem.isFormField()) {
                // true : 表单项
            } else {
                // false : 上传项
                // 5.获取上传文件的名称
                    //fileItem.getName()获得上传时文件名，    有的浏览器会返回文件名，而有的浏览器会返回“路径”+“文件名”
                    //new File(fileItem.getName()) 通过文bai件名获得一个文件对象du，
                    //(new File(fileItem.getName())).getName();调用文件对象的baigetName()方法，获得不带路径的文件名。du
                String fileName = (new File(fileItem.getName())).getName();

                System.out.println("fileName = " + fileName);
                String uuid = UUID.randomUUID().toString().replace("-", "").concat("_");
                fileName = uuid + fileName;
                System.out.println("fileName = " + fileName);
                // 6.上传文件
                fileItem.write(new File(path,fileName));
                fileItem.delete();// 删除临时文件  :  10kb
                System.out.println("文件上传结束...............");
            }
        }


        System.out.println("servlet  request方式上传结束...");
        return "success";
    }
    /**
     * 上传文件: springMVC方式
     *        需要: springMVC.xml 配置 上传文件解析器对象 CommonsMultipartResolver
     *          upload 与 表单 <input type="file" name="upload"> 保持一致，否则报空指针
     *              或者 <input type="file" name="uploadFile">
     *               @RequestParam(value = "uploadFile",required = false) MultipartFile upload
     */
    @RequestMapping(value="/servletUpload02",method = RequestMethod.POST)
    public String servletUpload(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("springMVC方式上传开始...");
        // 1.设置文件存储位置  tomcat部署de工程ROOT
        String path = request.getServletContext().getRealPath("/uploads22/");
        // 2. 判断目录是否存在
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        // 3.1 获取 上传文件名称
        String originalFilename = upload.getOriginalFilename();
        // 3.2 生成唯一的字符串 去除-  末尾加_
        String prefixName = UUID.randomUUID().toString().replace("-", "").concat("_");
        String fileName = prefixName + originalFilename;
        System.out.println("fileName = " + fileName);
        //4.上传文件
        upload.transferTo(new File(path,fileName));
        System.out.println("springMVC 方式上传结束...");
        return "success";
    }
}
