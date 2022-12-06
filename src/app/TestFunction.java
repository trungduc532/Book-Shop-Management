package app;

import java.sql.Connection;

import connection.database.ConnectionDB;
import controller.CustomerManagement;

public class TestFunction {
	public static void main(String[] args) {
		try {
			final Connection conn = ConnectionDB.getConnectDatabase();

//			CustomerManagement.addCustomer(conn);
			CustomerManagement.addAListCustomerFromConsole(conn);
			
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}
}
