/*Daichi Kanasugi
 *CST 338: Software Design
 *bank.java
 *10/4/2018
 * 
 * This program uses 3 different classes (bank.java, account.java, customer.java). Each class consists of getter, setter, constructors
 * and it store account and customer information for a bank. In the bank class it can display account and customer info.  
 *  
 */

package bank;


import java.util.ArrayList;
import java.text.DecimalFormat;

public class bank extends account{
	
	private String name;
	private ArrayList<account> account;
	private ArrayList<customer> customer;
	
	//Constructor
	public bank(String name) {
		this(name, new ArrayList<account>(), new ArrayList<customer>());
	}
	
	public bank(String name, ArrayList<account> account, ArrayList<customer> customer) {
		super();
		this.name = name;
		this.account = account;
		this.customer = customer;
	}
	
	//Getter and Setter Functions
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<account> getAccount() {
		return account;
	}

	public void setAccount(ArrayList<account> account) {
		this.account = account;
	}

	public ArrayList<customer> getCustomer() {
		return customer;
	}

	public void setCustomer(ArrayList<customer> customer) {
		this.customer = customer;
	}

	//add customer (max of 5 customers)
	public boolean addCustomer(String a, String b, int c) {
		if(customer.size() == 0){
	        customer.add(new customer(a, b, c));
	        return true;
	      }
	      if(customer.size() >= 5){
	        return false;
	      }
	      for(int i = 0; i < customer.size(); ++i){
	        if(c == customer.get(i).getSsn()){
	          return false;
	        }
	      }

	    customer.add(new customer(a, b, c));
	    return true;
	 }
	
	//open account (max of 5 accounts)
	public boolean openAccount(int ssn, int accNum, int acctype, double balance) {
		if(account.size() == 0){
	        account.add(new account(accNum, acctype, balance));
	        return true;
	      }
	      if(account.size() >= 5){
	        return false;
	      }
	      for(int i = 0; i < account.size(); ++i){
	        if(ssn == account.get(i).getSsn()){
	          return false;
	        }
	        
	      }
	    account.add(new account(accNum, acctype, balance));
	    return true;
	}
	
	//Closes account and customer so it doesn't mess up the arraylist
	public boolean closeAccount(int accNum) {
		for (int i = 0; i < account.size(); ++i) {
			if (accNum == account.get(i).getActNum()) {
				account.remove(i);
				customer.remove(i);
				return true; 
			}
		}
		return false;
	}
	
	//Display Customer Info
	public boolean accountInfo(int accNum) {
		for (int i = 0; i < account.size(); i++) {
			if (accNum == account.get(i).getActNum()) {
				System.out.println("Account Number: " + account.get(i).getActNum());
				int accType = account.get(i).getAccType();
				if(accType == 1) {
					System.out.println("Checking account");
				}
				else if(accType == 2) {
					System.out.println("Savings account");
				}
				System.out.println("Balance: $" + account.get(i).getBalance());
				System.out.println("Customer Info: " + customer.get(i).getName());
				System.out.println("Customer Address: " + customer.get(i).getAddress());
				System.out.println("SSN: " + customer.get(i).getSsn());
				
				return true; 
			}
		}
		return false;
	}
	
	//Updates the balance in that specific's person account
	public boolean updateBalance(int accNum, double newAmount){
		for (int i = 0; i < account.size(); i++) {
			if (accNum == account.get(i).getActNum()) {
				account.get(i).update(newAmount);
				return true;
			}
		}
		return false;
	}
	
	//Updates customer address
	public boolean updateAddress(int ssn, String addr) {
		for (int i = 0; i < customer.size(); i++) {
			if(ssn == customer.get(i).getSsn()) {
				customer.get(i).setAddress(addr);
				return true;
			}
		}
		return true;
	}
	
	//Displays everything for bank info
	void bankInfo() {
		System.out.println("Bank Name: " + getName());
		System.out.println("Number of Customers: " + customer.size());
		for(int i = 0; i < customer.size(); i++) {
			System.out.println(customer.get(i).getName() + " : " + customer.get(i).getSsn() + ", " + customer.get(i).getAddress());
		}
		System.out.println("Number of Accounts: " + account.size());
		for(int i = 0; i < customer.size(); i++) {
			double xBalance = account.get(i).getBalance();
			DecimalFormat format = new DecimalFormat("0.00");
		    String formatted = format.format(xBalance);
			System.out.println(account.get(i).getActNum() + ": $" + formatted + " - " + customer.get(i).getName() + " : " + customer.get(i).getSsn());
		}
		double total = 0;
		for(int i = 0; i < account.size(); i++) {
			total += account.get(i).getBalance();
		}
		 DecimalFormat format = new DecimalFormat("0.00");
	     String formatted = format.format(total);
		System.out.print("Bank Total Balance: $" + formatted);
	}
	
	//Driver
	public static void main(String[] args)  {
		bank csumbBank = new bank("CSUMB");
		System.out.println("\n========== Three New Customers ==========");
		csumbBank.addCustomer("Tom Smith", "123 University Center 93955",
		77777);
		csumbBank.addCustomer ("Alice Smith", "123 University Center 93955",
		88888);
		csumbBank.addCustomer ("Joe Otter", "2440 Ocean Avenue 93900",
		99999);
		System.out.println("\n========== Three New Accounts ==========");
		csumbBank.openAccount(77777, 1000, 1, 10.00);
		csumbBank.openAccount(88888, 2000, 1, 50.25);
		csumbBank.openAccount(99999, 3000, 2, 100.25);
		System.out.println("\n========== Bank Info ==========");
		csumbBank.bankInfo();
		System.out.println("\n========== Close Account ==========");
		System.out.println(csumbBank.closeAccount(1000));
		System.out.println(csumbBank.closeAccount(7000));
		System.out.println("========== Account Info ==========");
		csumbBank.accountInfo(2000);
		System.out.println(csumbBank.accountInfo(7000));
		}
}
