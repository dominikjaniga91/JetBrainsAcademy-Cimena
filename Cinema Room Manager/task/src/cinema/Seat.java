package cinema;

import java.util.Objects;

class Seat {

    private final int column;
    private final int row;
    private int frontSeatPrice = 10;
    private int backSeatPrice = 8;
    private String value = "S";

    public Seat(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return column == seat.column &&
                row == seat.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

    @Override
    public String toString() {
        return value;
    }

    public int getRow() {
        return row;
    }
}
