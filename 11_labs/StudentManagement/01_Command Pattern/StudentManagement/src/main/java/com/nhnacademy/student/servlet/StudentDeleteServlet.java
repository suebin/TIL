package com.nhnacademy.student.servlet;

import com.nhnacademy.student.repository.StudentRepository;
import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * 학생 리스트에서 학생을 삭제하는 Servlet.
 */
@Slf4j
@WebServlet(name = "studentDeleteServlet", urlPatterns = "/student/delete")
public class StudentDeleteServlet extends HttpServlet {

    private StudentRepository studentRepository;

    @Override
    public void init(ServletConfig config) {
        studentRepository =
                (StudentRepository) config.getServletContext().getAttribute("studentRepository");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        studentRepository.deleteById(id);

        req.setAttribute("view", "redirect:/student/list.do");
    }
}
