package cinema;

import java.util.Scanner;

class CinemaSystem {

    private final Scanner scanner = new Scanner(System.in);
    private Cinema cinema;

    void start() {
        int rows = getNumberOfRows(scanner);
        int seatsInRow = getNumberOfSeats(scanner);
        cinema = new Cinema(rows, seatsInRow);
        cinema.create();

        while (true) {
            printMenu();
            switch (scanner.nextInt()) {
                case 1:
                    cinema.print();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    cinema.printStatistics();
                    break;
                case 0:
                    return;
            }
        }
    }

    private static Seat readUserPlace(Scanner scanner) {
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int column = scanner.nextInt();
        return Seat.of(row, column);
    }

    private static int getNumberOfRows(Scanner scanner) {
        System.out.println("Enter the number of rows:");
        return scanner.nextInt();
    }

    private static int getNumberOfSeats(Scanner scanner) {
        System.out.println("Enter the number of seats in each row:");
        return scanner.nextInt();
    }

    private void buyTicket() {
        Seat userSeat = readUserPlace(scanner);
        Seat chosenSeat = cinema.bookSeat(userSeat);
        int price = cinema.calculatePrize(userSeat);
        System.out.printf("%nTicket price: $%d%n", price);
    }

    private void printMenu() {
        System.out.println("1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
    }

}
