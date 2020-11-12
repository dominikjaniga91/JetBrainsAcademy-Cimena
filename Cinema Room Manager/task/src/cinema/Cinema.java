package cinema;

import java.io.PrintStream;
import java.util.stream.IntStream;

public class Cinema {
    private final static PrintStream out = System.out;
    private final static int NUMBER_OF_ROWS = 7;
    private final static int NUMBER_OF_SEATS = 8;

    public static void main(String[] args) {
        System.out.println("Cinema:");
        printColumnsNumbers();
        printSeats();
    }

    private static void printColumnsNumbers() {
        out.print("  ");
        IntStream.rangeClosed(1, NUMBER_OF_SEATS)
                .forEach(i -> out.print(i + " "));
        out.println();
    }

    private static void printSeats() {
        String seats = "S ".repeat(NUMBER_OF_SEATS);
        IntStream.rangeClosed(1, NUMBER_OF_ROWS)
                .forEach(number -> out.printf("%d %s%n",number, seats));
    }
}