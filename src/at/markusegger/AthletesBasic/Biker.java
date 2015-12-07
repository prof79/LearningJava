/**
 * 
 */
package at.markusegger.AthletesBasic;

/**
 * @author MarkusME
 *
 * Biker is another type of athlete.
 */
public class Biker extends RacingAthlete
{
	boolean _usingClips;
	
	/**
	 * Parameterless constructor
	 */
	public Biker()
	{
		super();
	}
	
	/* (non-Javadoc)
	 * @see at.markusegger.AthletesBasic.RaceParticipant#performRaceActivity()
	 */
	@Override
	public String performRaceActivity()
	{
		return "Biking";
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
	
	/**
	 * Human-readable output of the Biker instance.
	 * 
	 * @return A String describing the Biker instance.
	 */
	@Override
	public String toString()
	{		
		return String.format("%s Using clips? %b"
								, super.toString()
								, getUsingClips());
	}	
}