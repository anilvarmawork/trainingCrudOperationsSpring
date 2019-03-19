package com.cognizant.training.CrudDemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello/*")
public class HelloWorldController {

    @GetMapping("hw")
    public String getHelloWorld () {
        return "Hello World!";
    }

    @GetMapping("hw/{name}")
    public String getHelloWorldWithName (@PathVariable String name) {
        return "Hello " + name + "!";
    }
}
