import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * This project uses only one class, which handles the calculation of the conversions as well
 * as the display, instead of separating them. This class only consists of a main method.
 */
public class Main {
	
	/*
	 * This main method contains the entire code, which uses JOptionPane to navigate between integer and
	 * binary inputs which are stored as ints, and displayed as strings.
	 */
	public static void main(String[] args) {
		
	      ImageIcon rico = new ImageIcon(Main.class.getResource("rico.png"));
	      ImageIcon ricoW = new ImageIcon(Main.class.getResource("rico1.png"));

	      String title = "Tori's Binary-Integer Converter";
	      
	      JOptionPane.showMessageDialog(null, "Welcome to Tori's binary-integer converter!", title, JOptionPane.INFORMATION_MESSAGE, rico);
	      
	      boolean playAgain = true;
	      
	      while(playAgain) {
	    	  String[] options = new String[4];
		      options[0] = "8-bit binary number";
		      options[1] = "integer";
		      options[2] = "view conversion table";
		      options[3] = "exit";
		      int choice = JOptionPane.showOptionDialog(null, "Would you like to convert an 8-bit binary number or an integer?", title, 0, JOptionPane.INFORMATION_MESSAGE, rico, options, null);
		      if(choice == 0) {
		    	  
		    	  String binary = (String) JOptionPane.showInputDialog(null, "Enter an 8-bit binary number.");
		    	  
		    	  if(binary.length() > 8) {
		    		  binary = binary.substring(0, 8);
		    	  }
		    	  
		    	  String binDisplay = "";
		    	  int[] binConvTable = new int[8];
		    	  String binConvTableDisplay = "";
		    	  
		    	  int total = 0;
		    	  int exp = 7;
		    	  
		    	  for(int i = 0; i < binary.length(); i++) {
		    		  binDisplay += binary.charAt(i) + " ";
		    		  if(binary.substring(i, i+1).equals("1")) {
		    			  total += Math.pow(2, exp);
		    			  binConvTable[i] = (int) Math.pow(2, exp);
		    		  }
		    		  else {
		    			  binConvTable[i] = 0;
		    		  }
		    		  exp--;
		    		  binConvTableDisplay += binConvTable[i] + " "; 
		    	  }
		    	  
		    	  ArrayList<Integer> binConvNonZeros = new ArrayList<Integer>();
		    	  for(int i = 0; i < binConvTable.length; i++) {
		    		  if(binConvTable[i] != 0) {
		    			  binConvNonZeros.add(binConvTable[i]);
		    		  }
		    	  }
		    	  
		    	  //creates string for the addition sentence
		    	  String binConvAddDisplay = "";
		    	  for(int i = 0; i < binConvNonZeros.size()-1; i++) {
			    	  binConvAddDisplay += binConvNonZeros.get(i) + " + ";
		    	  }
		    	  binConvAddDisplay += binConvNonZeros.get(binConvNonZeros.size()-1) + " = " + total;
		    	  
		    	  JOptionPane.showMessageDialog(null, binDisplay + "\n" + binConvTableDisplay + "\n" + binConvAddDisplay + "\n" + total, title, 0, ricoW);
		      }
		      
		      else if(choice == 1) {
		    	  int number = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter an integer between 0 and 255."));
		    	  
		    	  if(number > 255) {
		    		  number = 255;
		    	  }
		    	  
		    	  int numberTemp = number;
		    	  
		    	  int y;
		    	  
			     String intToBin = "";
		    	 while(numberTemp > 0) {
		    		 y = (numberTemp % 2);
			         intToBin = y + " " + intToBin;
			         numberTemp = numberTemp / 2;
		    	 }
		    	 
		    	 while(intToBin.length() < 16) {
		    		 intToBin = "0 " + intToBin;
		    	 }
		    	 
		    	 String addedValues = "";
		    	 int power = 0;
		    	  
		    	  for(int i = intToBin.length(); i > 0; i--) {
		    		  if(intToBin.substring(i-1, i).equals("1")) {
		    			  addedValues = (int) Math.pow(2, power) + " " + addedValues;
		    			  power++;
		    		  }
		    		  else if(intToBin.substring(i-1, i).equals("0")) {
		    			  addedValues = "0 " + addedValues;
		    			  power++;
		    		  }
		    		  
		    	  }
		    	 
		    
		    	 JOptionPane.showMessageDialog(null, number + "\n" + addedValues + "\n" + intToBin, title, 0, ricoW);
		    	  
		      }
		      
		      else if(choice == 2) {
		    	  String binTable =     "1       1      1      1       1       1      1      1";
		    	  String binConvTable = "2^7   2^6  2^5  2^4   2^3  2^2  2^1  2^0";
		    	  String intTable =     "128    64    32    16      8      4      2      1";
		    	  String intTotal =     "128 + 64 + 32 + 16 + 8 + 4 + 2 + 1 = 255";
		    	  JOptionPane.showMessageDialog(null, binTable + "\n" + binConvTable + "\n" + intTable + "\n" + intTotal, title, 0, ricoW);

		      }
		      
		      else if(choice == 3) {
		    	  playAgain = false;
		      }
	      
	      }
	      
	      
	
	}

	
}
