package org.springframework.controller.HandlerMethods;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller()
@RequestMapping("/header")
public class RequestHeaderTypes {

    @RequestMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("name","Request Param Types");
        return "header-home";
    }

    @RequestMapping("/header")
    public String simpleMapping(@RequestHeader("accept-language") String name, Model model){
        model.addAttribute("name",name);
        return "request-header";
    }

    @RequestMapping("/headerInt")
    public String simpleMappingInt(@RequestHeader(value = "int-val",defaultValue = "20") Integer name, Model model){
        model.addAttribute("name",name);
        return "request-header";
    }


    @RequestMapping("/multiHeader")
    public String simpleMappingNameMulti(@RequestParam Map<String,String> person, Model model){
        model.addAttribute("name",person);
        return "request-header";
    }
}
