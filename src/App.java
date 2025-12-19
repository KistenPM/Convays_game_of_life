import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("\nWelcome to Convay's game of life");

        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("\nSelect an option:");
                OptionList List = new OptionList(String.join(""));
                List.getOptions();
                break;
            }
            catch (IllegalArgumentException IAE) {
                System.out.println(IAE.getMessage());
            }
        }
    }
}

class OptionList {
    private String[] options;

    public OptionList(String option) {
        this.options = new String[option.length()];
        String[] UserOptionsList = {
                "- Start",
                "- Info",
                "- Exit"
        };
        for (String list : UserOptionsList) {
            System.out.println(list);
        }
    }
    public String[] getOptions() {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext("Start") || sc.hasNext("Info") || sc.hasNext("Exit")) {

        }else throw new IllegalArgumentException("\nНедопустимое значение.\nВведите верное значение.");
        String choice = sc.nextLine();
        switch (choice) {
            case "Start" -> {
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
            case "Info" -> {
                System.out.println("\nТы думал(-а) что здесь что-то будет?\n");
                OptionList List = new OptionList("Info");
                List.getOptions();
            }
            case "Exit" -> {
                System.out.println("Shutting down...");
                System.exit(0);
            }
        }
        return options;
    }
}