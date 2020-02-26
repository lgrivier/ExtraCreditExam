package edu.hfcc.changemaker;

public class ChangeMaker {

	public static final int QUARTER = 25;
	public static final int DIME = 10;
	public static final int NICKEL = 5;
	public static final int PENNY = 1;

	StringBuilder coins = new StringBuilder();
	
	public static void main(String change) throws BadDataException{
		
		
		
			ChangeMaker changeMaker = new ChangeMaker();
			changeMaker.makeChange(change);	
		
		
	}
	
	
	
	public String makeChange(String change) throws BadDataException {
		
		char[] changeArray = change.toCharArray();
		
		
		if(changeArray[0]!='$') {
			throw new BadDataException();
		}
		
		String removeDollarSign = change.substring(3, 5);
		int makeChange = Integer.parseInt(removeDollarSign);
		
		
		
		if(makeChange==0.00) {
			return "nothing";
		
		}
		
		if(makeChange>= QUARTER) {
			int quarters = (int) (makeChange/QUARTER);	
			coins.append(quarters + " quarter");
			attachS(quarters);
			makeChange = makeChange - (quarters*QUARTER);
		}
		if(makeChange >= DIME) {
			
			int dimes = (int) (makeChange/DIME);
			coins.append(dimes + " dime");
			attachS(dimes);
			makeChange = makeChange - (dimes*DIME);
		}
		if(makeChange >= NICKEL) {
			
			int nickels = (int) (makeChange/NICKEL);
			coins.append(nickels + " nickel");
			attachS(nickels);
			makeChange = makeChange - (nickels*NICKEL);
			
		}
		if(makeChange >= PENNY) {
			
			int pennies = (int) (makeChange/PENNY);
			if(pennies>1) {
				coins.append(pennies + " pennies");
			}
			else if (pennies == 1) {
				coins.append(pennies + " penny");
			}
		}
		
		
		return coins.toString();
	 
	 
	}
	
	public void attachS(int coin) {
		if(coin>1) {
			coins.append("s ");
		}
	}


}
