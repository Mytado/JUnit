public class Time {

    int theHour = 0;
    int theMinute = 0;
    int theSecond = 0;


    public String timeSet (int hour, int minute, int second) {
        if (hour >= 0 && minute <= 23) {
            if (minute >= 0 && minute <= 59){
                if (second >= 0 && minute <= 59) {
                    theHour = hour;
                    theMinute = minute;
                    theSecond = second;
                    return hour + ":" + minute + ":" + second;
                }
            }
        }
        return "Invalid data, time unchanged";
    }

    public String showTime () {
        return theHour + ":" + theMinute + ":" + theSecond;
    }
}
