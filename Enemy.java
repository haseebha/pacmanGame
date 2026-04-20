import java.util.Random;

class Enemy {
    public int row, col;
    private Random rand = new Random();

    public Enemy(int startRow, int startCol) {
        this.row = startRow;
        this.col = startCol;
    }

    public void moveRandomly(Board board) {
        int direction = rand.nextInt(4);
        int nextRow = this.row;
        int nextCol = this.col;

        if (direction == 0) nextRow--;      // Up
        else if (direction == 1) nextRow++; // Down
        else if (direction == 2) nextCol--; // Left
        else if (direction == 3) nextCol++; // Right

        if (board.isNotWall(nextRow, nextCol)) {
            this.row = nextRow;
            this.col = nextCol;
        }
    }
}

