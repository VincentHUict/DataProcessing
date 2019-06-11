package hu.nl.hibernate;

import java.sql.SQLException;
import java.text.ParseException;

import org.hibernate.SessionFactory;

public class Main {
  private static SessionFactory factory;
  public static void main(String[] args) throws SQLException, ParseException {
      
      Reiziger reiziger = new Reiziger();
      reiziger.setReizigerId(1);
      reiziger.setNaam("Vincent");
      reiziger.setGeboortedatum("01-01-2000");
      ReizigerService.getInstance().persist(reiziger);
      System.out.println("successfully saved"); 
      
      reiziger.setReizigerId(2);
      reiziger.setNaam("Anders");
      reiziger.setGeboortedatum(null);
      ReizigerService.getInstance().update(reiziger);
      
      ReizigerService.getInstance().delete(reiziger);
      ReizigerDaoImpl.getCurrentTransaction().commit();
      
      OVChipkaart ovChipkaart = new OVChipkaart();
      ovChipkaart.setKaartNummer(12345);
      ovChipkaart.setGeldigTot("01-01-2020");
      ovChipkaart.setKlasse(2);
      ovChipkaart.setSaldo(50.00);
      OVChipkaartService.getInstance().persist(ovChipkaart);
      System.out.println("successfully saved"); 

      ovChipkaart.setKaartNummer(54321);
      OVChipkaartService.getInstance().update(ovChipkaart);
      
      OVChipkaartService.getInstance().delete(ovChipkaart);
      OVChipkaartDaoImpl.getCurrentTransaction().commit();
      
      factory.close();
  }
}
