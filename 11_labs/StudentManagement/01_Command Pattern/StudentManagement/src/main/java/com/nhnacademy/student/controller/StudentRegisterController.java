package com.nhnacademy.student.controller;

import com.nhnacademy.student.command.Command;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Gender;
import com.nhnacademy.student.student.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class StudentRegisterController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        Gender gender = null;
        if (Objects.nonNull(request.getParameter("gender"))) {
            if (request.getParameter("gender").equals("male")) {
                gender = Gender.M;
            } else if (request.getParameter("gender").equals("female")) {
                gender = Gender.F;
            }
        }

        if (Objects.isNull(gender)) {
            throw new RuntimeException("폼을 모두 채워주시길 바랍니다!");
        }

        Student student = new Student(id, name, gender, age);
        studentRepository.save(student);

        return "redirect:/student/view.do?id=" + student.getId();
    }
}
