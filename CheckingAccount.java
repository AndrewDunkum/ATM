/* 
 * CheckingAccount.java 
 * 
 * Version: 
 *     $Id: CheckingAccount.java,v 1.3 2013/11/20 21:56:46 avd1379 Exp $ 
 * 
 * Revisions: 
 *     $Log: CheckingAccount.java,v $
 *     Revision 1.3  2013/11/20 21:56:46  avd1379
 *     more batchMode work
 *
 *     Revision 1.2  2013/11/18 23:04:11  avd1379
 *     BatchMode stuff mostly
 *
 *     Revision 1.1  2013/11/18 01:11:02  avd1379
 *     First Commit
 * 
 */
public class CheckingAccount extends Account{
	private final int min = 50;
	
	public CheckingAccount(int ID, int pin, double balance){
		super(ID,pin,balance);
		kind = "Checking";
	}
	
	public void applyInterest(){
		
	}
	
	public void withdraw(int amount){
		balance-=amount;
	}
}
