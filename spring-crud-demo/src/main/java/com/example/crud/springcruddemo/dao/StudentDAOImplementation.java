package com.example.crud.springcruddemo.dao;

import com.example.crud.springcruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository // applied to dao implementations, then spring will automatically register the dao implementation
public class StudentDAOImplementation implements StudentDAO{

    // entities
    private EntityManager entityManager;

    @Autowired // to inject dependency :) here entityManager
    public StudentDAOImplementation(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional // automatically adds jpa code to application, (handles transaction management)
    public void save(Student student) {
        entityManager.persist(student); // save

    }

    @Override
    public Student findStudentByID(Integer id) {
       return entityManager.find(Student.class, id); //pass the class and id
    }


}
