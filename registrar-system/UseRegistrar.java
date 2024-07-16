/*
*College registration system
*Created by Donagh Ó Briain
*/
package mycode;

import java.util.Scanner;

public class UseRegistrar {

	 static Registrar input() {
		Scanner input = new Scanner(System.in);
		Registrar reg = new Registrar();
		System.out.println("What is your id number?");
		reg.setIdNum(input.nextInt()) ;
		reg.setUserName(input.nextLine()) ;
		System.out.println("What is your user name?");
		reg.setUserName(input.nextLine()) ;
		System.out.println("What is your email address?");
		reg.setEAddress(input.nextLine()) ;
		System.out.println("How many modules do you have?");
		reg.setNumberOfModules(input.nextInt()) ;
		
		
		reg.calculateCost();
		
		return reg;
	}

	public static void main(String[] args) {
		
		System.out.println("Welcome! Please enter your details to register for our college.");
		
		Registrar reg = new Registrar();
		reg= input();
		reg.calcDiscount();
		reg.display();
	
	}
}