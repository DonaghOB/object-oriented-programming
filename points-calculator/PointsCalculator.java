package myCode;

import java.lang.StringBuffer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class PointsCalculator {
	static int noStudents= 0;
	static String delimiter =",";
	static final int MaxStudents=100;
	static ArrayList <String> studentNames = new ArrayList<String>();
	static ArrayList <Integer> art = new ArrayList <Integer>();
	//static ArrayList <Integer> result[] = new ArrayList <Integer>()[10];

	//static int[][] result = new int[10][];



	static ArrayList <Integer> music = new ArrayList <Integer>();
	static ArrayList <Integer> history = new ArrayList<Integer>();
	static ArrayList <Integer> irish = new ArrayList<Integer>();
	static ArrayList <Integer> english = new ArrayList<Integer>();
	static ArrayList <Integer> maths = new ArrayList<Integer>();
	static ArrayList <Integer> geography = new ArrayList<Integer>();
	static ArrayList <Integer> french = new ArrayList<Integer>();
	static ArrayList <Integer> business = new ArrayList<Integer>();
	static ArrayList <Integer> biology = new ArrayList<Integer>();

	static void addStudents(String entry) {
		/*	result[noStudents]
		//System.out.println("Adding student " + entry);


		studentNames.add(fields[0]);
		//System.out.println("Value = " + Integer.parseInt(fields[1]));
		for(int i=0;i<10;i++) {
			result[i][noStudents]= Integer.parseInt(fields[i+1]);

		}*/

		String fields[] = entry.split(delimiter);
		studentNames.add(fields[0]);

		art.add(Integer.parseInt(fields[1]));
		music.add(Integer.parseInt(fields[2]));
		history.add(Integer.parseInt(fields[3]));
		irish.add(Integer.parseInt(fields[4]));
		english.add(Integer.parseInt(fields[5]));
		maths.add(Integer.parseInt(fields[6]));
		geography.add(Integer.parseInt(fields[7]));
		french.add(Integer.parseInt(fields[8]));
		business.add(Integer.parseInt(fields[9]));
		biology.add(Integer.parseInt(fields[10]));



		//studentNames[noStudents] = new int (entry1);

		//( new String (entry));

		noStudents++;
	}

	int calcPoints(int studentNumber) {

		return subjectPoints(art.get(studentNumber)) + 
				subjectPoints(music.get(studentNumber)) +
				subjectPoints(history.get(studentNumber)) +
				subjectPoints(irish.get(studentNumber)) +
				subjectPoints(english.get(studentNumber)) +
				subjectPoints(maths.get(studentNumber)) +
				subjectPoints(geography.get(studentNumber)) +
				subjectPoints(french.get(studentNumber)) +
				subjectPoints(business.get(studentNumber) +
						subjectPoints(biology.get(studentNumber)) );

	}

	public String highestPoints() {
		String student = "";
		int highestPoint =0;
		for(int i =0;i<10;i++) {
			if(calcPoints(i)>highestPoint) {
				highestPoint=calcPoints(i);
				student=studentNames.get(i);
			}

		}
		System.out.println("The highest grade was scored by: "+ student +", who scored a total of "+highestPoint + ".");
		return student;

	}
	public String lowestPoints() {
		String student = "";
		int lowestPoint =Integer.MAX_VALUE;
		for(int i =0;i<10;i++) {
			if(calcPoints(i)<lowestPoint) {
				lowestPoint=calcPoints(i);
				student=studentNames.get(i);
			}

		}
		System.out.println("The lowest grade was scored by: "+ student +", who scored a total of "+lowestPoint + ". What a loser!");
		return student;

	}
	public int averagePoints() {

		int averagePoint = 0;
		for(int i =0;i<10;i++) {
			averagePoint=averagePoint+calcPoints(i);



		}
		System.out.println("The average is: " + averagePoint/10);
		return averagePoint /10;

	}

	public String collegeChecker( int student) {

		if(calcPoints(student) >300)	{
			return studentNames.get(student) + " is elegible for UCD, NCI and FE";
			
		}
		if(calcPoints(student) <300 && calcPoints(student)>199) {
			return studentNames.get(student) + " is elegible for NCI and FE";
			
		}
		if(calcPoints(student) <200) {
			return studentNames.get(student) + " is elegible for FE";	
			
		}
		
		return "";
		
	}


	int subjectPoints(int points) {

		if(points<30) {
			return 0;
		} 
		if(points<40) {
			return 36;
		}
		if(points<50) {
			return 46;
		}
		if(points<60) {
			return 56;
		}
		if(points<70) {
			return 66;
		}
		if(points<80) {
			return 77;
		}
		if(points<90) {
			return 88;
		}

		return 100;

	}

	/* static void points_return(ArrayList< String> names,ArrayList < Integer> points) {
		for(List<String> record: csvData) {

		}

	}*/
	public PointsCalculator() {

	}
	public PointsCalculator(String[] studentNames) {

	}

	public String toString() {
		StringBuffer sb=new StringBuffer();
		for(int i=0; i<noStudents;i++) {
			sb.append("Student: ").append(studentNames.get(i))
			.append("; art=" + art.get(i).toString())
			.append("; music=" + music.get(i).toString())
			.append("; history=" + history.get(i).toString())
			.append("; irish=" + irish.get(i).toString())
			.append("; english=" + english.get(i).toString())
			.append("; maths=" + maths.get(i).toString())
			.append("; geography=" + geography.get(i).toString())
			.append("; french=" + french.get(i).toString())
			.append("; business=" + business.get(i).toString())
			.append("; biology=" + biology.get(i).toString())

			.append(". Points = "+ calcPoints(i) + ". \n")
			.append(collegeChecker(i))


			.append("\n");
			//System.out.println("Art = "+ art.get(i));	

		}
		return(sb.toString());
	}





}
