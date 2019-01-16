/*Daichi Kanasugi
 *CST 338: Software Design
 *account.java
 *10/4/2018
 * 
 * This program uses 3 different classes (bank.java, account.java, customer.java). Each class consists of getter, setter, constructors
 * and it store account and customer information for a bank. In the account class it uses the getter and setter function to access private variables.
 * This file has a void function to update the balance of a person's account balance.
 */

package bank;

public class account extends customer {
	private int actNum;
	private int accType;
	private double balance;
	
	//constructor
	public account() {
		actNum = 0;
		accType = 0;
		balance = 0.00;
	}
	
	public account(int actNum, int accType, double balance) {
		super();
		this.actNum = actNum;
		this.accType = accType;
		this.balance = balance;
	}
	
	//getter and setter
	public int getActNum() {
		return actNum;
	}
	
	public void setActNum(int actNum) {
		this.actNum = actNum;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getAccType() {
		return accType;
	}
	
	public void setAccType(int accType) {
		this.accType = accType;
	}	
	
	//balance update function
	public void update(double money) {
		this.balance += money;
	}
}
