package ch.zsg.reservation.managers;

import java.util.ArrayList;
import java.util.Iterator;

import ch.zsg.reservation.model.*;

public class FahrtenManager extends ArrayList<Fahrt> {
	

	public String[] getNames () {
		String[] names = new String[this.size()];
		int i = 0;
		
		Iterator<Fahrt> iterator = this.iterator();
		while(iterator.hasNext()) {
			names[i] = iterator.next().toString();
			i++;
		}
		return names;
	}
	
	public Fahrt getElementAt(int index) {
		return this.get(index);
		
	}

	public Fahrt create(String fahrtName, Station vonOrt, Station bisOrt) {
		Fahrt fahrt = new Fahrt(fahrtName, vonOrt, bisOrt);
		this.add(fahrt);
		return fahrt;
	}

	public void update(int i, String fahrtName, Station vonOrt, Station bisOrt) {
		Fahrt fahrt = this.get(i);
		fahrt.setBisOrt(bisOrt);
		fahrt.setVonOrt(vonOrt);
		fahrt.setFahrtName(fahrtName);
	}



}
