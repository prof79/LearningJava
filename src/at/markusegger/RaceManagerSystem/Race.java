/**
 * 
 */
package at.markusegger.RaceManagerSystem;

import at.markusegger.RaceManagerObjects.RacingAthlete;

/**
 * The interface for a race manager class.
 * 
 * @author MarkusME
 * @version 1.0
 */
public interface Race
{
	/**
	 * 
	 * @return The name of the race event
	 */
	String getName();
	/**
	 * Set the name of the race event.
	 * 
	 * @param name	The race's name
	 */
	void setName(String name);
	
	/**
	 * 
	 * @return The race distance in kilometers
	 */
	double getDistance();
	/**
	 * Set the race distance.
	 * 
	 * @param distance	The distance in kilometers
	 */
	void setDistance(double distance);
	
	/**
	 * 
	 * @return The location of the race event
	 */
	String getLocation();
	/**
	 * Set the race event location.
	 * 
	 * @param location	The race's location
	 */
	void setLocation(String location);
	
	/**
	 * Add a race participant.
	 * 
	 * @param athlete	The racer to add
	 * @return True if successful otherwise false
	 */
	boolean addRacer(RacingAthlete athlete);
	/**
	 * Remove a racer from the contest.
	 * 
	 * @param name		The name of the athlete to remove
	 * @return True if the racer could be removed otherwise false
	 */
	boolean removeRacer(String name);
	
	/**
	 * 
	 * @return The number of contestants in the race
	 */
	int getCurrentNumberOfRacers();
	
	/**
	 * Retrieve a certain racer by name.
	 * 
	 * @param name	The name of the athlete you are looking for
	 * @return The athlete object or null if the athlete could not be found
	 */
	RacingAthlete getRacer(String name);
	
	/**
	 * Get all participants in the race.
	 * 
	 * @return An array of racing athletes
	 */
	RacingAthlete[] getRacers();
	
	/**
	 * 
	 * @return The athlete that has won the race
	 */
	RacingAthlete getWinner();
}
