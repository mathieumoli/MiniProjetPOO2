package zuul;

import zuul.commands.*;
import zuul.course.*;
import zuul.person.Student;
import zuul.room.*;

import java.util.*;

/**
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game. Users can walk
 * around some scenery. That's all. It should really be extended to make it more
 * interesting!
 * 
 * To play this game, create an instance of this class and call the "play"
 * method.
 * 
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates and executes the
 * commands that the parser returns.
 * 
 * @author Michael Kölling and David J. Barnes
 * @version 2011.08.08
 */

public class Game {
	private Parser parser;
	private Room currentRoom;
	public static ResourceBundle res;
	private Locale locale;
	private Student gamer;
	public static final int NB_COURSES = 4;
	public static List<LabItem> labs = new ArrayList<LabItem>();
	public static List<LectureItem> lectures = new ArrayList<LectureItem>();

	/**
	 * Create the game and initialise its internal map.
	 */
	public Game() {
		parser = new Parser();
		getLanguage();
		res = ResourceBundle.getBundle("zuul.intl.Zuul", locale);
	}

	/**
	 * Ask to the user his prefered language and set it
	 */
	private void getLanguage() {
		System.out
				.println("Voulez-vous jouer en français ? Si oui, appuyez sur 1.");
		System.out
				.println("Or do you prefer playing in English ? If so, press 2.");

		Scanner scanner = new Scanner(System.in);
		int value = scanner.nextInt();

		switch (value) {
		case 1:
			locale = Locale.getDefault();
			break;

		case 2:
		default:
			locale = new Locale("en", "US");
			break;
		}
	}

	/**
	 * Create all the rooms and link their exits together.
	 */
	private void createRooms() {

		// create the rooms
		Lunchroom lunchroom = new Lunchroom(
				res.getString("lunchroom.description"));
		LectureRoom lectureroom = new LectureRoom(
				res.getString("lectureroom.description1"));
		LabRoom labroom = new LabRoom(res.getString("labroom.description1")); // get(0)
																				// uniquement
																				// pour
																				// les
																				// tests
		Corridor corridor1 = new Corridor(
				res.getString("corridor1.description"));
		Corridor corridor2 = new Corridor(
				res.getString("corridor2.description"));
		Library library = new Library(res.getString("library.description"));
		ExamRoom examroom = new ExamRoom(res.getString("examroom.description"));

		// initialise room exits

		corridor1.setExit("west", labroom);
		corridor1.setExit("east", lunchroom);
		corridor1.setExit("north", corridor2);

		corridor2.setExit("south", corridor1);
		corridor2.setExit("west", library);
		corridor2.setExit("east", lectureroom);
		corridor2.setExit("north", examroom);

		labroom.setExit("east", corridor1);

		lunchroom.setExit("west", corridor1);

		library.setExit("east", corridor2);

		lectureroom.setExit("west", corridor2);

		examroom.setExit("south", corridor2);

		currentRoom = corridor1; // start game in the first corridor
	}

	/**
	 * Main play routine. Loops until end of play.
	 */
	public void play() {
		printWelcome();
		createCourses();
		createRooms();
		createGamer();
		printGamer();

		// Enter the main command loop. Here we repeatedly read commands and
		// execute them until the game is over.

		boolean finished = false;
		while (!finished) {
			Command command = parser.getCommand();
			finished = processCommand(command);
		}
		System.out.println(res.getString("game.thankyou"));
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome() {
		System.out.println();
		System.out.println(res.getString("game.welcome"));
		System.out.println(res.getString("game.boring"));
		System.out.println(res.getString("game.help"));
		System.out.println();
	}

	/**
	 * Create the player based on the given name
	 */

	private void createGamer() {
		System.out.println(res.getString("game.askname"));
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		gamer = new Student(name);

	}

	private void printGamer() {
		String string = new String(res.getString("game.welcomename1")
				+ gamer.getName() + res.getString("game.welcomename2")
				+ gamer.getName() + res.getString("game.welcomename3"));
		System.out.println(string);
		System.out.println();
		System.out.println(currentRoom.getLongDescription());
	}

	/**
	 * This method creates the labs and lectures (4 each) for 4 subjects
	 */
	private void createCourses() {
		String courses[] = { "OOP", "C", "ALGO", "SSII" };
		for (int i = 0; i < NB_COURSES; ++i) {
			labs.add(new LabItem(courses[i], i + 1));
			lectures.add(new LectureItem(courses[i], i + 1));
		}
	}

	/**
	 * Given a command, process (that is: execute) the command.
	 * 
	 * @param command
	 *            The command to be processed.
	 * @return true If the command ends the game, false otherwise.
	 */
	private boolean processCommand(Command command) {
		boolean wantToQuit = false;

		if (command.isUnknown()) {
			System.out.println(res.getString("game.idontknow"));
			return false;
		}

		String commandWord = command.getCommandWord();
		if (commandWord.equals("help")) {
			printHelp();
		} else if (commandWord.equals("go")) {
			goRoom(command);
		} else if (commandWord.equals("quit")) {
			wantToQuit = quit(command);
			// crée des methodes à partir d'ici
		} else if (commandWord.equals("take")
				&& (currentRoom instanceof Lunchroom)) {
			wantCoffee(command);
		} else if (commandWord.equals("light")
				&& (currentRoom instanceof Corridor)) {
			goCorridor(command);
		} else if (commandWord.equals("attend")
				&& (currentRoom instanceof StudySpace)) {
			wantAttend(command);
		} else if (commandWord.equals("read")
				&& (currentRoom instanceof Library)) {
			wantRead(command);

		}

		// else command not recognised.
		return wantToQuit;
	}

	// implementations of user commands:

	/**
	 * Print out some help information. Here we print some stupid, cryptic
	 * message and a list of the command words.
	 */
	private void printHelp() {
		System.out.println(res.getString("game.help2"));
		System.out.println(res.getString("game.help3"));
		System.out.println();
		System.out.println(res.getString("game.help4"));
		parser.showCommands();
	}

	private void wantAttend(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(res.getString("game.attend"));
			return;
		} else if ((command.getSecondWord().equals("lab"))
				&& (currentRoom instanceof LabRoom)) {
			((LabRoom) currentRoom).attendLab(gamer);
			System.out.println(currentRoom.getLongDescription());

		} else if ((command.getSecondWord().equals("lecture"))
				&& (currentRoom instanceof LectureRoom)) {
			((LectureRoom) currentRoom).attendLecture(gamer);
			System.out.println(currentRoom.getLongDescription());
		}
	}

	private void wantCoffee(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(res.getString("game.take"));
			return;
		} else if (command.getSecondWord().equals("coffee")) {
			System.out.println(res.getString("lunchroom.coffee1"));
			((Lunchroom) currentRoom).takeCoffee(gamer);
			System.out.println(res.getString("lunchroom.coffee2"));
		} else {
			System.out.println(res.getString("game.take"));
		}
		System.out.println(currentRoom.getExitString());
	}

	private void wantRead(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(res.getString("game.read"));
			return;
		} else if (command.getSecondWord().equals("book")) {
			((Library) currentRoom).learnPOO(gamer);
		}

	}

	private void goCorridor(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(res.getString("game.where"));
			return;
		} else if (command.getSecondWord().equals("on")) {
			((Corridor) currentRoom).setLights(true);
			System.out.println(currentRoom.getLongDescription());

		} else if (command.getSecondWord().equals("off")) {
			((Corridor) currentRoom).setLights(false);
			System.out.println(res.getString("corridor.dark"));
		}
	}

	/**
	 * Try to in to one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 */
	private void goRoom(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println(res.getString("game.where"));
			return;
		}
		String direction = command.getSecondWord();
		// Try to leave current room.
		Room nextRoom = currentRoom.getExit(direction);
		if (nextRoom == null) {
			System.out.println(res.getString("game.nodoor"));
		} else if (nextRoom.enter(gamer)) {
			currentRoom = nextRoom;
		} else {
			System.out.println(currentRoom.getLongDescription());
		}
	}

	/**
	 * "Quit" was entered. Check the rest of the command to see whether we
	 * really quit the game.
	 * 
	 * @return true, if this command quits the game, false otherwise.
	 */
	private boolean quit(Command command) {
		if (command.hasSecondWord()) {
			System.out.println(res.getString("game.quitwhat"));
			return false;
		}

		return true; // signal that we want to quit
	}
}
