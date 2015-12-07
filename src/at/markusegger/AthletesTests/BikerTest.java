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
	Biker biker1;
	
	String name = "Peter";
	int age = 28;
	
	int id = 18733246;
	String activity = "Biking";
	
	boolean usingClips = true;
	
	/**
	 * Setup for each test case.
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		biker1 = new Biker();
	}

	/**
	 * Clean up after each test case.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception
	{
		biker1 = null;
	}

	/**
	 * Test the constructors of the Biker class.
	 */
	@Test
	public void testConstructors()
	{
		assertNotNull("Default constructor returned null object"
						, biker1);
		
		//Biker biker2 = new Biker(...);
	}
	
	/**
	 * Tests the contestantID setter/getter.
	 */
	@Test
	public void testBikerID()
	{
		biker1.setContestantID(id);
		
		assertEquals("Biker ID not set as expected"
							, id
							, biker1.getContestantID());
	}
	
	/**
	 * Tests the performRaceActivity() method.
	 */
	@Test
	public void testBikerActivity()
	{
		assertTrue("Biker.performRaceActivity() does not contain activity '" + activity + "'"
							, biker1.performRaceActivity().contains(activity));
	}
	
	/**
	 * Tests the setter/getter for usingClips.
	 */
	@Test
	public void testBikerClips()
	{
		biker1.setUsingClips(usingClips);
		
		assertEquals("Using clips setter/getter not working"
						, usingClips
						, biker1.getUsingClips());
	}
	
	/**
	 * Tests the toString() method.
	 */
	@Test
	public void testToString()
	{
		biker1.setContestantID(id);
		biker1.setName(name);
		
		String bikerString = biker1.toString();
		
		boolean containsActivity = bikerString.contains(activity);
		boolean containsID = bikerString.contains(Integer.toString(id));
		boolean containsName = bikerString.contains(name);
		boolean containsClips = bikerString.toLowerCase().contains("clips");
		
		assertTrue("Biker.toString() lacks information. Is: " + biker1.toString()
						, containsActivity && containsID && containsName && containsClips);
	}
	
	/**
	 * Test the age setter/getter.
	 */
	@Test
	public void testSetGetAge()
	{
		biker1.setAge(age);
		
		assertEquals("Age doesn't match"
						, age
						, biker1.getAge());
	}
}
