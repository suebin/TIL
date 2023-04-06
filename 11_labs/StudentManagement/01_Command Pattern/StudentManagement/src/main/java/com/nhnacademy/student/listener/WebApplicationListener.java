package com.nhnacademy.student.listener;

import com.nhnacademy.student.repository.MapStudentRepository;
import com.nhnacademy.student.repository.StudentRepository;
import com.nhnacademy.student.student.Gender;
import com.nhnacademy.student.student.Student;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application 구동 시 동작하는 Listener.
 */
@WebListener
public class WebApplicationListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        StudentRepository studentRepository = new MapStudentRepository();

        for (int i = 1; i <= 10; i++) {
            String id = "student" + i;
            String name = "아카데미" + i;
            studentRepository.save(new Student(id, name, Gender.F, 20));
        }

        sce.getServletContext().setAttribute("studentRepository", studentRepository);
    }
}
