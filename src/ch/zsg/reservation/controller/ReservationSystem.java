package ch.zsg.reservation.controller;
import javax.swing.*;
import ch.zsg.reservation.managers.*;
import ch.zsg.reservation.model.*;
import ch.zsg.reservation.view.*;


@SuppressWarnings("serial")
public class ReservationSystem extends JFrame {
	private KundenManager kunden = new KundenManager();
	private ReservierbareFahrtenManager fahrten = new ReservierbareFahrtenManager();
	private ReservationsManager reservationen = new ReservationsManager();

	public static void main (String[] args) {
		new ReservationSystem();
	}

	public ReservationSystem() {
		getContentPane().setLayout(null);
		
		//Data initialization and later database
		this.fillKunden();
		this.fillReservierbareFahrten();
		View view = new View(this);
		view.setVisible(true);
		view.setSize(575, 515);
		view.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
		

	private void fillKunden() {
		// Later fetch data from database
		for (int i = 0; i < 5; i++) {
			Adresse adresse = new Adresse("Some Street", "9500", "Wil");
			this.kunden.add(new Kunde("Hans Meiner" + i, "0718551434", adresse));
		}
	}
	
	private void fillFahrten() {
		// Later fetch data from database
//		this.fahrten.create("Kreuzfahrt 1", Station.Horgen, Station.Meilen);
//		this.fahrten.create("Kreuzfahrt 1", Station.Meilen, Station.Schmerikon);
	}
	
	private void fillReservierbareFahrten() {
		fahrten.create(Station.Horgen, Station.Meilen, "14:00", "14:20", "01.04.2012", "Horten -> Meilen", 10, 10, Schiff.Helvetia);
		fahrten.create(Station.Meilen, Station.Rapperswil, "14:25", "14:45", "01.04.2012", "Meilen -> Rapperswil", 10, 10, Schiff.Limmat);
		fahrten.create(Station.Rapperswil, Station.Horgen, "15:00", "15:20", "01.04.2012", "Rapperswil -> Horgen", 10, 10, Schiff.StadtRapperswil);
	}
	
	public KundenManager getKundenVerwaltung() {
		return kunden;
	}
	
	public ReservationsManager getReservationsVerwaltung() {
		return reservationen;
	}
	
	public ReservierbareFahrtenManager getReservierbareFahrtenVerwaltung() {
		return fahrten;
	}


}
