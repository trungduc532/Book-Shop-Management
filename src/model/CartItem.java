package model;

import java.util.Scanner;

public class CartItem {
	private Book book;
	private int quantity;
	private float price;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	private static Scanner sc = new Scanner(System.in);
	
	public void addItem(CartItem cartItem,Book book) {
		cartItem.setBook(book);
		System.out.println("INPUT QUANTITY: ");
		int quantity = Integer.parseInt(sc.nextLine());
		cartItem.setQuantity(quantity);
		
		System.out.println("INPUT_PRICE: ");
		float price = Float.parseFloat(sc.nextLine());
		cartItem.setPrice(price);
		
	}

	public void editItem() {
		
		
	}
	
	public void removeItem(String item) {
		
		
	}
		
}
