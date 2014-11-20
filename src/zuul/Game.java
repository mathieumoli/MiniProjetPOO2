package zuul;

import zuul.commands.*;
import zuul.course.*;
import zuul.room.*;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

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

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        parser = new Parser();
        getLanguage();
        res = ResourceBundle.getBundle("zuul.intl.Zuul", locale);
        createRooms();
    }

    /**
     * Ask to the user his prefered language and set it
     */
    private void getLanguage() {
        System.out.println("Voulez-vous jouer en français ? Si oui, appuyez sur 1.");
        System.out.println("Or do you prefer playing in English ? If so, press 2.");

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
        Room hall = new Room(res.getString("hall.description"));
        Lunchroom lunchroom = new Lunchroom(res.getString("lunchroom.description"));
        LectureRoom lectureroom = new LectureRoom(res.getString("lectureroom.description"));
        LabRoom labroom = new LabRoom(res.getString("labroom.description"));
        Corridor corridor1 = new Corridor(res.getString("corridor1.description"));
        Corridor corridor2 = new Corridor(res.getString("corridor2.description"));
        Library library = new Library(res.getString("library.description"));
        ExamRoom examroom = new ExamRoom(res.getString("examroom.description"));

        // initialise room exits
        hall.setExit("north", corridor1);

        corridor1.setExit("south", hall);
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

        currentRoom = hall; // start game in the hall
    }

    /**
     * Main play routine. Loops until end of play.
     */
    public void play() {
        printWelcome();

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
        System.out.println(currentRoom.getLongDescription());
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
        } else {
            currentRoom = nextRoom;
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
        } else {
            return true; // signal that we want to quit
        }
    }
}
