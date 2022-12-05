/**
 * 59102901
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import common.DtrKey;
import model.Customer;

/**
 * Customer Management
 * @author Trung Duc
 * @see 2022/10
 *
 */
public class CustomerManagement {
	
	private static final Scanner scanner = new Scanner(System.in);
	
	/**
	 * Create a customer
	 * 
	 * @return
	 */
	private static final Customer createCustomer() {
		Customer customer = new Customer();
		System.out.print(DtrKey.CUSTOMER_NAME + ": ");
		customer.setName(scanner.nextLine().toUpperCase().trim());
		System.out.print(DtrKey.CUSTOMER_USER_NAME + ": ");
		customer.setUserName(scanner.nextLine().trim());
		System.out.print(DtrKey.CUSTOMER_PASSWORD + ": ");
		customer.setPassword(scanner.nextLine().trim());
		System.out.print(DtrKey.SHIPPING_ADDRESS + ": ");
		customer.setShippingAddress(scanner.nextLine().toUpperCase().trim());
		System.out.print(DtrKey.BILLING_ADDRESS + ": ");
		customer.setBillingAddress(scanner.nextLine().trim().toUpperCase());

		return customer;
	}
	
	public static void addCustomer(Connection conn) throws SQLException {

		System.out.println("========================= ADD A CUSTOMER =======================");

		StringBuilder query = new StringBuilder();
		Customer customer = CustomerManagement.createCustomer();
		query.append("INSERT INTO CUSTOMER_INFORMATION ");
		query.append("(CUSTOMER_NAME, CUSTOMER_USER_NAME, CUSTOMER_PASSWORD, SHIPPING_ADDRESS, BILLING_ADDRESS)");
		query.append("VALUES ( ?, ?, ?, ?, ? );");

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query.toString());
			int bindIndex = 1;
			ps.setString(bindIndex++, customer.getName());
			ps.setString(bindIndex++, customer.getUserName());
			ps.setString(bindIndex++, customer.getPassword());
			ps.setString(bindIndex++, customer.getShippingAddress());
			ps.setString(bindIndex++, customer.getBillingAddress());
			ps.executeUpdate();
			System.out.println("Success.");
			System.out.println("================================================================");

		} finally {
			System.out.print("");
		}

	}
}
