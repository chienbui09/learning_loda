package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/v1/web")
public class WebController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/hello")
    public String SayHi(
            @RequestParam(name = "name",required = false,defaultValue = "") String name,
            Model model
    ){
        model.addAttribute("name",name);
        return "hello";
    }
}
