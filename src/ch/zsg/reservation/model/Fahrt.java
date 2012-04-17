package ch.zsg.reservation.model;

public class Fahrt {
	private String fahrtName;
	private Station vonOrt;
	private Station bisOrt;
	
	public Fahrt (String fahrtName, Station vonOrt, Station bisOrt){
		this.fahrtName = fahrtName;
		this.vonOrt = vonOrt;
		this.bisOrt = bisOrt;
	}
	
	public String getFahrtName() {
		return fahrtName;
	}

	public void setFahrtName(String fahrtName) {
		this.fahrtName = fahrtName;
	}

	public Station getVonOrt() {
		return vonOrt;
	}

	public void setVonOrt(Station vonOrt) {
		this.vonOrt = vonOrt;
	}

	public Station getBisOrt() {
		return bisOrt;
	}

	public void setBisOrt(Station bisOrt) {
		this.bisOrt = bisOrt;
	}

	public String toString(){
		return fahrtName + " (von " + vonOrt + " bis " + bisOrt + ")";
	}
}
