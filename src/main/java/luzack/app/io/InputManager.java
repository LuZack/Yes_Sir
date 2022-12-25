package luzack.app.io;

import luzack.app.tasks.CalendarProvider;
import luzack.app.tasks.IntroProvider;
import luzack.app.tasks.ProcessManager;

import java.util.Scanner;

public class InputManager {

    private boolean exitBit = false;
    private int taskCode = 0;
    ProcessManager processManager;
    public InputManager(int code) {
        taskCode = code;
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
                    setTaskCode(1);
                    Thread thread = new Thread(processManager);
                    thread.start();
                    try {
                        thread.join();
                    } catch (Exception e) {
                        e.printStackTrace();

                        System.err.println("I am exiting calendar task due to unexpected error");
                        thread.interrupt();
                    }
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

    public void setTaskCode(int taskCode) {
        switch (taskCode) {
            case 1:
                processManager = new CalendarProvider();
                break;
            default:
                System.out.println("Unknown task code");
                break;
        }
    }

    public void printHelp() {
        System.out.println("I could do...");
        System.out.println("1. calendar");
    }
}
