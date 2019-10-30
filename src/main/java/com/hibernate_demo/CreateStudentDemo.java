package com.hibernate_demo;

import com.hibernate_demo.entity.Student;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class CreateStudentDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                                .configure("hibernate.cfg.xml")
                                .addAnnotatedClass(Student.class)
                                .buildSessionFactory();

        //create session
        Session session = factory.getCurrentSession();
        try{
            System.out.println("creating student object..");

         //create student object
         Student student = new Student("Rocky", "Balboa", "champion@gmail.com");

         //start transaction
         session.beginTransaction();

         //save the student object
            session.save(student);
            System.out.println("Saving the Student");

         //commit transaction
            session.getTransaction().commit();
            System.out.println("Done! ");

        } finally {
            factory.close();
        }
    }

    protected final Logger log = Logger.getLogger(getClass().getName());
}
