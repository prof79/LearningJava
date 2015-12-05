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
	 * @param name				The name of the Athlete.
	 */
	public Runner(int contestantID, String name)
	{
		setContestantID(contestantID);
		setName(name);
	}
	
	/** (non-Javadoc)
	 * @see at.markusegger.AthletesBasic.RaceParticipant#performRaceActivity()
	 */
	public String performRaceActivity()
	{
		return "Running";
	}
}
