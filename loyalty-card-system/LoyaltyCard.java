package loyaltyCardProject;
import java.util.Random;
//import java.util.*;

public class LoyaltyCard {




	//static char getCardChar;

	String uniqueID="";
	String userName ="";
	Double moneySpent =0.0;
	Boolean cardActive=true;

	public double bonusPoints;
	public Double conversionRate;


	public double getBonusPoints() {
		return bonusPoints;
	}





	public void setBonusPoints(int bonusPoints) {
		this.bonusPoints = bonusPoints;
	}





	public Double getConversionRate() {
		return conversionRate;
	}





	public void setConversionRate(Double conversionRate) {
		this.conversionRate = conversionRate;
	}





	public String RandomString(int length) {

		//Random r = new Random(5);
		StringBuffer abc = new StringBuffer();

		String idGenerator="123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";


		for(int i=0;i<length;i++) {
			int i2 = (int) (Math.random()*idGenerator.length());
			char a= idGenerator.charAt(i2);
			abc.append(a);
		}
		return abc.toString();

	}





	public String getUniqueID() {
		return uniqueID;
	}





	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}



	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		userName = username;
	}

	public Double getMoneySpent() {
		return moneySpent;
	}


	public void setMoneySpent(Double moneySpent) {
		this.moneySpent = moneySpent;
	}

	public Boolean getCardActive() {
		return cardActive;
	}


	public void setCardActive(Boolean cardActive) {
		this.cardActive = cardActive;
	}




	public void initRates(int bonus, double rate) {
		setBonusPoints(bonus);
		setConversionRate(rate);
	}


	public LoyaltyCard() {
		super();
		setUniqueID(RandomString(6));
	}

	public LoyaltyCard(String uniqueID, String userName, Double moneySpent, Boolean cardActive) {
		this.uniqueID=uniqueID;
		this.userName=userName;	
		this.moneySpent=moneySpent;	
		this.cardActive=cardActive;
	}





	public String getCardType() {
		return "loyalty";
	}

	
	public double totalPoints() {
		return 0.0;
	}
	public String toString() {
		return  getCardType() + ", " +getUniqueID() +", " +getUsername() + ", " + getMoneySpent() + ", " + totalPoints();

	}

}


/*   Random r = new Random();

   static String uniqueId = ""; {

    for (int i = 0; i < 6; i++) {
        System.out.println(uniqueId.charAt(r.nextInt(uniqueId.length())));
    }
}
 */


