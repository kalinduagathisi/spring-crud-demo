package com.example.crud.springcruddemo.dao;

import com.example.crud.springcruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

     Student findStudentByID(Integer id);

     List<Student> findAllStudents();

     List<Student> findByLastName(String lastName);

     void update(Student student);

     void delete(Integer id);

     int deleteAll();

}
