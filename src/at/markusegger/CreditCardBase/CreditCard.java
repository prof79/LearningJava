/**
 * 
 */
package at.markusegger.CreditCardBase;

/**
 * A model for a credit card.
 * 
 * @author MarkusME
 * @version 1.0
 */
public class CreditCard
{
	private long _number;
	private double _balance;
	
	/**
	 * Credit card constructor with two parameters.
	 * 
	 * @param number	The credit card number
	 * @param balance	The card's balance
	 */
	public CreditCard(long number, double balance)
	{
		setNumber(number);
		setBalance(balance);
	}
	
	/**
	 * Get the credit card number.
	 * 
	 * @return The credit card number
	 */
	public long getNumber()
	{
		return _number;
	}
	
	/**
	 * Set the number of the credit card.
	 * 
	 * @param newNumber		The credit card number
	 */
	public void setNumber(long newNumber)
	{
		_number = newNumber;
	}
	
	/**
	 * Get the monetary balance of the card.
	 * 
	 * @return The balance of the credit card
	 */
	public double getBalance()
	{
		return _balance;
	}
	
	/**
	 * Set the monetary balance of the credit card.
	 * 
	 * @param newBalance	The new balance of the credit card
	 */
	public void setBalance(double newBalance)
	{
		_balance = newBalance;
	}
	
	/**
	 * Get a string representation of the credit card.
	 */
	@Override
	public String toString()
	{
		return String.format("Card number: %-16d\tBalance: %.2f"
								, getNumber()
								, getBalance()
								);
	}
}
