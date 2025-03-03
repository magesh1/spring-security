package com.example.security.service;

import com.example.security.model.StudentModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    List<StudentModel> users = new ArrayList<>();

    public StudentService() {
        generateData();
    }

    private void generateData() {
        StudentModel stu = new StudentModel();
        stu.setId(1);
        stu.setName("ganesh");
        stu.setStd("2");

        StudentModel stu2 = new StudentModel();
        stu2.setId(2);
        stu2.setName("bharath");
        stu2.setStd("5");

        StudentModel stu3 = new StudentModel();
        stu3.setId(3);
        stu3.setName("santhosh");
        stu3.setStd("10");
        users.add(stu);
        users.add(stu2);
        users.add(stu3);
    }

    public List<StudentModel> listStudents() {
        return users;
    }

}
