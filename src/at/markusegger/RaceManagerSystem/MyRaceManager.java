/**
 * 
 */
package at.markusegger.RaceManagerSystem;

import java.util.ArrayList;
import java.util.Random;

import at.markusegger.RaceManagerObjects.RacingAthlete;
import at.markusegger.Utilities.Utilities;

/**
 * A concrete race manager implementation.
 * This class manages a named event in a certain location and its participants.
 * 
 * @author MarkusME
 * @version 0.1
 */
public class MyRaceManager implements Race
{
	private String _raceName;
	private double _raceDistance;
	private String _raceLocation;
	private Random _rand;
	private int _nextID;
	
	ArrayList<RacingAthlete> _athletes;
	
	/**
	 * Default parameterless constructor.
	 */
	public MyRaceManager()
	{
		_rand = new Random();
		
		_nextID = _rand.nextInt(999999);
		
		_athletes = new ArrayList<RacingAthlete>();
	}
	
	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSystem.Race#getName()
	 */
	@Override
	public String getName()
	{
		return _raceName;
	}

	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSystem.Race#setName(java.lang.String)
	 */
	@Override
	public void setName(String name)
	{
		_raceName = name;
	}

	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSystem.Race#getDistance()
	 */
	@Override
	public double getDistance()
	{
		return _raceDistance;
	}

	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSystem.Race#setDistance(double)
	 */
	@Override
	public void setDistance(double distance)
	{
		_raceDistance = distance;
	}

	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSystem.Race#getLocation()
	 */
	@Override
	public String getLocation()
	{
		return _raceLocation;
	}

	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSystem.Race#setLocation(java.lang.String)
	 */
	@Override
	public void setLocation(String location)
	{
		_raceLocation = location;
	}

	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSystem.Race#addRacer(at.markusegger.RaceManagerObjects.RacingAthlete)
	 */
	@Override
	public boolean addRacer(RacingAthlete athlete)
	{
		// TODO: For the time being, we only allow participants with unique names.
		if (getRacer(athlete.getName()) != null)
		{
			return false;
		}
		
		// We mustn't forget the contestant ID.
		athlete.setContestantID(_nextID++);
		
		return _athletes.add(athlete);
	}

	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSystem.Race#removeRacer(java.lang.String)
	 */
	@Override
	public boolean removeRacer(String name)
	{
		// Can't remove from an empty list.
		if (getCurrentNumberOfRacers() == 0)
		{
			return false;
		}
		
		RacingAthlete athlete = getRacer(name);
		
		if (athlete == null)
		{
			return false;
		}
		else
		{
			return _athletes.remove(athlete);
		}
	}

	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSystem.Race#getCurrentNumberOfRacers()
	 */
	@Override
	public int getCurrentNumberOfRacers()
	{
		return _athletes.size();
	}

	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSystem.Race#getRacer(java.lang.String)
	 */
	@Override
	public RacingAthlete getRacer(String name)
	{
		for (RacingAthlete a : _athletes)
		{
			if (Utilities.nullSafeEquals(a.getName().toLowerCase(), name.toLowerCase()))
			{
				return a;
			}
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSystem.Race#getRacers()
	 */
	@Override
	public RacingAthlete[] getRacers()
	{
		// Stupid, stupid ArrayList! (Non-generic toArray())
		RacingAthlete[] athleteArray = new RacingAthlete[_athletes.size()];
		
		for (int i = 0; i < _athletes.size(); ++i)
		{
			athleteArray[i] = _athletes.get(i);
		}
		
		return athleteArray;
	}

	/* (non-Javadoc)
	 * @see at.markusegger.RaceManagerSystem.Race#getWinner()
	 */
	@Override
	public RacingAthlete getWinner()
	{
		int numberOfRacers = getCurrentNumberOfRacers();
		
		if (numberOfRacers > 0)
		{
			int winnerIndex = _rand.nextInt(numberOfRacers);
			
			return _athletes.get(winnerIndex);
		}
		else
		{
			return null;
		}
	}
	
	@Override
	public String toString()
	{
		return String.format("Race event: %s\nLocation: %s\nDistance: %.2f km"
				, getName()
				, getLocation()
				, getDistance()
				);
	}
}