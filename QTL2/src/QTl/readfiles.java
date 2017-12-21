package QTl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class readfiles {
	static BufferedReader inFile;
	static ArrayList<Object> objectenLijst = new ArrayList();
	
	static ArrayList<Double> qua = new ArrayList<Double>();
	static ArrayList<String> loc = new ArrayList<String>();
	static ArrayList<String> genNamen = new ArrayList<String>();
	
	public static ArrayList<Object> readfiles() {
		quaFile();
		locFile();
		verwerkData();
		return objectenLijst;
	}
	
	private static void locFile() {
		try {
	        inFile = new BufferedReader(new FileReader("C:\\thijs\\blok2\\QTL\\CvixLerC9.LOC"));
	        String line;
	        int i = 4;
	        String markers = "";  

	        line = inFile.readLine();	
	        while ((line = inFile.readLine()) != null) {
	
	        	if (line.contains("(a,b)")) { 
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
	        		qua.add(Double.parseDouble(a[1]));
	        	} else {
	        		qua.add(-1.0);
	        	}
	        }while ((line = inFile.readLine()) != null);
	        inFile.close();
	    } catch (IOException e) {
	        JOptionPane.showMessageDialog(null,
	                "File Error: " + e.toString());
	    }
	}
	
	private static void verwerkData(){
		gen a;
		String b;
		double c;
		
		ArrayList<Double> aLijst = new ArrayList<Double>();
		ArrayList<Double> bLijst = new ArrayList<Double>();
		
		for(int i = 0; i < genNamen.size(); i++) {
			a = new gen();
			b = loc.get(i); 
			
			for(int x = 0; x < b.length(); x++) {
				c = qua.get(x);
				if (c != -1.0 && b.charAt(x) == 'b' ) {
					bLijst.add(c);
				} else if (c != -1.0 && b.charAt(x) == 'a' ) {
					aLijst.add(c);
				}
			}
			
			a.setaLijst(aLijst);
			a.setbLijst(bLijst);
			a.setLoc(loc.get(i));
			a.setNaam(genNamen.get(i));
			objectenLijst.add(a);
		}
	}
}
