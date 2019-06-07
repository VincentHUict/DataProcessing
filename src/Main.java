package dao_veel_op_veel_relatie;

public class Main {
	public static void main(String[] args) {
		
		try {
			ReizigerDao reizigerdao = new ReizigerOracleDaolmpl();
			OVChipkaartDao ovchipkaartdao = new OVChipkaartOracleDaoImpl();
			ProductOracleDaoLmpl productdao = new ProductOracleDaoLmpl();
			
			
			Reiziger r1 = new Reiziger();
			Reiziger r2 = new Reiziger();
			
			r1.setNaam("vsels");
			r1.setGeboortedatum("01-01-2000");
			r1 = reizigerdao.save(r1);
			
			r2.setNaam("mooie naam");
			r2 = reizigerdao.save(r2);
			
			r1.setNaam("niet vsels");
			r1 = reizigerdao.update(r1);
			
			for (Reiziger r : reizigerdao.findAll()) {
				System.out.println(r.getNaam());
			}
			
			OVChipkaart o1 = new OVChipkaart();
			o1.setKaartNummer(202020);
			o1.setKlasse(2);
			o1.setReiziger(1);
			o1.setSaldo(80);
			ovchipkaartdao.save(o1);
			
			Product p1 = new Product();
			p1.setProductNaam("productjonge");
			p1.setBeschrijving("Een beschrijving");
			p1.setPrijs(8.8);
			p1.setProductnummer(2);
			productdao.save(p1);
			
			Product p2 = new Product();
			p2.setProductNaam("productjonges");
			p2.setBeschrijving("Een beschrijvinkje");
			p2.setPrijs(9);
			p2.setProductnummer(3);
			productdao.save(p2);
			
			ovchipkaartdao.linkProduct(o1, p1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}