/*
 * Loyalty card project
 * Donagh Ó Briain 2024
 */

package loyaltyCardProject;

// Importing necessary libraries
import java.util.Scanner; // For user input
import java.util.ArrayList; // For managing lists of objects
import java.io.FileWriter; // For writing to files
import java.io.Flushable; // For flushing data
import java.io.FileReader; // For reading files
import java.io.BufferedReader; // For reading text from character-input stream
import java.io.FileNotFoundException; // Exception handling for file not found
import java.io.IOException; // Exception handling for input/output errors


public class DriverClass {

	// ArrayList to hold LoyaltyCard objects
	public static ArrayList<LoyaltyCard> myCards = new ArrayList<LoyaltyCard>();

	// Status indicator
	static int status = 1;

	// File to store data
	static String cardFile = "output.txt";

	// Separator for data
	static String sep = ",";



	public static void setupMethod() {
		// Creating LoyaltyCard objects and initializing their attributes
		LoyaltyCard lc1 = new Bronze();
		lc1.setUsername("Steve");
		lc1.setMoneySpent(250.20);
		lc1.setCardActive(true);

		LoyaltyCard lc2 = new Bronze();
		lc2.setUsername("Joe");
		lc2.setMoneySpent(50.00);
		lc2.setCardActive(false);

		LoyaltyCard lc3 = new Bronze();
		lc3.setUsername("Paul");
		lc3.setMoneySpent(83.67);
		lc3.setCardActive(true);

		LoyaltyCard lc4 = new Silver();
		lc4.setUsername("John");
		lc4.setMoneySpent(200.00);
		lc4.setCardActive(false);

		LoyaltyCard lc5 = new Silver();
		lc5.setUsername("Ringo");
		lc5.setMoneySpent(589.00);
		lc5.setCardActive(true);

		LoyaltyCard lc6 = new Silver();
		lc6.setUsername("Axl");
		lc6.setMoneySpent(177.00);
		lc6.setCardActive(true);

		LoyaltyCard lc7 = new Gold();
		lc7.setUsername("Elvis");
		lc7.setMoneySpent(105.50);
		lc7.setCardActive(true);

		LoyaltyCard lc8 = new Gold();
		lc8.setUsername("Bob");
		lc8.setMoneySpent(57.50);
		lc8.setCardActive(true);

		LoyaltyCard lc9 = new Gold();
		lc9.setUsername("Frank");
		lc9.setMoneySpent(97.50);
		lc9.setCardActive(false);

		// Adding LoyaltyCard objects to the ArrayList
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


		//method that checks error with prompt passed through
	public static int getIntFromString(String prompt) {
		int optionValue = 0;
		Scanner sc = new Scanner(System.in);

		// Loop until a valid integer input is received
		boolean done = false;
		while (!done) {
			System.out.println(prompt);
			String menuString = sc.nextLine();
			try {
				optionValue = Integer.parseInt(menuString);
				done = true; // Set to true when a valid integer is entered
			} catch (NumberFormatException e) {
				System.out.println("Invalid integer entered.");
			}
		}
		return optionValue;
	}

	//method that checks error with prompt passed through
	public static Double getDoubleFromString(String prompt) {
		Double optionValue = 0.0;
		Scanner sc = new Scanner(System.in);

		// Loop until a valid double input is received
		boolean done = false;
		while (!done) {
			System.out.println(prompt);
			String menuString = sc.nextLine();
			try {
				optionValue = Double.parseDouble(menuString);
				done = true; // Set to true when a valid double is entered
			} catch (NumberFormatException e) {
				System.out.println("Invalid input entered.");
			}
		}
		return optionValue;
	}
	//method that checks error with prompt passed through
	public static Boolean getBooleanFromString(String prompt) {
		Boolean optionValue = null;
		Scanner sc = new Scanner(System.in);

		// Loop until a valid boolean input is received
		boolean done = false;
		while (!done) {
			System.out.println(prompt);
			String menuString = sc.nextLine();

			// Parsing the input string to boolean
			optionValue = Boolean.parseBoolean(menuString);

			// Checking if the input is either "true" or "false" (case insensitive)
			if (menuString.equalsIgnoreCase("true") || menuString.equalsIgnoreCase("false")) {
				done = true; // Set to true when a valid boolean is entered
			} 
		}

		return optionValue;
	}



	public static void viewAllCards() {
		String cardType = "";

		Scanner input = new Scanner(System.in);
        System.out.println("Here are the cards: ");

		// Iterating through each LoyaltyCard object in the ArrayList
		for (LoyaltyCard lc : myCards) {
			// Determining the card type
			if (lc instanceof Gold) {
				cardType = "Gold";
			} else if (lc instanceof Silver) {
				cardType = "Silver";
			} else if (lc instanceof Bronze) {
				cardType = "Bronze";
			}
			// Printing card details
			System.out.println("| Card type: " + cardType + ", | Unique ID is: " + lc.uniqueID +  ", | Name is: " + lc.userName + ", | Total spent is: " + lc.moneySpent +  ", | Is the card active: " + lc.cardActive + ", | Bonus points per Card: " +  lc.bonusPoints + ", | Conversion rate for the card is: " + lc.conversionRate +  ", | Total points earned: " + lc.totalPoints() + " |");
		}
        System.out.println("returning to menu...");
	}

	public static void cardSeacher() {
	    String searchValue = "";
	    LoyaltyCard lcard = new LoyaltyCard();
	    Scanner input = new Scanner(System.in);
	    System.out.println("You have chosen to search for a card.");
	    System.out.println("Please enter ID for the card you want to find:");
	    searchValue = input.nextLine();
	    System.out.println("Searching for the following ID: " + searchValue);
	    
	    // Iterating through each LoyaltyCard object in the ArrayList
	    for (LoyaltyCard lc : myCards) {
	        if (searchValue.equals(lc.getUniqueID())) { // Checking if searchValue matches the unique ID of any LoyaltyCard
	            // Printing card details if match found
	            System.out.println("Found card: Card type: " + lc.getCardType() +  ", Unique ID is: " + lc.getUniqueID() +   ", Name is: " + lc.getUsername() + ", Total spent is: " + lc.getMoneySpent() + ", Is the card active: " + lc.getCardActive() + ", Bonus points per Card: " + lc.getBonusPoints() +  ", Conversion rate for the card is: " + lc.getConversionRate() +   ", Total points earned: " + lc.totalPoints());
	            System.out.println("returning to menu...");

	            return;
	        }
	    }
	    // If no match found
	    System.out.println("Unable to locate applicable ID.");
	    System.out.println("Returning to menu...");
	}


	public static void cardRegister() {
	    LoyaltyCard lcard = new LoyaltyCard(); // Creating a LoyaltyCard object to hold card details
	    Scanner input = new Scanner(System.in); // Creating a Scanner object to get user input
	    int menuOption = 0; // Variable to store the user's menu choice

	    // Displaying initial messages to the user
	    System.out.println("Welcome to the card register.");
	    System.out.println("Here you will register your new card by entering the new details.");
	    System.out.println("...");

	    // Displaying card generation menu and processing user input until the user chooses to return to the main menu
	    while (menuOption != 4) {
	        // Displaying card generation menu options
	        System.out.println("----Card generation menu----");
	        System.out.println("What card type would you like?");
	        System.out.println("1. Bronze Card");
	        System.out.println("2. Silver Card");
	        System.out.println("3. Gold Card");
	        System.out.println("4. Main menu");

	        // Getting the user's menu choice
	        menuOption = getIntFromString("Please enter a valid integer 1-4");

	        switch (menuOption) {
	            case 1:
	                lcard = new Bronze(); // Creating a new Bronze card object
	                break;
	            case 2:
	                lcard = new Silver(); // Creating a new Silver card object
	                break;
	            case 3:
	                lcard = new Gold(); // Creating a new Gold card object
	                break;
	        }

	        if (menuOption != 4) {
	            // Entering new card details
	            System.out.println("Please enter your new name:");
	            lcard.setUsername(input.nextLine()); // Setting the username for the new card
	            lcard.setMoneySpent(getDoubleFromString("Hello, " + lcard.getUsername() + ". Now, how much has been spent on this card?")); // Setting the money spent on the card
	            System.out.println("Activate the card? (true/false)");
	            lcard.setCardActive(getBooleanFromString("Please enter a valid input (true/false)")); // Setting the activation status of the card

	            // Adding new card to the ArrayList
	            myCards.add(lcard);
	            System.out.println("Card created successfully.");
	        }
	    }

	    // Exiting the card registration process and returning to the main menu
	    System.out.println("...");
	    System.out.println("Exiting to menu now");
	}


	public static void cardDeletion() {
	    String searchValue = "";
	    LoyaltyCard lcard = new LoyaltyCard();
	    Scanner input = new Scanner(System.in);

	    // Prompting user for the ID of the card to be deleted
	    System.out.println("You have chosen to delete a card.");
	    System.out.println("Please enter the ID of the card you want to delete:");
	    searchValue = input.nextLine();

	    int i = 0; // Counter variable to track index of LoyaltyCard in ArrayList
	    for (LoyaltyCard lc : myCards) {
	        if (searchValue.equals(lc.getUniqueID())) { // Checking if searchValue matches the unique ID of any LoyaltyCard
	            System.out.println("Searching for the following ID: " + searchValue);
	            System.out.println("Found card: " + lc.uniqueID);

	            // Displaying details of the card to be deleted
	            System.out.println("Deleting the following details: Card type: " + lc.getCardType() +", Unique ID is: " + lc.getUniqueID() + ", Name is: " + lc.getUsername() + ", Total spent is: " + lc.getMoneySpent() +", Is the card active: " + lc.getCardActive() +", Bonus points per Card: " + lc.getBonusPoints() + ", Conversion rate for the card is: " + lc.getConversionRate() +	 ", Total points earned: " + lc.totalPoints());

	            myCards.remove(i); // Removing the card from the ArrayList
	            System.out.println("Returning to main menu...");
	            return;
	        }
	        i++;
	    }

	    // If no match found
	    System.out.println("Unable to locate applicable ID.");
	    System.out.println("Returning to menu...");
	}

	public static void updateCard() {
		String searchValue = "";
		Scanner input = new Scanner(System.in);

		System.out.println("You have chosen to update a card.");

		int i = 0;
		 boolean done = false;
		    // Loop until a valid card ID is entered
		    while (!done) {
		        System.out.println("Please enter the ID of the card:");
		        searchValue = input.nextLine();
		        System.out.println("Searching for the following ID: " + searchValue);

		        // Iterating through the ArrayList to find the card with the entered ID
		        for (i = 0; i < myCards.size(); i++) {
		            if (searchValue.equals(myCards.get(i).getUniqueID())) {
		                // Displaying details of the card to be updated
					System.out.println("found card: "+ i + ":Card type: " + myCards.get(i).getCardType() +", Unique ID is:" +myCards.get(i).uniqueID+",  Name is: " + myCards.get(i).userName + ", Total spent is: "+ myCards.get(i).moneySpent + ", Is the card active: " + myCards.get(i).cardActive + ", Bonus points per Card: " + myCards.get(i).bonusPoints +", Conversion rate for the card is: " + myCards.get(i).conversionRate + ", Total points earned: " +myCards.get(i).totalPoints());
					done = true;
					break;

				}

			}

		}

		int menuOption=0;



		while(menuOption!=4) {

			searchValue=myCards.get(i).getUniqueID();
			System.out.println("1. Name");
			System.out.println("2.Total spend");
			System.out.println("3. Active");
			System.out.println("4. Menu");
			menuOption =getIntFromString("Pick an option 1-4");

			switch(menuOption) {
			case 1:
				String newName;
				System.out.println("Current name is:" + myCards.get(i).userName);
				System.out.println("Please enter the new name:");
				newName = input.nextLine();
				System.out.println("The new name is " + newName);
				myCards.get(i).userName = newName;
				System.out.println("Returning to update menu");

				break;
			case 2:
				Double newAmount;
				System.out.println("Current total amount is:" + myCards.get(i).moneySpent);
				System.out.println("Please enter the new total amount:");
				newAmount = getDoubleFromString("Please enter a valid amount:");
				System.out.println("The new amount is " + newAmount);
				myCards.get(i).moneySpent = newAmount;
				System.out.println("Returning to update menu");
				break;
			case 3:
				Boolean newStatus;
				System.out.println("Current status is:" + myCards.get(i).cardActive);
				System.out.println("Please enter the new status:  (true/false)");
				newStatus = getBooleanFromString("Please enter a valid input (true/false)");
				System.out.println("The new amount is " + newStatus);
				myCards.get(i).cardActive = newStatus;
				System.out.println("Returning to update menu");
				break;

			}
		}
	}


	public static void fileReader() {
	    BufferedReader reader = null;
	    try {
	        reader = new BufferedReader(new FileReader(cardFile)); // Creating a BufferedReader to read from the file
	    } catch (FileNotFoundException e2) {
	        System.out.println("No existing file currently"); // Handling case when file is not found
	        return;
	    } catch (IOException e) {
	        e.printStackTrace(); // Printing stack trace if an I/O error occurs
	    }

	    try {
	        String line = reader.readLine(); // Reading the first line from the file

	        while (line != null) {
	            String[] arr = line.split(sep); // Splitting the line into an array of strings using the separator

	            // Parsing string values to double and boolean
	            Double d1 = null;
	            Boolean b1 = null;
	            try {
	                d1 = Double.parseDouble(arr[3]);
	                b1 = Boolean.parseBoolean(arr[4]);
	            } catch (Exception e1) {
	                System.out.println("E1 has been found " + e1); // Printing error message if parsing fails
	            }

	            LoyaltyCard lc = null;
	            // Creating LoyaltyCard objects based on the type specified in the file
	            if (arr[0].equals("Gold")) {
	                lc = new Gold(arr[1], arr[2], d1, b1);
	            } else if (arr[0].equals("Silver")) {
	                lc = new Silver(arr[1], arr[2], d1, b1);
	            } else if (arr[0].equals("Bronze")) {
	                lc = new Bronze(arr[1], arr[2], d1, b1);
	            }

	            myCards.add(lc); // Adding the LoyaltyCard object to the ArrayList

	            line = reader.readLine(); // Reading the next line from the file
	        }
	    } catch (IOException e) {
	        e.printStackTrace(); // Printing stack trace if an I/O error occurs
	    }

	    try {
	        reader.close(); // Closing the BufferedReader
	    } catch (IOException e) {
	        e.printStackTrace(); // Printing stack trace if an I/O error occurs
	    }
	}

	public static void filePrinter() {
	    FileWriter writer = null;
	    try {
	        writer = new FileWriter(cardFile); // Creating a FileWriter to write to the file
	    } catch (IOException e) {
	        e.printStackTrace(); // Printing stack trace if an I/O error occurs
	    } 

	    // Writing LoyaltyCard details to the file
	    for (LoyaltyCard lc : myCards) {
	        try {
	            writer.write(lc.getCardType() + sep + lc.getUniqueID() + sep + lc.getUsername() + sep + lc.getMoneySpent() + sep + lc.getCardActive() + sep + lc.getBonusPoints() + sep + lc.getConversionRate() + sep + lc.totalPoints() + System.lineSeparator());
	        } catch (IOException e) {
	            e.printStackTrace(); // Printing stack trace if an I/O error occurs
	        }
	    }

	    try {
	        writer.flush(); // Flushing the FileWriter
	        writer.close(); // Closing the FileWriter
	    } catch (IOException e) {
	        e.printStackTrace(); // Printing stack trace if an I/O error occurs
	    }
	}








	public static void main(String[] args) {
	    fileReader(); // Reading data from file into ArrayList

	    int choice = 0;

	    // If no cards are loaded from file, setupMethod is called to initialize some sample cards
	    if (myCards.size() == 0) {
	        setupMethod();
	    }

	    // Displaying current directory path
	    System.out.println("User directory is " + System.getProperty("user.dir"));

	    // Main menu loop
	    while (status == 1) {
	        System.out.println("--------Main Menu-------");
	        System.out.println("|1. View all cards     |");
	        System.out.println("|2. Search for a card  |");
	        System.out.println("|3. Register a new card|");
	        System.out.println("|4. Delete a card      |");
	        System.out.println("|5. Update details     |");
	        System.out.println("|6. Print to file      |");
	        System.out.println("|7. Exit               |");
	        System.out.println("------------------------");

	        choice = getIntFromString("pick a number 1-7"); // Getting user's choice

	        // Handling user's choice
	        switch (choice) {
	            case 1:
	                viewAllCards(); // View all cards
	                break;
	            case 2:
	                cardSeacher(); // Search for a card
	                break;
	            case 3:
	                cardRegister(); // Register a new card
	                break;
	            case 4:
	                cardDeletion(); // Delete a card
	                break;
	            case 5:
	                updateCard(); // Update details
	                break;
	            case 6:
	                filePrinter(); // Print to file
	                System.out.println("File printed successfully.");
	                System.out.println("Returning to menu...");
	                System.out.println("...");
	                break;
	            case 7:
	                status = 0; // Exiting program
	                System.out.println("7 has been chosen");
	                System.out.println("Program closing...");
	                System.exit(191); // Exiting with status code
	                break;
	        }
	    } 
	}

}