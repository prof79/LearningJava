/**
 * 
 */
package at.markusegger.Utilities;

import java.util.Scanner;

/**
 * A collection of several utilities.
 * TODO: DRY code smell, generics possible?
 * 
 * @author MarkusME
 * @version 0.7 
 */
final public class Utilities
{
	/**
	 * A null-safe comparison method.
	 * 
	 * @param object1		The first object to compare.
	 * @param object2		The second object compared with object1.
	 */
	static public boolean nullSafeEquals(Object object1, Object object2)
	{
		return object1 == null ? object2 == null : object1.equals(object2);
	}

	/**
	 * A null-safe comparison method for strings.
	 * 
	 * @param object1		The first object to compare.
	 * @param object2		The second object compared with object1.
	 */
	static public boolean nullSafeEquals(String object1, String object2)
	{
		return nullSafeEquals((Object) object1, (Object) object2);
	}
	
	/**
	 * Repeats a character n times.
	 * 
	 * @param ch 		The character to repeat
	 * @param times		How often to repeat the character ch
	 * @return          A concatenated string of the repeated characters
	 */
	static public String repeatChar(char ch, int times)
	{
		StringBuffer buffer = new StringBuffer();
		
		for (int i = 0; i < times; ++i)
		{
			buffer.append(ch);
		}
		
		return buffer.toString();
	}
	
	/**
	 * Repeats a string n times.
	 * 
	 * @param str 		The string to repeat
	 * @param times		How often to repeat the string str
	 * @return          A concatenation of the repeated strings
	 */
	static public String repeatString(String str, int times)
	{
		StringBuffer buffer = new StringBuffer();
		
		for (int i = 0; i < times; ++i)
		{
			buffer.append(str);
		}
		
		return buffer.toString();
	}
	
	/**
	 * Repeats a star character ('*') n times.
	 * @param times		How often to repeat the star
	 * @return          A concatenated string of the star character
	 */
	static public String repeatStar(int times)
	{
		return repeatChar('*', times);
	}
	
	/**
	 * Repeats a dash character ('-') n times.
	 * @param times		How often to repeat the dash
	 * @return          A concatenated string of dashes
	 */
	static public String repeatDash(int times)
	{
		return repeatChar('-', times);
	}
	
	/**
	 * Repeats an equal sign character ('=') n times.
	 * @param times		How often to repeat the equal sign
	 * @return          A concatenated string of the character
	 */
	static public String repeatEqualSign(int times)
	{
		return repeatChar('=', times);
	}
	
	/**
	 * Validates that a number falls into a certain range.
	 * 
	 * @param value				The numeric value to check
	 * @param minimumValue		The allowed minimum (inclusive)
	 * @param maxValue			The allowed maximum (inclusive)
	 * 
	 * @throws IndexOutOfBoundException
	 */
	static public void validateNumberInRange(int value, int minValue, int maxValue)
		throws IndexOutOfBoundsException
	{
		if (value < minValue || value > maxValue)
		{
			String message = String.format("%d is not between %d and %d (inclusive)", value, minValue, maxValue);
			
			throw new IndexOutOfBoundsException(message);
		}
	}
	
	/**
	 * Validates that a number falls into a certain range.
	 * 
	 * @param value				The numeric value to check
	 * @param minimumValue		The allowed minimum (inclusive)
	 * @param maxValue			The allowed maximum (inclusive)
	 * 
	 * @throws IndexOutOfBoundException
	 */
	static public void validateNumberInRange(double value, double minValue, double maxValue)
		throws IndexOutOfBoundsException
	{
		if (value < minValue || value > maxValue)
		{
			String message = String.format("%f is not between %f and %f (inclusive)", value, minValue, maxValue);
			
			throw new IndexOutOfBoundsException(message);
		}
	}
	
	/**
	 * Validates that a number falls into a certain range.
	 * This shorthand version only checks the lower bound.
	 * 
	 * @param value				The numeric value to check
	 * @param minimumValue		The allowed minimum (inclusive)
	 * 
	 * @throws IndexOutOfBoundException
	 */
	static public void validateNumberInRange(int value, int minValue)
		throws IndexOutOfBoundsException
	{
		validateNumberInRange(value,  minValue, Integer.MAX_VALUE);
	}
	
	/**
	 * Validates that a number falls into a certain range.
	 * This shorthand version only checks the lower bound.
	 * 
	 * @param value				The numeric value to check
	 * @param minimumValue		The allowed minimum (inclusive)
	 * 
	 * @throws IndexOutOfBoundException
	 */
	static public void validateNumberInRange(double value, double minValue)
		throws IndexOutOfBoundsException
	{
		validateNumberInRange(value,  minValue, Double.MAX_VALUE);
	}
	
	/**
	 * Retrieves an integer from keyboard.
	 * Input is limited to a certain range (inclusive). You may use
	 * Integer.MIN_VALUE and Integer.MAX_VALUE as arguments.
	 * 
	 * @param prompt	The input prompt message or null. The prompt will print without a newline (System.out.print())
	 * @param minValue	The minimum integer value (inclusive)
	 * @param maxValue	The maximum integer value (inclusive)
	 * @return The user's choice as an integer
	 */
	static public int readIntFromKeyboard(String prompt, int minValue, int maxValue)
	{
		final Scanner scanner = new Scanner(System.in);
		
		int choice = -1;
		boolean invalidInput = true;
		
		while (invalidInput)
		{
			if (prompt != null && !prompt.isEmpty())
			{
				System.out.print(prompt);
			}
			
			String inputLine = scanner.nextLine().trim();
			
			try
			{
				choice = Integer.parseInt(inputLine);
				
				Utilities.validateNumberInRange(choice, minValue, maxValue);
				
				invalidInput = false;
			}
			catch (NumberFormatException nfe)
			{
				System.out.println("Invalid input! Not a number: " + inputLine);
			}
			catch (IndexOutOfBoundsException ioobe)
			{
				System.out.println("Invalid input! " + ioobe.getMessage());
			}
		}
		
		return choice;
	}
	
	/**
	 * Retrieves a double from keyboard.
	 * Input is limited to a certain range (inclusive). You may use
	 * Double.MIN_VALUE and Double.MAX_VALUE as arguments.
	 * 
	 * @param prompt	The input prompt message or null. The prompt will print without a newline (System.out.print())
	 * @param minValue	The minimum double value (inclusive)
	 * @param maxValue	The maximum double value (inclusive)
	 * @return The user's choice as a double
	 */
	static public double readDoubleFromKeyboard(String prompt, double minValue, double maxValue)
	{
		final Scanner scanner = new Scanner(System.in);
		
		double choice = Double.NaN;
		boolean invalidInput = true;
		
		while (invalidInput)
		{
			if (prompt != null && !prompt.isEmpty())
			{
				System.out.print(prompt);
			}
			
			String inputLine = scanner.nextLine().trim();
			
			try
			{
				choice = Double.parseDouble(inputLine);
				
				Utilities.validateNumberInRange(choice, minValue, maxValue);
				
				invalidInput = false;
			}
			catch (NumberFormatException nfe)
			{
				System.out.println("Invalid input! Not a number: " + inputLine);
			}
			catch (IndexOutOfBoundsException ioobe)
			{
				System.out.println("Invalid input! " + ioobe.getMessage());
			}
		}
		
		return choice;
	}
}
