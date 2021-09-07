package com.yao.springboot_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by WXHang on HANG at 2021/9/7 14:44
 * Desc：
 */
@Controller
public class RouterController {

    @RequestMapping({"/","index"})
    public String index(){
        return "index";
    }

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }
    @RequestMapping("/level1{id}")
    public String toLevel1(@PathVariable("id") int id){
        return "views/level1/"+id;
    }
    @RequestMapping("/level2{id}")
    public String toLevel2(@PathVariable("id") int id){
        return "views/level2/"+id;
    }
    @RequestMapping("/level3{id}")
    public String toLevel3(@PathVariable("id") int id){
        return "views/level3/"+id;
    }
}
