package luzack.app;

import luzack.app.io.InputManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    private static Gson gson = new Gson();
    public static void main( String[] args ) {
        InputManager inputManager = new InputManager(0);
    }
}
