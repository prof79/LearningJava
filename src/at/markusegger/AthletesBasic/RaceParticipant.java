/**
 * 
 */
package at.markusegger.AthletesBasic;

/**
 * @author MarkusME
 *
 */
public interface RaceParticipant
{
	/*
	 * Retrieves the contestant ID.
	 * @return int		Returns the contestant ID.
	 */
	int getContestantID();
	
	/*
	 * Sets the contestant ID.
	 * @param int newContestantID		The contestant ID of the athlete. 
	 */
	void setContestantID(int newContestantID);
	
	String performRaceActivity();

}
