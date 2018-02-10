import java.util.ArrayList;

public class Account {
	
	private int numOfAccount;
	private String clientName;
	private int numOfBorrowedBooks;
	static ArrayList<Account> accounts = new ArrayList<>();

	public Account() {

	}

	public Account(int numOfAccount, String clientName, int numOfBorrowedBooks) {

		this.numOfAccount = numOfAccount;
		this.clientName = clientName;
		this.numOfBorrowedBooks = numOfBorrowedBooks;
		accounts.add(this);

	}

	public int getNumOfAccount() {
		return numOfAccount;
	}

	public void setNumOfAccount(int numOfAccount) {
		this.numOfAccount = numOfAccount;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public int getNumOfBorrowedBooks() {
		return numOfBorrowedBooks;
	}

	public void setNumOfBorrowedBooks(int numOfBorrowedBooks) {
		this.numOfBorrowedBooks = numOfBorrowedBooks;
	}

	public static void print() {
		for (Account e : accounts) {
			System.out.print("\nNumber of Account:" + e.numOfAccount + "\nClient name: " + e.clientName + "\nNumber of borrowed Books: "
					+ e.numOfBorrowedBooks + "\n\n");
		}

	}

	public static ArrayList<Account> getAccounts() {
		return accounts;
	}

	public static void setAccounts(ArrayList<Account> accounts) {
		Account.accounts = accounts;
	}
}

