package org.springframework.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getMotivation(){
        return "win";
    }

    @RequestMapping("quote")
    public String getQuote(){
        return "quote";
    }

    //add data to model public String getData(HttpServletRequest)
}
