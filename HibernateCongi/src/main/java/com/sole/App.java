package com.sole;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        
        // Correct instantiation of the Configuration class from Hibernate
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Building the SessionFactoryj
        SessionFactory factory = cfg.buildSessionFactory();
//        System.out.println(factory);
//        System.out.print(factory.isClosed());
        
        student st=new student();
        st.setId(108);
        st.setName("Shrikant");
        st.setCity("BEED");
        
        System.out.print(st);
        
        
        //creating object of Address class
        Address ad=new Address();
        ad.setStreet("street");
        ad.setCity("AUTEWADI");
        ad.setOpen(true);
        //ad.setAddedDate(new Date());
        ad.setX(1234.565);
        
        
//        //saving image 
//        FileInputStream fs=new FileInputStream("/");//give image path here
//        byte[] data =new byte[fs.available()];
//        fs.read(data);
//        ad.setImage(data);
//        
        
        
        
        Session session=factory.openSession();
        session.beginTransaction();
        
        session.save(st);
        session.save(ad);
        Transaction tx=session.getTransaction();
        tx.commit();
        
        
        session.close();
       System.out.print("done::");
    }
}
