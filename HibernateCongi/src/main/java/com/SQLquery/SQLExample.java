package com.SQLquery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.sole.student;

public class SQLExample {
	public static void main(String[] args) {
		 SessionFactory factory=new Configuration().configure().buildSessionFactory();
		 
		 Session s=factory.openSession();
		 //SQL Query
		 String q="select * from student";
		  NativeQuery nq = s.createSQLQuery(q);
		  List<Object[]> list=nq.list();
		  
		  for(Object[] st:list) {
			  System.out.println(st[3]+" "+st[4]);
		  }
		  //give output
//		  Hibernate: select * from student
//		  delhi sole
//		  delhi mahadev
//		  PUNe mahadev sole
//		  BEED Shrikant
		 
		 
		 
		 s.close();
		 factory.close();
	}
	

}
