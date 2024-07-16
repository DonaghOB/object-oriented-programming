package loyaltyCardProject;

public class Bronze extends LoyaltyCard{

	public String getCardType() {

		return "Bronze";
	}
	public double totalPoints() {
		return bonusPoints + (conversionRate * moneySpent);
	}

	public Bronze(String uniqueID, String userName, Double moneySpent, Boolean cardActive) {
		super(uniqueID, userName, moneySpent, cardActive);

		initRates(10,0.2);
		
	
	}

	public Bronze() {
		super();
		//this(this.uniqueID,"",0.0,false);

		initRates(10,0.2);
	}

}


