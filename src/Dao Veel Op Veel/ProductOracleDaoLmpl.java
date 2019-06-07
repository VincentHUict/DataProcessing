package dao_veel_op_veel_relatie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductOracleDaoLmpl extends OracleBaseDao implements ProductDao {
	
	public ArrayList<Product> findByKaartnummer(int kaartnummer) {
		ArrayList<Product> product = new ArrayList<Product>();
		
		try {
			Connection myConn = getConnection();
			Statement myStm = myConn.createStatement();
			String strQuery = "SELECT * FROM OV_CHIPKAART_PRODUCT o" +
							"LEFT JOIN PRODUCT p ON (o.PRODUCTNUMMER = p.PRODUCTNUMMER)" +
							"WHERE o.KAARTNUMMER =" + kaartnummer;
			ResultSet myRs = myStm.executeQuery(strQuery);
			
			while(myRs.next()) {
				Product p = new Product();
				p.setProductnummer(myRs.getInt("PRODUCTNUMMER"));
				p.setProductNaam(myRs.getString("PRODUCTNAAM"));
				p.setBeschrijving(myRs.getString("BESCHRIJVING"));
				p.setPrijs(myRs.getFloat("PRIJS"));
				product.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}	
	
	public Product save(Product product) {
		
		try {
			Connection myConn = getConnection();
			Statement myStm = myConn.createStatement();
			String q = "INSERT INTO "
					+ "PRODUCT(PRODUCTNUMMER, PRODUCTNAAM, BESCHRIJVING, PRIJS)"
					+ "VALUES('" + product.getProductnummer() + "','" 
					+ product.getProductNaam() + "','" 
					+ product.getBescrijving() + "'," 
					+ product.getPrijs() + ")";
			ResultSet myRs = myStm.executeQuery(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	public Product update(Product product) {
		
		try {
			Connection myConn = getConnection();
			Statement myStm = myConn.createStatement();
			String q = "Update PRODUCT SET "
					+ "PRODUCTNUMMER = '" + product.getProductnummer() + "' "
					+ "PRODUCTNAAM = '" + product.getProductNaam() + "' "
					+ "BESCHRIJVING = '" + product.getBescrijving() + "' "
					+ "PRIJS = '" + product.getPrijs() + "' ";
			ResultSet myRs = myStm.executeQuery(q);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	public boolean delete(Product product) {
		
		try {
			Connection myConn = getConnection();
			Statement myStm = myConn.createStatement();
			ResultSet myRs = myStm.executeQuery("delete from PRODUCT "
					+ "where PRODUCTNUMMER = " + product.getProductnummer());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
