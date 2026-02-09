package MineSweeper;

public class Cell {
    
    private boolean hasMine = false;
    private boolean revealed = false;
    public int neighborMines = 0;
    public String[] numEmojis = {"0️⃣","1️⃣","2️⃣","3️⃣","4️⃣","5️⃣","6️⃣","7️⃣","8️⃣"};
    private boolean flagged = false;

    public boolean isFlagged() {
        return flagged;
        }

        public void toggleFlag() {
            flagged = !flagged;
            }
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