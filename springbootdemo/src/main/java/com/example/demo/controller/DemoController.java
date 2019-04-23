package com.example.demo.controller;

import com.example.demo.service.DemoService;
import com.example.demo.service.IDemoService;
import com.example.demo.vo.StudentVo;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by kobe on 2018/10/9.
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;
    @Autowired
    private IDemoService demoService1;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String sayHello(HttpServletRequest request){
        ServletContext context = request.getServletContext();
       context.setAttribute("test","测试");
        System.out.println(context.getAttribute("test"));
        return demoService.demo();
    }

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public void testServletContext(HttpServletRequest request){
        ServletContext context = request.getServletContext();
        System.out.println(context.getAttribute("server.port"));
        System.out.println(context.getAttribute("test"));
    }

    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public  void downLoad(HttpServletResponse response){

        try {
            HSSFWorkbook wb = new HSSFWorkbook();
            HSSFSheet sheet = wb.createSheet("assumption");
            sheet.createRow(0).createCell(1).setCellValue("test");
            response.setContentType("application/octet-stream");
            response.setHeader("content-disposition", "attachment;filename="+URLEncoder.encode("test.xls","utf-8"));
            response.setCharacterEncoding("utf-8");
            OutputStream out = response.getOutputStream();
            wb.write(out);
        }catch(Exception e) {
            //logger.error(StringUtil.getExceptionStackTrace(e));
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/testAop",method = RequestMethod.GET)
    public void testAop(){
        StudentVo studentVo = new StudentVo();
        studentVo.setAge(21);
        studentVo.setId("11111");
        studentVo.setName("gyf");
        demoService1.testStudent(studentVo);
    }
}
