package cinema;

import java.util.Scanner;

class CinemaSystem {

    private final CinemaManager cinemaManager = new CinemaManager();
    private final Scanner scanner = new Scanner(System.in);
    private Cinema cinema;

    void start() {
        int rows = getNumberOfRows(scanner);
        int seatsInRow = getNumberOfSeats(scanner);
        cinema = cinemaManager.createCinema(rows, seatsInRow);
        cinema.print();

        buyTicket();
        cinema.print();

    }

    private static Seat readUserPlace(Scanner scanner) {
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int column = scanner.nextInt();
        return new Seat(row, column);
    }

    private static int getNumberOfRows(Scanner scanner) {
        System.out.println("Enter the number of rows:");
        return scanner.nextInt();
    }

    private static int getNumberOfSeats(Scanner scanner) {
        System.out.println("Enter the number of seats in each row:");
        return scanner.nextInt();
    }

    private void exit() {
        System.exit(0);
    }

    private void buyTicket() {
        Seat userSeat = readUserPlace(scanner);
        int price = cinema.calculatePrize(userSeat);
        System.out.printf("%nTicket price: $%d%n", price);
        cinema.bookSeat(userSeat);
    }

}
