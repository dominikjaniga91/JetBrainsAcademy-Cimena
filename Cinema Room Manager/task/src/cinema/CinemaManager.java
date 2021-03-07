package cinema;

import java.util.ArrayList;
import java.util.List;

public class CinemaManager {

    static Cinema createCinema(final int numberOfRows, final int numberOfSeats) {

        List<Row> rows = new ArrayList<>();
        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
            List<Seat> seats = new ArrayList<>();
            for (int seatNumber = 0; seatNumber < numberOfSeats; seatNumber++) {
                Seat seat = new Seat(rowNumber + 1, seatNumber + 1);
                seats.add(seat);
            }
            Row row = new Row(seats);
            rows.add(row);
        }
        return new Cinema(rows);
    }

    static void bookSeat(Cinema cinema, Seat userSeat) {
        var rows = cinema.getRows();
        for (Row row : rows) {
            for (Seat seat : row.getSeats()) {
                if (seat.equals(userSeat)) {
                    seat.setValue("B");
                }
            }
        }
    }
}
