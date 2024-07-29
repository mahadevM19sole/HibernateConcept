package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.sole.student;

public class CriteriaEx {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session s = factory.openSession();
		
		 Criteria c=s.createCriteria(student.class);
		 //c.add(Restrictions.eq("city", "delhi"));   //used for restrictions for conditions
		 c.add(Restrictions.gt("id", 106));
		 
		 List<student>student1=c.list();
		 for(student st:student1 ) {
			 System.out.println(st);
		 }
		
		s.close();
		
		factory.close();
		
		
	}

}
