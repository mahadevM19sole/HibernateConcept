package com.sole;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class getPost {
	public static void main(String args[]) {
		Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Building the SessionFactory
        SessionFactory factory = cfg.buildSessionFactory();
		 Session session=factory.openSession();
		 
		 //get object of student class
		 //fetch data from table
		 //get and load both are used to fetch data 
		 student st1=(student)session.get(student.class, 102);//if data is not found it will return null
		 System.out.print(st1);
		 
		student st3=(student)session.load(student.class, 103);//if data is not found it will return objectNotfound exception never return null
		System.out.print(st3);
		 
	}

}
