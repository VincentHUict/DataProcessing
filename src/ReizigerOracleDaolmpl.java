package dao_veel_op_veel_relatie;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

public class ReizigerOracleDaolmpl extends OracleBaseDao implements ReizigerDao {
	private ArrayList<Reiziger> reizigers = new ArrayList<Reiziger>();
	
	public ArrayList<Reiziger> findAll() {
		return reizigers;
	}

	public ArrayList<Reiziger> findByGeboortedatum(String Geboortedatum) {
		ArrayList<Reiziger> RGeboortedatum = new ArrayList<Reiziger>();
		for (Reiziger reiziger : this.reizigers) {
			if (reiziger.getGeboortedatum() != null) {
				if (reiziger.getGeboortedatum().toString().equals(Geboortedatum)) {
					RGeboortedatum.add(reiziger);
				}
			}
		}
		return RGeboortedatum;
	}

	public Reiziger save(Reiziger reiziger) {
		if (!this.reizigers.contains(reiziger)) {
			this.reizigers.add(reiziger);
		}
		return reiziger;
	}

	public Reiziger update(Reiziger reiziger) {
		if (this.reizigers.contains(reiziger)) {
			this.reizigers.remove(reiziger);
			this.reizigers.add(reiziger);
		}
		return reiziger;
	}
	
	public boolean delete(Reiziger reiziger) {
		if (this.reizigers.contains(reiziger)) {
			this.reizigers.remove(reiziger);
			return true;
		}
		return false;
	}

	public Reiziger findById(int reizigerId) throws ParseException, SQLException {
		return null;
	}
}