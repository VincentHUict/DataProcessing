package hu.nl.hibernate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "REIZIGER", uniqueConstraints = {
        @UniqueConstraint(columnNames = "REIZIGERID")
})
public class Reiziger {
	
	@Id
	@Column(name = "REIZIGERID", unique = true)
	private int reizigerID;
	
	@Column(name = "NAAM")
	private String naam;
	
	@Column(name = "VOORLETTERS")
	private String voorl;
	
	@Column(name = "TUSSENVOEGSEL")
	private String tussenvoegsel;
	
	@Column(name = "ACHTERNAAM")
	private String achternaam;
	
	@Column(name = "GEBOORTEDATUM")
	private Date gbdatum;
	
	@OneToMany(targetEntity = OVChipkaart.class, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy="reiziger")
	private ArrayList<OVChipkaart> OVChipkaarten= new ArrayList<OVChipkaart>();
	
	public Reiziger() {
	}
	
	public Reiziger(int reizigerID, String naam, String voorl, String tussenvoegsel, String achternaam, Date gbdatum, ArrayList<OVChipkaart> OVChipkaarten) {
        this.reizigerID = reizigerID;
        this.naam = naam;
        this.voorl = voorl;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.gbdatum = gbdatum;
        this.OVChipkaarten = OVChipkaarten;
    }
	
	public ArrayList<OVChipkaart> getOVChipkaarten() {
		return OVChipkaarten;
	}
	
	public void setOVChipkaarten(OVChipkaart ov) {
		OVChipkaarten.add(ov);
	}
	
	public int getReizigerId() {
		return this.reizigerID;
	}

	public void setReizigerId(int reizigerID) {
		this.reizigerID = reizigerID;
	}
	
	public String getNaam() {
		return naam;
	}
	
	public void setNaam(String naam) {
		this.naam = naam;
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
