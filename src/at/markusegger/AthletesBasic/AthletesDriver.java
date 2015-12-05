/**
 * 
 */
package at.markusegger.AthletesBasic;

/**
 * @author MarkusME
 *
 * The athletes management console UI.
 * 
 */
public class AthletesDriver
{
	/**
	 * The main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		Runner runner1 = new Runner();
		
		runner1.setContestantID(42731);
		runner1.setName("Tom");

		Runner runner2 = new Runner(2972003, "Hilda");
		
		Swimmer swimmer1 = new Swimmer();
		
		swimmer1.setContestantID(201102);
		swimmer1.setName("Tanya");
		
		System.out.println();
		System.out.println("ATHLETES\n");
		System.out.println(runner1);
		System.out.println(runner2);
		System.out.println(swimmer1);
		System.out.println();
	}
}
