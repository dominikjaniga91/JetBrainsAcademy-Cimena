package cinema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class Cinema implements Iterable<Row> {

    private List<Row> rows;
    public final int numberOfRows;
    public final int numberOfSeats;

    public Cinema(int numberOfRows, int numberOfSeats) {
        this.numberOfRows = numberOfRows;
        this.numberOfSeats = numberOfSeats;
    }

    void print() {
        printColumnsNumbers();
        printSeats();
    }

    private void printColumnsNumbers() {
        System.out.println();
        System.out.println("Cinema:");
        System.out.print("  ");
        IntStream.rangeClosed(1, rows.get(0).getSeats().size())
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

    Optional<Seat> bookSeat(Seat userSeat) {
        for (Row row : rows) {
            for (Seat seat : row) {
                if (seat.equals(userSeat) && seat.isFree()) {
                    seat.book();
                    return Optional.of(seat);
                }
            }
        }
        return Optional.empty();
    }

    void create() {

        rows = new ArrayList<>();
        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
            List<Seat> seats = new ArrayList<>();
            for (int seatNumber = 0; seatNumber < numberOfSeats; seatNumber++) {
                int prize = calculatePrize(rowNumber);
                Seat seat = new Seat(rowNumber + 1, seatNumber + 1, prize);
                seats.add(seat);
            }
            Row row = new Row(seats);
            rows.add(row);
        }
    }

    int calculatePrize(int rowNumber) {
        if (numberOfSeats * numberOfRows <= 60) {
            return 10;
        }
        return rowNumber <= numberOfRows / 2 ? 10 : 8;
    }


    void printStatistics() {
        System.out.printf("Number of purchased tickets: %d\n" +
                "Percentage: %.2f%%\n" +
                "Current income: $%d\n" +
                "Total income: $%d\n\n", getNumberOfTickets(), getPercentageOfFill(), getValueOfTickets(), getTotalIncome());
    }

    long getNumberOfTickets() {
        return rows.stream().map(Row::getNumberOfTickets).reduce(0L, Long::sum);
    }

    int getValueOfTickets() {
        return rows.stream().map(Row::getValueOfTickets).reduce(0, Integer::sum);
    }

    int getTotalIncome() {
        return rows.stream().map(Row::getTotalIncome).reduce(0, Integer::sum);
    }

    double getPercentageOfFill() {
        return (double) getNumberOfTickets() / (numberOfRows * numberOfSeats) * 100;
    }

    @Override
    public Iterator<Row> iterator() {
        return rows.iterator();
    }
}