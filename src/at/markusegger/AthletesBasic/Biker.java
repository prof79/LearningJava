/**
 * 
 */
package at.markusegger.AthletesBasic;

/**
 * @author MarkusME
 *
 */
public class Biker implements RaceParticipant
{
	int _id;
	
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
}
