package com.nhnacademy.student.servlet;

import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Gender;
import com.nhnacademy.student.student.Student;
import java.util.Objects;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 학생 리스트의 학생을 수정하는 Servlet.
 */
@WebServlet(name = "StudentUpdateServlet", urlPatterns = "/student/update")
public class StudentUpdateServlet extends HttpServlet {
    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) {
        studentRepository =
                (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        Student student = studentRepository.getStudentById(id);

        req.setAttribute("student", student);
        req.setAttribute("view", "/student/update.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        Gender gender = null;
        if (Objects.nonNull(req.getParameter("gender"))) {
            if (req.getParameter("gender").equals("male")) {
                gender = Gender.M;
            } else if (req.getParameter("gender").equals("female")) {
                gender = Gender.F;
            }
        }

        if (Objects.isNull(gender)) {
            throw new RuntimeException("폼을 모두 채워주시길 바랍니다!");
        }

        Student student = new Student(id, name, gender, age);
        studentRepository.update(student);

        req.setAttribute("view", "redirect:/student/list.do");
    }
}
