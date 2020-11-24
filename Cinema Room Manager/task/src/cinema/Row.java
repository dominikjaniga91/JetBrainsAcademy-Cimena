package cinema;

import java.util.List;

class Row {

    private List<Seat> seatsInRow;

    public Row(List<Seat> seatsInRow) {
        this.seatsInRow = seatsInRow;
    }

    public List<Seat> getSeats() {
        return seatsInRow;
    }

}
