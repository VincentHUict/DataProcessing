package dao_1_op_veel_relatie;

import java.util.ArrayList;;

public interface OVChipkaartDao {
	public ArrayList<OVChipkaart> findByReiziger(int reizigerId);
	
	public OVChipkaart save(OVChipkaart ovChipkaart);
	
	public OVChipkaart update(OVChipkaart ovChipkaart);
	
	public boolean delete(OVChipkaart ovChipkaart);
}
