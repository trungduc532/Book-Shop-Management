package common;

public class BookKey {
	
	public static final String BOOK_ID = "BOOK_ID";
	public static final String BOOK_TITLE  = "BOOK_TITLE";
	public static final String BOOK_AUTHOR = "AUTHOR";
	public static final String BOOK_TYPE = "BOOK_TYPE";
	public static final String BOOK_PUBLISHER = "PUBLISHER";
	public static final String BOOK_PUBLISH_YEAR = "BOOK_PUBLISH_YEAR";
	public static final String PRICE = "PRICE";
	
	public static final String FORMAT_DATE = "yyyy-MM-dd";
	
	
	// database information
	public static final String DATABASE_NAME = "BookShop";
	public static final String DB_PASSWORD = "1234567890d";
	
	
	public static void printInfo() {
		System.out.println("|  CART_ID   |      CUSTOMER      |SHIPPING_FEE|     TOTAL     |   PAYMENT_METHOD  |\n");
	}
	
	
}
