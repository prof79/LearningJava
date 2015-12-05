/**
 * 
 */
package at.markusegger.AthletesBasic;

/**
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

	/** (non-Javadoc)
	 * @see at.markusegger.AthletesBasic.RaceParticipant#performRaceActivity()
	 */
	public String performRaceActivity()
	{	
		return "Swimming";
	}
}
