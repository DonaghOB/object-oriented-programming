/*
 * Loyalty card project
 * Donagh Ó Briain 2024
 */
package loyaltyCardProject;


public class LoyaltyCard {



String sep = ",";
	//String variable for the random unique ID 
	String uniqueID="";

	//String variable for the name
	String userName ="";

	//Double variable for the money spent by each user
	Double moneySpent =0.0;

	//Boolean variable for the card active status
	Boolean cardActive=true;


	//Double variable for the bonus points per Card class
	public double bonusPoints;

	//Double variable for the conversion rate per Card class
	public Double conversionRate;


	//Getter method for Bonus points
	public double getBonusPoints() {
		return bonusPoints;
	}

	//Setter method for Bonus points
	public void setBonusPoints(int bonusPoints) {
		this.bonusPoints = bonusPoints;
	}




	//Getter method for the conversion rate
	public Double getConversionRate() {
		return conversionRate;
	}




	//Setter method for the conversion rate
	public void setConversionRate(Double conversionRate) {
		this.conversionRate = conversionRate;
	}




	//Method for making a random string of 6 alphanumerical characters.
	// Method to generate a random string of a given length
	public String RandomString(int length) {
		// Create a StringBuffer to store the generated string
		StringBuffer abc = new StringBuffer();
		// Define a string containing characters to use for generating the random string
		String idGenerator = "123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		// Loop to generate characters for the string
		for(int i = 0; i < length; i++) {
			// Generate a random index within the idGenerator string length
			int i2 = (int) (Math.random() * idGenerator.length());
			// Get the character at the generated index and append it to the StringBuffer
			char a = idGenerator.charAt(i2);
			abc.append(a);
		}
		// Convert the StringBuffer to a string and return it
		return abc.toString();
	}




	// Getter method for uniqueID
	public String getUniqueID() {
		return uniqueID;
	}

	// Setter method for uniqueID
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	// Getter method for username
	public String getUsername() {
		return userName;
	}

	// Setter method for username
	public void setUsername(String username) {
		userName = username;
	}

	// Getter method for moneySpent
	public Double getMoneySpent() {
		return moneySpent;
	}

	// Setter method for moneySpent
	public void setMoneySpent(Double moneySpent) {
		this.moneySpent = moneySpent;
	}

	// Getter method for cardActive
	public Boolean getCardActive() {
		return cardActive;
	}

	// Setter method for cardActive
	public void setCardActive(Boolean cardActive) {
		this.cardActive = cardActive;
	}



	// Method to initialize bonus points and conversion rate
	public void initRates(int bonus, double rate) {
		// Set bonus points and conversion rate with provided values
		setBonusPoints(bonus);
		setConversionRate(rate);
	}

	// Default constructor
	public LoyaltyCard() {
		// Call to superclass constructor (implicit call to Object class constructor)
		super();
		// Generate a random unique ID with length 6 and set it
		setUniqueID(RandomString(6));
	}


	// Constructor with parameters
	public LoyaltyCard(String uniqueID, String userName, Double moneySpent, Boolean cardActive) {
		// Initialize instance variables with the provided values
		this.uniqueID = uniqueID;
		this.userName = userName;
		this.moneySpent = moneySpent;
		this.cardActive = cardActive;
	}

	// Method to get the card type (default "loyalty")
	public String getCardType() {
		return "loyalty";
	}

	// Method to calculate total points (default returns 0)
	public double totalPoints() {
		return 0.0;
	}

	// toString method to represent LoyaltyCard object as a string
	public String toString() {
		return getCardType() + sep + getUniqueID() + sep + getUsername() + sep + getMoneySpent() + sep + getCardActive()+ sep +totalPoints();
	}
}
