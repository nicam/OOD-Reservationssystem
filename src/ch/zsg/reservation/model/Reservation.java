package ch.zsg.reservation.model;
import java.util.*;


public class Reservation {
	private int anzahlTisch, anzahlMitnahme, klasse;
	private Kunde kunde;
	private List<Strecke> strecken = new ArrayList<Strecke>();
	private List<Historie> history;

	public Reservation(ReservierbareFahrt fahrt, Kunde kunde, int anzahlTisch, int anzahlMitnahme, int klasse) {
		super();
		this.kunde = kunde;
		this.anzahlTisch = anzahlTisch;
		this.anzahlMitnahme = anzahlMitnahme;
		this.klasse = klasse;

		this.reserve(fahrt, kunde, anzahlTisch, anzahlMitnahme, klasse);
	}
	
	public void reserve(ReservierbareFahrt fahrt, Kunde kunde, int anzahlTisch, int anzahlMitnahme, int klasse) {
		strecken.add(new Strecke(fahrt, anzahlTisch, anzahlMitnahme, klasse));
	}

	public void addLog(String text) {
		history.add(new Historie(text, "now"));
	}
	
	public String toString() {
		return this.kunde.getName() + " Mitnahme: " + strecken.get(0).mitnahme + " Tisch" + strecken.get(0).tisch;
	}

	public Kunde getKunde() {
		return kunde;
	}	

}
