package ch.zsg.reservation.model;

public class Adresse {
	private String strasse, ort, plz;

	public Adresse(String strasse, String ort, String plz) {
		super();
		this.strasse = strasse;
		this.ort = ort;
		this.plz = plz;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getPlz() {
		return plz;
	}

	public void setPlz(String plz) {
		this.plz = plz;
	}
	
	
}
