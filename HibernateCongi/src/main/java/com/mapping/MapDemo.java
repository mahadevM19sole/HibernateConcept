package com.mapping;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class MapDemo {
	public static void main(String args[]) {
		 Configuration cfg = new Configuration();
	        cfg.configure("hibernate.cfg.xml");

	        // Building the SessionFactory
	        SessionFactory factory = cfg.buildSessionFactory();
	 //create object of question class
	        Question q1=new Question();
	        q1.setQuestionId(1212);
	        q1.setQuestion("What is java ?");
	        
	        
	        //creating object of answer class
	        Answer answer=new Answer();
	        answer.setAnswerId(343);
	        answer.setAnswer("java is programming language");
	        
	        q1.setAnswer(answer);
	        
	        
	        Question q2=new Question();
	        q2.setQuestionId(242);
	        q2.setQuestion("What is collection freamwork ?");
	        
	        
	        //creating object of answer class
	        Answer answer1=new Answer();
	        answer1.setAnswerId(344);
	        answer1.setAnswer("API to work with object");
	        
	        q2.setAnswer(answer1);
	        
	        Session s=factory.openSession();
	        Transaction tx=s.beginTransaction();
	        
	        s.save(q1);
	        s.save(q2);
	        s.save(answer);
	        s.save(answer1);
	        tx.commit();
	        s.close();
	        factory.close();
	}

}
