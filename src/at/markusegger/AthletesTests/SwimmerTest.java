/**
 * 
 */
package at.markusegger.AthletesTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import at.markusegger.AthletesBasic.RacingAthlete;
import at.markusegger.AthletesBasic.Swimmer;

/**
 * @author MarkusME
 *
 * Test cases for the Swimmer class. 
 */
public class SwimmerTest extends RacingAthleteTest
{
	Swimmer swimmer1;
	
	String _activity = "Swimming";
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		swimmer1 = (Swimmer) getDefaultRacingAthlete();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		swimmer1 = null;
	}

	/**
	 * Test the constructors of Swimmer.
	 */
	@Test
	public void testConstructors()
	{
		super.testConstructors();
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
				
		assertTrue("Activity not contained in string"
						, swimmer1.toString().contains(_activity));
	}

	@Override
	protected RacingAthlete getDefaultRacingAthlete()
	{
		return new Swimmer();
	}

	@Override
	protected RacingAthlete getSpecificRacingAthlete()
	{
		return new Swimmer(_name, _age, _id);
	}
}
