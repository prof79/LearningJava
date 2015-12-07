/**
 * 
 */
package at.markusegger.AthletesBasic;

/**
 * @author MarkusME
 *
 * Biker is another type of athlete.
 */
public class Biker implements RaceParticipant, Person
{
	int _id;
	String _name;
	int _age;
	boolean _usingClips;
	
	/* (non-Javadoc)
	 * @see at.markusegger.AthletesBasic.RaceParticipant#getContestantID()
	 */
	@Override
	public int getContestantID()
	{
		return _id;
	}

	/* (non-Javadoc)
	 * @see at.markusegger.AthletesBasic.RaceParticipant#setContestantID(int)
	 */
	@Override
	public void setContestantID(int newContestantID)
	{
		_id = newContestantID;
	}

	/* (non-Javadoc)
	 * @see at.markusegger.AthletesBasic.RaceParticipant#performRaceActivity()
	 */
	@Override
	public String performRaceActivity()
	{
		return "Biking";
	}

	@Override
	public String getName()
	{
		return _name;
	}

	@Override
	public void setName(String newName)
	{
		_name = newName;
	}

	@Override
	public int getAge()
	{
		return _age;
	}

	@Override
	public void setAge(int newAge)
	{
		_age = newAge;
	}
	
	@Override
	public String toString()
	{		
		return String.format("%s: %s with ID %d is %s. Using clips? %b"
								, getClass().getName()
								, getName()
								, getContestantID()
								, performRaceActivity()
								, getUsingClips());
	}
	
	/**
	 * Getter for using clips property.
	 * 
	 * @return	Does the biker use clips?
	 */
	public boolean getUsingClips()
	{
		return _usingClips;
	}
	
	/**
	 * Setter for clip usage.
	 * 
	 * @param usingClips	Biker is using clips?
	 */
	public void setUsingClips(boolean usingClips)
	{
		_usingClips = usingClips;
	}
}
