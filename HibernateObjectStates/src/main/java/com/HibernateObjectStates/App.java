package com.HibernateObjectStates;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;



public class App 
{
    public static void main( String[] args )
    {
        
        StandardServiceRegistry ssr=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  

        Metadata meta=new MetadataSources(ssr).getMetadataBuilder().build();  
          
        SessionFactory sf=meta.getSessionFactoryBuilder().build();  
        
        Session session=sf.openSession();
        session.beginTransaction();
        
        Laptop lap=new Laptop();
        lap.setId(7);
        lap.setName("lenovo");
        lap.setPrice(2000);
        session.persist(lap);
        lap.setPrice(3400);
         session.remove(lap);//remove the persistent object
        session.getTransaction().commit();
      
        session.detach(lap);
        lap.setPrice(1000);
        session.close();
    }
}
