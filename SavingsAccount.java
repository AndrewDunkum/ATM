/* 
 * SavingsAccount.java 
 * 
 * Version: 
 *     $Id: SavingsAccount.java,v 1.3 2013/11/20 21:56:46 avd1379 Exp $ 
 * 
 * Revisions: 
 *     $Log: SavingsAccount.java,v $
 *     Revision 1.3  2013/11/20 21:56:46  avd1379
 *     more batchMode work
 *
 *     Revision 1.2  2013/11/18 23:04:11  avd1379
 *     BatchMode stuff mostly
 * 
 */

/**
 * 
 * @author Andrew Dunkum avd1379
 *
 */
public class SavingsAccount extends Account{
	private final double interest = .005;
	private final int min = 200;
	
	public SavingsAccount(int ID, int pin, double balance){
		super(ID, pin, balance);
		kind = "Savings";
	}
	
	public void applyInterest(){
		if(balance>=min)
			balance = balance*(interest/12);
	}
	
	public void withdraw(int amount){
		balance -= amount;
	}
	
	
}
