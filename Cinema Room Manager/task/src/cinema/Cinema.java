package cinema;

import java.util.List;
import java.util.Scanner;

public class Cinema {

    private List<Row> rows;

    public Cinema(List<Row> rows) {
        this.rows = rows;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = getNumberOfRows(scanner);
        int seatsInRow = getNumberOfSeats(scanner);
        Cinema cinema = CinemaCreator.createCinema(rows, seatsInRow);

        Seat userSeat = readUserPlace(scanner);
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


}