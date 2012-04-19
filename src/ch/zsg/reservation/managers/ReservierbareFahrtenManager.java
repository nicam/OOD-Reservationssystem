package ch.zsg.reservation.managers;

import java.util.ArrayList;
import java.util.Iterator;

import ch.zsg.reservation.model.*;

@SuppressWarnings("serial")
public class ReservierbareFahrtenManager extends ArrayList<ReservierbareFahrt> {
	

	public String[] getNames () {
		String[] names = new String[this.size()];
		int i = 0;
		
		Iterator<ReservierbareFahrt> iterator = this.iterator();
		while(iterator.hasNext()) {
			names[i] = iterator.next().toString();
			i++;
		}
		return names;
	}
	
	public ReservierbareFahrt getElementAt(int index) {
		return this.get(index);
		
	}

	public ReservierbareFahrt create(Station abOrt, Station anOrt, String abZeit, String anZeit, String datum, String fahrtName, int freieTisch, int freieMitnahme, Schiff schiffName) {
		ReservierbareFahrt fahrt = new ReservierbareFahrt(abOrt, anOrt, abZeit,anZeit, datum, fahrtName, freieTisch,freieMitnahme, schiffName);
		this.add(fahrt);
		return fahrt;
	}

	public void update(int i, String fahrtName, Station vonOrt, Station bisOrt) {
		//TODO: implement me
	}



}
