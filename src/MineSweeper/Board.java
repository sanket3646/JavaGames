package MineSweeper;

import java.util.Random;

public class Board {

    private Random random = new Random();
    private int boardSize = 9;
    private int numberOfMines = 10;
    private Cell[][] board = new Cell[boardSize][boardSize];

    Board(){
        for(int i = 0; i<boardSize; i++){
            for(int j = 0; j<boardSize; j++){
                board[i][j] = new Cell();
            }
        }
        placeMines(numberOfMines);
        calculateNeighborMines();
    }

    private void placeMines(int numberOfMines){

        int row;
        int col;
        int placedMines = 0;

        while(placedMines<numberOfMines){

            row = random.nextInt(boardSize);
            col = random.nextInt(boardSize);

            if(!board[row][col].getHasMine()){
                board[row][col].setHasMine();
               placedMines++;
            }
        }

    }

    private void calculateNeighborMines() {

    for (int i = 0; i < boardSize; i++) {
        for (int j = 0; j < boardSize; j++) {

            // Skip cells that have mines
            if (board[i][j].getHasMine()) {
                continue;
            }

            int count = 0;

            // Check all 8 neighbors using relative positions
            for (int r = i - 1; r <= i + 1; r++) {
                for (int c = j - 1; c <= j + 1; c++) {

                    // Skip the cell itself
                    if (r == i && c == j) continue;

                    // Make sure neighbor is inside the board
                    if (r >= 0 && r < boardSize && c >= 0 && c < boardSize) {
                        if (board[r][c].getHasMine()) {
                            count++;
                        }
                    }
                }
            }

            board[i][j].neighborMines = count;
        }
    }
}

    public boolean revealCell(int row, int col){

        if (board[row][col].isFlagged()) {
                return false; // Do nothing if flagged
                }
        

        if (board[row][col].getHasMine()) {
            board[row][col].setIsRevealed();
            return true;
        }

        floodReveal(row, col);
        return false;
    }

    private void floodReveal(int row, int col) {

        // Stop if out of bounds
        if (row < 0 || row >= boardSize || col < 0 || col >= boardSize) return;

        Cell cell = board[row][col];

        // Stop if already revealed
        if (cell.getIsRevealed()) return;

        // Reveal this cell
        cell.setIsRevealed();

        // Stop spreading if it has a number
        if (cell.neighborMines > 0) return;

        // Spread to all neighbors
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = col - 1; c <= col + 1; c++) {
                if (r == row && c == col) continue;
                floodReveal(r, c);
            }
        }
}
public void toggleFlag(int row, int col) {
        Cell cell = board[row][col];

            // Cannot flag revealed cells
                if (!cell.getIsRevealed()) {
                        cell.toggleFlag();
                            }
                            }



    public void displayBoard() {
    
        for (int i = 0; i < boardSize; i++){
            System.out.print(i + "  ");
        }
        System.out.println();
    for (int i = 0; i < boardSize; i++) {
        for (int j = 0; j < boardSize; j++) {
if (board[i][j].isFlagged()) {
    System.out.print("🚩 ");
}
            else if (board[i][j].getIsRevealed()) {
                if (board[i][j].getHasMine()) {
                    System.out.print("☠️  ");
                } else {
                    System.out.print(board[i][j].numEmojis[board[i][j].neighborMines] + "  ");
                }
            } else {
                 System.out.print( "⏹️  ");
            }

        } 
        System.out.println(); // move to next row
    }
}}
