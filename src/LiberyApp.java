import java.util.*;

public class LiberyApp {

	static Scanner input = new Scanner(System.in);
	private static Account acount;
	private static Book book;
	private static Borrowed borrowed;

	public static void main(String[] args) {

		System.out.println("Select the option: ");
		System.out.println(
				"\n1. Create new account \n2. Create new book \n3. Borrow a book \n4. Return a book \n5. Print account "
						+ "\n6. Print status of books \n7. Print borrowed books");
		int selection = input.nextInt();

		switch (selection) {

		case 1:

			createAccount();
			backToMeni();

			break;

		case 2:

			createBook();
			backToMeni();

			break;

		case 3:

			borrowedBook();
			backToMeni();

			break;

		case 4:

			returnBook();
			backToMeni();

			break;

		case 5:

			Account.print();
			backToMeni();

			break;

		case 6:

			Book.print();
			backToMeni();

			break;

		case 7:

			Borrowed.print();
			backToMeni();

			break;

		default:
			System.err.println("Wrong input, please insert number 1-7.");
			backToMeni();
		}
	}

	private static void createAccount() {

		System.out.println("Enter number of account: ");
		int numOfAccount = input.nextInt();

		while (checkAccount(numOfAccount)) {
			System.err.println("Account number exists or is negative, try again: ");
			numOfAccount = input.nextInt();
		}

		System.out.println("Enter client name: ");
		String clientName = input.next();

		while (checkClientName(clientName)) {
			System.err.println("The name exists, try again: ");
			clientName = input.next();
		}

		int borrowedBook = 0;

		setAcount(new Account(numOfAccount, clientName, borrowedBook));
	}

	private static void createBook() {

		System.out.println("Enter number of book: ");
		int numOfBook = input.nextInt();

		while (checkNumOfBook(numOfBook)) {
			System.err.println("Number of book exists or is negative, try again: ");
			numOfBook = input.nextInt();
		}

		System.out.println("Enter book name: ");
		String nameOfBook = input.next();

		boolean statusOfBook = true;

		setBook(new Book(numOfBook, nameOfBook, statusOfBook));
	}

	private static void borrowedBook() {

		System.out.println("Enter number of account: ");
		int numOfAccount = input.nextInt();

		while (!checkAccount(numOfAccount)) {
			System.err.println("Account not exists, try again: ");
			numOfAccount = input.nextInt();
		}

		while (checkNumberOfBorrowedBooks(numOfAccount)) {
			System.err.println("The number of borrowed books is 3, you can't borrow another book.");
			backToMeni();

		}

		System.out.println("Enter number of book: ");
		int numOfBook = input.nextInt();

		while (!checkNumOfBook(numOfBook)) {
			System.err.println("Book not exists, try again:");
			numOfBook = input.nextInt();
		}

		while (checkBorrowedBooks(numOfBook)) {
			System.err.println("Book is borrowed, you can borrow another book.");
			numOfBook = input.nextInt();
		}

		Date date = new Date();

		setBorrowed(new Borrowed(numOfAccount, numOfBook, date));

		incrementNumOfBrrowedBooks(numOfAccount);
		setStatusBook(numOfBook);

	}

	private static void returnBook() {

		System.out.println("Enter number of account: ");
		int numOfAccount = input.nextInt();

		System.out.println("Enter number of book: ");
		int numOfBook = input.nextInt();

		decrementNumOfBorrowedBooks(numOfAccount);
		setStatusBook(numOfBook);
		removeBorrowedBook(numOfBook);

	}

	private static boolean checkAccount(int numOfAccount) {
		for (Account e : Account.accounts) {
			if (numOfAccount == e.getNumOfAccount()) {
				return true;
			}
		}
		return false;

	}

	private static boolean checkClientName(String clientName) {
		for (Account e : Account.accounts) {
			if (clientName.equals(e.getClientName()))
				return true;
		}
		return false;
	}

	private static boolean checkNumOfBook(int numOfBook) {
		for (Book e : Book.books) {
			if (numOfBook == e.getNumOfBook()) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkNumberOfBorrowedBooks(int numOfAccount) {
		for (Account e : Account.accounts) {
			if (numOfAccount == e.getNumOfAccount()) {
				if (Account.getAccounts().get(Account.getAccounts().indexOf(e)).getNumOfBorrowedBooks() == 3) {
					return true;
				}
			}
		}
		return false;

	}

	public static boolean checkBorrowedBooks(int numOfBook) {
		for (Borrowed e : Borrowed.borrowedBooks) {
			if (numOfBook == e.getNumOfBook()) {
				return true;
			}
		}
		return false;
	}

	public static void incrementNumOfBrrowedBooks(int numOfAccount) {
		for (Account e : Account.accounts) {
			if (numOfAccount == e.getNumOfAccount()) {
				Account.getAccounts().get(Account.getAccounts().indexOf(e)).setNumOfBorrowedBooks(
						(Account.getAccounts().get(Account.getAccounts().indexOf(e)).getNumOfBorrowedBooks()) + 1);
			}
		}
	}

	public static void decrementNumOfBorrowedBooks(int numOfAccount) {
		for (Account e : Account.accounts) {
			if (numOfAccount == e.getNumOfAccount()) {
				Account.getAccounts().get(Account.getAccounts().indexOf(e)).setNumOfBorrowedBooks(
						(Account.getAccounts().get(Account.getAccounts().indexOf(e)).getNumOfBorrowedBooks()) - 1);
			}
		}
	}

	public static void setStatusBook(int numOfBook) {
		for (Book e : Book.books) {
			if (numOfBook == e.getNumOfBook()) {
				if (Book.getBooks().get(Book.getBooks().indexOf(e)).isStatusOfBook()) {
					Book.getBooks().get(Book.getBooks().indexOf(e)).setStatusOfBook(false);
				} else {
					Book.getBooks().get(Book.getBooks().indexOf(e)).setStatusOfBook(true);
				}
			}
		}
	}

	public static int index(int numOfBook) {
		int i = 0;
		for (Borrowed e : Borrowed.borrowedBooks) {
			if (numOfBook == e.getNumOfBook()) {
				return i = Borrowed.getBorrowedBooks().indexOf(e);
			}
		}
		return i;
	}

	public static void removeBorrowedBook(int numOfBook) {

		Borrowed.borrowedBooks.remove(index(numOfBook));

	}

	public static void backToMeni() {
		LiberyApp.main(null);
	}

	public static Account getAcount() {
		return acount;
	}

	public static void setAcount(Account acount) {
		LiberyApp.acount = acount;
	}

	public static Book getBook() {
		return book;
	}

	public static void setBook(Book book) {
		LiberyApp.book = book;
	}

	public static Borrowed getBorrowed() {
		return borrowed;
	}

	public static void setBorrowed(Borrowed borrowed) {
		LiberyApp.borrowed = borrowed;
	}
}
