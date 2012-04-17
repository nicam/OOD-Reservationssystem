package ch.zsg.reservation.model;

public class Strecke {

	private ReservierbareFahrt fahrt;
	int tisch, mitnahme;
	
	public Strecke(ReservierbareFahrt fahrt, int tisch, int mitnahme, int klasse) {
		this.fahrt = fahrt;
		this.tisch = tisch;
		this.mitnahme = mitnahme;
	}
	
	public boolean reserve(ReservierbareFahrt fahrt) {
		return fahrt.reduce(tisch, mitnahme);
	}
	
	public boolean cancel() {
		return fahrt.add(tisch, mitnahme);
	}
}
