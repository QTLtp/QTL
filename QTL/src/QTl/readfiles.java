package QTl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class readfiles {
	static BufferedReader inFile;
	static ArrayList<Integer> planten = new ArrayList<Integer>();
	static ArrayList<Float> qua = new ArrayList<Float>();
	static ArrayList<String> loc = new ArrayList<String>();
	static ArrayList<String> genNamen = new ArrayList<String>();
	
	
	public static void readfiles() {
		quaFile();
		locFile();
	}
	
	private static void locFile() {
		try {
	        inFile = new BufferedReader(new FileReader("C:\\thijs\\blok2\\QTL\\CvixLerC9.LOC"));
	        String line;
	        int i = 4;
	        String markers = "";  

	        line = inFile.readLine();	
	        while ((line = inFile.readLine()) != null) {
	
	        	if (line.contains("(a,b) ; ")) { 
	        		i = 0;
	        		genNamen.add(line.split(" ")[0]);
	        		
	        	} else if(i < 4) {
	        		markers += line.replace("\n", "").replace(" ", "");
	        		if (i == 3) {
	        			loc.add(markers);
		        		markers = "";
	        		}
	        		i++;
	        	}
	        }
	        
	        inFile.close();
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null,
	                "File Error: " + e.toString());
	    }
	}
	
	private static void quaFile() {
		try {
	        inFile = new BufferedReader(new FileReader("C:\\thijs\\blok2\\QTL\\CvixLerC9.QUA"));
	        String line;
	        String[] a;
	        do{line = inFile.readLine();
	        }while (!(line.startsWith("1")));
	        do{
	        	if (!(line.contains("-"))) {
	        		a = line.split("\t");
	        		qua.add(Float.parseFloat(a[1]));
	        		planten.add(Integer.valueOf(a[0]));
	        	}
	        }while ((line = inFile.readLine()) != null);
	        inFile.close();
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null,
	                "File Error: " + e.toString());
	    }
	}

	public static ArrayList<Integer> getPlanten() {
		return planten;
	}

	public static void setPlanten(ArrayList<Integer> planten) {
		readfiles.planten = planten;
	}

	public static ArrayList<Float> getQua() {
		return qua;
	}

	public static void setQua(ArrayList<Float> qua) {
		readfiles.qua = qua;
	}

	public static ArrayList<String> getLoc() {
		return loc;
	}

	public static void setLoc(ArrayList<String> loc) {
		readfiles.loc = loc;
	}

	public static ArrayList<String> getGenNamen() {
		return genNamen;
	}

	public static void setGenNamen(ArrayList<String> genNamen) {
		readfiles.genNamen = genNamen;
	}
	
}
