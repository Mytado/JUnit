import java.util.Set;

public class Clock {

    private Time theTime;
    private Date theDate;
    public states currentState;

    public Clock () {
        theTime = new Time();
        theDate = new Date();
        currentState = states.DISPLAY_TIME;
    }


    public String changeModel() {
        String result = "";

        switch (currentState) {
            case DISPLAY_TIME:
                currentState = states.DISPLAY_DATE;
                result = theDate.showDate();
                break;

            case DISPLAY_DATE:
                currentState = states.DISPLAY_TIME;
                result = theTime.showTime();
                break;

            case CHANGE_DATE:
                result = "invalid action";
                break;

            case CHANGE_TIME:
                result = "invalid action";
                break;
        }

        return result;
    }

    public String ready() {
        String result = "";

        switch (currentState) {
            case DISPLAY_TIME:
                currentState = states.CHANGE_TIME;
                result = "Invalid action";
                break;

            case DISPLAY_DATE:
                result = "invalid action";
                break;

            case CHANGE_DATE:
                currentState = states.DISPLAY_DATE;
                result = "Ready to set date";
                break;

            case CHANGE_TIME:
                currentState = states.DISPLAY_TIME;
                result = "Ready to set time";
                break;

        }

        return result;
    }

    public String set(int p1, int p2, int p3) {
        String result = "";

        switch (currentState) {
            case DISPLAY_TIME:
                result = "Invalid action in display time";
                break;

            case DISPLAY_DATE:
                result = "Invalid action in display date";
                break;

            case CHANGE_DATE:
                theDate.dateSet(p1, p2, p3);
                result = theDate.showDate();
                break;

            case CHANGE_TIME:
                theTime.timeSet(p1, p2, p3);
                result = theTime.showTime();
                break;

        }
        return result;
    }
}
