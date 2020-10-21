package edu.pitt.cmpinf401.lab9;

import java.io.*;
import java.util.*;

public class RectangleReader {
	public static void main(String[] args) {
		String filename = "Rectangles.txt";
	        Scanner inputFile = openFile(filename);

		while (inputFile.hasNext()) {
			inputFile.useDelimiter(",");
			if (inputFile.next() == "Rectangle") {
				try {
					int id = Integer.parseInt(inputFile.next());
					String color = inputFile.next();
					int w = Integer.parseInt(inputFile.next());
					int h = Integer.parseInt(inputFile.next());
					Rectangle r = new Rectangle(id, w, h, color);
					System.out.println(r);
				} catch (NumberFormatException e) {
					inputFile.nextLine();
					continue;
				}
				String color = inputFile.next();
			} else { continue; }
		}
	}

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
