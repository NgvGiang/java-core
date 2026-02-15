package org.example.javacore.controller;

import org.example.javacore.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("hello")
public class HelloWorldController  {
    //Path param (should only be used for 1 param in link(findByID))
    @GetMapping("user/{userName}")
    public String hello(@PathVariable String userName){
        return "Hello "+ userName;
    }

    //Request Param (be used when there are multiple param in the link ...?userName=Chuck&age=21)
    @GetMapping("userReqParam")
    public String helloReqParam(@RequestParam String userName, int age){
        return "Hello " + userName + age;
    }

    //Request Object (DTO = Data Transfer Object)
    @GetMapping("userReqObj")
    public String helloReqObj(@RequestBody UserDto userDto){
        return "Hello " + userDto.getUserName() + userDto.getAge();
    }

}
