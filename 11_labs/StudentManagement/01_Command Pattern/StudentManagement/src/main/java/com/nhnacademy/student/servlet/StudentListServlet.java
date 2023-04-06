package com.nhnacademy.student.servlet;

import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Student;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * 학생 리스트를 조회하는 Servlet.
 */
@Slf4j
@WebServlet(name = "studentListServlet", urlPatterns = "/student/list")
public class StudentListServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) {
        studentRepository = (
                StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        List<Student> studentList = studentRepository.getStudents();

        req.setAttribute("studentList", studentList);
        req.setAttribute("view", "/student/list.jsp");
    }

}
