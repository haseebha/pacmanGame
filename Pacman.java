class Pacman {
    public int row, col, score;

    public Pacman(int startRow, int startCol) {
        this.row = startRow;
        this.col = startCol;
        this.score = 0;
    }

    public void move(int newRow, int newCol) {
        this.row = newRow;
        this.col = newCol;
    }

    public void addScore() {
        this.score += 10;
    }
}
