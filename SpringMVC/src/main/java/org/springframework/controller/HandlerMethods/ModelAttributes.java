package org.springframework.controller.HandlerMethods;

import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@ControllerAdvice
@RequestMapping("modelAttribute")
public class ModelAttributes {

    @ModelAttribute
    public void addAttribute(Model model){
        model.addAttribute("common","Common to all models using @request mapping");
    }

    @ModelAttribute("names")
    public List<String> addAttribute(){
        List<String> abc = new ArrayList<>();
        abc.add("yo");
        abc.add("lo");
        return abc;
    }

    @RequestMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("name","Model Attribute Types");
        return "attrib-home";
    }

    @RequestMapping("/modelAttributes")
    public String modelAttrib(@ModelAttribute("names") List<String> names,Model model){
        names.add("Added by self");
        model.addAttribute("added","newly added");
        return "attrib";
    }

}
