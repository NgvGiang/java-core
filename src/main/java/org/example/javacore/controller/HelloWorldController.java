package org.example.javacore.controller;

import org.example.javacore.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("hello")
public class HelloWorldController  {
    // request params
    @GetMapping("user")
    public String hello(@RequestBody UserDto userDto){
        return "Hello ";
    }


}
