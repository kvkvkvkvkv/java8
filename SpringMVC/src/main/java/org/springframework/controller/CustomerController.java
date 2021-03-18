package org.springframework.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping("/showForm")
    public String showFrom(Model model){
        model.addAttribute("customer",new Customer());
        return "customer";
    }

    @RequestMapping("/processForm")
    public String processFrom(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return "customer";
        }


        return "customer-submit";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class,stringTrimmerEditor);
    }
}
