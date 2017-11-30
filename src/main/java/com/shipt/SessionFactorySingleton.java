package com.shipt;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
 

public class SessionFactorySingleton {
	public static SessionFactorySingleton sessionFactorySingleton;
    public static SessionFactory factory;
    public static Session session;

//to disallow creating objects by other classes.
 
    private SessionFactorySingleton() {
    }
//maling the Hibernate SessionFactory object as singleton
 
    public static synchronized SessionFactorySingleton getSessionFactory() {
 
        if (factory == null) {
        	sessionFactorySingleton = new SessionFactorySingleton();
            factory = new Configuration().configure("hibernate.cfg.xml").
                    buildSessionFactory();
            session = factory.openSession();
            
        }
        return sessionFactorySingleton;
    }

	public static Session getFactorySession() {
		return session;
	}

    
    
}