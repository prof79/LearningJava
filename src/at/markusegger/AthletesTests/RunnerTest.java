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
public class RunnerTest
{
	Runner r;
	int id = 47118181;
	String activity = "Running";
	String name = "Gwen";
	
	/**
	 * Setup for each test case.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		r = new Runner();
	}

	/**
	 * Clean up after each test case.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		r = null;
	}

	@Test
	public void testRunnerID()
	{
		r.setContestantID(id);
		
		assertEquals("Runner ID not set as expected"
							, id
							, r.getContestantID());
	}
	
	@Test
	public void testRunnerActivity()
	{
		assertEquals("Runner.performRaceActivity() does not contain activity '" + activity + "'"
							, true
							, r.performRaceActivity().contains(activity));
	}
}
