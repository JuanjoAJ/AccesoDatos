package Ejercicio5;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static SessionFactory sessionFactory;


    public SessionFactory getSessionFactory()
    {
        if(sessionFactory==null)
            createConnection();

        return sessionFactory;

    }

    private void createConnection()
    {
        sessionFactory = new Configuration().buildSessionFactory();
    }

}
