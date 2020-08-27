package com.kgc.controller;

import com.kgc.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    /**
     * 响应结果类型是String
     * @param model
     * @return
     */
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString方法执行了...");
        //模拟调用service查询用户信息
        User user = new User();
        user.setUsername("哥哥");
        user.setPassword("123");
        user.setAge(30);
        //借助model将信息存入request域中
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 响应结果是void类型
     *   默认情况是根据方法名称形成逻辑视图
     *   找的就是当前方法名称.jsp
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //编写请求转发的路径
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //response.sendRedirect(request.getContextPath()+"/h.jsp");
        //System.out.println("testVoid方法执行了...");
        /**
         * 注意  请求转发可以访问WEB-INF下的资源
         *       重定向是不可以访问WEB0-INF下的资源
         */
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("hello  成都");
        return;
    }

    /**
     * 响应的结果类型是testModelAndView
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建ModelAndView
        ModelAndView mdv = new ModelAndView();
        //模拟调用service查询user对象信息
        User user = new User();
        user.setUsername("哥哥");
        user.setPassword("123");
        user.setAge(30);
        //把User对象存入mdv中 也会把user对象存入request域中
        mdv.addObject("user",user);
        //跳转到某某某页面
        mdv.setViewName("success");
        return mdv;
    }

    /**
     * 使用关键字的方式来完成请求转换发和重定向
     * 注意  在是永恒重定向关键字进行重定向时springmvc会帮助我们自动加上虚拟目录
     * @return
     */
    @RequestMapping("/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        //请求转发
        //return "forward:/WEB-INF/pages/success.jsp";
        //重定向
        return "redirect:/index.jsp";//问题  重定向需要加上虚拟目录
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){//json -- 》 Javabean
        System.out.println("testAjax方法执行了...");
        System.out.println(user);//前端获取的json被转换为了user
        //模拟查询数据库
        user.setUsername("haha");
        user.setAge(21);
        return user;
    }
}
