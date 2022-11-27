package app;


import java.sql.Connection;

import connection.database.ConnectionDB;
import controller.BookManagement;
import menu.Menu;


public class BookShopApp {
	public static void main(String[] args) {

		Menu.printMenuSystem();
		try {
			Connection conn = ConnectionDB.getConnectDatabase();
//			BookManagement.addBook(conn);
			BookManagement.showInfoBook(conn, 1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}