import java.util.Random;

public class Field {                             //object example
    private final boolean[][] grid;                    //атрибут
    private final int rows, cols;

    public Field(int rows, int cols) {                 //конструктор
        this.grid = new boolean[rows][cols];
        this.rows = rows;
        this.cols = cols;

        if (rows < 3 || rows > 100 || cols < 3 || cols > 100) {
            throw new IllegalArgumentException("\nНедопустимые размеры поля.\nВведите не меньше 3 и не больше 100");
        }
    }

    public void setCell(int row, int col, boolean state) {
        if (row < 0 || row >= rows || col < 0 || col >= cols)
            throw new IllegalArgumentException("Клетка вне пределов поля");
        grid[row][col] = state;
    }

    public void nextGeneration() {
        boolean[][] newGrid = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int sosedi = countsosedi(i, j);
                if (grid[i][j]) {
                        newGrid[i][j] = (sosedi == 2 || sosedi == 3);
                } else {
                    newGrid[i][j] = sosedi == 3;
                }
            }
        }

        for (int i = 0; i < rows; i++)
            System.arraycopy(newGrid[i], 0, grid[i], 0, cols);
    }

    private int countsosedi(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = row +i;
                int c = col +j;
                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c]) {
                    count++;
                }
            }
        }return count;
    }

    public void randomize() {
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                grid[i][j] = rand.nextBoolean();
        }
    }

    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] ? "■ " : "□ ");
            }
            System.out.println();
        }
    }
}