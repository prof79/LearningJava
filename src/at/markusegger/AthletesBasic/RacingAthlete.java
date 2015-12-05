/**
 * 
 */
package at.markusegger.AthletesBasic;

/**
 * This is the racing athlete base class.
 * @author MarkusME
 *
 */
abstract public class RacingAthlete implements RaceParticipant
{
	int _contestantID;
	String _name;
	
	/**
	 * Default parameterless constructor.
	 */
	public RacingAthlete()
	{
	}
	
	/**
	 * Explicit constructor.
	 * 
	 * @param contestantID		The contestant ID.
	 * @param name				The name of the athlete.
	 */
	public RacingAthlete(int contestantID, String name)
	{
		_contestantID = contestantID;
		_name = name;
	}
	
	/**
	 * Retrieves the contestant ID.
	 * @return Returns the contestant ID.
	 */
	public int getContestantID()
	{
		return _contestantID;
	}
	
	/**
	 * Sets the contestant ID.
	 * @param newContestantID	The contestant ID of the athlete. 
	 */
	public void setContestantID(int newContestantID)
	{
		_contestantID = newContestantID;
	}
	
	/**
	 * Retrieves the athlete's name.
	 * @return The name of the athlete.
	 */
	public String getName()
	{
		return _name;
	}
	
	/**
	 * Sets the athlete's name.
	 * @param newName	The athlete's name.
	 */
	public void setName(String newName)
	{
		_name = newName;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s: %s with ID %d is %s"
								, getClass().getName()
								, getName()
								, getContestantID()
								, performRaceActivity());
	}
}
