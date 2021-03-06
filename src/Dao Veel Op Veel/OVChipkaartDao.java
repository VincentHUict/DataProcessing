package dao_veel_op_veel_relatie;

import java.util.ArrayList;;

public interface OVChipkaartDao {
	public ArrayList<OVChipkaart> findByReiziger(int reizigerId);
	
	public OVChipkaart save(OVChipkaart ovChipkaart);
	
	public OVChipkaart update(OVChipkaart ovChipkaart);
	
	public boolean delete(OVChipkaart ovChipkaart);

	public boolean linkProduct(OVChipkaart o1, Product p1);
}
