public class Field {                             //object example
    private final boolean[][] grid;                    //атрибут

    public Field(int w, int h) {                 //конструктор
        this.grid = new boolean[w][h];
        if (w < 3 || h < 3 || w > 100 || h > 100) {
            throw new IllegalArgumentException("\nНедопустимые размеры поля.\nВведите не меньше 3 и не больше 100");
        }
    }

     public boolean[][] getGrid() {               //Геттер / мутатор метод
         for (boolean[] ints : grid) {
             for (boolean anInt : ints) {
                 System.out.print("[" + anInt + "]" + " ");
             }
             System.out.println();
         }
        return grid;
     }
//    public void ListField() {
//        for (int[] ints : grid) {
//            for (int anInt : ints) {
//                System.out.print(anInt);
//            }
//            System.out.println();
//        }
//    }

//     private String name;                      //attribute examples
//     private int quantity;
//
//     public Field(String name, int quantity) { //constructor method example
//         this.name = name;
//         this.quantity = quantity;
//     }
//
//     public String getName() {                 //getter method examples
//         return name;
//     }
//     public int getQuantity() {
//         return quantity;
//     }
}