package com.practice.tricky;

/**
 * Why do we need immutable objects? 1. Simplicity, to maintain only one state
 * for a class 2. Security, say in the below example getSBBlance() returns
 * a mutable object so anyone who gets it can change the original object as
 * well. 
 * 
 * @author XKS9
 *
 */
public class WhyImmuatbleClasses {
	private Integer balance;
	
	private StringBuilder sbBalance;
	

	public WhyImmuatbleClasses(Integer balance, StringBuilder sbBalance) {
		super();
		this.balance = balance;
		this.sbBalance = sbBalance;
	}
	
	public static void main(String[] args) {

		StringBuilder sb_balance = new StringBuilder("sb_balance");
		
		WhyImmuatbleClasses ob = new WhyImmuatbleClasses(100,sb_balance);
		String s = new String("Hello");
		String s2 = ob.playWithString(s);
		System.out.println("Original String passed: " + s);
		System.out.println("After playString method: " + s2);

		StringBuilder sb = new StringBuilder("Hello");
		StringBuilder sb2 = ob.playWithStringBuilder(sb);
		System.out.println("Original StringBuilder passed: " + sb);
		System.out.println("After playString method: " + sb2);

		// Balance
		int bal = ob.getBalance();
		System.out.println("Balance: " + bal); //immutable
		
		//sb_balance
		StringBuilder new_sbBalance =  ob.getSBBalance();
		new_sbBalance.append("new_sb_balance"); //changes in the original object as well
		System.out.println(ob.getSBBalance()); 
		
	}

	public String playWithString(String s) {
		s = s + "!"; // new object is created
		return s;
	}

	public StringBuilder playWithStringBuilder(StringBuilder sb) {
		sb = sb.append("?"); // appended to the same object, making the value change in the original object
								// as well
		return sb;

	}

	public int getBalance() {
		return this.balance;
	}
	
	public StringBuilder getSBBalance() {
		return this.sbBalance;
	}
}