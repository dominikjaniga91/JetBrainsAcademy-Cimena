package cinema;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Cinema implements Iterable<Row> {

    private List<Row> rows;

    public Cinema(List<Row> rows) {
        this.rows = rows;
    }

    void print() {
        printColumnsNumbers();
        printSeats();
    }

    private void printColumnsNumbers() {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        IntStream.rangeClosed(1, rows.size())
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    private void printSeats() {

        for (int i = 0; i < rows.size(); i++) {
            System.out.printf("%d ", i + 1);
            List<Seat> seats = rows.get(i).getSeats();
            for (Seat seat : seats) {
                System.out.printf("%s ", seat);
            }
            System.out.println();
        }
        System.out.println();
    }

    int calculatePrize(Seat seat) {
        if (rows.size() * rows.get(0).getSeats().size() <= 60) {
            return 10;
        }
        return seat.getRow() <= rows.size() / 2 ? 10 : 8;
    }

    void bookSeat(Seat userSeat) {
        for (Row row : rows) {
            for (Seat seat : row) {
                if (seat.equals(userSeat)) {
                    seat.setValue("B");
                }
            }
        }
    }

    @Override
    public Iterator<Row> iterator() {
        return rows.iterator();
    }
}