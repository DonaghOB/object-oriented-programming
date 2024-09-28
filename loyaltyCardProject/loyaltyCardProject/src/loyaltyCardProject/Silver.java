/*
 * Loyalty card project
 * Donagh Ó Briain 2024
 */
package loyaltyCardProject;

//Silver class extending LoyaltyCard
public class Silver extends LoyaltyCard {

	// Method to get the card type
	//Return a string
	public String getCardType() {

		return "Silver";
	}

	// Method to calculate total points earned
	public double totalPoints() {
		// Total points include bonus points and points earned from money spent using a calculation with the conversion rate
		return bonusPoints + (conversionRate * moneySpent);
	}
	// Constructor with parameters
	public Silver(String uniqueID, String userName, Double moneySpent, Boolean cardActive) {
		// Call to superclass constructor
		super(uniqueID, userName, moneySpent, cardActive);

		// Initialize conversion rate and bonus points
		initRates(50,0.3);
	}

	// Empty constructor
	public Silver() {

		// Call to superclass default constructor
		super();


		// Initialize conversion rate and bonus points
		initRates(50,0.3);
	}

}


