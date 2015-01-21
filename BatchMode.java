import java.io.*;
import java.util.*;
/* 
 * BatchMode.java 
 * 
 * Version: 
 *     $Id: BatchMode.java,v 1.3 2013/11/21 01:41:27 avd1379 Exp $ 
 * 
 * Revisions: 
 *     $Log: BatchMode.java,v $
 *     Revision 1.3  2013/11/21 01:41:27  avd1379
 *     more BatchMode...
 *
 *     Revision 1.2  2013/11/20 21:56:46  avd1379
 *     more batchMode work
 *
 *     Revision 1.1  2013/11/18 23:04:11  avd1379
 *     BatchMode stuff mostly
 * 
 */
/**
 * 
 * @author Andrew Dunkum avd1379
 *
 */
public class BatchMode {
	private Scanner reader;
	private Report record;
	private StringTokenizer ST;
	private Bank bank;
	
	public BatchMode(String[] args, Bank bank){
		record = new Report();
		findAccounts(args[0]);
		record.addBatchHeading();
		record.addInitialAccountData(bank.getAccounts());
		record.addChangesHeading();
		readCommands(args[1]);
		record.addFinalHeading();
		finalAccounts();
		record.addFinalEnding();
	}
	
	public void findAccounts(String bankFile){
		try{
			reader = new Scanner(new BufferedReader(new FileReader(bankFile)));
		}catch(FileNotFoundException FNF){
			System.out.println("Bank file invalid or empty. Starting program with no accounts...");
			bank.setAccounts(new LinkedList<Account>());
		}
		LinkedList<Account> a = null;
		int AccCount = 0;
		String AccStr = "";
		while(reader.hasNext()){
			AccStr += reader.nextLine();
			AccCount++;
		}
		a = new LinkedList<Account>();
		ST = new StringTokenizer(AccStr);
		for(int i = 0; i < AccCount; i++){
			String type = ST.nextToken();
			int ID = Integer.parseInt(ST.nextToken());
			int pin = Integer.parseInt(ST.nextToken());
			double balance = Double.parseDouble(ST.nextToken());
			if(type.equalsIgnoreCase("c"))
				a.add(new CDAccount(ID, pin, balance));
			else if(type.equalsIgnoreCase("s"))
				a.add(new SavingsAccount(ID, pin, balance));
			else if(type.equalsIgnoreCase("x"))
				a.add(new CheckingAccount(ID, pin, balance));
		}
		bank.setAccounts(a);
	}
	
	public void readCommands(String batchFile){
		try{
			reader = new Scanner(new BufferedReader(new FileReader(batchFile)));
		}catch(FileNotFoundException FNF){
			System.out.println("Bank file invalid or empty. Starting program with no accounts...");
		}
		while(reader.hasNext()){
			doCommand(reader.nextLine());
		}
	}
	
	public void doCommand(String command){
		ST = new StringTokenizer(command);
		String firstLetter = ST.nextToken();
		LinkedList<Account> a = bank.getAccounts();
		//if the command is to add an account
		if(firstLetter.equalsIgnoreCase("o")){
			String secondLetter = ST.nextToken();
			int ID = Integer.parseInt(ST.nextToken());
			int pin = Integer.parseInt(ST.nextToken());
			double balance = Double.parseDouble(ST.nextToken());
			//x means open a checking account
			if(secondLetter.equalsIgnoreCase("x"))
				a.add(new CheckingAccount(ID, pin, balance));
			//s means savings account
			if(secondLetter.equalsIgnoreCase("s"))
				a.add(new SavingsAccount(ID, pin, balance));
			//c means open a CD account
			if(secondLetter.equalsIgnoreCase("c"))
				a.add(new CDAccount(ID, pin, balance));
			//update the accounts
			bank.setAccounts(a);
			record.addChanges(ID + "\to" + secondLetter + "Open: " + "\t$" + balance);
		}
		if(firstLetter.equalsIgnoreCase("c")){
			
		}
		if(firstLetter.equalsIgnoreCase("d")){
			int ID = Integer.parseInt(ST.nextToken());
			int amount = Integer.parseInt(ST.nextToken());
			if(bank.makeDeposit(ID, amount))
				record.addChanges(ID + "\t" + "\t" + "$" + bank.getBalance(ID));
			else record.addChanges(ID + "\t" + "\t" + "Failed");
			
		}
		if(firstLetter.equalsIgnoreCase("w")){
			int ID = Integer.parseInt(ST.nextToken());
			int amount = Integer.parseInt(ST.nextToken());
			if(bank.makeWithdrawl(ID, amount))
				record.addChanges(ID + "\t" + "\t" + "$" + bank.getBalance(ID));
			else record.addChanges(ID + "\t" + "\t" + "Failed");
		}
	}
	
	public void finalAccounts(){
		LinkedList<Account> accounts = bank.getAccounts();
		for(Account a : accounts){
			String s = "";
			s += a.kind;
			s += "\t";
			s += a.ID;
			s += "\t";
			s += a.balance;
			s += "\n";
			record.addChanges(s);
		}
	}
	
	
	
	
	
	
	
}
