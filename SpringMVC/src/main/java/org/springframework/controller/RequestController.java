package org.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello") //removes ambiguous mapping
public class RequestController {

    @RequestMapping("/")
    public String getMotivation(){
        return "win";
    }

    //using request param instead of httpservletrequest
    @RequestMapping("/requestParam")
    public String param(@RequestParam("motivate") String motivate, Model model){

        model.addAttribute("message",motivate);

        return "daily";
    }
}
