package com.lovo.springBoot.controller;

import com.lovo.springBoot.entity.UserEntity;
import com.lovo.springBoot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("login")
    public String getUser(String userName,String password){
        int p = Integer.parseInt(password);
        UserEntity user=userService.findUser(userName,p);
        if(user!=null){
            return "登录成功";
        }
        return "登录失败";
    }
    @RequestMapping("addUser")
    public ModelAndView addUser(UserEntity user){
    ModelAndView mv = new ModelAndView();
    userService.saveUser(user);
    mv.addObject("user",user);
        //重定向到查询controller
        RedirectView rv = new RedirectView();
        rv.setUrl("findUser");
        mv.setView(rv);
        return mv;

    }
    @RequestMapping("findUser")
    public ModelAndView findUser(){
    ModelAndView mv = new ModelAndView("userShow");
    mv.addObject("userList",userService.findAll());
    return mv;
    }

    @RequestMapping("gotoUpdateUser")
    public ModelAndView gotoUpdateUser(String id){
        ModelAndView mv=new ModelAndView("user");
        //根据ID获取对象
        int uid= Integer.parseInt(id);
        UserEntity user=  userService.findUserById(uid);
        //把对象放入到模型
        mv.addObject("user",user);

        return  mv;
    }
    @RequestMapping("deleteUser")
    public ModelAndView deleteUser(String id){
        ModelAndView mv = new ModelAndView();
        int uid= Integer.parseInt(id);
        userService.deleteUser(uid);
        RedirectView rv = new RedirectView();
        rv.setUrl("findUser");
        mv.setView(rv);
        return mv;

    }
    @RequestMapping("gotoUserPage")
    public  ModelAndView gotoUserPage(){
        ModelAndView mv=new ModelAndView("user");
        UserEntity user=new UserEntity();
        mv.addObject("user",user);
        return mv;
    }
}
