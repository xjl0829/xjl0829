package com.nowcoder.community.controller;

import com.nowcoder.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * @Auther: zjl
 * @Date: 2022/5/10 - 23:09
 * @Description: com.nowcoder.community.controller
 * @Version: 1.0
 */
@Controller
@RequestMapping("/alpha")
public class AlphaController {

    @Autowired
    private AlphaService alphaService;

    @RequestMapping(value = "/hello")
    @ResponseBody
    public String sayHello(){
        return "Hello Spring Boot!123";
    }

    @RequestMapping("/find")
    @ResponseBody
    public String getData(){
        return alphaService.find();
    }

    @RequestMapping("/http")
    public void http(HttpServletRequest request, HttpServletResponse response){
        //获取请求数据
        System.out.println(request.getMethod());
        System.out.println(request.getServletPath());
        Enumeration<String> enumeration = request.getHeaderNames();
        while (enumeration.hasMoreElements()){
            String name = enumeration.nextElement();
            String value = request.getHeader(name);
            System.out.println(name + ": " + value);
        }
        System.out.println(request.getParameter("code"));
        //返回响应数据
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write("<h1>牛客</h1>");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }
    }

    //GET 请求 /students?current=  &limit= `1
    @RequestMapping(path="/students",method=RequestMethod.GET)
    @ResponseBody
    public String findGET(@RequestParam(name ="current",required = false,defaultValue = "1") int current,
                          @RequestParam(name ="limit",required = false,defaultValue = "10")int limit){
        System.out.println(current);
        System.out.println(limit);
        return "some student";
    }

    // /student/123
    @RequestMapping(path = "/student/{id}",method = RequestMethod.GET)
    @ResponseBody
    public String getStudent(@PathVariable("id") int id){
        System.out.println(id);
        return "a student";
    }

    //POST请求
    @RequestMapping(path = "student",method = RequestMethod.POST)
    @ResponseBody
    public String saveStudent(String name,String age){
        System.out.println(name);
        System.out.println(age);
        return "/teacher";
    }

    //响应HTML数据
    @RequestMapping(path = "/teacher",method = RequestMethod.GET)
    public ModelAndView getTeacher(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","zs");
        modelAndView.addObject("age",29);
        modelAndView.setViewName("/demo/view");
        return modelAndView;
    }

    //响应HTML数据
    @RequestMapping(path = "/school",method = RequestMethod.GET)
    public String getSchool(Model model){
        model.addAttribute("name","zut");
        model.addAttribute("age",3);
        return "/demo/view";
    }

    //响应JSON数据(异步请求)
    //java对象-> JSON字符串-> JS对象
    @RequestMapping(path = "/emp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getEmp(){
        Map<String,Object> map = new HashMap<>();
        map.put("name","zs");
        map.put("age","123");
        map.put("salary","12k");
        return map;
    }

    @RequestMapping(path = "/emps",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getEmps(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        map.put("name","zs");
        map.put("age","123");
        map.put("salary","12k");
        list.add(map);

        Map<String,Object> map1 = new HashMap<>();
        map1.put("name","ls");
        map1.put("age","13");
        map1.put("salary","8k");
        list.add(map1);

        Map<String,Object> map2 = new HashMap<>();
        map2.put("name","ww");
        map2.put("age","143");
        map2 .put("salary","10k");
        list.add(map2);

        return list;
    }

}
