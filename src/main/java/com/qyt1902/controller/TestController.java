package com.qyt1902.controller;

import com.qyt1902.util.FastDFSClient;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Iterator;

@Controller
@RequestMapping(value = "/")
public class TestController
{
    @RequestMapping(value = "uploadRxPic",method = RequestMethod.POST)
    @ResponseBody
    public String returnSuccess(HttpServletRequest request) {
        String ret="";
        try{
            FastDFSClient client = new FastDFSClient("classpath:tracker_server.conf");
            CommonsMultipartResolver multipartResolver= new CommonsMultipartResolver(request.getSession().getServletContext());
            if(multipartResolver.isMultipart(request)){
                MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
                Iterator<String> iter=multipartRequest.getFileNames();
                while (iter.hasNext()){
                    MultipartFile multipartFile=multipartRequest.getFile(iter.next());
                    CommonsMultipartFile cf= (CommonsMultipartFile)multipartFile;
                    DiskFileItem fi = (DiskFileItem)cf.getFileItem();
                    File file =fi.getStoreLocation();
                    String ext = FilenameUtils.getExtension(fi.getName());
                    String uploadFile = client.uploadFile(file.getAbsolutePath(), ext);
                    ret=toJson("http://39.108.88.100/"+uploadFile);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ret;
    }

    @RequestMapping(value = "index2")
    //produces���ڽ�����������������⣬application/json;Ϊjson�����������
    public String returnIndex() {
        return "index2";
    }

    @RequestMapping(value = "pic")
    //produces���ڽ�����������������⣬application/json;Ϊjson�����������
    public String returnPic() {
        String ss="aa";
        return "/pic/pic";
    }


    public String toJson(String str){
        JSONObject jo =new JSONObject();
        jo.put("path",str);
        return jo.toString();
    }
}