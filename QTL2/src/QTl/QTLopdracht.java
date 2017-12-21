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

	}
}
