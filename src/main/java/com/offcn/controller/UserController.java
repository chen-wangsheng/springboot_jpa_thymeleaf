package com.offcn.controller;

import com.offcn.bean.User;
import com.offcn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author 陈旺生
 * @create 2019-12-31 20:53
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String findAll(Model model){
        List<User> userList = userService.findAll();
        model.addAttribute("page",userList);

        return "user/list";
    }
    //用户点击add按钮，跳转到新增用户页面
    @RequestMapping("/toAdd")
    public String toAdd(){
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String save(User user){
        userService.add(user);
        //跳转到列表页
        return "redirect:/";
    }


    //跳转到编辑页面
    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model,@PathVariable("id") Long id){
        //读取对应id用户信息
        User user = userService.findOne(id);
        model.addAttribute("user",user);
        //跳转到编辑页面
        return "user/userEdit";
    }

    //保存修改用户数据
    @RequestMapping("/update")
    public String update(User user){
        userService.update(user.getId(),user);
        //跳转到列表页
        return "redirect:/";
    }

    //删除用户数据
    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id){
        userService.delete(id);
        //跳转到列表页
        return "redirect:/";

    }


}
