package dao_simulatie_1_domeinklasse;

import java.util.ArrayList;

public interface ReizigerDao {
	public ArrayList<Reiziger> findAll();
	
	public ArrayList<Reiziger> findByGeboortedatum(String Geboortedatum);
	
	public Reiziger save(Reiziger reiziger);
	
	public Reiziger update(Reiziger reiziger);
	
	public boolean delete(Reiziger reiziger);
}
