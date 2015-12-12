/**
 * 
 */
package at.markusegger.RaceManagerSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import at.markusegger.Utilities.Utilities;
import at.markusegger.RaceManagerObjects.*;
import at.markusegger.RaceManagerSearch.*;
import at.markusegger.RaceManagerData.*;

/**
 * This is the main part and console GUI for the race manager.
 * 
 * @author MarkusME
 * @version 1.2
 */
public class Program
{
	static final private int lineWidth = 80;
	static final private String stars = Utilities.repeatStar(lineWidth);
	static final private String title = "Markus' Java Race Manager";
	static final private Scanner scanner = new Scanner(System.in);
	static private boolean quitFlag = false;
	static private MyRaceManager raceManager;
	
	static private int minMenuID;
	static private int maxMenuID;
	
	/**
	 * This is the main entry point for the race manager application.
	 * 
	 * @param args		The command-line arguments (unused)
	 */
	public static void main(String[] args)
	{
		printHeader();
		
		while (!quitFlag)
		{
			printMenu();
			handleInput(getInput());			
		}
	}

	/**
	 * Retrieves a menu choice from keyboard.
	 * Menu items are unsigned integers, e. g. 1 to 7.
	 * 
	 * @return The choice of the user as an integer
	 */
	static private int getInput()
	{
		return Utilities.readIntFromKeyboard("Your choice: ", minMenuID, maxMenuID);
	}

	/**
	 * Let the user specify an athlete type by keyboard.
	 * 
	 * @return	The specific RacingAthlete class type
	 */
	static private Class<?> getAthleteTypeInput()
	{
		boolean validType = false;
		String type;
		Class<?> result = null;
		
		while (!validType)
		{
			System.out.print("Choose a kind of athlete: Biker, Runner, Swimmer [b, r, s]? ");
			
			type = scanner.nextLine().trim();
			
			if (!type.isEmpty())
			{
				char first = type.toLowerCase().charAt(0);
				
				switch (first)
				{
					case 'b':
						// Biker selected
						result = Biker.class;
						validType = true;
						break;
						
					case 'r':
						// Runner selected
						result = Runner.class;
						validType = true;
						break;
						
					case 's':
						// Swimmer selected
						result = Swimmer.class;
						validType = true;
						break;
						
					default:
						break;
				}
			}
		}
		
		return result;
	}
	
	/**
	 * Prints the application's title.
	 */
	static private void printHeader()
	{
		System.out.println(stars);
		
		System.out.println(String.format("*** %-" + (lineWidth - 8) + "s ***", title.toUpperCase()));
	}
	
	/**
	 * Print a sub-header.
	 * 
	 * @param caption	The sub-header's name
	 */
	static private void printSubheader(String caption)
	{
		System.out.println(stars);
		System.out.println(caption.trim().toUpperCase());
		System.out.println(stars);
		System.out.println();
	}
	
	/**
	 * Print the application menu/available choices.
	 */
	static private void printMenu()
	{
		System.out.println(stars);
		System.out.println("Enter 1 to create a new race");
		System.out.println("Enter 2 to add a new racer");
		System.out.println("Enter 3 to remove a racer");
		System.out.println("Enter 4 to find a racer");
		System.out.println("Enter 5 to get the winner");
		System.out.println("Enter 6 to list the racers");
		System.out.println("Enter 7 to get infos about the race");
		System.out.println("Enter 8 to clear the roster of racers");
		System.out.println("Enter 9 to load racers from file");
		System.out.println("Enter 10 to save racers to file");
		System.out.println("Enter 11 to quit");
		System.out.println(stars);
		
		minMenuID = 1;
		maxMenuID = 11;
	}
	
	/**
	 * Print the find sub-menu
	 */
	static private void printFindMenu()
	{
		System.out.println(stars);
		System.out.println("Enter 1 to search by partial name");
		System.out.println("Enter 2 to search by contestant ID");
		System.out.println("Enter 3 to search by athlete type");
		System.out.println(stars);
	}
	
	/**
	 * This method handles the choice the user made.
	 * 
	 * @param choice		The number of the menu item chosen
	 */
	static private void handleInput(int choice)
	{
		System.out.println();
		
		switch (choice)
		{
			case 1:
				// Create a race
				createRace();
				break;
				
			case 2:
				// Add a new racer
				addRacer();
				break;
				
			case 3:
				// Remove a racer
				removeRacer();
				break;
				
			case 4:
				// Find a racer
				findRacer();
				break;
				
			case 5:
				// Get the winner
				getWinner();
				break;
				
			case 6:
				// List the racers
				listRacers();
				break;
				
			case 7:
				// Race info
				raceInfo();
				break;
			
			case 8:
				// Clear racers
				clearRacers();
				break;
				
			case 9:
				// Load racers from file
				loadRacersFromFile();
				break;
				
			case 10:
				// Save racers to file
				saveRacersToFile();
				break;
				
			case 11:
				// Quit
				quitFlag = true;
				System.out.println("Exiting ...");
				break;
			
			default:
				throw new IllegalArgumentException(
						String.format("Invalid menu choice %d in %s"
								, choice
								, "handleInput()"));
		}
	}

	/**
	 * Clears (removes) all racers from the roster.
	 * TODO: Interactively ask before
	 */
	private static void clearRacers()
	{
		printSubheader("Clear Roster");
		
		raceManager.removeAllRacers();
		
		System.out.println("All racers have been removed from race.");
		
		System.out.println();
	}

	/**
	 * Save racers to file.
	 * TODO: Interactively ask before
	 */
	private static void saveRacersToFile()
	{
		printSubheader("Save Racers");
		
		try
		{
			RaceFileManager.saveAthletesToFile(
					raceManager.getRacerList(),
					DataFile.PATH);
			
			System.out.println("Racers successfully saved.");
		}
		catch (NullPointerException | IOException e)
		{
			System.out.println("Sorry, there was a problem while saving the racers:");
			
			e.printStackTrace();
		}
		
		System.out.println();
	}

	/**
	 * Load racers from file.
	 * 
	 * 	TODO: Interactively ask before
	 */
	private static void loadRacersFromFile()
	{
		printSubheader("Load Racers");
		
		try
		{
			ArrayList<RacingAthlete> athletes =
					RaceFileManager.loadAthletesFromFile(DataFile.PATH);
			
			// TODO: We need "removeAllRacers" and "addRacers"
			for (RacingAthlete a : athletes)
			{
				raceManager.addRacer(a);
			}
			
			System.out.println("Racers successfully loaded.");
		}
		catch (NullPointerException | IllegalArgumentException | IOException e)
		{
			System.out.println("Sorry, couldn't load racers from file:");
			
			e.printStackTrace();
		}
		
		System.out.println();
	}

	/**
	 * Creates a new Race.
	 */
	private static void createRace()
	{
		raceManager = new MyRaceManager();
		
		String eventName, eventLocation;
		double raceDistance;
		
		printSubheader("Create a race");
		
		System.out.print("Event name: ");
		eventName = scanner.nextLine().trim();
		
		System.out.print("Event location: ");
		eventLocation = scanner.nextLine().trim();
		
		raceDistance = Utilities.readDoubleFromKeyboard("Race distance (km): ", Double.MIN_VALUE, Double.MAX_VALUE); 
		
		raceManager.setName(eventName);
		raceManager.setLocation(eventLocation);
		raceManager.setDistance(raceDistance);
		
		System.out.println(
				String.format("\nRace '%s' created.\n", eventName));
	}
	
	/**
	 * Add a racer to the race.
	 */
	private static void addRacer()
	{
		if (!checkRace())
		{
			return;
		}
		
		RacingAthlete athlete = null;
		boolean validType = false;
		String type;
		String name;
		int age;
		
		printSubheader("Add racer");
		
		Class<?> classType = getAthleteTypeInput();
		
		try
		{
			athlete = (RacingAthlete) classType.newInstance();	
		}
		catch (InstantiationException e)
		{
			e.printStackTrace();
		}
		catch (IllegalAccessException e)
		{
			e.printStackTrace();
		}
				
		do
		{
			System.out.print("What is the name of the athlete? ");
			name = scanner.nextLine().trim();
		}
		while (name.isEmpty());
		
		age = Utilities.readIntFromKeyboard("How old is the athlete? ", 1, 300);
		
		if (athlete == null)
		{
			throw new NullPointerException("athlete should not have been null");
		}

		athlete.setName(name);
		athlete.setAge(age);
		
		if (athlete instanceof Biker)
		{
			Biker biker = (Biker) athlete;
			boolean validClips = false;
			String clipsStr;
			
			while (!validClips)
			{
				System.out.print("Is the biker using clips? (y/n) ");
				
				clipsStr = scanner.nextLine().trim();
				
				if (!clipsStr.isEmpty())
				{
					char first = clipsStr.toLowerCase().charAt(0);
					
					switch (first)
					{
						case 'y':
							biker.setUsingClips(true);
							validClips = true;
							break;
							
						case 'n':
							biker.setUsingClips(false);
							validClips = true;
							break;
							
						default:
							break;
					}
				}
			}
			
		}
		else if (athlete instanceof Runner)
		{
			Runner runner = (Runner) athlete;
			String shoeBrand;
			
			System.out.print("What shoe brand does the runner use? ");
			
			shoeBrand = scanner.nextLine().trim();
			
			runner.setShoeBrand(shoeBrand);				
		}
		
		System.out.println();
		
		if (raceManager.addRacer(athlete))
		{
			System.out.println(String.format("Racer %s added successfully.", name));
		}
		else
		{
			System.out.println(String.format("Athlete %s could not be added to the race!", name));
		}
		
		System.out.println();
	}

	/**
	 * Remove a racer from the race.
	 */
	private static void removeRacer()
	{
		if (!checkRacers())
		{
			return;
		}
		
		String name;
		RacingAthlete athlete;
		
		printSubheader("Remove racer");
		
		System.out.print("What is the name of the racer you want to remove? ");
		
		name = scanner.nextLine().trim();
		
		athlete = raceManager.getRacer(name);
		
		System.out.println();
		
		if (athlete == null)
		{
			System.out.println(String.format("Sorry, athlete %s could not be found!", name));
		}
		else
		{
			boolean result = raceManager.removeRacer(name);
			
			if (result)
			{
				System.out.println(String.format("Athlete %s has been removed.", name));
			}
			else
			{
				System.out.println(
						String.format("There was a technical error removing the athlete %s! Please contact the developer."
								, name));
			}
		}
		
		System.out.println();
	}

	/**
	 * Find an athlete by name.
	 */
	private static void findRacer()
	{
		if (!checkRacers())
		{
			return;
		}

		printSubheader("Find racer");

		printFindMenu();
		
		int choice = Utilities.readIntFromKeyboard("Your choice: ", 1, 3);
		
		System.out.println();
		
		switch (choice)
		{
			case 1:
				findByPartialName();
				break;
				
			case 2:
				findByContestantID();
				break;
				
			case 3:
				findByAthleteType();
				break;
				
			default:
				break;
		}
	}

	/**
	 * Find an athlete by type
	 */
	private static void findByAthleteType()
	{
		Class<?> classType = getAthleteTypeInput();
		
		AthleteFinder af = new AthleteFinderByType(classType);
		
		findWorker(af);
	}

	/**
	 * Find an athlete by contestant ID
	 */
	private static void findByContestantID()
	{
		int searchedID;
		
		searchedID = Utilities.readIntFromKeyboard("Enter a contestant ID: "
				, 1
				, MyRaceManager.MAX_ID);
		
		AthleteFinder af = new AthleteFinderByContestantID(searchedID);
		
		findWorker(af);
	}

	/**
	 * Find an athlete by partial name match
	 */
	private static void findByPartialName()
	{
		String searchPhrase;
		
		System.out.print("Enter a part of the name: ");
		
		do
		{
			searchPhrase = scanner.nextLine();
		}
		while (searchPhrase.isEmpty());
		
		AthleteFinder af = new AthleteFinderByPartialName(searchPhrase);
		
		findWorker(af);
	}

	/**
	 * The worker method to perform a search using an AthleteFinder.
	 * 
	 * @param af	The AthleteFinder predicate for searching
	 */
	private static void findWorker(AthleteFinder af)
	{
		boolean atLeastOneMatch = false;
		
		RacingAthlete[] racers = raceManager.getRacers();
		
		System.out.println();
		
		for (RacingAthlete a : racers)
		{
			if (af.searchForAthlete(a))
			{
				atLeastOneMatch = true;
				
				System.out.println(a.toString());
			}
		}
		
		if (!atLeastOneMatch)
		{
			System.out.println("No athlete found.");
		}
		
		System.out.println();
	}
	
	/**
	 * Get the winner of the race.
	 */
	private static void getWinner()
	{
		if (!checkRacers())
		{
			return;
		}
		
		printSubheader("Winning ceremony");
		
		System.out.println(raceManager.toString());
		System.out.println();
		
		RacingAthlete athlete = raceManager.getWinner();
		
		System.out.println("... and the winner is: " + athlete.getName());
		System.out.println();
	}

	/**
	 * List all the athletes participating in the race.
	 */
	private static void listRacers()
	{
		if (!checkRacers())
		{
			return;
		}
		
		printSubheader("Racer list");
		
		RacingAthlete[] athletes = raceManager.getRacers();
		
		for(RacingAthlete a : athletes)
		{
			System.out.println(a.toString());
		}
		
		System.out.println();
	}

	
	/**
	 * Get infos about the race.
	 */
	private static void raceInfo()
	{
		printSubheader("Race info");
		
		System.out.println(raceManager.toString());
		System.out.println();
	}
	
	/**
	 * Validates that a race has been created.
	 */
	private static boolean checkRace()
	{
		if (raceManager == null)
		{
			System.out.println("You need to create a race first!\n");
			
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * Validates that there are any participants.
	 */
	private static boolean checkRacers()
	{
		if (checkRace())
		{
			if (raceManager.getCurrentNumberOfRacers() == 0)
			{
				System.out.println("You need to add some racers first!\n");
				
				return false;
			}
			else
			{
				return true;
			}
		}
		
		return false;
	}
}
