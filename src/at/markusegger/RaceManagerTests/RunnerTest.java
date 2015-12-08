package at.markusegger.RaceManagerTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import at.markusegger.RaceManagerObjects.*;

/**
 * Tests for the Runner class.
 * 
 * @author MarkusME
 *
 */
public class RunnerTest extends RacingAthleteTest
{
	Runner runner1;

	String _activity = "Running";
	
	String _shoes = "New Balance";
	
	/**
	 * Setup for each test case.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		runner1 = new Runner();
	}

	/**
	 * Clean up after each test case.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		runner1 = null;
	}
	
	/**
	 * Tests the constructors.
	 */
	@Test
	public void testConstructors()
	{
		super.testConstructors();
		
		Runner specificRunner = (Runner) getSpecificRacingAthlete();
		
		assertNotNull("Specific Runner is null", specificRunner);
		
		assertEquals("Specific Runner constructor: name"
						, _name
						, specificRunner.getName());
		
		assertEquals("Specific Runner constructor: age"
						, _age
						, specificRunner.getAge());
		
		assertEquals("Specific Runner constructor: id"
						, _id
						, specificRunner.getContestantID());
		
		assertEquals("Specific Runner constructor: shoeBrand"
						, _shoes
						, specificRunner.getShoeBrand());
	}
	
	/**
	 * Tests the performRaceActivity() method.
	 */
	@Override
	public void testPerformRaceActivity()
	{
		super.testPerformRaceActivity(_activity);		
	}
	
	@Test
	public void testToString()
	{
		super.testToString();
		
		runner1.setShoeBrand(_shoes);
				
		assertTrue("Activity not found in string"
						, runner1.toString().contains(_activity));
		
		assertTrue("Shoes not found in string"
						, runner1.toString().contains(_shoes));
	}

	@Override
	protected RacingAthlete getDefaultRacingAthlete()
	{
		return new Runner();
	}

	@Override
	protected RacingAthlete getSpecificRacingAthlete()
	{
		return new Runner(_name, _age, _id, _shoes);
	}
}