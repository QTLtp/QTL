package QTl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class QTLopdracht {
	static BufferedReader inFile;
	static ArrayList<Integer> planten = new ArrayList<Integer>();
	static ArrayList<Float> qua = new ArrayList<Float>();
	static ArrayList<String> loc = new ArrayList<String>();
	static ArrayList<String> genNamen = new ArrayList<String>();

	public static void main(String[] args) {
		readfiles();
		System.out.println(planten.get(0));
		System.out.println(qua.get(0));
		System.out.println(loc.get(0));
		System.out.println(genNamen.get(0));
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
	
}
