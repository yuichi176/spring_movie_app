package com.example.spring_movie_app.controller;

import com.example.spring_movie_app.form.AccountForm;
import com.example.spring_movie_app.service.signup.SignupService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {
    private final SignupService signupService;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @GetMapping("/signup")
    public ModelAndView getSignUp(ModelAndView modelAndView) {
        modelAndView.addObject("accountForm", new AccountForm());
        modelAndView.setViewName("signup");
        return modelAndView;
    }

    @PostMapping("/signup")
    public ModelAndView postSignUp(@ModelAttribute("accountForm") @Validated AccountForm accountForm,
                                   BindingResult result,
                                   ModelAndView modelAndView) {
        if(!result.hasErrors()) {
            String userName = accountForm.getUserName();
            String password = accountForm.getPassword();
            this.signupService.add(userName, password);
            modelAndView.setViewName("redirect:/login");
        } else {
            modelAndView.addObject("accountForm", accountForm);
            modelAndView.setViewName("signup");
        }
        return modelAndView;
    }
}
