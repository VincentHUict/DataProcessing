package dao_1_op_veel_relatie;

import java.util.ArrayList;

public interface ReizigerDao {
	public ArrayList<Reiziger> findAll();
	
	public ArrayList<Reiziger> findByGeboortedatum(String Geboortedatum);
	
	public Reiziger save(Reiziger reiziger);
	
	public Reiziger update(Reiziger reiziger);
	
	public boolean delete(Reiziger reiziger);
}
