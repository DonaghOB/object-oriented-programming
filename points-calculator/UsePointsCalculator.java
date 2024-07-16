package myCode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class UsePointsCalculator {

	static String fileName="Book1.csv";

	public static void main(String[] args) {
		PointsCalculator pCalc = new PointsCalculator();
		// Creates a FileReader
		FileReader file;
		try {
			file = new FileReader(fileName);
			//Creates a BufferedReader
			BufferedReader buffer = new BufferedReader(file);

			//int lineCount =0;
			int i = 0;
			String line = buffer.readLine();
			while (line != null) {
				if(i>0) {pCalc.addStudents(line);}
				i++;
				line = buffer.readLine();
			}
			file.close();
		}
		catch(FileNotFoundException e1){
			System.out.println("File not found Exception found trying to open file! "+ e1);
			e1.printStackTrace();
			System.exit(1);

		} catch(IOException e2) {
			System.out.println("IO Exception found trying to open file! "+ e2);
			System.exit(2);
		}
		System.out.println("Students:" + pCalc);
		
		pCalc.highestPoints();
		pCalc.lowestPoints();
		pCalc.averagePoints();

	}

}
