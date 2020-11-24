package cinema;

import java.util.List;
import java.util.Scanner;

public class Cinema {

    private List<Row> rows;

    public Cinema(List<Row> rows) {
        this.rows = rows;
    }

    public Cinema(){
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Cinema cinema = new Cinema();
        int frontSeatPrice = 10;
        int backSeatPrice = 8;

        int rows = cinema.getNumberOfRows(scanner);
        int seatsInRow = cinema.getNumberOfSeats(scanner);
        int frontRows = getFrontRows(rows);
        int backRows = getBackRows(rows, frontRows);
        int frontSeatsCost = cinema.calculatePrice(frontRows, seatsInRow, frontSeatPrice);
        int backSeatsCost = cinema.calculatePrice(backRows, seatsInRow, backSeatPrice);
        int totalCost = frontSeatsCost + backSeatsCost;

        System.out.printf("Total income: %n$%s", totalCost);
    }

    private static int getBackRows(int rows, int frontRows) {
        return rows > 4 ? rows - frontRows : 0;
    }

    private static int getFrontRows(int rows) {
        return rows > 4 ? rows / 2 : rows;
    }

    private int getNumberOfRows(Scanner scanner) {
        System.out.println("Enter the number of rows:");
        return scanner.nextInt();
    }

    private int getNumberOfSeats(Scanner scanner) {
        System.out.println("Enter the number of seats in each row:");
        return scanner.nextInt();
    }

    private int calculatePrice(int rows, int seats, int price) {
        return rows * seats * price;
    }
}