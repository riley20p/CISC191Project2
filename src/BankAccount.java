/**
 * Lead Author(s):
 * 
 * @author Riley Phan; 5550006344
 * 
 *         References:
 *         Morelli, R., & Walde, R. (2016).
 *         Java, Java, Java: Object-Oriented Problem Solving
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-
 *         java-object-oriented-problem-solving
 * 
 *         Version: 2021-12 (4.22.0)
 *         Responsibilities of class:
 *         Methods that use objects and args, storing variables, constructing
 *         objects.
 *         Holds information about a person's bankaccount such as holding money, withdrawing and depositing 
 */

public class BankAccount
{

	// fields for a CreditCard

	// BankAccount will have a balance, essentially acting as a bankaccount
	private double bankAccountBalance = 0;

	/**
	 * args-constructor to create and set creditcard balance to a given ammount
	 * 
	 * @param balance
	 */
	BankAccount(double startingBalance)
	{
		this.bankAccountBalance = startingBalance;
	}

	/**
	 * no-args constructor
	 */
	BankAccount()
	{
	}

	/**
	 * returns balance
	 * 
	 * @return
	 */
	public double getBalance()
	{
		return bankAccountBalance;
	}

	/**
	 * setter method to set balance to a any amount
	 * 
	 * @param amount
	 */
	public void setMoney(double amount)
	{
		this.bankAccountBalance = amount;
	}

	/**
	 * method to deposit a certain amount of money to balance.
	 * 
	 * @param amount
	 */
	public void depositMoney(double amount)
	{
		this.bankAccountBalance = bankAccountBalance + amount;
	}

	/**
	 * method to withdraw a given amount of money from bank balance
	 * 
	 * @param amount
	 */
	public void withdrawMoney(double amount)
	{
		this.bankAccountBalance = bankAccountBalance - amount;
	}
}
