package chapter08.persistence;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * This emulates an older Hibernate-based DAO.
 */
public class CustomerRepository {

    private SessionFactory sessionFactory;

    public CustomerRepository() {
        sessionFactory = new Configuration().addAnnotatedClass(Customer.class)
                .configure().buildSessionFactory();
    }

    public void directIndexingIsABadIdeaIfTheEntityCantBeFound() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Customer where id = :id ");
        query.setParameter("id", "12345678");
        Customer customer = (Customer) query.list().get(0); // Boom
    }

    public void iterationIsSafer() {
        Session session = sessionFactory.openSession();
        Query<Customer> query = session.createQuery("from Customer where dob > :dob ");
        query.setParameter("dob", 19750101);
        for (Customer customer : query.list()) {

            // Do something interesting with the customer...
        }
    }
}
