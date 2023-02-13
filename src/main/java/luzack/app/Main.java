package luzack.app;

import luzack.app.io.InputManager;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import luzack.app.utils.Agenda;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    private static Gson gson = new Gson();
    public static void main( String[] args ) {

        try (Reader reader = new FileReader("data/calendar/2023/2.json")) {

            // Convert JSON File to Java Object
            Object agenda = gson.fromJson(reader, Object.class);

            // print staff
            System.out.println(agenda.getClass().getName());

        } catch (IOException e) {
            e.printStackTrace();
        }
//        InputManager inputManager = new InputManager(0);
    }
}
