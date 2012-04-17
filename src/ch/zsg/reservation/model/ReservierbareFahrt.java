package ch.zsg.reservation.model;
import java.util.ArrayList;


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
