package MineSweeper;
public class Main {
    public static void main(String[] args) {

        boolean flag =true;
        do{
        clearScreen();
        MineSweeperGame game = new MineSweeperGame();
        game.start();
        
        } while(flag);
    }
    public static void clearScreen() {
            System.out.print("\033[H\033[2J");
                System.out.flush();
                }

    }
