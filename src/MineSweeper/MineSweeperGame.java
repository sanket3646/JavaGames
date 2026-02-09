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
            clearScreen();
            board.displayBoard();
            System.out.println("Enter action (0 = reveal, 1 = flag):");
            int action = sc.nextInt();
            System.out.print("Enter row: ");
            row = sc.nextInt();
            System.out.print("Enter column: ");
            col = sc.nextInt();
            if(action==1) board.toggleFlag(row, col);
            else
             gameOver = board.revealCell(row, col);

        }while(!gameOver);
        clearScreen();

        board.displayBoard();
        System.out.println("Boom!!! You hit a mine");
    }
    public void clearScreen() {
            System.out.print("\033[H\033[2J");
                System.out.flush();
                }

    }
