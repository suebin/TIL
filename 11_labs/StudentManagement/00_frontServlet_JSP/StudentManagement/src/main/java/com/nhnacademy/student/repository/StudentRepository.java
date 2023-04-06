package com.nhnacademy.student.repository;

import com.nhnacademy.student.student.Student;
import java.util.List;

/**
 * Student 객체를 저장하는 Repository Interface.
 */
public interface StudentRepository {
    void save(Student student);

    void update(Student student);

    void deleteById(String id);

    Student getStudentById(String id);

    List<Student> getStudents();

    boolean existById(String id);
}
