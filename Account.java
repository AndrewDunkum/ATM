/* 
 * Account.java 
 * 
 * Version: 
 *     $Id: Account.java,v 1.3 2013/11/20 21:56:46 avd1379 Exp $ 
 * 
 * Revisions: 
 *     $Log: Account.java,v $
 *     Revision 1.3  2013/11/20 21:56:46  avd1379
 *     more batchMode work
 *
 *     Revision 1.2  2013/11/18 23:04:11  avd1379
 *     BatchMode stuff mostly
 *
 *     Revision 1.1  2013/11/18 01:11:01  avd1379
 *     First Commit
 * 
 */

/**
 * 
 * @author Andrew Dunkumn avd1379
 *
 */

public abstract class Account {

	protected int ID;
	protected int pin;
	protected double balance;
	protected String kind;
	
	public Account(int ID, int pin, double balance){
		this.ID = ID;
		this.pin = pin;
		this.balance = balance;
	}
	
	public synchronized double getBalance(){
		return balance;
	}
	public synchronized void deposit(double amount){
		balance += amount;
	}
	public int getID(){
		return ID;
	}
	public abstract void applyInterest();
	
	public abstract void withdraw(int amount);
	
}
