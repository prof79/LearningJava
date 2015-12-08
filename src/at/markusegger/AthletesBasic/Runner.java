/**
 * 
 */
package at.markusegger.AthletesBasic;

/**
 * Runner is one type of athlete.
 * 
 * @author MarkusME
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
	 * @param age				The age of the athlete.
	 * @param shoeBrand			The brand of shoes used by the athlete.
	 */
	public Runner(String name, int age, int contestantID, String shoeBrand)
	{
		super(name, age, contestantID);
		
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
	
	@Override
	public String toString()
	{
		// Shoes should only be mentioned when set.
		return getShoeBrand() == null
					? super.toString()
					: String.format("%s using shoes: %s"
									, super.toString()
									, _shoeBrand);
	}
}
