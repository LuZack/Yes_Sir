package luzack.app.tasks;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;
import java.util.ArrayList;

public class CalendarProvider extends ProcessManager {
    private LocalDate date;
    private Map<Integer, ArrayList<String>> schedule;
  public CalendarProvider() {
        System.out.println("CalendarProvider");
        date = LocalDate.now();
        schedule = new HashMap<>();
        //schedule.put(10, "9:00am-lab");
    }
    public void work() {
        try {
            drawCalendar(date.getYear(), date.getMonthValue(), schedule);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //To do: change loop logic for changed data structure
    public void drawCalendar( int year, int month, Map<Integer, String> map) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        String r = ",Su,,Mo,,Tu,,We,,Th,,Fr,,Sa\n".replace(",","         "), e;
        for(int x=calendar.getActualMaximum(5),l = 0, b = 0, j, c, i = 0; i < 7;r+="\n", l += b <= x & ++i > 6 ? 7*(i = 1) : 0)
            for(j = 0; j < 141; b = l + j / 20 + 2 - calendar.get(7), e = (e = map.get(b)) != null ? e.replaceAll("([^-]{1,9})(-| |$)","$1-") + " - " : null, r += e = i % 6 < 1 ? "-" : c < 1 ? "|" : c * i < 2 & b > 0 & b <= x ? b + "" : c < 2 & e != null ? e.split("-")[i-2] : " ", j += e.length())
                c = j % 20;
        System.out.println(r);
    }


}

