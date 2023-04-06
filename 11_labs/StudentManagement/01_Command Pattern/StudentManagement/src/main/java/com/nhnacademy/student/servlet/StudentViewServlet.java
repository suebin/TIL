package com.nhnacademy.student.servlet;

import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Student;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 학생 리스트의 학생을 조회하는 Servlet.
 */
@WebServlet(name = "StudentViewServlet", urlPatterns = "/student/view")
public class StudentViewServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) {
        studentRepository =
                (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String id = null;
        if (Objects.nonNull(req.getParameter("id"))) {
            id = req.getParameter("id");
        }

        Student student = studentRepository.getStudentById(id);

        req.setAttribute("student", student);
        req.setAttribute("view", "/student/view.jsp");
    }
}
