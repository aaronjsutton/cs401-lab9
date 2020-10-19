package edu.pitt.cmpinf401.lab9;


import java.io.*;   
import java.util.*;  

/**
   This program demonstrates how exception handlers can
   be used to recover from errors.
*/
 
public class HomeSales
{
   public static void main(String[] args)
   {
      String filename = "SalesData.txt";
      int months = 0;
      
      //double oneMonth;
      double totalSales = 0.0;
      double averageSales;

      // Attempt to open the file by calling the open-file method.
      Scanner inputFile = openFile(filename);
      
	  Scanner kbd = new Scanner(System.in);

	  String input = kbd.nextLine();
    inputFile = openFile(input);
    while (inputFile != null) {
      input = kbd.nextLine();
      System.out.println("cannot find file. try again");
      kbd.nextLine();
    }
     
	  kbd.close();
      
      // Process the contents of the file.
	  ArrayList<Double> numberList = new ArrayList<Double>();
      while (inputFile.hasNext())
      {
    	  //@TODO add error handling when processing the string input
		  numberList.add(inputFile.nextDouble());
		  months++;
		 
      }
      
      inputFile.close();

      for (double i = 0; i < numberList.size(); i++) {
		  	totalSales += numberList.get((int) i);
	  }

      // Calculate the average.
      averageSales = totalSales / months;

      // Display the results.
      System.out.printf("Number of months: %d\n" +
                       "Total Sales: $%,.2f\n" +
                       "Average Sales: $%,.2f",
                       months, totalSales, averageSales);
      System.exit(0);
   }

   /**
      The openFile method opens the specified file and
      returns a reference to a Scanner object.
      @param filename The name of the file to open.
      @return A Scanner reference, if the file exists
              Otherwise, null is returned.
   */

   public static Scanner openFile(String filename)
   {
      Scanner scan;
      File file = new File(filename);
      try {
        scan = new Scanner(file);
        return scan;
      } catch (FileNotFoundException e) {
        return null;
      }
   }
}
