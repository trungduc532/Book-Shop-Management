package app;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import connection.database.ConnectionDB;
import controller.BookManagement;
import controller.BookSearch;
import menu.Menu;
import model.Book;

public class BookShopApp {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {

		try {
			Connection conn = ConnectionDB.getConnectDatabase();
			/**
			 * Prepare data 1. Create BOOK_INFORMATION table on db 2. Add data in table:
			 * Copy from Data.txt file and run statement below
			 */
			// BookManagement.addAListBookFromConsole(conn);
			while (true) {
				Menu.menuSystem();
				System.out.print("INPUT YOUR CHOICE: ");
				Integer.parseInt(scanner.nextLine());

				List<Book> listBook = BookSearch.searchByBookTitle(conn, "CHET VI CHUNG KHOAN");
				for (Book book : listBook) {
					book.showInfo();
				}
			}
//			BookManagement.addAListBookFromConsole(conn);
//			BookManagement.update(conn, 16);

//			BookManagement.addBook(conn);
//			BookManagement.showInfoBook(conn, 1);
//			BookManagement.deleteBook(conn, 2);
//			for (int i = 1; i < 3; i++) {
//				BookManagement.showInfoBook(conn, i);
//			}
//			ConnectionDB.closeConnectionDate(conn);
			
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}