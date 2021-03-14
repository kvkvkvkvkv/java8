package org.springframework.controller;

import org.springframework.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showFrom(Model model){
        model.addAttribute("student",new Student());
        return "student";
    }

    @RequestMapping("/processForm")
    public String processFrom(@ModelAttribute("student") Student student){
        //dies getter setter for use
        //can directly use
        return "student-submit";
    }
}
