/**
 * 
 */
package at.markusegger.AthletesBasic;

/**
 * Swimmer is another type of athlete.
 * 
 * @author MarkusME
 *
 */
public class Swimmer extends RacingAthlete
{
	/**
	 * Default parameterless constructor.
	 */
	public Swimmer()
	{
		super();
	}
	
	/**
	 * Parameterized constructor.
	 * 
	 * @param name				Athlete's name
	 * @param age				Athlete's age
	 * @param contestantID		Athlete's ID
	 */
	public Swimmer(String name, int age, int contestantID)
	{
		super(name, age, contestantID);
	}
	
	/** (non-Javadoc)
	 * @see at.markusegger.AthletesBasic.RaceParticipant#performRaceActivity()
	 */
	public String performRaceActivity()
	{	
		return "Swimming";
	}
}
