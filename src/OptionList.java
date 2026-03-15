import java.util.Scanner;

public class OptionList {
    public void showMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("- Start");
            System.out.println("- Info");
            System.out.println("- Exit");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "Start" -> startGame(sc);
                case "Info" -> showInfo(sc);
                case "Exit" -> {
                    System.out.println("Shutting down...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid option. Try again");
            }
        }
    }

    private int readInt(Scanner sc, int min, int max) {
        while (true) {
            try {
                int value = Integer.parseInt(sc.nextLine());
                if (value >= min && value <= max) {
                    return value;
                } else {
                    System.out.printf("Введите число от %d до %d: ", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.print("Некорректный ввод. Введите число: ");
            }
        }
    }

    private void manualInit(Field field, Scanner sc) {
        System.out.println(
                """
                Введите координаты живых клеток (строка и столбец через пробел).
                Для завершения введите пустую строку.
                """
        );
        while (true) {
            System.out.print("Координаты: ");
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            String[] parts = line.split("\\s+");  // объявляем parts
            if (parts.length != 2) {
                System.out.println("Нужно два числа: строка и столбец.");
                continue;
            }
            try {
                int r = Integer.parseInt(parts[0]);  // используем parts[0]
                int c = Integer.parseInt(parts[1]);  // используем parts[1]
                field.setCell(r, c, true);
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Введите целые числа.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    private void showInfo(Scanner sc) {
        System.out.println("Conway's game of life - это клеточный автомат, придуманный Джоном Конвеем.");
        sc.nextLine();
    }
    private void startGame(Scanner sc) {
        System.out.println("Enter number of rows and columns (min 3, max 100):");
        int rows = readInt(sc, 3, 100);
        int cols = readInt(sc, 3, 100);
        Field field = new Field(rows, cols);

        System.out.println("Choose initialization: 1 - random, 2 - manual");
        int init = readInt(sc, 1, 2);
        if (init == 1) {
            field.randomize();
        } else {
            manualInit(field, sc);
        }

        gameLoop(field, sc);
    }

    private void gameLoop(Field field, Scanner sc) {
        while (true) {
            field.display();
            System.out.println("Press Enter for next step, 'q' to quit");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("q"))break;
            field.nextGeneration();
        }
    }
}
