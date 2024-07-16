package loyaltyCardProject;

public class Gold extends LoyaltyCard {

	public String getCardType() {
		
		return "Gold";
	}
	public double totalPoints() {
		return bonusPoints + (conversionRate * moneySpent);
	}
	
   	public Gold(String uniqueID, String userName, Double moneySpent, Boolean cardActive) {
		super(uniqueID, userName, moneySpent, cardActive);
		
	    initRates(100,0.4);
	}

	public Gold() {
		super();
		//this(this.uniqueID,"",0.0,false);

	    initRates(100,0.4);
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
