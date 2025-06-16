package Ejercicio5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Ejercicio5 {
    public static void main(String[] args) {
        Session session= new HibernateUtils().getSessionFactory().getCurrentSession();
        Transaction transaction= session.beginTransaction();
        session.persist(new Usuario("juanjo", "avila", 123456));
        transaction.commit();
        session.close();


        Session session1= new HibernateUtils().getSessionFactory().getCurrentSession();
        Transaction transaction1= session1.beginTransaction();
        Usuario usuario=session1.get(Usuario.class, 123456);
        transaction1.commit();
        session1.close();

    }
}
