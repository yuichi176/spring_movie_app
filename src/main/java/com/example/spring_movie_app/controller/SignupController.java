package com.example.spring_movie_app.controller;

import com.example.spring_movie_app.service.signup.SignupService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignupController {
    private final SignupService signupService;

    public SignupController(SignupService signupService) {
        this.signupService = signupService;
    }

    @GetMapping("/signup")
    public ModelAndView getSignUp(ModelAndView modelAndView) {
        modelAndView.setViewName("signup");
        return modelAndView;
    }

    @PostMapping("/signup")
    public ModelAndView postSignUp(@RequestParam("username") String userName,
                                   @RequestParam("password") String password,
                                   ModelAndView modelAndView) {
        this.signupService.add(userName, password);
        modelAndView.setViewName("redirect:/login");
        return modelAndView;
    }
}
