package dao_1_op_veel_relatie;

public class OVChipkaart {
	private int kaartNummer;
	private String geldigTot;
	private int klasse;
	private int saldo;
	private int reizigerId;

	public OVChipkaart(int kaartNummer, String geldigTot, int klasse, int saldo, int reizigerId) {
		this.kaartNummer = kaartNummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
		this.reizigerId = reizigerId;
	}
	
	public OVChipkaart() {
	}

	public void setReiziger(int reizigerId) {
		this.reizigerId = reizigerId;
	}

	public int getReiziger() {
		return reizigerId;
	}

	public int getKaartNummer() {
		return kaartNummer;
	}

	public String getGeldigTot() {
		return geldigTot;
	}

	public int getKlasse() {
		return klasse;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	public void setGeldigTot(String geldigTot) {
		this.geldigTot = geldigTot;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String toString() {
		String s = "OV-Chipkaart met nummer: " + getKaartNummer() + " is geldig tot: " + getGeldigTot()
				+ " , met klasse: " + getKlasse() + " en het huidige saldo is: " + getSaldo();
		return s;
	}
}
