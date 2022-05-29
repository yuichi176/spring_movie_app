package com.example.spring_movie_app.controller;

import com.example.spring_movie_app.form.AccountForm;
import com.example.spring_movie_app.helper.MessageSourceHelper;
import com.example.spring_movie_app.service.signup.SignupService;
import org.springframework.dao.DataIntegrityViolationException;
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
    private final MessageSourceHelper messageSource;

    public SignupController(SignupService signupService, MessageSourceHelper messageSource) {
        this.signupService = signupService;
        this.messageSource = messageSource;
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
        if(result.hasErrors()) {
            modelAndView.addObject("accountForm", accountForm);
            modelAndView.setViewName("signup");
            return modelAndView;
        }

        String userName = accountForm.getUserName();
        String password = accountForm.getPassword();
        try {
            this.signupService.add(userName, password);
        } catch (DataIntegrityViolationException ex) {
            modelAndView.addObject("accountForm", accountForm);
            modelAndView.addObject("errorMsg", messageSource.getMessage("account.error.duplicate.userName", userName));
            modelAndView.setViewName("signup");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/login");

        return modelAndView;
    }
}
