package MineSweeper;

import java.util.Random;

public class Board {

    private Random random = new Random();
    private int boardSize = 5;
    private int numberOfMines = 5;
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

            row = random.nextInt(numberOfMines);
            col = random.nextInt(numberOfMines);

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

        board[row][col].setIsRevealed();
        return board[row][col].getHasMine();
    }

    private void floodReveal(int row, int col){

        board[row][col].setIsRevealed();
        if(board[row][col].neighborMines == 0){
            
        }
    }
    public void displayBoard() {

    for (int i = 0; i < boardSize; i++) {
        for (int j = 0; j < boardSize; j++) {
            if (board[i][j].getIsRevealed()) {
                if (board[i][j].getHasMine()) {
                    System.out.print("💣 ");
                } else {
                    System.out.print(board[i][j].neighborMines + "  ");
                }
            } else {
                System.out.print( "⏹️ ");
            }

        }
        System.out.println(); // move to next row
    }
}
}