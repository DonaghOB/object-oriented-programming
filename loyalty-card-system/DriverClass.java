package loyaltyCardProject;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.Flushable;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DriverClass {



	public static ArrayList <LoyaltyCard> myCards = new ArrayList<LoyaltyCard>();



	static int status=1;
	static int choice=0;
	static String cardFile = "output.txt";
	static String sep = ",";

	public static void setupMethod() {
		LoyaltyCard lc1 = new LoyaltyCard();
		lc1 = new Bronze();
		lc1.setUsername("Steve");
		lc1.setMoneySpent(250.20);
		lc1.setCardActive(true);
		//public static ArrayList <LoyaltyCard> myCards = new ArrayList<LoyaltyCard>();
		
		
		LoyaltyCard lc2 = new LoyaltyCard();
		lc2 = new Bronze();
		lc2.setUsername("Joe");
		lc2.setMoneySpent(50.00);
		lc2.setCardActive(false);
		
		LoyaltyCard lc3 = new LoyaltyCard();
		lc3 = new Bronze();
		lc3.setUsername("Paul");
		lc3.setMoneySpent(83.67);
		lc3.setCardActive(true);
		
		LoyaltyCard lc4 = new LoyaltyCard();
		lc4 = new Silver();
		lc4.setUsername("John");
		lc4.setMoneySpent(200.00);
		lc4.setCardActive(false);
		
		LoyaltyCard lc5 = new LoyaltyCard();
		lc5 = new Silver();
		lc5.setUsername("Ringo");
		lc5.setMoneySpent(589.00);
		lc5.setCardActive(true);
		
		LoyaltyCard lc6 = new LoyaltyCard();
		lc6 = new Silver();
		lc6.setUsername("Axl");
		lc6.setMoneySpent(177.00);
		lc6.setCardActive(true);
		
		LoyaltyCard lc7 = new LoyaltyCard();
		lc7 = new Gold();
		lc7.setUsername("Elvis");
		lc7.setMoneySpent(105.50);
		lc7.setCardActive(true);
		
		LoyaltyCard lc8 = new LoyaltyCard();
		lc8 = new Gold();
		lc8.setUsername("Bob");
		lc8.setMoneySpent(57.50);
		lc8.setCardActive(true);
		
		LoyaltyCard lc9 = new LoyaltyCard();
		lc9 = new Gold();
		lc9.setUsername("Frank");
		lc9.setMoneySpent(97.50);
		lc9.setCardActive(false);
		
		
		myCards.add(lc1);
		myCards.add(lc2);
		myCards.add(lc3);
		myCards.add(lc4);
		myCards.add(lc5);
		myCards.add(lc6);
		myCards.add(lc7);
		myCards.add(lc8);
		myCards.add(lc9);
		
	}
	
	


	public static void viewAllCards() {
		String cardType="";

		Scanner input = new Scanner(System.in);

		for(LoyaltyCard lc:myCards) {
			if(lc instanceof Gold) {
				cardType="Gold";
			}else if(lc instanceof Silver) {
				cardType="Silver";
			}else if(lc instanceof Bronze) {
				cardType="Bronze";
			}
			System.out.println("|Card type: " +cardType +", |Unique ID is:" +lc.uniqueID+", | Name is: " + lc.userName + ", |Total spent is: "+ lc.moneySpent + ", | Is the card active: " + lc.cardActive + ", |Bonus points per Card: " + lc.bonusPoints +", | Conversion rate for the card is: " + lc.conversionRate + ", |Total points earned: " +lc.totalPoints() + "|");
		}



	}
	public static void cardSeacher() {
		String searchValue="";
		LoyaltyCard lcard = new LoyaltyCard();
		Scanner input = new Scanner(System.in);
		System.out.println("You have chosen to search for a card.");
		System.out.println("Please enter Id for the card you want to find:");
		searchValue = input.nextLine();
		System.out.println("Searching for the following ID: " + searchValue);
		for(LoyaltyCard lc:myCards) {
			//System.out.println(lc.getUniqueID());
			if(searchValue.equals(lc.getUniqueID())) {

				System.out.println("found card: "+ "Card type: " +lc.getCardType() +", Unique ID is:" +lc.uniqueID+",  Name is: " + lc.userName + ", Total spent is: "+ lc.moneySpent + ", Is the card active: " + lc.cardActive + ", Bonus points per Card: " + lc.bonusPoints +", Conversion rate for the card is: " + lc.conversionRate + ", Total points earned: " +lc.totalPoints());
			}

		}




	}

	public static void cardRegister()  {

		LoyaltyCard lcard = new LoyaltyCard();
		Scanner input = new Scanner(System.in);

		int menuOption=0;

		System.out.println("Welcome to the card register.");
		System.out.println("Here you will make register your new card by enting the new details.");
		System.out.println("...");

		while(menuOption!=4) {
			System.out.println("What card type would you like?");
			System.out.println("1. Bronze Card");
			System.out.println("2. Silver Card");
			System.out.println("3. Gold Card");
			System.out.println("4. Main menu");
			menuOption = input.nextInt();



			switch(menuOption) {
			case 1:
				lcard = new Bronze();
				break;
			case 2:
				lcard = new Silver();
				break;
			case 3:
				lcard = new Gold();
				break;


			}

			if(menuOption!=4) {
				input.nextLine();

				System.out.println("Please enter your new Username:");
				lcard.userName = input.nextLine();
				System.out.println("Hello, " + lcard.userName + ". Now  how much has been spent on this card?");
				lcard.moneySpent = input.nextDouble();
				System.out.println("Activate the card? (true/false)");
				lcard.cardActive = input.nextBoolean();


				myCards.add(lcard);
			}
		}
		System.out.println("...");
		System.out.println("Exiting to menu now");

	}

	public static void cardDeletion() {
		String searchValue ="";
		LoyaltyCard lcard = new LoyaltyCard();
		Scanner input = new Scanner(System.in);

		System.out.println("You have chosen to delete a card.");
		System.out.println("Please enter the id of the card you want to delete:");
		searchValue = input.nextLine();
		int i=0;
		for(LoyaltyCard lc:myCards) {
			System.out.println(lc.getUniqueID());
			System.out.println(searchValue);
			if(searchValue.equals(lc.getUniqueID())) {

				System.out.println("found card: "+ lc);
				System.out.println("Searching for the following ID: " + searchValue);
				System.out.println("Deleting the following details:" + "found card: "+ "Card type: " +lc.getCardType() +", Unique ID is:" +lc.uniqueID+",  Name is: " + lc.userName + ", Total spent is: "+ lc.moneySpent + ", Is the card active: " + lc.cardActive + ", Bonus points per Card: " + lc.bonusPoints +", Conversion rate for the card is: " + lc.conversionRate + ", Total points earned: " +lc.totalPoints());
				myCards.remove(i);
				return;
			}
			i++;

		}


	}
	public static void updateCard() {
		String searchValue = "";
		Scanner input = new Scanner(System.in);

		System.out.println("You have chosen to update a card.");
		System.out.println("Please enter the ID of the card in here:");
		searchValue = input.nextLine();
		System.out.println("Searching for the following ID: " + searchValue);
		for(LoyaltyCard lc:myCards) {
			//System.out.println(lc.getUniqueID());
			if(searchValue.equals(lc.getUniqueID())) {

				System.out.println("found card: "+ "found card: "+ "Card type: " +lc.getCardType() +", Unique ID is:" +lc.uniqueID+",  Name is: " + lc.userName + ", Total spent is: "+ lc.moneySpent + ", Is the card active: " + lc.cardActive + ", Bonus points per Card: " + lc.bonusPoints +", Conversion rate for the card is: " + lc.conversionRate + ", Total points earned: " +lc.totalPoints());
			}

		}

		;
		int menuOption=0;

		for(LoyaltyCard lc:myCards) {
			while(menuOption!=4) {
				System.out.println("1. Name");
				System.out.println("2.Total spend");
				System.out.println("3. Active");
				System.out.println("4. Menu");
				menuOption =input.nextInt();
				input.nextLine();



				switch(menuOption) {
				case 1:
					String newName;
					System.out.println("Current name is:" + lc.userName);
					System.out.println("Please enter the new name:");
					newName = input.nextLine();
					System.out.println("The new name is " + newName);
					lc.userName = newName;
					break;
				case 2:
					Double newAmount;
					System.out.println("Current total amount is:" + lc.moneySpent);
					System.out.println("Please enter the new total amount:");
					newAmount = input.nextDouble();
					System.out.println("The new amount is " + newAmount);
					lc.moneySpent = newAmount;
					break;
				case 3:
					Boolean newStatus;
					System.out.println("Current status is:" + lc.cardActive);
					System.out.println("Please enter the new status:  (true/false)");
					newStatus = input.nextBoolean();
					System.out.println("The new amount is " + newStatus);
					lc.cardActive = newStatus;
					break;
				}
			}
		}

	}

	public static void fileReader() {
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(cardFile));
		} catch (FileNotFoundException e2) {
			System.out.println("No existing file currently");
			return;
		} catch (IOException e) {

			e.printStackTrace();
		} 



		try {

			String line = reader.readLine();

			while(line != null){
				//System.out.println(line);
				String[] arr = line.split(sep);
				Boolean b1=null;
				Double d1=null;
				try {

					d1=Double.parseDouble(arr[3]);
					b1=Boolean.parseBoolean(arr[4]);

				}
				catch(Exception e1) {
					System.out.println("E1 has been found " + e1);
				}

					
					LoyaltyCard lc = new LoyaltyCard(arr[1],arr[2],d1,b1);
					myCards.add(lc);
					line = reader.readLine();
				}
			

			//reader.line(lc.userName + lc.moneySpent + lc.cardActive + System.lineSeparator());
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void filePrinter() {
		FileWriter writer = null;
		try {
			writer = new FileWriter(cardFile);
		} catch (IOException e) {

			e.printStackTrace();
		} 


		for(LoyaltyCard lc:myCards) {
			try {
				writer.write(lc.getCardType() +sep + lc.uniqueID +sep+  lc.userName + sep + lc.moneySpent +sep + lc.cardActive + System.lineSeparator());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}







	public static void main(String[] args) {
		setupMethod();
		System.out.println("User directory is " + System.getProperty("user.dir"));
		Scanner input = new Scanner(System.in);


		while(status==1) {
			fileReader();
			System.out.println("--------Main Menu-------");
			System.out.println("|1. View all cards     |");
			System.out.println("|2. Search for a card  |");
			System.out.println("|3. Register a new card|");
			System.out.println("|4. Delete a card      |");
			System.out.println("|5. Update details     |");
			System.out.println("|6. Print to file      |");
			System.out.println("|7. Exit               |");
			System.out.println("------------------------");




			System.out.println("pick a number 1-7");
			choice = input.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Here are the ");
				viewAllCards();
				break;
			case 2:
				cardSeacher();
				break;
			case 3:
				cardRegister();
				break;
			case 4:
				cardDeletion();
				break;
			case 5:
				updateCard();
				break;
			case 6:
				filePrinter();
				System.out.println("6 has been chosen");
				System.out.println("If you would like to return to the menu, press 1");
				break;
			case 7:
				status = 0;
				System.out.println("7 has been chosen");
				System.out.println("Program closing...");
				System.exit(191);
				break;


			}
		}


	}

}
