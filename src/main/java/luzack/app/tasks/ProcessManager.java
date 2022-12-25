package luzack.app.tasks;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class ProcessManager implements Runnable {

    private final AtomicBoolean running = new AtomicBoolean(false);
    public void run() {
        running.set(true);
        work();
    }

    public void stop() {
        running.set(false);
    }
    public abstract void work();
}
