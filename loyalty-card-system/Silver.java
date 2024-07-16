package loyaltyCardProject;

public class Silver extends LoyaltyCard {

	public String getCardType() {

		return "Silver";
	}
	public double totalPoints() {
		return bonusPoints + (conversionRate * moneySpent);
	}

	public Silver(String uniqueID, String userName, Double moneySpent, Boolean cardActive) {
		super(uniqueID, userName, moneySpent, cardActive);

		initRates(50,0.3);
	}

	public Silver() {
		super();
		//this(this.uniqueID,"",0.0,false);

		initRates(50,0.3);
	}

}


