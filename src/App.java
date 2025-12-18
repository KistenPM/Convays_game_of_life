import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Convay's game of life");

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of rows and columns");
        while (true) {
            try {
                Field Grid = new Field(sc.nextInt(), sc.nextInt());
                System.out.println("Enter the section");
                Grid.getGrid()[sc.nextInt()][sc.nextInt()] = sc.nextBoolean();
                Grid.getGrid();
                break;
            }
            catch (IllegalArgumentException IAE) {
                System.out.println(IAE.getMessage());
            }
        }
    }
}