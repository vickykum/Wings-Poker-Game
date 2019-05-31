package PokerGame_GUI;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class RuleReader {
	
	 public ArrayList<String> readFile(String inputFilePath) {
		    ArrayList<String> vector = new ArrayList<>();

		    try{
		      BufferedReader br = new BufferedReader(new FileReader(inputFilePath));

		      //int n = Integer.parseInt(bufferedReader.readLine());

		      /*for (int i = 0; i < n; i ++) {
		        vector.add(bufferedReader.readLine());
		      }*/
		      
		      String line = "";
		      while((line = br.readLine()) != null) {
		    	  vector.add(line);
		      }
		     
		      
		      br.close();

		    }
		    catch (Exception e) {
		      e.printStackTrace();
		    }
		    return vector;
		  }	
	 
	 public String[] getRules(String inputFilePath) {
		 ArrayList<String> readRules = readFile(inputFilePath);
		 String[] allRules = new String[readRules.size()];
		 
		 for(int i =0; i<readRules.size(); i++) {
			 allRules[i] = readRules.get(i);
		 }
		 
		 return allRules;
	 }

}
