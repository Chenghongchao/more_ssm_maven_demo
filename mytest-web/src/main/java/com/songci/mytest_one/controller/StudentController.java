package com.songci.mytest_one.controller;

import com.songci.mytest_one.model.Student;
import com.songci.mytest_one.model.utils.ResultVo;
import com.songci.mytest_one.service.StudentService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Created by songl on 2017/8/10.
 */
@Controller
@RequestMapping("/studentApi/")
public class StudentController {
    @Resource
    private StudentService studentService;
    @RequestMapping("findAllStudentInfo")
    public @ResponseBody
    ResultVo findAllStudentInfo (@RequestParam("id") String id){
        Student student=new Student();
        //不做过多验证判断
        if ("0".equals(id)){student=null;}
        else {student.setId(new Integer(id));}
        return studentService.findAllStudent(student);
    }
    @RequestMapping(value = "userName.json",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map getUserName(@RequestParam Map<String,Object> maps){

        return maps;
    }
}
