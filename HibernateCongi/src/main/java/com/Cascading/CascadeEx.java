package com.Cascading;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.mapping.Answer;
import com.mapping.Question;

public class CascadeEx {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session s = factory.openSession();
		
		 Question q1=new Question();
		 
		 q1.setQuestionId(546);
		 q1.setQuestion("What is cascading?");
		 
		 
		 Answer a1= new Answer(21,"It is main concept in hibernate");
		 Answer a2= new Answer(22,"It is hibernate");

		 Answer a3= new Answer(23,"It is cascading");
		 
		 List<Answer> list=new ArrayList<>();
		 
		 list.add(a1);
		 list.add(a2);
		 list.add(a3);
		 
		// q1.setAnswer(list);
		 Transaction tx=s.beginTransaction();
		 
		 s.save(q1);
		 s.save(a1);
		 s.save(a2);
		 s.save(a3);
		 
		 tx.commit();

		 
		 
		s.close();
		factory.close();
	}

}
