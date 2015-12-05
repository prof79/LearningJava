/**
 * 
 */
package at.markusegger.Utilities;

/**
 * @author MarkusME
 *
 * A collection of several utilities.
 * 
 */
public final class Utilities
{
	/*
	 * A null-safe comparison method.
	 * 
	 * @param object1		The first object to compare.
	 * @param object2		The second object compared with object1.
	 */
	public static boolean nullSafeCompare(Object object1, Object object2)
	{
		return object1 == null ? object2 == null : object1.equals(object2);
	}

	public static Object nullSafeCompare(String object1, String object2)
	{
		return nullSafeCompare((Object) object1, (Object) object2);
	}
}
