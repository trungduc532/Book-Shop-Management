package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import common.BookKey;
import connection.database.ConnectionDB;
import model.Book;

public class BookManagement {

	private static Scanner scanner = new Scanner(System.in);

	public static void addBook(Connection conn) throws Exception {

		System.out.println("=========================== ADD A BOOK =========================");

		StringBuilder query = new StringBuilder();
		Book book = BookManagement.createBook();
		query.append("INSERT INTO BOOK_INFORMATION ");
		query.append("(TITLE, AUTHOR, BOOK_TYPE, PUBLISH_YEAR, PUBLISHER, PRICE)");
		query.append("VALUES ( ?, ?, ?, ?, ?, ? );");

		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(query.toString());
			int bindIndex = 1;
			ps.setString(bindIndex++, book.getTitle());
			ps.setString(bindIndex++, book.getAuthor());
			ps.setString(bindIndex++, book.getType());
			ps.setDate(bindIndex++, book.getPublishYear());
			ps.setString(bindIndex++, book.getPublisher());
			ps.setFloat(bindIndex++, book.getPrice());
			ps.executeUpdate();

		} finally {
			ConnectionDB.closeConnectionDate(conn);
		}

	}

	private static Book createBook() {
		Book book = new Book();
		System.out.print(BookKey.BOOK_TITLE + ": ");
		book.setTitle(scanner.nextLine().toUpperCase().trim());
		System.out.print(BookKey.BOOK_AUTHOR + ": ");
		book.setAuthor(scanner.nextLine().toUpperCase().trim());
		System.out.print(BookKey.BOOK_TYPE + ": ");
		book.setType(scanner.nextLine().toUpperCase().trim());
		System.out.print(BookKey.BOOK_PUBLISHER + ": ");
		book.setPublisher(scanner.nextLine().toUpperCase().trim());

		// INPUT PUBLISH_YEAR
		SimpleDateFormat format = new SimpleDateFormat(BookKey.FORMAT_DATE);
		System.out.println("Enter date and time in the format yyyy-MM-dd");
		java.util.Date date = null;
		while (date == null) {
			System.out.print(BookKey.BOOK_PUBLISH_YEAR + ": ");
			String line = scanner.nextLine().toUpperCase().trim();
			try {

				date = format.parse(line);
				java.sql.Date sqlDate = new Date(date.getTime());
				book.setPublishYear(sqlDate);
			} catch (ParseException e) {
				System.out.print(BookKey.BOOK_PUBLISH_YEAR + "AGAIN: ");
			}
		}
		System.out.print(BookKey.PRICE + ": ");
		book.setPrice(Float.parseFloat(scanner.nextLine()));

		return book;
	}

	public static final void update(Connection conn, int bookId) throws SQLException {
		Book book = search(conn, bookId);
		System.out.print("NEW TITLE: ");
		book.setTitle(scanner.nextLine());
		System.out.print("NEW AUTHOR: ");
		book.setAuthor(scanner.nextLine());
		System.out.print("NEW TYPE: ");
		book.setType(scanner.nextLine());
		System.out.print("NEW PUBLISHER: ");
		book.setPublisher(scanner.nextLine());
		SimpleDateFormat format = new SimpleDateFormat(BookKey.FORMAT_DATE);
		System.out.println("Enter date and time in the format yyyy-MM-dd");
		java.util.Date date = null;
		while (date == null) {
			System.out.print("NEW PUBLISH YEAR: ");
			String line = scanner.nextLine().toUpperCase().trim();
			try {

				date = format.parse(line);
				java.sql.Date sqlDate = new Date(date.getTime());
				book.setPublishYear(sqlDate);
			} catch (ParseException e) {
				System.out.print("NEW PUBLISH YEAR AGAIN: ");
			}
		}
		System.out.print("NEW PRICE: ");
		book.setPrice(Float.parseFloat(scanner.nextLine()));
		
		
		StringBuilder query = new StringBuilder();
		query.append("");
	}
	
	public static void showInfoBook(Connection conn, int bookId) throws SQLException{
		Book book = search(conn, bookId);
		System.out.println(book.toString());
	}

	public static final Book search(Connection conn, int bookId) throws SQLException {
		Book book = new Book();
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM ");
		query.append("BOOK_INFORMATION ");
		query.append("WHERE BOOK_ID = ? ");
		query.append(";");

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(query.toString());
			ps.setInt(1, bookId);
			rs = ps.executeQuery();
			int columnIndex = 1;
			while (rs.next()) {
				book.setBookId(rs.getInt(columnIndex++));
				book.setTitle(rs.getString(columnIndex++));
				book.setAuthor(rs.getString(columnIndex++));
				book.setType(rs.getString(columnIndex++));
				book.setPublishYear(rs.getDate(columnIndex++));
				book.setPublisher(rs.getString(columnIndex++));
				book.setPrice(rs.getFloat(columnIndex++));
			}
		} finally {
			ConnectionDB.closeConnectionDate(conn);
		}
		return book;
	}

}
