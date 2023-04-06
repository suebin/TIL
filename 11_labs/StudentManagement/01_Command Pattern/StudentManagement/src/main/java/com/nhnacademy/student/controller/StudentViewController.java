package com.nhnacademy.student.controller;

import com.nhnacademy.student.command.Command;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

public class StudentViewController implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        StudentRepository studentRepository = (StudentRepository) request.getServletContext().getAttribute("studentRepository");

        String id = null;
        if (Objects.nonNull(request.getParameter("id"))) {
            id = request.getParameter("id");
        }

        Student student = studentRepository.getStudentById(id);

        request.setAttribute("student", student);

        return "/student/view.jsp";
    }
}
