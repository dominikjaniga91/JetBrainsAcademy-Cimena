package cinema;

import java.util.Optional;
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
        System.out.println("\nEnter the number of rows:");
        return scanner.nextInt();
    }

    private static int getNumberOfSeats(Scanner scanner) {
        System.out.println("\nEnter the number of seats in each row:");
        return scanner.nextInt();
    }

    private void buyTicket() {
        Optional<Seat> chosenSeat = Optional.empty();
        do {
            Seat userSeat = readUserPlace(scanner);
            if (cinema.isValidSeat(userSeat)) {
                chosenSeat = cinema.bookSeat(userSeat);
                if (chosenSeat.isPresent()) {
                    System.out.printf("%nTicket price: $%d%n", chosenSeat.get().getPrice());
                } else {
                    System.out.println("\nThat ticket has already been purchased!");
                }
            } else {
                System.out.println("Wrong input!");
            }
        } while (chosenSeat.isEmpty());
    }

    private void printMenu() {
        System.out.println("\n1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "3. Statistics\n" +
                "0. Exit");
    }

}
