


package QTl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.apache.commons.math3.stat.inference.TTest;

import jdk.jfr.Description;


/**
 * @author Thijs & Pim
 *
 */
public class QTLopdracht {

	static ArrayList<Object> objectenLijst;
	static double[] resultaten;

	
	/**
	 * @param args
	 * @return void
	 * @function een normale main functie die readfiles aanroept
	 */
	public static void main(String[] args) {
		
		objectenLijst = readfiles.readfiles();
		statistiek();
		
		
		
		safeResults();
		for(int i = 0; i < resultaten.length; i++)System.out.println(resultaten[i]);
		
		
	}
	
	
	/**
	 * @return void
	 * @functie loopt over de objectenLijst en voert per gen/object een t.test uit. De resultaten worden in een array worden opgeslagen.
	 */
	public static void statistiek(){
		double t_statistic;
		double [] sample1;
		double [] sample2;
		gen objectje;
		ArrayList<Double> a;
		ArrayList<Double> b;
		TTest ttest;
		resultaten = new double[objectenLijst.size()];
		
		for(int i = 0; i < objectenLijst.size(); i++) {
			
			objectje = (gen) objectenLijst.get(i);
			ttest = new TTest();
			
			a = objectje.getaLijst();
			b = objectje.getbLijst();
			
			sample1 = new double[a.size()];
			sample2 = new double[b.size()];
		    for (int x = 0; x < sample1.length; x++) {sample1[x] = a.get(x).doubleValue();}
		    for (int y = 0; y < sample2.length; y++) {sample2[y] = b.get(y).doubleValue();}
			
			t_statistic = ttest.tTest(sample1, sample2);
			resultaten[i] = t_statistic;
		}
	}
	
	/**
	 * @return void
	 * @functie schrijft de resultaten over in het bestand resultaten.txt
	 */
	public static void safeResults() {
		
		try {
			FileWriter fileWriter = new FileWriter("resultaten.txt");
	        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("Gen: \t p-value\n");
			for(int i = 0; i < resultaten.length; i++) {
				bufferedWriter.write(System.lineSeparator()+((gen) objectenLijst.get(i)).getNaam()+"\t"+resultaten[i]);
				
				
			}
			bufferedWriter.close();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

