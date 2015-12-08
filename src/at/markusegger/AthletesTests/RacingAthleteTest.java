/**
 * 
 */
package at.markusegger.AthletesTests;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import at.markusegger.AthletesBasic.*;

/**
 * Tests the RacingAthlete class.
 * 
 * @author MarkusME
 * @version 0.8
 */
abstract public class RacingAthleteTest
{
	// Tested Class
	private RacingAthlete defaultAthlete;
	private RacingAthlete specificAthlete;
	
	// Person
	private String _defaultName = "Tony";
	private int _defaultAge = 39;
	protected String _name = "Hugo";
	protected int _age = 97;
	
	// RaceParticipant
	private int _defaultID = 830111309;
	protected int _id = 4711839;
	
	abstract protected RacingAthlete getDefaultRacingAthlete();
	abstract protected RacingAthlete getSpecificRacingAthlete();
	
	/**
	 * Default parameterless constructor.
	 */
	public RacingAthleteTest()
	{
		defaultAthlete = getDefaultRacingAthlete();
		
		specificAthlete = getSpecificRacingAthlete();
	}
	
	/**
	 * Initial set-up before each test.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{
	}
	
	/**
	 * Clean-up after each test.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception
	{
	}
	
	/**
	 * Tests the constructors.
	 */
	@Test
	public void testConstructors()
	{
		assertNotNull("Default RacingAthlete is null", defaultAthlete);
		
		assertEquals("Specific RacingAthlete: Name not matching"
						, _name
						, specificAthlete.getName()
						);
		
		assertEquals("Specific RacingAthlete: Age not matching"
						, _age
						, specificAthlete.getAge()
						);
		
		assertEquals("Specific RacingAthlete: Contestant ID not matching"
						, _id
						, specificAthlete.getContestantID()
						);
	}
		
	/**
	 * Person: Test the name setter/getter.
	 */
	@Test
	public void testSetGetName()
	{
		defaultAthlete.setName(_defaultName);
		
		assertEquals("Name is not set properly"
						, _defaultName
						, defaultAthlete.getName()
						);
	}
	
	/** Person: Test the age setter/getter.
	 * 
	 */
	@Test
	public void testSetGetAge()
	{
		defaultAthlete.setAge(_defaultAge);
		
		assertEquals("Age is not set properly"
						, _defaultAge
						, defaultAthlete.getAge()
						);
	}
	
	/**
	 * RaceParticipant: Test the contestantID setter/getter.
	 */
	@Test
	public void testSetGetContestantID()
	{
		defaultAthlete.setContestantID(_defaultID);
		
		assertEquals("ID is not set properly"
						, _defaultID
						, defaultAthlete.getContestantID()
						);
	}
	
	/**
	 * RaceParticipant: Wrapper to test the (abstract) peformRaceActivity() method.
	 */
	public void testPerformRaceActivity(String expectedActivityName)
	{
		assertEquals("Race activity is not set properly"
						, expectedActivityName
						, defaultAthlete.performRaceActivity()
						);
	}
	
	/**
	 * RaceParticipant: Test the performRaceActivity() method.
	 * To be implemented in subclass using the wrapper.
	 */
	@Test
	abstract public void testPerformRaceActivity();
	
	/**
	 * Tests the RacingAthlete.toString() method.
	 */
	@Test
	public void testToString()
	{
		// Preparations
		
		defaultAthlete.setName(_defaultName);
		defaultAthlete.setAge(_defaultAge);
		
		defaultAthlete.setContestantID(_defaultID);
		
		String athleteString = defaultAthlete.toString();
		
		// Class
		
		assertTrue("Does not contain class name"
						, athleteString.contains(defaultAthlete.getClass().getSimpleName())
						);
		
		// Person Interface
				
		assertTrue("Does not contain name"
						, athleteString.contains(_defaultName));
		
		assertTrue("Does not contain age"
						, athleteString.contains(Integer.toString(_defaultAge))
						);
		
		// RaceParticipant Interface
				
		assertTrue("Does not contain ID"
						, athleteString.contains(Integer.toString(_defaultID))
						);
	}
}
