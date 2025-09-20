package com.example.demo.Student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ResponseBody
public class HomeController {
    @GetMapping("/home")
    public String getHomePage(){
        return "Welcome to Home Page";
    }
    @GetMapping("/dashboard")
    public String getDashboardPage(){
        return "Login Successful";
    }
}
