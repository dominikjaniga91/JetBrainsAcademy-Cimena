package cinema;

import java.util.Scanner;

class Main {

    public static void main(String[] args) {

        CinemaManager cinemaManager = new CinemaManager();
        Scanner scanner = new Scanner(System.in);

        int rows = getNumberOfRows(scanner);
        int seatsInRow = getNumberOfSeats(scanner);
        Cinema cinema = cinemaManager.createCinema(rows, seatsInRow);
        cinema.print(seatsInRow);


        Seat userSeat = readUserPlace(scanner);
        int price = cinema.calculatePrize(userSeat);
        System.out.printf("%nTicket price: $%d%n", price);
        CinemaManager.bookSeat(cinema, userSeat);
        cinema.print(seatsInRow);
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
}