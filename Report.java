import java.util.*;
/* 
 * Report.java 
 * 
 * Version: 
 *     $Id: Report.java,v 1.4 2013/11/21 01:41:26 avd1379 Exp $ 
 * 
 * Revisions: 
 *     $Log: Report.java,v $
 *     Revision 1.4  2013/11/21 01:41:26  avd1379
 *     more BatchMode...
 *
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
public class Report {
	private String report;
	
	public Report(){
		report = "";
	}
	
	public void addBatchHeading(){
		report = "========== Initial Bank Data ==================\n";
		report+="\n";
		report+="Account Type    Account Balance\n";
		report+="------------    ------- -----------\n";
	}
	
	public void addInitialAccountData(LinkedList<Account> init){
		if(init == null){
			report +="\n";
		}
		for(Account a : init){
			report += (a.kind + "\t");
			report += (a.getID() + "\t");
			report += (a.getBalance() + "\n");
		}
	}
	
	public void addChangesHeading(){
		report += "\n";
		report += "===============================================";
		report += "\n";
	}
	
	public void addChanges(String s){
		report += s;
	}
	
	public void addFinalHeading(){
		report += "==========   Final Bank Data ==================";
		report +="\n";
		report +="\n";
		report +="Account Type    Account Balance";
		report +="------------    ------- -----------";
	}
	
	public void addFinalEnding(){
		report += "===============================================";
	}
	
	
}
