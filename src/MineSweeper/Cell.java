package MineSweeper;

public class Cell {
    
    private boolean hasMine = false;
    private boolean revealed = false;
    public int neighborMines = 0;

    public boolean getHasMine(){
        return hasMine;
    }
    public boolean getIsRevealed(){
        return revealed;
    }
    public void setHasMine(){
        hasMine = true;
    }
    public void setIsRevealed(){
        revealed = true;
    }
    
}