package QTl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class QTLopdracht {

	static ArrayList<Object> objectenLijst;

	public static void main(String[] args) {
		objectenLijst = readfiles.readfiles();
		
		gen b = (gen) objectenLijst.get(0);
		System.out.println(b.getaLijst());
		System.out.println(b.getbLijst());


	}
}
