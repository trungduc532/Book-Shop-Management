/**
 * 59102901
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.database.ConnectionDB;
import model.Book;

/**
 * 
 * @author Trung Duc
 * @version 1.0
 * @since 2022-10
 *
 */
public class BookSearch {
	
	/**
	 * Search bookinformation by BooId
	 * @param conn
	 * @param bookId
	 * @return book
	 * @throws SQLException
	 */
	public static final Book searchByBookId(Connection conn, int bookId) throws SQLException {
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
	
	/**
	 * Search book by title
	 * @param conn
	 * @param Title
	 * @return
	 * @throws SQLException
	 */
	public static final List<Book> searchByBookTitle(Connection conn, String Title) throws SQLException {
		List<Book> listBook = new ArrayList<>();
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM ");
		query.append("BOOK_INFORMATION ");
		query.append("WHERE TITLE = ? ");
		query.append(";");

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, Title);
			rs = ps.executeQuery();
			int columnIndex = 1;
			while (rs.next()) {
				final Book book = new Book();
				book.setBookId(rs.getInt(columnIndex++));
				book.setTitle(rs.getString(columnIndex++));
				book.setAuthor(rs.getString(columnIndex++));
				book.setType(rs.getString(columnIndex++));
				book.setPublishYear(rs.getDate(columnIndex++));
				book.setPublisher(rs.getString(columnIndex++));
				book.setPrice(rs.getFloat(columnIndex++));
				listBook.add(book);
			}
		} finally {
			ConnectionDB.closeConnectionDate(conn);
		}
		return listBook;
	}
	
	public static final Book searchByTitleAndAuthor(Connection conn, String title, String author) throws SQLException {
		final Book book = new Book();
		StringBuilder query = new StringBuilder();
		query.append("SELECT * ");
		query.append("FROM ");
		query.append("BOOK_INFORMATION bi");
		query.append("WHERE bi.TITLE = ? ,");
		query.append("bi.AUTHOR = ? ");
		query.append(";");

		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(query.toString());
			ps.setString(1, title);
			ps.setString(2, author);
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
