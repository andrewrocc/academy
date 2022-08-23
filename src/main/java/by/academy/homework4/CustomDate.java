package by.academy.homework4;

import java.time.LocalDate;

class CustomDate {

    private Year customYear;

    private Month customMonth;

    private Day customDay;

    private LocalDate userDate;

    private LocalDate localDate_dateFrom;

    private LocalDate localDate_dateTo;

    public CustomDate(int year, int month, int day) {
        setConstructionValues(year, month, day);
        userDate = LocalDate.of(this.customYear.year, this.customMonth.month, this.customDay.day);
    }

    public CustomDate(String validDate) {
        String[] dateParsed = validDate.split("-");
        int[] dateInt = { Integer.parseInt(dateParsed[0]), Integer.parseInt(dateParsed[1]), Integer.parseInt(dateParsed[2]) };
        setConstructionValues(dateInt[2], dateInt[1], dateInt[0]);
    }

    private void setConstructionValues(int year, int month, int day) {
        customYear = new Year(year);
        customMonth = new Month(month);
        customDay = new Day(day);
    }

    public void getDayOfWeek() {
        System.out.println(userDate.getDayOfWeek().getValue() + " (" + userDate.getDayOfWeek() + ")");
    }

    public int getNumberOfDays(CustomDate dateFrom, CustomDate dateTo) {
        if (dateFrom.equals(dateTo))
            return 0;

        localDate_dateFrom = LocalDate.of(dateFrom.customYear.year, dateFrom.customMonth.month, dateFrom.customDay.day);
        localDate_dateTo = LocalDate.of(dateTo.customYear.year, dateTo.customMonth.month, dateTo.customDay.day);
        swap();

        if (dateTo.customYear.year == dateFrom.customYear.year &&
                dateTo.customMonth.month == dateFrom.customMonth.month) {
            return getDaysApart();
        }

        if (dateTo.customYear.year == dateFrom.customYear.year) {
            int daysInMonth = getDaysInMonth();
            return getDaysApart() + daysInMonth;
        }
        else {
            int daysInYear = getDaysInYear();
            return daysInYear + getDaysInMonth() + getDaysApart();
        }
    }

    private int getDaysApart() {
        return localDate_dateTo.getDayOfMonth() - localDate_dateFrom.getDayOfMonth();
    }

    private int getDaysInMonth() {
        int result = 0;
        while (localDate_dateFrom.getMonth().getValue() < localDate_dateTo.getMonth().getValue()) {
            result += localDate_dateFrom.lengthOfMonth();
            localDate_dateFrom = localDate_dateFrom.plusMonths(1);
        }
        return result;
    }

    private int getDaysInYear() {
        int result = 0;
        while(localDate_dateFrom.getYear() < localDate_dateTo.getYear()) {
            result += localDate_dateFrom.lengthOfYear();
            localDate_dateFrom = localDate_dateFrom.plusYears(1);
        }
        return result;
    }

    private void swap() {
        if (!localDate_dateFrom.isBefore(localDate_dateTo)) {
            LocalDate temp_value = localDate_dateFrom;
            localDate_dateFrom = localDate_dateTo;
            localDate_dateTo = temp_value;
        }
    }

    public boolean isLeapYear() {
        return (this.customYear.year % 4) == 0
                && (this.customYear.year % 100) != 0
                || (this.customYear.year % 400) == 0;
    }

    class Year {
        private int year;

        public Year(int year) {
            this.year = year;
        }
    }

    class Month {
        private int month;

        public Month(int month) {
            this.month = month;
        }
    }

    class Day {
        private int day;

        public Day(int day) {
            this.day = day;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomDate that)) return false;

        if (customYear != null ? !(customYear.year == that.customYear.year) : that.customYear != null) return false;
        if (customMonth != null ? !(customMonth.month == that.customMonth.month) : that.customMonth != null) return false;
        return customDay != null ? customDay.day == that.customDay.day : that.customDay == null;
    }

    @Override
    public int hashCode() {
        int result = customYear != null ? customYear.hashCode() : 0;
        result = 31 * result + (customMonth != null ? customMonth.hashCode() : 0);
        result = 31 * result + (customDay != null ? customDay.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "year = " + customYear.year +
                ", month = " + customMonth.month +
                ", day = " + customDay.day;
    }
}
