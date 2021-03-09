package cinema;

import java.util.Iterator;
import java.util.List;

class Row implements Iterable<Seat> {

    private List<Seat> seatsInRow;

    Row(List<Seat> seatsInRow) {
        this.seatsInRow = seatsInRow;
    }

    List<Seat> getSeats() {
        return seatsInRow;
    }

    int getNumberOfTickets() {
        return (int) seatsInRow.stream().filter(Seat::isTaken).count();
    }

    int getValueOfTickets() {
        return seatsInRow.stream()
                .filter(Seat::isTaken)
                .map(Seat::getPrice)
                .reduce(0, Integer::sum);
    }

    int getTotalIncome() {
        return seatsInRow.stream()
                .map(Seat::getPrice)
                .reduce(0, Integer::sum);
    }

    @Override
    public Iterator<Seat> iterator() {
        return seatsInRow.iterator();
    }
}
