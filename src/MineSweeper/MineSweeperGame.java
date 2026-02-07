package MineSweeper;

import java.util.Scanner;

public class MineSweeperGame {

    private Board board;
    public MineSweeperGame(){
        board = new Board();
    }

    public void start(){
        Scanner sc = new Scanner(System.in);
        int row, col;
        boolean gameOver = false;
        do{
            board.displayBoard();
            System.out.print("Enter row: ");
            row = sc.nextInt();
            System.out.print("Enter column: ");
            col = sc.nextInt();
            gameOver = board.revealCell(row, col);

        }while(!gameOver);
        board.displayBoard();
        System.out.println("Boom!!! You hit a mine");
    }
}