package com.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sole.student;

//Hibernate caching improves the performance of the application by pooling the object in the cache.
//It is useful when we have to fetch the same data multiple times.
//There are mainly two types of caching:
//First Level Cache,and Second Level Cache
//Session object holds the first level cache data.It is enabled by default.
//The first level cache data will not be available to entire application.An application can use many session object.

public class FirstLevelCach {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session s = factory.openSession();

		student st = s.get(student.class, 104);
		System.out.println(st);
		System.out.println("this is first level catching");
		
		
		student st2=s.get(student.class, 104);  //does not creat second object
		System.out.println(st2);
		
		System.out.println(s.contains(st2));   //it give true bc object is present in catch memory




		s.close();
	}

}
