package cinema;

import java.util.ArrayList;
import java.util.List;

public class CinemaCreator {

    private final int numberOfRows;
    private final int numberOfSeats;

    CinemaCreator(int numberOfRows, int numberOfSeats) {
        this.numberOfRows = numberOfRows;
        this.numberOfSeats = numberOfSeats;
    }

    Cinema createCinema() {

        List<Row> rows = new ArrayList<>();
        for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) {
            List<Seat> seats = new ArrayList<>();
            for (int seatNumber = 0; seatNumber < numberOfSeats; seatNumber++) {
                Seat seat = new Seat(rowNumber, seatNumber);
                seats.add(seat);
            }
            Row row = new Row(seats);
            rows.add(row);
        }
        return new Cinema(rows);
    }
}
