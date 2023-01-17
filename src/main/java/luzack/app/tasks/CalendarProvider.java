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
        ArrayList<String> list = new ArrayList<>();
        list.add("10:00am-test1");
        list.add("10:00am-test2dasdasdasdasdasd");
        list.add("10:00am-test3dasdasdasdasdasd");
        list.add("10:00am-test4");
        list.add("10:00am-test5");
        list.add("10:00am-test6");
        list.add("10:00am-test7");
        list.add("10:00am-test8");

        schedule.put(3, list);
//        schedule.put(10, "9:00am-lab");
    }
    public void work() {
        try {
            drawCalendar(date.getYear(), date.getMonthValue(), schedule);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //To do: change loop logic for changed data structure
    public void drawCalendar( int year, int month, Map<Integer, ArrayList<String>> map) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, 1);
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        int daysOfCurrentMonth = calendar.getActualMaximum(5);

        String calendarASCII = ",Su,,Mo,,Tu,,We,,Th,,Fr,,Sa\n".replace(",","         "), e;
        calendarASCII = horizontalLine(calendarASCII);
        int dayCount = 1;
        for (int i = 0; i < startDay - 1; i++) {
            calendarASCII += "|                   ";
        }
        for (int i = 8-startDay; i > 0; i--) {
            calendarASCII += "|"+dayCount+"                  ";
            dayCount++;
        }
        calendarASCII += "|\n";
        int i = 0;
        for (int k = 0; k < 7; k++) {
            i = 0;
            if (startDay == 1) {
                i = 1;
            }
            for (int j = 0; j < 7; j++, i = j >= startDay-1 ? i + 1 : i) {
                if (map.get(i) != null && k < map.get(i).size()) {
                    if (map.get(i).size() > 6 && k == 6) {
                        e = map.get(i).size()-6+" more tasks..";
                    }
                    else if (map.get(i).get(k).length()>17)
                        e = map.get(i).get(k).substring(0, 15) + "...";
                    else
                        e = map.get(i).get(k);
                } else {
                    e = "";
                }
                calendarASCII += "|" + e;
                for (int l = 0; l < 19 - e.length(); l++) {
                    calendarASCII += " ";
                }
            }
            calendarASCII += "|\n";
        }

        while (i <= daysOfCurrentMonth) {
            dayCount = i;
            calendarASCII += horizontalLine("");
            for (int j = 0; j < 7; j++, i++) {
                if (i <= daysOfCurrentMonth) {
                    if (i > 9) {
                        calendarASCII += "|" + i + "                 ";
                    } else {
                        calendarASCII += "|" + i + "                  ";
                    }
                } else {
                    calendarASCII += "|                   ";
                }
            }
            calendarASCII += "|\n";

            for (int k = 0; k < 7; k++) {
                if (k == 0) i = dayCount-1;
                else i = dayCount;
                for (int j = 0; j < 7; j++, i++) {
                    if (map.get(i) != null && k < map.get(i).size()) {
                        if (map.get(i).size() > 6 && k == 6) {
                            e = map.get(i).size()-6+" more tasks..";
                        }
                        else if (map.get(i).get(k).length()>17)
                            e = map.get(i).get(k).substring(0, 15) + "...";
                        else
                            e = map.get(i).get(k);
                    } else {
                        e = "";
                    }
                    calendarASCII += "|" + e;
                    for (int l = 0; l < 19 - e.length(); l++) {
                        calendarASCII += " ";
                    }
                }
                calendarASCII += "|\n";
            }
        }


        calendarASCII = horizontalLine(calendarASCII);


        System.out.println(calendarASCII);
//        i = 0;
//        for(int x=calendar.getActualMaximum(5),l = 0, b = 0, c; i < 7;calendarASCII+="\n", l += b <= x & ++i > 6 ? 7*(i = 1) : 0)
//            for(int j = 0; j < 141; b = l + j / 20 + 2 - calendar.get(7), e = (e = map.get(b)) != null ? e.replaceAll("([^-]{1,9})(-| |$)","$1-") + " - " : null, calendarASCII += e = i % 6 < 1 ? "-" : c < 1 ? "|" : c * i < 2 & b > 0 & b <= x ? b + "" : c < 2 & e != null ? e.split("-")[i-2] : " ", j += e.length())
//                c = j % 20;
//        System.out.println(calendarASCII);

    }
    public String horizontalLine(String calendarASCII) {
        for (int i = 0; i < 141; i++)
            calendarASCII += "-";
        calendarASCII += "\n";
        return calendarASCII;
    }

}

