package dao_simulatie_1_domeinklasse;

public class Main {
	public static void main(String[] args) {
		ReizigerDao reizigerdao = new ReizigerOracleDaolmpl();
		
		Reiziger r1 = new Reiziger("Vincent Sels", "13-07-1999");
		Reiziger r2 = new Reiziger("Henk Bos", "18-03-1960");
		
		r1.setNaam("Iemand Anders");
		r1.setGeboortedatum("09-02-2005");
		reizigerdao.save(r1);
		System.out.println(r1);
		
		r2.setNaam("Nieuw iemand");
		reizigerdao.save(r2);
		System.out.println(r2);
		
		for (Reiziger r : reizigerdao.findAll()) {
			System.out.println(r.getNaam());
		}
		
		r1.setNaam("Nog iemand");
		reizigerdao.update(r1);
		System.out.println(r1);
		
		reizigerdao.delete(r2);
	}
}
