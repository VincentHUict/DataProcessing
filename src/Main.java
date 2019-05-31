package dao_1_op_veel_relatie;

public class Main {
	public static void main(String[] args) {
		ReizigerDao reizigerdao = new ReizigerOracleDaolmpl();
		OVChipkaartDao ovchipkaartdao = new OVChipkaartOracleDaoImpl();
		
		OVChipkaart ovc1 = new OVChipkaart(99, "01-01-2025", 2, 10, 1);
		ovchipkaartdao.save(ovc1);
		
		for (OVChipkaart ov : ovchipkaartdao.findByReiziger(2)) {
			System.out.println(ov.getKaartNummer());
		}
		
		for (Reiziger r : reizigerdao.findAll()) {
			System.out.println(r.getNaam());
			System.out.println(r.getKaart());
			System.out.println(r.getClass());
			System.out.println(r.getGeboortedatum());
			System.out.println(r.getReizigerId());

		}
	}
}