package com.ObjectState;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sole.Certificate;
import com.sole.student;

public class stateDemo {
	public static void main(String args[]) {
		
		System.out.print("example");
		
		//hibernate Object state;
		//Transient
		//Persistent
		//Detached
		//Removed
		
		SessionFactory f=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		student st=new student();
		
		st.setId(1414);
		st.setName("Peter");
		st.setCity("Pune");
		st.setCerti(new Certificate("java Hibernate course","5Months"));
		//data comes in transient state
		
		
		Session s=f.openSession();
		Transaction tx=s.beginTransaction();
		s.save(st);
		//data come under Persistent state= session, database save
		st.setName("Mahadev");//	we can change data under persistent state
		
		tx.commit();
		s.close();//session close so data not updated fater session is closed
		
		
		st.setName("sachin");//data comes under Detached state
		//data does not save under database
		
		System.out.print(st);
		
		f.close();
		
	}

}
