package com.example.security.controller;

import com.example.security.model.StudentModel;
import com.example.security.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private StudentService service;

    @GetMapping("/about")
    public String about() {
        return "About";
    }

    @GetMapping("/")
    public String home(HttpServletRequest request) {
        return "Home " + request.getSession().getId();
    }

    @GetMapping("/crsf")
    public CsrfToken csrf(HttpServletRequest request) {
        CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
        return csrfToken;
    }

    @GetMapping("/students")
    public List<StudentModel> listStudent() {
        return service.listStudents();
    }

}
