package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class HomeController {

    @Autowired
    ApplicantRepository appRepo;

    @GetMapping("/")
    public String loadForm(Model model){
        model.addAttribute("applicantvar", new Applicant());
        return "questionform";
    }

    @PostMapping("/")
    public String processForm(@Valid Applicant filledForm, BindingResult result){
        if (result.hasErrors())
        {
            return "questionform";
        }

        appRepo.save(filledForm);
        return "confirm";
    }
}
