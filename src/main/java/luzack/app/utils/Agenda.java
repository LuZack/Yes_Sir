package luzack.app.utils;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Dailytasks> monthlytasks;
    public Agenda(ArrayList<Dailytasks> monthlytasks) {
        this.monthlytasks = monthlytasks;
    }

    public class Dailytasks {
        private int date;
        private String day;
        private ArrayList<Task> tasks;
    
        public Dailytasks(int date, String day, ArrayList<Task> tasks) {
            this.date = date;
            this.day = day;
            this.tasks = tasks;
        }

        
    }
    public class Task {
        private String name;
        private String description;
        private int hour;
        private int minute;
        
        public Task(String name, String description, int hour, int minute) {
            this.name = name;
            this.description = description;
            this.hour = hour;
            this.minute = minute;
        }
    }
}

