package QTl;

import java.util.ArrayList;

public class gen {

	int genNr;
	String loc;
	String naam;
	ArrayList <Float >aLijst;
	ArrayList <Float> bLijst;
	
	public int genNr() {
		return genNr;
	}
	
	public void genNr(int nr) {
		this.genNr = nr;
	}

	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}

	public ArrayList<Float> getaLijst() {
		return aLijst;
	}

	public void setaLijst(ArrayList<Float> aLijst) {
		this.aLijst = aLijst;
	}

	public ArrayList<Float> getbLijst() {
		return bLijst;
	}

	public void setbLijst(ArrayList<Float> bLijst) {
		this.bLijst = bLijst;
	}
	
	
}
