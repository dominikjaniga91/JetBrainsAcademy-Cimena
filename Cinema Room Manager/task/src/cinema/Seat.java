package cinema;

import java.util.Objects;

class Seat {

    private final int column;
    private final int row;
    private final int prize;
    private String value = "S";

    public Seat(int row, int column, int prize) {
        this.row = row;
        this.column = column;
        this.prize = prize;
    }

    public static Seat of(int row, int column) {
        return new Seat(row, column, 0);
    }

    public void book() {
        this.value = "B";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return column == seat.column &&
                row == seat.row;
    }

    boolean isTaken() {
        return "B".equals(value);
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
