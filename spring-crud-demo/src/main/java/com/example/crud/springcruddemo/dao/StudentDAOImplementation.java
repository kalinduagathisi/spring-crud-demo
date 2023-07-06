package com.example.crud.springcruddemo.dao;

import com.example.crud.springcruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    public List<Student> findAllStudents() {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("from Student", Student.class);
//        TypedQuery<Student> query = entityManager.createQuery("from Student order by lastName", Student.class);  // to order by last name

        //return query results
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        // create query
        TypedQuery<Student> query = entityManager.createQuery("from Student where lastName=:theData", Student.class);

        //set query params
        query.setParameter("theData", lastName);
        return query.getResultList();
    }

    @Override
    public void update(Student student) {

    }


}
