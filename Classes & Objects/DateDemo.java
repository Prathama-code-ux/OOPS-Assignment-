public class DateDemo {
    static final class CustomDate {
        private int day;
        private int month;
        private int year;

        CustomDate() {
            this.day = 1;
            this.month = 1;
            this.year = 1970;
        }

        CustomDate(int day) {
            this.day = day;
            this.month = 1;
            this.year = 1970;
        }

        CustomDate(int day, int month) {
            this.day = day;
            this.month = month;
            this.year = 1970;
        }

        CustomDate(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        private boolean isLeapYear(int y) {
            return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
        }

        private int daysInMonth(int m, int y) {
            switch (m) {
                case 4: case 6: case 9: case 11:
                    return 30;
                case 2:
                    return isLeapYear(y) ? 29 : 28;
                default:
                    return 31;
            }
        }

        public CustomDate getNextDate() {
            int nextDay = day + 1;
            int nextMonth = month;
            int nextYear = year;

            if (nextDay > daysInMonth(month, year)) {
                nextDay = 1;
                nextMonth++;
                if (nextMonth > 12) {
                    nextMonth = 1;
                    nextYear++;
                }
            }
            return new CustomDate(nextDay, nextMonth, nextYear);
        }

        public CustomDate getPreviousDate() {
            int prevDay = day - 1;
            int prevMonth = month;
            int prevYear = year;

            if (prevDay < 1) {
                prevMonth--;
                if (prevMonth < 1) {
                    prevMonth = 12;
                    prevYear--;
                }
                prevDay = daysInMonth(prevMonth, prevYear);
            }
            return new CustomDate(prevDay, prevMonth, prevYear);
        }

        public void printDate() {
            System.out.printf("%02d/%02d/%04d%n", day, month, year);
        }
    }

    public static void main(String[] args) {
        CustomDate d1 = new CustomDate();
        CustomDate d2 = new CustomDate(15);
        CustomDate d3 = new CustomDate(28, 2);
        CustomDate d4 = new CustomDate(1, 1, 2000);

        System.out.print("Date 1: "); d1.printDate();
        System.out.print("Previous: "); d1.getPreviousDate().printDate();
        System.out.print("Next: "); d1.getNextDate().printDate();

        System.out.print("Date 2: "); d2.printDate();
        System.out.print("Previous: "); d2.getPreviousDate().printDate();
        System.out.print("Next: "); d2.getNextDate().printDate();

        System.out.print("Date 3: "); d3.printDate();
        System.out.print("Previous: "); d3.getPreviousDate().printDate();
        System.out.print("Next: "); d3.getNextDate().printDate();

        System.out.print("Date 4: "); d4.printDate();
        System.out.print("Previous: "); d4.getPreviousDate().printDate();
        System.out.print("Next: "); d4.getNextDate().printDate();

        System.out.println("Should this class be final? Yes, declaring it final prevents subclassing which is a good design practice for value objects to ensure immutability and consistent behavior.");
    }
}
