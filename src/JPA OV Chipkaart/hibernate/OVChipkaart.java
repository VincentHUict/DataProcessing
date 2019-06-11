package hu.nl.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "OVCHIPKAART", uniqueConstraints = { @UniqueConstraint(columnNames = "KAARTNUMMER") })
public class OVChipkaart {

	@Id
	@Column(name = "KAARTNUMMER", unique = true, nullable = false, length = 10)
	private int kaartNummer;

	@Column(name = "GELDIGTOT", nullable = false)
	private String geldigTot;

	@Column(name = "KLASSE", length = 1)
	private int klasse;

	@Column(name = "SALDO")
	private double saldo;

	@ManyToOne(targetEntity = Reiziger.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "REIZIGERID")
	private Reiziger reiziger;

	public OVChipkaart() {
	}

	public OVChipkaart(int kaartNummer, String geldigTot, int klasse, float saldo) {
		this.kaartNummer = kaartNummer;
		this.geldigTot = geldigTot;
		this.klasse = klasse;
		this.saldo = saldo;
	}

	public int getKaartNummer() {
		return kaartNummer;
	}

	public void setKaartNummer(int kaartNummer) {
		this.kaartNummer = kaartNummer;
	}

	public String getGeldigTot() {
		return geldigTot;
	}

	public void setGeldigTot(String geldigTot) {
		this.geldigTot = geldigTot;
	}

	public int getKlasse() {
		return klasse;
	}

	public void setKlasse(int klasse) {
		this.klasse = klasse;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double d) {
		this.saldo = d;
	}
}
