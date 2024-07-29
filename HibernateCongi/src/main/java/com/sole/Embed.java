package com.sole;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Embed {
public static void main(String args[]) {
	Configuration cfg = new Configuration();
    cfg.configure("hibernate.cfg.xml");

    // Building the SessionFactory
    SessionFactory factory = cfg.buildSessionFactory();
    student student1=new student();
    student1.setId(1234);
    student1.setName("mahadev");
    student1.setCity("lohor");
    
    Certificate certificate=new Certificate();
    certificate.setCourse("Android");
    certificate.setDuration("3 months");
    student1.setCerti(certificate);
    
    
    student student2=new student();
    student1.setId(12);
    student1.setName("mahadev  sole");
    student1.setCity("ashti");
    
    Certificate certificate1=new Certificate();
    certificate1.setCourse("java");
    certificate1.setDuration("1 months");
    student2.setCerti(certificate1);
    
    Session s=factory.openSession();
    Transaction tx=s.beginTransaction();
    
    s.save(student1);
    s.save(student2);
    tx.commit();
    s.close();
    factory.close();
}
}
