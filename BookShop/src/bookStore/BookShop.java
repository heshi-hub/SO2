package bookStore;

import java.util.ArrayList;

public class BookShop {
	private ArrayList<Book> books;
	private ArrayList<Customer> customers;
	
	public BookShop() {
		books = new ArrayList<>();
		customers = new ArrayList<>();
	}
	
	public void sell(Customer c, Book b) {
		if (bookExists(b)){
			customers.add(c);
			books.remove(b);
		}
	}
	
	private boolean bookExists(Book b) {
		for(Book book: books) {
			if (book == b) {
				return true;
			}
		}
		return false;
	}

}
