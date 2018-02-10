import java.util.ArrayList;
import java.util.Date;

public class Borrowed {

	private int numOfAccount;
	private int numOfBook;
	private Date date = new Date();
	static ArrayList<Borrowed> borrowedBooks = new ArrayList<>();

	public Borrowed() {

	}

	public Borrowed(int numOfAccount, int numOfBook, Date date) {

		this.numOfAccount = numOfAccount;
		this.numOfBook = numOfBook;
		this.date = date;
		borrowedBooks.add(this);
	}


	
	public int getNumOfAccount() {
		return numOfAccount;
	}

	public void setNumOfAccount(int numOfAccount) {
		this.numOfAccount = numOfAccount;
	}

	public int getNumOfBook() {
		return numOfBook;
	}

	public void setNumOfBook(int numOfBook) {
		this.numOfBook = numOfBook;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public static ArrayList<Borrowed> getBorrowedBooks() {
		return borrowedBooks;
	}

	public static void setBorrowedBooks(ArrayList<Borrowed> borrowedBooks) {
		Borrowed.borrowedBooks = borrowedBooks;
	}

	public static void print() {
		for (Borrowed e : borrowedBooks) {
			System.out.print("\nNumber of Book:" + e.numOfBook + "\nAccount number: " + e.numOfAccount + "\nBorrowed date: "
					+ e.date + "\n\n");
		}

	}


}
