package luzack.app.tasks;

public class IntroProvider  {
    public IntroProvider(int taskCode) {
        if (taskCode == 0) {
            System.out.println(" __   __  _______  _______          _______  ___   ______    __  \n" +
                    "|  | |  ||       ||       |        |       ||   | |    _ |  |  | \n" +
                    "|  |_|  ||    ___||  _____|        |  _____||   | |   | ||  |  | \n" +
                    "|       ||   |___ | |_____         | |_____ |   | |   |_||_ |  | \n" +
                    "|_     _||    ___||_____  | ___    |_____  ||   | |    __  ||__| \n" +
                    "  |   |  |   |___  _____| ||_  |    _____| ||   | |   |  | | __  \n" +
                    "  |___|  |_______||_______|  |_|   |_______||___| |___|  |_||__| version 0.1.0");
        }

        System.out.println("\nHow may I help you today?");
        System.out.println("If you are not sure what to do, please type help.");
    }
}
