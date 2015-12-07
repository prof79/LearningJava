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
	private RacingAthlete _ra;
	
	// Person
	protected String _name = "Hugo";
	protected int _age = 97;
	
	// RaceParticipant
	protected int _id = 4711839;
	
	abstract protected RacingAthlete getDefaultRacingAthlete();
	abstract protected RacingAthlete getSpecificRacingAthlete();
	
	/**
	 * Initial set-up before each test.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		_ra = getDefaultRacingAthlete();
	}
	
	/**
	 * Clean-up after each test.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		_ra = null;
	}
	
	/**
	 * Tests the constructors.
	 */
	@Test
	public void testConstructors()
	{
		assertNotNull("Default RacingAthlete is null", _ra);
	}
		
	/**
	 * Person: Test the name setter/getter.
	 */
	@Test
	public void testSetGetName()
	{
		_ra.setName(_name);
		
		assertEquals("Name is not equal"
						, _name
						, _ra.getName());
	}
	
	/** Person: Test the age setter/getter.
	 * 
	 */
	@Test
	public void testSetGetAge()
	{
		_ra.setAge(_age);
		
		assertEquals("Age is not equal"
						, _age
						, _ra.getAge());
	}
	
	/**
	 * RaceParticipant: Test the contestantID setter/getter.
	 */
	@Test
	public void testSetGetContestantID()
	{
		_ra.setContestantID(_id);
		
		assertEquals("ID doesn't match"
						, _id
						, _ra.getContestantID());
	}
	
	/**
	 * RaceParticipant: Wrapper to test the (abstract) peformRaceActivity() method.
	 */
	public void testPerformRaceActivity(String expectedActivityName)
	{
		assertEquals("Race activity doesn't match"
						, expectedActivityName
						, _ra.performRaceActivity());
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
		// Class
		
		assertTrue("Does not contain class name"
						, _ra.toString().contains(_ra.getClass().getSimpleName()));
		
		// Person Interface
		
		_ra.setName(_name);
		_ra.setAge(_age);
		
		assertTrue("Does not contain name"
						, _ra.toString().contains(_name));
		
		assertTrue("Does not contain age"
						, _ra.toString().contains(Integer.toString(_age)));
		
		// RaceParticipant Interface
		
		_ra.setContestantID(_id);
		
		assertTrue("Does not contain ID"
						, _ra.toString().contains(Integer.toString(_id)));
	}
}
