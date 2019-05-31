package dao_1_op_veel_relatie;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Reiziger {
	private int reizigerID;
	private String naam;
	private String voorl;
	private String tussenvoegsel;
	private String achternaam;
	private Date gbdatum;
	private ArrayList<OVChipkaart> kaart;

	public Reiziger(String naam, String gbdatum) {
		Date datum = null;
		try {
			datum = new SimpleDateFormat("dd-mm-yyyy").parse(gbdatum);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.naam = naam;
		this.gbdatum = datum;
		kaart = new ArrayList<OVChipkaart>();
	}
	
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
	}
	
	public int getReizigerId() {
		return this.reizigerID;
	}

	public void setReizigerId(int reizigerID) {
		this.reizigerID = reizigerID;
	}

	public String getVoorletters() {
		return this.voorl;
	}

	public void setVoorletters(String voorl) {
		this.voorl = voorl;
	}

	public String getTussenvoegsel() {
		return this.tussenvoegsel;
	}

	public void setTussenvoegsel(String tussenvoegsel) {
		this.tussenvoegsel = tussenvoegsel;
	}

	public String getAchternaam() {
		return this.achternaam;
	}

	public void setAchternaam(String achternaam) {
		this.achternaam = achternaam;
	}

	public Date getGeboortedatum() {
		return this.gbdatum;
	}

	public void setGeboortedatum(String gbdatum) {
		Date datum = null;
		try {
			datum = new SimpleDateFormat("dd-mm-yyyy").parse(gbdatum);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.gbdatum = datum;
	}
	
	public ArrayList<OVChipkaart> getKaart() {
		return kaart;
	}
	
	public void maakKaartAan(OVChipkaart kaart) {
		if (!this.kaart.contains(kaart)) {
			this.kaart.add(kaart);
		}
	}
}
