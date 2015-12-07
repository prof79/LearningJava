/**
 * 
 */
package at.markusegger.AthletesBasic;

/**
 * @author MarkusME
 * Runner is one type of athlete.
 */
public class Runner extends RacingAthlete
{
	String _shoeBrand;
	
	/**
	 * Default parameterless constructor.
	 */
	public Runner()
	{
		super();
	}

	/**
	 * Explicit parameterised constructor.
	 * 
	 * @param contestantID		The contestant ID.
	 * @param name				The name of the athlete.
	 * @param shoeBrand			The brand of shoes used by the athlete.
	 */
	public Runner(int contestantID, String name, String shoeBrand)
	{
		super();
		
		setContestantID(contestantID);
		setName(name);
		setShoeBrand(shoeBrand);
	}
	
	/** (non-Javadoc)
	 * @see at.markusegger.AthletesBasic.RaceParticipant#performRaceActivity()
	 */
	public String performRaceActivity()
	{
		return "Running";
	}
	
	/**
	 * Get the shoe brand used by the athlete.
	 * 
	 * @return The brand name of the shoes.
	 */
	public String getShoeBrand()
	{
		return _shoeBrand;
	}
	
	/**
	 * Sets the brand of shoes used.
	 * 
	 * @param newShoeBrand		Sets the new shoe brand used by the athlete.
	 */
	public void setShoeBrand(String newShoeBrand)
	{
		_shoeBrand = newShoeBrand;
	}
}
