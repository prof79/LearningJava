/**
 * 
 */
package at.markusegger.Learning.FileIO;

import java.io.*;
import java.util.*;

/**
 * Learning Java I/O
 * 
 * @author MarkusME
 * @version 0.2
 */
public class Program
{
	final private static String file1 =
			"C:\\Users\\MarkusME\\workspace\\LearningJava\\src\\at\\markusegger\\Learning\\FileIO\\File1.txt";
	
	final private static String file2 =
			"C:\\Users\\MarkusME\\workspace\\LearningJava\\src\\at\\markusegger\\Learning\\FileIO\\File2.txt";
	
	/**
	 * File I/O Tests
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		readTextFile();
		
		System.out.println();
		
		writeTextFile();
		
		System.out.println();
		
		byteDemo();
		
		// TODO: Buffered reader, buffered writer
		// TODO: Binary - input stream/output stream + buffer, PrintOutputStream
	}

	/**
	 * Reading Text File Demo
	 */
	private static void readTextFile()
	{
		System.out.println("Reading text file ...");
		
		File file = null;
		Scanner scanner = null;
		
		try
		{
			file = new File(file1);
		
			System.out.println(String.format("Exists? %b", file.exists()));
					
			scanner = new Scanner(file);
			
			System.out.println("<file>");
			
			while (scanner.hasNextLine())
			{
				System.out.println(scanner.nextLine());
			}
			
			System.out.println("</file>");
			
		}
		catch (NullPointerException npex)
		{
			npex.printStackTrace();
		}
		catch (FileNotFoundException fnfex)
		{
			fnfex.printStackTrace();
		}
		finally
		{
			if (scanner != null)
			{
				scanner.close();
				scanner = null;
			}
		}
		
		System.out.println("Done!");
	}
	
	/**
	 * Write Text File Demo
	 */
	private static void writeTextFile()
	{
		System.out.println("Writing text file ...");
		
		File file = null;
		FileWriter fileWriter = null;
		
		Random rand = new Random();
		
		try
		{
			file = new File(file2);
			
			fileWriter = new FileWriter(file, false);
			
			for (int i = 0; i < 10; ++i)
			{
				// I knew there was a more idiomatic way than String.format ...
				// However, since there is no FileWriter.writeLine() it's less advantageous ...
				String str = Integer.toString(rand.nextInt()) + "\n";
				
				fileWriter.write(str);
			}
		}
		catch (NullPointerException npex)
		{
			npex.printStackTrace();
		}
		catch (IOException ioex)
		{
			// TODO Auto-generated catch block
			ioex.printStackTrace();
		}
		finally
		{
			if (fileWriter != null)
			{
				try
				{
					fileWriter.close();
					fileWriter = null;
				}
				catch (IOException innerEx)
				{
					innerEx.printStackTrace();
				}
			}
		}
		
		System.out.println("Done!");
	}
	
	/**
	 * Demo of numeric roll-over in case of a byte.
	 */
	private static void byteDemo()
	{
		byte by = 0;
		
		System.out.println("<byte>");
		
		for (int i = 0; i < 520; ++i)
		{
			System.out.println(by++);
		}
		System.out.println("</byte>");
	}
}
