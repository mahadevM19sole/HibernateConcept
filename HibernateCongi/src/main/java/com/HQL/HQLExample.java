package com.HQL;

import java.util.List;

import org.hibernate.query.*; //new version
//import org.hibernate.Query;//old version
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.sole.student;

public class HQLExample {
	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");

	        // Building the SessionFactory
	        SessionFactory factory = cfg.buildSessionFactory();
	        Session s=factory.openSession();
	        
	        //HQL Syntax
	        String query="from student";
	        
	        //String quer="from student where city='mumbai'";	
	        
	        Query q=s.createQuery(query);
	        //single=unique
	        //multiple= list
	        
	        List<student> list=q.list();
	        for(student st:list) {
	        	System.out.print(st.getName());
	        }
	        
	        
	        System.out.print("______________________________________");
	        
	        Transaction tx=s.beginTransaction();
//	        Query q2=s.createQuery("delete from student s where s.city=:c");
//	        q2.setParameter("c", "delhi");
//	        int r=q2.executeUpdate();
//	        System.out.println("deleted");
//	        System.out.println( r);
	        
	        
	        Query q2=s.createQuery("update  student  set city=:c  where name=:n");
	        q2.setParameter("c", "GOA");
	        q2.setParameter("n", "sole");
	        int r=q2.executeUpdate();
	        System.out.println("updated");
	        System.out.println( r);
	        tx.commit();
	        
	        
	        s.close();
	        
	        factory.close();
	}

}
