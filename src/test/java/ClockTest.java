import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClockTest {

    private Clock clock = new Clock();

    //TRANSITIONS

    @Test void testS1ToS2() {
        clock.currentState = states.DISPLAY_TIME;
        String expected = "Ready to set date";
        String actual = clock.ready();
        assertEquals(expected, actual);
    }

    @Test void testS2ToS1() {
        clock.currentState = states.DISPLAY_DATE;
        String expected = "2000/1/1";
        String actual = clock.changeModel();
        assertEquals(expected, actual);
    }

    //TODO
    @Test void testS1ToS3() {
        clock.currentState = states.DISPLAY_TIME;
        String expected = "";
        String actual = clock.ready();
    }

    @Test void testS3ToS1() {
        clock.currentState = states.CHANGE_TIME;
        String expected = "1:1:1";
        String actual = clock.set(1,1,1);
        assertEquals(expected, actual);
    }

    @Test void testS2ToS4() {

    }

    @Test void testS4ToS2() {

    }

    //ILLEGAL TRANSITIONS 6 st
    @Test void testS1Set() {

    }

    @Test void testS2Set() {

    }

    @Test void testS3ChangeModel() {

    }

    @Test void testS3Ready() {

    }

    @Test void testS4ChangeModel() {

    }

    @Test void testS4Ready(){

    }

    //DATE - YEAR

    @Test void testYearLowUnder() {
        String expected = "Invalid data, date unchanged";
        clock.currentState = states.CHANGE_DATE;
        String actual = clock.set(1999, 2, 2);
        assertEquals(expected, actual);
    }

    @Test void testYearLowBorder() {
        String expected = "Invalid data, date unchanged";
        clock.currentState = states.CHANGE_DATE;
        String actual = clock.set(2000, 2, 2);
        assertEquals(expected, actual);
    }

    @Test void testYearHighBorder() {
        clock.currentState = states.CHANGE_DATE;
        String expected = "2100/2/2";
        String actual = clock.set(2100, 2, 2);
        assertEquals(expected, actual);
    }

    @Test void testYearHighOver() {
        String expected = "Invalid data, date unchanged";
        clock.currentState = states.CHANGE_DATE;
        String actual = clock.set(2101, 2, 2);
        assertEquals(expected, actual);
    }

    //DATE - MONTH

    @Test void testMonthLowUnder() {
        String expected = "Invalid data, date unchanged";
        clock.currentState = states.CHANGE_DATE;
        String actual = clock.set(2001, 0, 2);
        assertEquals(expected, actual);
    }

    @Test void testMonthLowBorder() {
        clock.currentState = states.CHANGE_DATE;
        String expected = "2001/1/2";
        String actual = clock.set(2001, 1, 2);
        assertEquals(expected, actual);
    }

    @Test void testMonthHighBorder() {
        String expected = "Invalid data, date unchanged";
        clock.currentState = states.CHANGE_DATE;
        String actual = clock.set(2001, 12, 2);
        assertEquals(expected, actual);
    }

    @Test void testMonthHighOver() {
        String expected = "Invalid data, date unchanged";
        clock.currentState = states.CHANGE_DATE;
        String actual = clock.set(2001, 13, 2);
        assertEquals(expected, actual);
    }

    //DATE - DAY
    @Test void testDayLowUnder() {
        String expected = "Invalid data, date unchanged";
        clock.currentState = states.CHANGE_DATE;
        String actual = clock.set(2001, 2, 0);
        assertEquals(expected, actual);
    }

    @Test void testDayLowBorder() {
        clock.currentState = states.CHANGE_DATE;
        String expected = "2001/2/1";
        String actual = clock.set(2001, 2, 1);
        assertEquals(expected, actual);
    }

    @Test void testDayHighBorder() {
        clock.currentState = states.CHANGE_DATE;
        String expected = "2001/2/31";
        String actual = clock.set(2001, 2, 31);
        assertEquals(expected, actual);
    }

    @Test void testDayHighOver() {
        String expected = "Invalid data, date unchanged";
        clock.currentState = states.CHANGE_DATE;
        String actual = clock.set(2001, 2, 32);
        assertEquals(expected, actual);
    }

    //TIME - HOUR
    @Test void testHourLowUnder() {
        String expected = "Invalid data, time unchanged";
        clock.currentState = states.CHANGE_TIME;
        String actual = clock.set(-1, 1, 1);
        assertEquals(expected, actual);
    }

    @Test void testHourLowBorder() {
        clock.currentState = states.CHANGE_TIME;
        String expected = "0:1:1";
        String actual = clock.set(0, 1, 1);
        assertEquals(expected, actual);
    }

    @Test void testHourHighBorder() {
        clock.currentState = states.CHANGE_TIME;
        String expected = "23:1:1";
        String actual = clock.set(23, 1, 1);
        assertEquals(expected, actual);
    }

    @Test void testHourHighOver() {
        String expected = "Invalid data, time unchanged";
        clock.currentState = states.CHANGE_TIME;
        String actual = clock.set(24, 1, 1);
        assertEquals(expected, actual);
    }

    //TIME - MINUTE
    @Test void testMinuteLowUnder() {
        String expected = "Invalid data, time unchanged";
        clock.currentState = states.CHANGE_TIME;
        String actual = clock.set(1,-1, 1);
        assertEquals(expected, actual);
    }

    @Test void testMinuteLowBorder() {
        clock.currentState = states.CHANGE_TIME;
        String expected = "1:0:1";
        String actual = clock.set(1,0, 1);
        assertEquals(expected, actual);

    }

    @Test void testMinuteHighBorder() {
        clock.currentState = states.CHANGE_TIME;
        String expected = "1:59:1";
        String actual = clock.set(1,59, 1);
        assertEquals(expected, actual);
    }

    @Test void testMinuteHighOver() {
        String expected = "Invalid data, time unchanged";
        clock.currentState = states.CHANGE_TIME;
        String actual = clock.set(1,60, 1);
        assertEquals(expected, actual);
    }

    //TIME - SECOND
    @Test void testSecondLowUnder() {
        String expected = "Invalid data, time unchanged";
        clock.currentState = states.CHANGE_TIME;
        String actual = clock.set(1,1, -1);
        assertEquals(expected, actual);
    }

    @Test void testSecondLowBorder() {
        clock.currentState = states.CHANGE_TIME;
        String expected = "1:1:0";
        String actual = clock.set(1,1, 0);
        assertEquals(expected, actual);
    }

    @Test void testSecondHighBorder() {
        clock.currentState = states.CHANGE_TIME;
        String expected = "1:1:59";
        String actual = clock.set(1,1, 59);
        assertEquals(expected, actual);
    }

    @Test void testSecondHighOver() {
        String expected = "Invalid data, time unchanged";
        clock.currentState = states.CHANGE_TIME;
        String actual = clock.set(1,1, 60);
        assertEquals(expected, actual);
    }

}