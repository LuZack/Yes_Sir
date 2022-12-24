package luzack.app.io;

import luzack.app.tasks.CalendarProvider;
import luzack.app.tasks.IntroProvider;
import luzack.app.thread.ThreadManager;

import java.util.Scanner;

public class InputManager {

    private boolean exitBit = false;
    ThreadManager threadManager = new ThreadManager();
    public InputManager() {
        new IntroProvider();
        while(!exitBit) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            switch (input) {
                case "exit":
                case "q":
                case "quit":
                case "bye":
                case "goodbye":
                    exitBit = true;
                    break;
                case "calendar":
                case "cal":

                    break;
                case "help":
                    printHelp();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }

    public void printHelp() {
        System.out.println("I could do...");
        System.out.println("1. calendar");
    }
    public void runCalendar() {
        System.out.println("Running calendar");
    }
}
