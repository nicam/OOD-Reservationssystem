package ch.zsg.reservation.managers;

import java.util.ArrayList;
import java.util.Iterator;

import ch.zsg.reservation.model.*;
@SuppressWarnings("serial")

public class ReservationsManager extends ArrayList<Reservation> {
	

	public String[] getNames () {
		String[] names = new String[this.size()];
		int i = 0;
		
		Iterator<Reservation> iterator = this.iterator();
		while(iterator.hasNext()) {
			names[i] = iterator.next().toString();
			i++;
		}
		return names;
	}
	
	public Reservation getElementAt(int index) {
		return this.get(index);
		
	}

	public Reservation create(ReservierbareFahrt fahrt, Kunde kunde, int anzahlTisch, int anzahlMitnahme, int klasse) {
		Reservation reservation = new Reservation(fahrt, kunde, anzahlTisch, anzahlMitnahme, klasse);
		this.add(reservation);
		return reservation;
	}

	public void update() {
		//TODO: implement me
	}



}
