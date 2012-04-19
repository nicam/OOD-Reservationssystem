package ch.zsg.reservation.managers;

import java.util.ArrayList;
import java.util.Iterator;

import ch.zsg.reservation.model.*;

@SuppressWarnings("serial")
public class KundenManager extends ArrayList<Kunde> {
	
	Kunde generic = new Kunde("Neuen Kunden hinzufügen");
	
	public String[] getNames () {
		String[] names = new String[this.size()];
		int i = 0;
		
		Iterator<Kunde> iterator = this.iterator();
		while(iterator.hasNext()) {
			names[i] = iterator.next().getName();
			i++;
		}
		return names;
	}
	
	public Kunde getElementAt(int index) {
		return this.get(index);
		
	}
	
	public Kunde getGeneric() {
		return generic;
	}

	public Kunde create(String name, String adresse, String ort, String plz, String telefon) {
		Adresse adressObj = new Adresse(adresse, ort, plz);
		Kunde kunde = new Kunde(name, telefon, adressObj);
		this.add(kunde);
		return kunde;
	}

	public void update(int i, String name, String strasse, String ort, String plz, String telefon) {
		Kunde kunde = this.get(i);
		kunde.setName(name);
		kunde.setTelefon(telefon);
		Adresse adressObj = kunde.getAdresse();
		adressObj.setOrt(ort);
		adressObj.setPlz(plz);
		adressObj.setStrasse(strasse);		
	}



}
