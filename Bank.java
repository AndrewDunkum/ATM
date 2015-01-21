import java.util.*;
/* Bank.java 
 * 
 * Version: 
 *     $Id: Bank.java,v 1.3 2013/11/20 21:56:46 avd1379 Exp $ 
 * 
 * Revisions: 
 *     $Log: Bank.java,v $
 *     Revision 1.3  2013/11/20 21:56:46  avd1379
 *     more batchMode work
 *
 *     Revision 1.2  2013/11/18 23:04:10  avd1379
 *     BatchMode stuff mostly
 *
 *     Revision 1.1  2013/11/18 01:11:01  avd1379
 *     First Commit
 * 
 */

/**
 * 
 * @author Andrew Dunkum avd1379
 *
 */
public class Bank {
	private LinkedList<Account> accounts;
	Iterator<Account> i;
	/**
	 * the main method of the ATM program. Deals with command-line arguments
	 * @param args
	 */
	public static void main(String[] args){
		Bank b = new Bank(args);
	}
	
	public Bank(String[] args){
		//if you have the wrong number of arguments, yell at the user
		if(args.length<1||args.length>2){
			System.err.println("Usage: java Bank bankFile [batchFile]");
			System.exit(0);
		}
		//if the ATM was started without a batch file
		if(args.length == 1){
			MainGUI GUI = new MainGUI();
		}
		if(args.length == 2){
			BatchMode BM = new BatchMode(args, this);
		}
	}
	
	public void setAccounts(LinkedList<Account> accounts){
		this.accounts = accounts;
	}
	public LinkedList<Account> getAccounts(){
		return accounts;
	}
	public boolean makeDeposit(int ID, int amount){
		i = accounts.iterator();
		double orig = 0;
		boolean worked = false;
		Account a = null;
		while(i.hasNext()){
			a = i.next();
			if(a.getID()==ID){
				orig = a.getBalance();
				a.deposit(amount);
				worked = true;
			}
		}
		return worked;
	}
	public double getBalance(int ID){
		double balance = -1;
		Account a = null;
		i = accounts.iterator();
		while(i.hasNext()){
			a = i.next();
			if(a.getID()==ID)
				balance = a.getBalance();
		}
		
		return balance;
	}
	public boolean makeWithdrawl(int ID, int amount){
		i = accounts.iterator();
		double orig = 0;
		boolean worked = false;
		Account a = null;
		while(i.hasNext()){
			a = i.next();
			if(a.getID()==ID){
				orig = a.getBalance();
				//can't take out more than you have
				if(orig>amount){
					//CD accounts can't be withdrawn from
					if(!(a instanceof CDAccount)){
						a.withdraw(amount);
						worked = true;
					}
				}
			}
		}
		return worked;
	}
	
}

