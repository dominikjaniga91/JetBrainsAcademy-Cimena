package cinema;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Cinema {

    private List<Row> rows;

    public Cinema(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return rows;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = getNumberOfRows(scanner);
        int seatsInRow = getNumberOfSeats(scanner);
        Cinema cinema = CinemaManager.createCinema(rows, seatsInRow);
        printCinemaSchema(cinema, seatsInRow);

        Seat userSeat = readUserPlace(scanner);
        int price = userSeat.calculatePrice();
        System.out.printf("Ticket price: $%d%n%n", price);
        CinemaManager.bookSeat(cinema, userSeat);
    }

    private static int getNumberOfRows(Scanner scanner) {
        System.out.println("Enter the number of rows:");
        return scanner.nextInt();
    }

    private static int getNumberOfSeats(Scanner scanner) {
        System.out.println("Enter the number of seats in each row:");
        return scanner.nextInt();
    }

    private static Seat readUserPlace(Scanner scanner) {
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int column = scanner.nextInt();
        return new Seat(row, column);
    }

    private static void printCinemaSchema(Cinema cinema, int seats) {
        printColumnsNumbers(seats);
        printSeats(cinema);
    }

    private static void printColumnsNumbers(int seats) {
        System.out.print("  ");
        IntStream.rangeClosed(1, seats)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    private static void printSeats(Cinema cinema) {

        List<Row> rows = cinema.getRows();
        for (int i = 0; i < rows.size(); i++) {
            System.out.printf("%d ", i + 1);
            List<Seat> seats = rows.get(i).getSeats();
            for (Seat seat : seats) {
                System.out.printf("%s ", seat);
            }
            System.out.println();
        }
    }
}