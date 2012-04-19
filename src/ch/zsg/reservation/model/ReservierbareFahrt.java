package ch.zsg.reservation.model;


public class ReservierbareFahrt {
	
	Station abOrt, anOrt;
	String abZeit, anZeit, datum, fahrtName;
	int freieTisch, freieMitnahme, totalTisch, totalMitnahme;
	Schiff schiffName;
	
	public ReservierbareFahrt(Station abOrt, Station anOrt, String abZeit,
			String anZeit, String datum, String fahrtName, int freieTisch,
			int freieMitnahme, Schiff schiffName) {
		super();
		this.abOrt = abOrt;
		this.anOrt = anOrt;
		this.abZeit = abZeit;
		this.anZeit = anZeit;
		this.datum = datum;
		this.fahrtName = fahrtName;
		this.freieTisch = totalTisch = freieTisch;
		this.freieMitnahme = totalMitnahme = freieMitnahme;
		this.schiffName = schiffName;
	}
	
	public Station getAbOrt() {
		return abOrt;
	}

	public void setAbOrt(Station abOrt) {
		this.abOrt = abOrt;
	}

	public Station getAnOrt() {
		return anOrt;
	}

	public void setAnOrt(Station anOrt) {
		this.anOrt = anOrt;
	}

	public String getAbZeit() {
		return abZeit;
	}

	public void setAbZeit(String abZeit) {
		this.abZeit = abZeit;
	}

	public String getAnZeit() {
		return anZeit;
	}

	public void setAnZeit(String anZeit) {
		this.anZeit = anZeit;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getFahrtName() {
		return fahrtName;
	}

	public void setFahrtName(String fahrtName) {
		this.fahrtName = fahrtName;
	}

	public int getFreieTisch() {
		return freieTisch;
	}

	public void setFreieTisch(int freieTisch) {
		this.freieTisch = freieTisch;
	}

	public int getFreieMitnahme() {
		return freieMitnahme;
	}

	public void setFreieMitnahme(int freieMitnahme) {
		this.freieMitnahme = freieMitnahme;
	}

	public int getTotalTisch() {
		return totalTisch;
	}

	public void setTotalTisch(int totalTisch) {
		this.totalTisch = totalTisch;
	}

	public int getTotalMitnahme() {
		return totalMitnahme;
	}

	public void setTotalMitnahme(int totalMitnahme) {
		this.totalMitnahme = totalMitnahme;
	}

	public Schiff getSchiffName() {
		return schiffName;
	}

	public void setSchiffName(Schiff schiffName) {
		this.schiffName = schiffName;
	}

	public String toString(){
		return abZeit + " " + abOrt + " -> " + anZeit + " " + anOrt;
	}
	
	public boolean reduce(int countTisch, int countMitname) {
		if (freieTisch - countTisch < 0) {
			return false;
		}
		if (freieMitnahme - countMitname < 0) {
			return false;
		}
		freieTisch -= countTisch;
		freieMitnahme -= countMitname;
		
		return true;
	}
	
	public boolean add(int countTisch, int countMitname) {
		if (freieTisch + countTisch > totalTisch) {
			return false;
		}
		if (freieMitnahme + countMitname > totalMitnahme) {
			return false;
		}
		freieTisch += countTisch;
		freieMitnahme += countMitname;
		
		return true;
	}
}
