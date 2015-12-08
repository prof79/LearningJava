/**
 * 
 */
package at.markusegger.RaceManagerObjects;

/**
 * This is the racing athlete base class.
 * 
 * @author MarkusME
 * @version 0.8
 */
abstract public class RacingAthlete implements Person, RaceParticipant
{
	// Person
	private String _name;
	private int _age;
	// RaceParticipant
	private int _contestantID;
	
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
	 * @param age				The age of the athlete.
	 */
	public RacingAthlete(String name, int age, int contestantID)
	{
		// Person
		_name = name;
		_age = age;
		
		// RaceParticipant
		_contestantID = contestantID;
	}
	
	/**
	 * Retrieves the athlete's name.
	 * 
	 * @return The name of the athlete.
	 */
	public String getName()
	{
		return _name;
	}
	
	/**
	 * Sets the athlete's name.
	 * 
	 * @param newName	The athlete's name.
	 */
	public void setName(String newName)
	{
		_name = newName;
	}
	
	/**
	 * Retrieves the athlete's age.
	 * 
	 * @return The age of the athlete.
	 */
	public int getAge()
	{
		return _age;
	}
	
	/**
	 * Sets the athlete's age.
	 * 
	 * @param newAge	The athlete's age.
	 */
	public void setAge(int newAge)
	{
		_age = newAge;
	}
	
	/**
	 * Retrieves the contestant ID.
	 * 
	 * @return Returns the contestant ID.
	 */
	public int getContestantID()
	{
		return _contestantID;
	}
	
	/**
	 * Sets the contestant ID.
	 * 
	 * @param newContestantID	The contestant ID of the athlete. 
	 */
	public void setContestantID(int newContestantID)
	{
		_contestantID = newContestantID;
	}
	
	@Override
	public String toString()
	{
		return String.format("%-10s] Name: %-10s Age: %3d ID: %10d Discipline: %s"
								, getClass().getSimpleName()
								, getName()
								, getAge()
								, getContestantID()
								, performRaceActivity()
								);
	}
}
