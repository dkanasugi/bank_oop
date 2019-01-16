/*Daichi Kanasugi
 *CST 338: Software Design
 *account.java
 *10/4/2018
 * 
 * This program uses 3 different classes (bank.java, account.java, customer.java). Each class consists of getter, setter, constructors
 * and it store account and customer information for a bank. In this customer class, it is not anything special. Just getter and setter functions.
 *  
 */

package bank;

public class customer {
	private String name;
	private int ssn; 
	private String address;
	
	//Constructors
	public customer() {
		name = "";
		address = "";
		ssn = 0;
	}
	
	public customer(String x, String y, int a) {
		setName(x);
		setAddress(y);
		setSsn(a);
	}
	
	//getter and setter functions
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	} 
}
