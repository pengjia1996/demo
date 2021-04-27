package com.pj.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author pengjia
 * @version 1.0
 * @date 2021/4/27 15:48
 */
public class  HibernateSessionFactory {
    private static final  ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
    private static SessionFactory sessionFactory;
    private static Configuration configuration = new Configuration();
    private static ServiceRegistry serviceRegistry;

    //加载类时创建会话工厂对象
    static {
        /*try {
            configuration.configure();
            serviceRegistry = new  ServiceRegistryBuilder().applySettings(*configuration*.getProperties()).buildServiceRegistry();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            System.err.println("%%%%  Error Creating SessionFactory %%%%");
            e.printStackTrace();
        }*/
    }

    //构造方法私有化，创建对象的能力由内部决定，阻止外部非法任意创建；
    private  HibernateSessionFactory() {
    }

    public static Session getSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        if (session == null || !session.isOpen()) {
            session = (sessionFactory != null) ? sessionFactory.openSession():null;
            threadLocal.set(session);
        }
        return session;
    }
    public static void  closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
        if (session != null) {
            session.close();
        }
    }
    public static  org.hibernate.SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
