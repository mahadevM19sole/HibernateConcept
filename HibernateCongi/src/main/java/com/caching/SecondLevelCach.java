package com.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sole.student;

public class SecondLevelCach {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        // First session
        Session s1 = factory.openSession();
        student student1 = s1.get(student.class, 104);
        System.out.println(student1);
        s1.close();

        // Second session
        Session s2 = factory.openSession();
        student student2 = s2.get(student.class, 104);
        System.out.print(student2);
        s2.close();

        factory.close();
    }
}
