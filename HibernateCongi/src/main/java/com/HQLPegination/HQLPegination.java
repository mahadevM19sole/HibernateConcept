package com.HQLPegination;

import java.util.List;

import org.hibernate.query.*;
//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sole.student;

public class HQLPegination {
	public static void main(String[] args) {

		// Pagination is the process of dividing a large set of data into smaller, more
		// manageable chunks or pages for easier navigation and faster loading times.
//		Pagination offers several benefits, such as:
//			Faster page loading times: By limiting the amount of data that is loaded at once, pagination can improve the performance of web pages, reducing the load time and improving the user experience.
//			Improved user experience: By breaking up the data into smaller pages, users can more easily navigate through the data and find the information they need.
//			Reduced server load: By limiting the amount of data that is loaded at once, pagination can reduce the strain on the server and improve scalability.

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s=factory.openSession();
		Query query=s.createQuery(" from student");
		
		
		
		//implmeting Pegination
          query.setFirstResult(0);
          query.setMaxResults(2);
          
          List<student> list=query.list();
          for(student st:list) {
        	  System.out.println(st.getId()+" "+st.getName()+ " "+ st.getCity()+" ");
          }
          
          
		
		
		s.close();
		
		

		factory.close();

	}

}
