/*
*College registration system
*Created by DOnagh Ó Briain
*/
package mycode;

import java.util.Scanner;

public class Registrar { //Start Registrar class

	private int idNum;

	private String userName;

	private String eAddress;

	private int numberOfModules;

	private double totalCost;

	private double discountRate;
	
	private int standardCostOfModule;
	
	public Registrar () {
		//System.out.println("In Registrar constructor");
		totalCost= 0.0; //Always initialize cost to zero
		discountRate = 0.1; //Set discount rate to 10%
		standardCostOfModule = 100; //
	}

	public Registrar(int idNum, String userName, String eAddress, int modNum) {
		super(); //Call the empty constructor for things we always set
		this.idNum = idNum;
		this.userName = userName;
		this.eAddress = eAddress;
		this.numberOfModules = modNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEAddress() {
		return eAddress;
	}

	public void setEAddress(String eAddress) {
		this.eAddress = eAddress;
	}

	public int getNumberOfModules() {
		return numberOfModules;
	}

	public void setNumberOfModules(int modNum) {
		this.numberOfModules = modNum;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public void setIdNum (int value){
		idNum = value;
	}
	public int getIdNum() {
		return idNum;
	}
	
	 void calculateCost() {
		setTotalCost(getNumberOfModules() * standardCostOfModule);
		
	}
	
	  void calcDiscount() {
		if( getNumberOfModules() > 5)  {
			this.setTotalCost(getTotalCost() - (getTotalCost() * discountRate));
		
		}
	}

	void display() {
		if(numberOfModules > 5) {
			System.out.println("--You have received a discount!--");
			
		}
		System.out.println("Your ID number is:" + this.getIdNum());
		System.out.println("Your user name is:" + this.getUserName());
		System.out.println("Your email address is:" + this.getEAddress());
		System.out.println("You have " + this.getNumberOfModules() + " modules");
		System.out.println("The total cost of enrolment is:" + this.getTotalCost());
	}

	public String toString() {

		return "idNum=" + getIdNum() + ",userName=" + getUserName()+ "totalCost=" + getTotalCost() + ",Module number=" + getNumberOfModules()  + ",Email=" +getEAddress(); 
	}
}



