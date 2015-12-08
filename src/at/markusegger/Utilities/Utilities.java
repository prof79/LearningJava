/**
 * 
 */
package at.markusegger.Utilities;

/**
 * @author MarkusME
 *
 * A collection of several utilities.
 * TODO: DRY code smell, generics possible?
 * 
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
}
