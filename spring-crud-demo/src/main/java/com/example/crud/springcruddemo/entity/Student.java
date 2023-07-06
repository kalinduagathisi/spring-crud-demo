package com.example.crud.springcruddemo.entity;

import jakarta.persistence.*;

@Entity // in order to specify that this class is an entity and map to a database table
@Table(name = "student") // name of the table -(if not set, it'll be the class name)
public class Student {

    // fields

    @Id // primary key attribute
    @GeneratedValue(strategy = GenerationType.IDENTITY) // primary key generation procedure
    @Column(name = "id") // specifies the column name of the table
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;


    // no args constructor

    public Student() {
    }

    // with args constructor

    public Student(String firstName, String lastName, String email) {
        // we don't include id,  because it isn't used to create an object
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString methods
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
