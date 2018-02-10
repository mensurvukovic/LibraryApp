import java.util.ArrayList;

public class Book {

	private int numOfBook;
	private String nameOfBook;
	private boolean statusOfBook;
	static ArrayList<Book> books = new ArrayList<>();

	public Book() {

	}

	public Book(int numOfBook, String nameOfBook, boolean statusOfBook) {

		this.numOfBook = numOfBook;
		this.nameOfBook = nameOfBook;
		this.statusOfBook = statusOfBook;
		books.add(this);
	}

	public int getNumOfBook() {
		return numOfBook;
	}

	public void setNumOfBook(int numOfBook) {
		this.numOfBook = numOfBook;
	}

	public String getNameOfBook() {
		return nameOfBook;
	}

	public void setNameOfBook(String nameOfBook) {
		this.nameOfBook = nameOfBook;
	}

	public boolean isStatusOfBook() {
		return statusOfBook;
	}

	public void setStatusOfBook(boolean statusOfBook) {
		this.statusOfBook = statusOfBook;
	}

	public static ArrayList<Book> getBooks() {
		return books;
	}

	public void setBooks(ArrayList<Book> books) {
		Book.books = books;
	}

	public static void print() {
		for (Book e : books) {
			System.out.print("\nNumber of Book:" + e.numOfBook + "\nName of Book: " + e.nameOfBook
					+ "\nStatus of Book: " + e.statusOfBook + "\n\n");
		}

	}
}