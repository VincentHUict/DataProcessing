package dao_1_op_veel_relatie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class OVChipkaartOracleDaoImpl extends OracleBaseDao implements OVChipkaartDao {
	public ArrayList<OVChipkaart> findByReiziger(int reizigerId) {
		ArrayList<OVChipkaart> kaart = new ArrayList<OVChipkaart>();
		
		try {
			Connection myConn = getConnection();
			Statement myStm = myConn.createStatement();
			String statement = "SELECT * FROM OV_CHIPKAART WHERE REIZIGERID = " + reizigerId;
			ResultSet myRs = myStm.executeQuery(statement);
			
			while(myRs.next()) {
				OVChipkaart kaartje = new OVChipkaart();
				kaartje.setKaartNummer(myRs.getInt("kaartNummer"));
				kaartje.setGeldigTot(myRs.getString("geldigTot"));
				kaartje.setKlasse(myRs.getInt("klasse"));
				kaartje.setSaldo(myRs.getInt("saldo"));
				kaartje.setReiziger(myRs.getInt("reizigerId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kaart;
	}
	
	public OVChipkaart save(OVChipkaart ovChipkaart) {
		try {
			Connection myConn = getConnection();
			Statement myStm = myConn.createStatement();
			String a = "INSERT INTO OV_CHIPKAART(KAARTNUMMER, GELDIGTOT, KLASSE, SALDO, REIZIGERID)"
					+ "VALUES('" + ovChipkaart.getKaartNummer() + "','" + ovChipkaart.getGeldigTot() + "','" + ovChipkaart.getKlasse() + "','" + ovChipkaart.getSaldo() + "','" + ovChipkaart.getReiziger() + "', + TO_DATE('01-01-2019', 'DD-MM-YYYY'))";
			myStm.executeQuery(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ovChipkaart;
	}
	
	public OVChipkaart update(OVChipkaart ovChipkaart) {
		try {
			Connection myConn = getConnection();
			Statement myStm = myConn.createStatement();
			
			String a = "UPDATE OV_CHIPKAART SET "
							+ "KAARTNUMMER = '" + ovChipkaart.getKaartNummer() + "' "
							+ "KLASSE = '" + ovChipkaart.getKlasse() + "' "
							+ "SALDO = '" + ovChipkaart.getSaldo() + "' "
							+ "REIZIGERID = '" + ovChipkaart.getReiziger() + "' ";
			myStm.executeQuery(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ovChipkaart;
	}
	
	public boolean delete(OVChipkaart ovChipkaart) {
		try {
			Connection myConn = getConnection();
			Statement myStm = myConn.createStatement();
			myStm.executeQuery("DELETE FROM OV_CHIPKAART WHERE KAARTNUMMER = " + ovChipkaart.getKaartNummer());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
