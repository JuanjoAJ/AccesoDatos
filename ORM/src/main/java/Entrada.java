import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import utils.HibernateUtils;

public class Entrada {
    public static void main(String[] args) {

        Trabajador trabajador= new Trabajador("Juanjo", "Avila", "correo@ue.com",1234);

        SessionFactory sessionFactory= new HibernateUtils().getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(trabajador);
        session.getTransaction().commit();
    }
}
