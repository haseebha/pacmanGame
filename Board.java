class Board {
    public char[][] maze = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '#', '.', '.', '.', '.', '#'},
            {'#', '.', '#', '.', '#', '.', '#', '#', '.', '#'},
            {'#', '.', '#', '.', '.', '.', '.', '#', '.', '#'},
            {'#', '.', '#', '#', '.', '#', '.', '#', '.', '#'},
            {'#', '.', '.', '.', '.', '#', '.', '.', '.', '#'},
            {'#', '.', '#', '#', '#', '#', '.', '#', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '#', '.', '#'},
            {'#', '.', '#', '.', '#', '#', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
    };

    public void draw(Pacman p, Enemy e) {
        // Clear screen effect
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Score: " + p.score);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == p.row && j == p.col) System.out.print("P ");
                else if (i == e.row && j == e.col) System.out.print("E ");
                else System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isNotWall(int r, int c) {
        return maze[r][c] != '#';
    }

    public boolean isFood(int r, int c) {
        return maze[r][c] == '.';
    }

    public void removeFood(int r, int c) {
        maze[r][c] = ' ';
    }
}