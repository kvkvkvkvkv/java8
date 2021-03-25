package org.springframework.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RestCon {

    @GetMapping("/hello")
    public String hello(){
        return "Hello!";
    }
}
