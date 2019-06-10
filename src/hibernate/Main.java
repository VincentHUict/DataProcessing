package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
  private static SessionFactory factory;
  public static void main(String[] args) throws SQLException, ParseException {
      try {
        factory = new Configuration().configure().buildSessionFactory();
      } catch (Throwable ex) {
        System.err.println("Failed to create sessionFactory object." + ex);
        throw new ExceptionInInitializerError(ex);
      }
      Session session = factory.openSession();
      Transaction t = session.beginTransaction();

      Log log = new Log(1,"Hibernate works!");
      session.save(log);
      
      Reiziger reiziger = new Reiziger();
      reiziger.setReizigerId(1);
      reiziger.setNaam("Vincent");
      reiziger.setGeboortedatum("01-01-2000");
      session.save(reiziger);
      System.out.println("successfully saved"); 
      
      reiziger.setReizigerId(2);
      reiziger.setNaam("Anders");
      reiziger.setGeboortedatum(null);
      session.update(reiziger);
      
      session.delete(reiziger);
      t.commit();
       
      factory.close();  
      session.close();   
  }
}
