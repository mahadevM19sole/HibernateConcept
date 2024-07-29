package com.mapping.xml;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();
        Transaction tx=s.beginTransaction();
        
        Person p=new Person(91,"mahadev","Pune","8180");
        s.save(p);
        tx.commit();
        
        
        s.close();
		
		
		factory.close();

	}

}
