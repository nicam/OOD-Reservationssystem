package ch.zsg.reservation.model;

public class Historie {
	private String text, datum;

	public Historie(String text, String datum) {
		super();
		this.text = text;
		this.datum = datum;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}
}
