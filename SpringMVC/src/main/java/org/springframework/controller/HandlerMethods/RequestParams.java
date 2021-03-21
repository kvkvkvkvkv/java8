package org.springframework.controller.HandlerMethods;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller()
@RequestMapping("/requestParams")
public class RequestParams {

    @RequestMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("name","Request Param Types");
        return "request-home";
    }

    @RequestMapping("/name")
    public String simpleMapping(@RequestParam String name, Model model){
        model.addAttribute("name",name);
        return "request-param";
    }

    @RequestMapping("/explicitName")
    public String simpleMappingName(@RequestParam("name") String person, Model model){
        model.addAttribute("name",person);
        return "request-param";
    }

    @RequestMapping("/requiredName")
    public String simpleMappingNameRequired(@RequestParam(name = "name",required = false) String person, Model model){
        model.addAttribute("name",person);
        return "request-param";
    }

    @RequestMapping("/optionalName")
    public String simpleMappingNameOptional(@RequestParam(name = "name") Optional<String> person, Model model){
        model.addAttribute("name",person.orElseGet(()->"No person"));
        return "request-param";
    }

    @RequestMapping("/defaultName")
    public String simpleMappingNameDefault(@RequestParam(name = "name",defaultValue = "Yo") String person, Model model){
        model.addAttribute("name",person);
        return "request-param";
    }

    @RequestMapping("/mapName")
    public String simpleMappingNameMap(@RequestParam(name = "name") Map<String,String> person, Model model){
        model.addAttribute("name",person);
        return "request-param";
    }

    @RequestMapping("/multiName")
    public String simpleMappingNameMulti(@RequestParam(name = "name") List<String> person, Model model){
        model.addAttribute("name",person);
        return "request-param";
    }
}
