/**
 * 
 */
package at.markusegger.CreditCardBase;

/**
 * A model for a credit card.
 * 
 * @author MarkusME
 * @version 0.1
 */
public class CreditCard
{
	private long _number;
	private double _balance;
	
	public CreditCard(long number, double balance)
	{
		setNumber(number);
		setBalance(balance);
	}
	
	public long getNumber()
	{
		return _number;
	}
	
	public void setNumber(long newNumber)
	{
		_number = newNumber;
	}
	
	public double getBalance()
	{
		return _balance;
	}
	
	public void setBalance(double newBalance)
	{
		_balance = newBalance;
	}
	
	@Override
	public String toString()
	{
		return String.format("Card number: %-16d\tBalance: %.2f"
								, getNumber()
								, getBalance()
								);
	}
}
