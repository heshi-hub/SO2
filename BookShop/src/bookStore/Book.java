package bookStore;

public enum Book {
	NOVEL(15),
	MANGA(12),
	COMIC(8),
	BIOGRAPHY(20);
	
	private int price;
	
	private Book(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}

}
