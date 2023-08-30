package com.sparta.springauth.controller;

import com.sparta.springauth.dto.LoginRequestDto;
import com.sparta.springauth.dto.SignupRequestDto;
import com.sparta.springauth.entity.User;
import com.sparta.springauth.repository.UserRepository;
import com.sparta.springauth.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/login-page")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/user/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/user/signup")
    public String signup(SignupRequestDto signupRequestDto){
        userService.signup(signupRequestDto);
//        return "login";
        return "redirect:/api/user/login-page";
    }
    @PostMapping("/user/login")
    public String login(LoginRequestDto loginRequestDto, HttpServletResponse res){
        try {
            userService.login(loginRequestDto,res);
        } catch (Exception e) {
            return "redirect:/api/user/login-page?error";
        }
        return "redirect:/";
    }

}