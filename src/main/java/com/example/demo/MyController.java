package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController
{
    @RequestMapping("/spring")
    public String test1(@RequestParam(name = "testId") final Integer id)
    {
        System.out.println("name: " + id);
        return "Hello test1";
    }

    @RequestMapping("/student")
    public String test2(@RequestBody final Student student)
    {
        System.out.println(" name: " + student.getName() + " , id: " + student.getId());
        return "Hallo test 2";
    }

    @RequestMapping("/info")
    public String test3(@RequestHeader(name = "Content-Type", defaultValue = "appication/json", required = false) final String contentType)
    {
        System.out.println(contentType);
        return "Header information";
    }

    @RequestMapping("/spring/{id}")
    public String getSpringId(@PathVariable final Integer id)
    {
        System.out.println("The URL:" + "localhost:8080/ " + id);
        return "test from PathVariable";

    }

}
