/*
 * Loyalty card project
 * Donagh Ó Briain 2024
 */
package loyaltyCardProject;

// Gold class extending LoyaltyCard
public class Gold extends LoyaltyCard {

	// Method to get the card type
	//Return a string
	public String getCardType() {
		return "Gold";
	}

	// Method to calculate total points earned
	public double totalPoints() {
		// Total points include bonus points and points earned from money spent
		return bonusPoints + (conversionRate * moneySpent);
	}

	// Constructor with parameters
	public Gold(String uniqueID, String userName, Double moneySpent, Boolean cardActive) {
		// Call to superclass constructor
		super(uniqueID, userName, moneySpent, cardActive);

		// Initialize conversion rate and bonus points
		initRates(100, 0.4);
	}

	// Empty constructor
	public Gold() {
		// Call to superclass default constructor
		super();

		// Initialize conversion rate and bonus points
		initRates(100, 0.4);
	}
}




/*
 * 
 * 
 * 
 * 

 CONstructrors

 1. Card() - generate a random UUID and give me an empty one
 3. Card(all args) - construct just based on inputs



 */
