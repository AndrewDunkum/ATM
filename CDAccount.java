/* 
 * CDAccount.java 
 * 
 * Version: 
 *     $Id: CDAccount.java,v 1.3 2013/11/20 21:56:47 avd1379 Exp $ 
 * 
 * Revisions: 
 *     $Log: CDAccount.java,v $
 *     Revision 1.3  2013/11/20 21:56:47  avd1379
 *     more batchMode work
 *
 *     Revision 1.2  2013/11/18 23:04:11  avd1379
 *     BatchMode stuff mostly
 *
 *     Revision 1.1  2013/11/18 01:11:02  avd1379
 *     First Commit
 * 
 */

/**
 * 
 * @author Andrew Dunkum avd1379
 *
 */
public class CDAccount extends Account{
	private final double interest = .05;
	private final int min = 50;
	
	public CDAccount(int ID, int pin, double balance){
		super(ID, pin, balance);
		kind = "CD";
	}
	
	public void applyInterest(){
		balance = balance*(interest/12);
	}
	
	public void withdraw(int amount){
		
	}
	
}
