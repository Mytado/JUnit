public class Date {

    private int theYear = 2000;
    private int theMonth = 1;
    private int theDay = 1;

    public String dateSet (int year, int month, int day) {
        if (year >= 2000 && year <= 2100) {
            if(month >=1 && month <= 12) {
               if (day >=1 && day <= 31) {
                   return day + "/" + month + "/" + year;
               }
            }
        }
        return "Invalid data, date unchanged";
    }

    public String showDate() {
        return theDay + "/" + theMonth + "/" + theYear;
    }
}
