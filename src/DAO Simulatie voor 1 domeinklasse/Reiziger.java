package dao_simulatie_1_domeinklasse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reiziger {
	private int reizigerID;
	private String naam;
	private String voorl;
	private String tussenvoegsel;
	private String achternaam;
	private Date gbdatum;

	public Reiziger(String naam, String gbdatum) {
		Date datum = null;
		try {
			datum = new SimpleDateFormat("dd-mm-yyyy").parse(gbdatum);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		this.naam = naam;
		this.gbdatum = datum;
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
}