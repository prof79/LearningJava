/**
 * 
 */
package at.markusegger.CreditCardRandom;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.RandomAccess;

import at.markusegger.CreditCardBase.CreditCard;
import at.markusegger.Utilities.ConsoleBase;

/**
 * Demo for random file access under Java.
 * 
 * @author MarkusME
 * @version 0.1
 */
public final class CcRandom extends ConsoleBase
{
	static final private String FILE_PATH = "C:\\Users\\MarkusME\\workspace\\LearningJava\\src\\at\\markusegger\\CreditCardRandom\\ccdata.bin";
	static final private String FILE_MODE = "rw";
	static final private int RECORD_LENGTH = 16;
	
	static final private ConsoleBase instance = new CcRandom();
	static private RandomAccessFile dataFile;
	
	/**
	 * The main entry point for the credit card manager program.
	 * 
	 * @param args		The command-line arguments to the program
	 */
	public static void main(String[] args)
	{
		try
		{
			dataFile = new RandomAccessFile(FILE_PATH, FILE_MODE);
			
			instance.setTitle("Credit Card Manager 1");
			instance.mainLoop();
			
			try
			{
				dataFile.close();
			}
			catch (IOException e)
			{
				System.out.println("There was an error closing the credit card data file.");
				System.out.println();
				e.printStackTrace();
			}
			finally
			{
				dataFile = null;
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("There was an error accessing the credit card data file. Program will exit.");
			System.out.println();
			e.printStackTrace();
		}
	}

	/* (non-Javadoc)
	 * @see at.markusegger.Utilities.ConsoleBase#printMenu()
	 */
	@Override
	public void printMenu()
	{
		System.out.println(getStars());
		System.out.println("Enter 1 to view all cards");
		System.out.println("Enter 2 to view a specific card");
		System.out.println("Enter 3 to add a card");
		System.out.println("Enter 4 to update a card");
		System.out.println("Enter 5 to remove a card");
		System.out.println("Enter 6 to exit the program");
		System.out.println(getStars());
		
		setMinMenuID(1);
		setMaxMenuID(6);
	}

	/* (non-Javadoc)
	 * @see at.markusegger.Utilities.ConsoleBase#handleInput(int)
	 */
	@Override
	public void handleInput(int choice)
	{
		System.out.println();
		
		switch (choice)
		{
			case 1:
				viewCards();
				break;
			
			case 2:
				viewCard();
				break;
				
			case 3:
				addCard();
				break;
				
			case 4:
				updateCard();
				break;
				
			case 5:
				removeCard();
				break;
				
			case 6:
				setQuitFlag(true);
				System.out.println();
				System.out.println("Thanks for using the program! Bye");
				System.out.println();
				break;
			
			default:
				throw new IllegalArgumentException("Unexpected menu choice " + choice);
		}
	}

	/**
	 * List all credit cards saved in the system so far.
	 */
	private void viewCards()
	{
		if (!checkCards())
		{
			return;
		}
		
		printSubheader("View Cards");
		
		long pos = 0;
		
		try
		{
			dataFile.seek(pos);
			
			while (pos < dataFile.length())
			{
				long number = dataFile.readLong();
				
				double balance = dataFile.readDouble();
				
				String output = (new CreditCard(number, balance)).toString();
				
				System.out.println(output);
				
				pos += RECORD_LENGTH;
			}
		}
		catch (IOException ioex)
		{
			System.out.println("There was an error reading the card data from file: " + ioex.getMessage());
		}
		
		System.out.println();
	}

	/**
	 * Helper method to check for a valid list of credit cards in the system
	 * (i. e. RandomAccessFile is not empty).
	 * 
	 * @return True when there are any cards saved in the system otherwise false
	 */
	private boolean checkCards()
	{
		try
		{
			if (dataFile.length() == 0)
			{
				System.out.println("No cards were saved in the system.");
				System.out.println();
				
				return false;
			}
			else
			{
				return true;
			}
		}
		catch (IOException e)
		{
			return false;
		}
	}

	/**
	 * View the infos of a specific credit card.
	 */
	private void viewCard()
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * Add a credit card to the sytem.
	 */
	private void addCard()
	{
		printSubheader("Add Card");
		
		long number = getNumberInput();
		double balance = getBalanceInput();
		
		try
		{
			addCardToFile(new CreditCard(number, balance));
			
			System.out.println();
			
			System.out.println("Card added.");
		}
		catch (IOException ioex)
		{
			System.out.println();
			
			System.out.println("There was an error adding the card: " + ioex.getMessage());
		}
		
		System.out.println();
	}

	/**
	 * Update the data of a specific credit card.
	 */
	private void updateCard()
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * Remove a credit card from the system.
	 */
	private void removeCard()
	{
		// TODO Auto-generated method stub
		
	}

	/**
	 * Retrieve a valid credit card number from keyboard input.
	 * In our toy example valid card numbers consist of 16 consecutive digits.
	 * 
	 * @return	The credit card number as a {@link long} value
	 */
	private long getNumberInput()
	{
		long number = Long.MIN_VALUE;
		boolean validInput = false;
		
		while (!validInput)
		{
			//number = at.markusegger.Utilities.Utilities.readLongFromKeyboard("Enter the credit card number: ", Long.MIN_VALUE, Long.MAX_VALUE);
			
			System.out.print("Enter the credit card number (16 digits): ");
			
			String line = scanner.nextLine().trim();
			
			if (line.matches("\\d{16}"))
			{
				number = Long.parseLong(line);
				
				validInput = true;
			}
			else
			{
				System.out.println("Invalid card number!");
			}
		}
		
		return number;
	}

	/**
	 * Retrieve an account balance value from keyboard input.
	 * 
	 * @return	The card's balance as a {@link double} value
	 */
	private double getBalanceInput()
	{
		return at.markusegger.Utilities.Utilities.readDoubleFromKeyboard("Enter the card's balance: ", Double.MIN_VALUE, Double.MAX_VALUE);
	}
	
	/**
	 * Internal method to save a card into the RandomAccessFile.
	 * 
	 * @param newCard			The credit card data to be saved
	 * @throws IOException
	 */
	private void addCardToFile(CreditCard newCard)
		throws IOException
	{
		dataFile.seek(dataFile.length());
		
		dataFile.writeLong(newCard.getNumber());
		dataFile.writeDouble(newCard.getBalance());
	}
}
