
package project.pkg2.gui.help;


public class TicTacToeModel {
    
    private Boolean xTurn = true;
    private TicTacToeController controller;
    private int counter = 0;
    public Boolean draw = false;
    int doubleWidth;
    
    public TicTacToeModel(){
  
    }
    

    public String turnSwitch(){
        if (xTurn == true){
            xTurn = false;
            return ("X");
        }
        else{
            xTurn = true;
            return ("O");
        }
    }
    
    public String setMark(String getText){
        
        if (isMarked(getText) == false){
            this.counter++;
            return turnSwitch();
        }
        else{
            return getText;
        }
    }
    
    public Boolean isMarked(String getText){
        if (getText.equals("X") || getText.equals("O")){
            return true;
        }
        else{
            return false;
        }
    }

    public int getCounter() {
        return this.counter;
    }


}
