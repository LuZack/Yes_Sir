package luzack.app.io;

import luzack.app.tasks.CalendarProvider;
import luzack.app.tasks.IntroProvider;
import luzack.app.tasks.ProcessManager;
import luzack.app.tasks.TaskAdder;

import java.util.Scanner;

public class InputManager {

    private boolean exitBit = false;
    private int taskCode = 0;
    ProcessManager processManager;
    public InputManager(int code) {
        new IntroProvider(0);
        while(!exitBit) {
            taskCode = code;
            new IntroProvider(1);
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
                    Thread thread_1 = new Thread(processManager);
                    thread_1.start();
                    try {
                        thread_1.join();
                    } catch (Exception e) {
                        e.printStackTrace();

                        System.err.println("I am exiting calendar task due to unexpected error");
                        thread_1.interrupt();
                    }
                    break;
                case "task":
                case "add task":
                case "t":
                    setTaskCode(2);
                    Thread thread_2 = new Thread(processManager);
                    thread_2.start();
                    try {
                        thread_2.join();
                    } catch (Exception e) {
                        e.printStackTrace();

                        System.err.println("I am exiting calendar task due to unexpected error");
                        thread_2.interrupt();
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
            case 2:
                processManager = new TaskAdder();
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
