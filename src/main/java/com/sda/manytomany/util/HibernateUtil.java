package com.sda.manytomany.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private final static SessionFactory sf = new Configuration()
            .configure()
            .buildSessionFactory();

    private static Session session = sf.openSession();

    public HibernateUtil() {
    }

    public static Session getSession() {
        if (session == null) {
            session = (Session) new HibernateUtil();
        }
        return session;
    }
}

