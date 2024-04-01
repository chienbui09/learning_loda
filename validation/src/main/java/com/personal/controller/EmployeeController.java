package com.personal.controller;

import com.personal.data.Info;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @PostMapping()
    public String validateEmployeeCode(@RequestBody @Valid Info info){
        System.out.println(info);
        return info.toString();
    }
}
