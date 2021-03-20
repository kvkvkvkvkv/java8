package org.springframework.controller;

import org.springframework.aop.aspectj.annotation.LazySingletonAspectInstanceFactoryDecorator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @RequestMapping("/")
    public String getMotivation(){
        return "win";
    }

    @RequestMapping("quote")
    public String getQuote(){
        return "quote";
    }

    //add data to model public String getData(HttpServletRequest)
    @RequestMapping("usingModel")
    public String usingModel(HttpServletRequest request, Model model){

        //gets from the request url
        String motivation = request.getParameter("motivation");

        //adds to model that we are sending to view
        //pass any key - message and value-motivation
        model.addAttribute("message",motivation);

        return "quote";
    }

    //using request param instead of httpservletrequest
    @RequestMapping("/requestParam")
    public String param(@RequestParam("motivate") String motivate, Model model){

        model.addAttribute("message",motivate);

        return "daily";
    }


}
