package model;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	private static Scanner sc = new Scanner(System.in);
	private int customerId;
	private String name;
	private String userName;
	private String password;
	private String shippingAddress;
	private String BillingAddress;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getBillingAddress() {
		return BillingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		BillingAddress = billingAddress;
	}
	
	public void add(Customer customer) {
		// INPUT INFORMATION OF BOOK
		System.out.println("CUSTOMER ID: ");
		int customerId = Integer.parseInt(sc.nextLine());
		customer.setCustomerId(customerId);

		System.out.print("NAME: ");
		String name = sc.nextLine().toUpperCase().trim();
		customer.setName(name);

		System.out.println("USER NAME: ");
		String userName = sc.nextLine().toUpperCase().trim();
		customer.setUserName(userName);

		System.out.print("PASSWORD: ");
		String passWord = sc.nextLine().trim();
		customer.setPassword(passWord);

		System.out.println("SHIPPING ADDRESS: ");
		String shippingAddress = sc.nextLine().toUpperCase().trim();
		customer.setShippingAddress(shippingAddress);

		System.out.print("BILLING ADDRESS: ");
		String billingAddress = sc.nextLine().toUpperCase().trim();
		customer.setBillingAddress(billingAddress);
	}


//	public void updateCustomer(int customerId, String name) {
//		Customer newCustomer = search(customerId, name);
//		if(newCustomer == null) 
//			add(newCustomer);
//		else {
//			newCustomer.setUserName(sc.nextLine().toUpperCase().trim());
//			newCustomer.setPassword(sc.nextLine().toUpperCase().trim());
//			newCustomer.setShippingAddress(sc.nextLine().toUpperCase().trim());
//			System.out.println("UPDATE SUCCESS!");
//		}
//	}
//	
//	public void remove(int customerId, String name) {
//		Customer customer = search(customerId, name);
//		if (customer == null)
//			System.out.println("THIS CUSTOMER NOT EXITS.");
//		else {
//			System.out.println("ARE YOU SURE YOU WANT TO REMOVE THIS CUSTOMER.");
//			System.out.print("Y/N? : ");
//			if (sc.nextLine() == "Y")
//				
//			System.out.println("DELETED.");
//		}
//	}
//	
}
