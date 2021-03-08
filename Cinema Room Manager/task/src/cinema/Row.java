package cinema;

import java.util.Iterator;
import java.util.List;

class Row implements Iterable<Seat> {

    private List<Seat> seatsInRow;

    public Row(List<Seat> seatsInRow) {
        this.seatsInRow = seatsInRow;
    }

    public List<Seat> getSeats() {
        return seatsInRow;
    }

    long getNumberOfTickets() {
        return seatsInRow.stream().filter(Seat::isTaken).count();
    }

    long getValueOfTickets() {
        return seatsInRow.stream().map(Seat::getPrice).reduce(0, Integer::sum);
    }

    @Override
    public Iterator<Seat> iterator() {
        return seatsInRow.iterator();
    }
}
