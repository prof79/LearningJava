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
 * @author MarkusME
 *
 */
public class RacingAthleteTest
{
	RacingAthlete _ra;
	String _name = "Hugo";
	int _id = 4711839;
	
	@Before
	public void setUp() throws Exception
	{
		_ra = new RacingAthlete() {
			
			@Override
			public String performRaceActivity() {
				return "abstract";
			}
		};
	}
	
	@After
	public void tearDown() throws Exception
	{
		_ra = null;
	}
	
	@Test
	public void testRacingAthlete()
	{
		assertNotEquals("RacingAthlete not null",_ra, null);
	}
	
	@Test
	public void testSetAndGet()
	{
		_ra.setContestantID(_id);
		
		_ra.setName(_name);
		
		assertEquals("ID is equal", _ra.getContestantID(), _id);
		assertEquals("Name ist equal", _ra.getName(), _name);
	}
}
