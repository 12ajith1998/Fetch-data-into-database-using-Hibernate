package com.simplykrish.DemoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App 
{
    public static void main( String[] args )
    {
    	Alien ak=new Alien();
    	
    	Configuration conf=new Configuration().configure().addAnnotatedClass(Alien.class);
    	
    	ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
    	
    	SessionFactory sf=conf.buildSessionFactory();
    	
    	Session session=sf.openSession();
 
    	Transaction tx=session.beginTransaction();
    	
    	ak=(Alien)session.get(Alien.class, 1);
    	
    	tx.commit();
    	
    	System.out.println(ak);
    }
}
