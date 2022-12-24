package luzack.app.thread;

import luzack.app.tasks.CalendarProvider;
import luzack.app.tasks.ProcessManager;

public class ThreadManager implements Runnable {

    private ProcessManager process;

    // To Do: divide the process into different threads
    public void run() {
        System.out.println("Running thread");
    }
}

