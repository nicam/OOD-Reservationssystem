package ch.zsg.reservation.model;
import java.util.*;


public class Kunde {
	private String name, telefon;
	private Adresse adresse;
	private List<Reservation> reservationen = new ArrayList<Reservation>();
	
	public Kunde(String name) {
		this.name = name;
	}
	
	public Kunde(String name, String telefon, Adresse adresse) {
		super();
		this.name = name;
		this.telefon = telefon;
		this.adresse = adresse;
	}
	
	public List<Reservation> getReservationen() {
		return reservationen;
	}

	public void setReservationen(List<Reservation> reservationen) {
		this.reservationen = reservationen;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	
}
