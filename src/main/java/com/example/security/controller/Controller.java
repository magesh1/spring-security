package com.example.security.controller;

import com.example.security.model.StudentModel;
import com.example.security.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private StudentService service;

    @GetMapping("/public/about")
    public String about() {
        return "About";
    }

    @GetMapping("/public")
    public String home(HttpServletRequest request) {
        return "Home " + request.getSession().getId();
    }

    @GetMapping("/admin/crsf")
    public CsrfToken csrf(HttpServletRequest request) {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        System.out.println(csrfToken);
        return csrfToken;
    }

    @GetMapping("/admin/about")
    public String adminAbout() {
        return "admin page";
    }

    @GetMapping("/user/students")
    public List<StudentModel> listStudent() {
        return service.listStudents();
    }

}
