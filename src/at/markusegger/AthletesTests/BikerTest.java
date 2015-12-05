package at.markusegger.AthletesTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import at.markusegger.AthletesBasic.*;

/**
 * Tests for the Runner class.
 * 
 * @author MarkusME
 *
 */
public class BikerTest
{
	Biker b;
	int id = 18733246;
	String activity = "Biking";
	String name = "Peter";
	
	/**
	 * Setup for each test case.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		b = new Biker();
	}

	/**
	 * Clean up after each test case.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		b = null;
	}

	@Test
	public void testBikerID()
	{
		b.setContestantID(id);
		
		assertEquals("Biker ID not set as expected"
							, id
							, b.getContestantID());
	}
	
	@Test
	public void testBikerActivity()
	{
		assertEquals("Biker.performRaceActivity() does not contain activity '" + activity + "'"
							, true
							, b.performRaceActivity().contains(activity));
	}
}
