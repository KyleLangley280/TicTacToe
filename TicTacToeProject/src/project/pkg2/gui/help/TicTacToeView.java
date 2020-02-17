
package project.pkg2.gui.help;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TicTacToeView extends JPanel implements ActionListener {
    int width;
    JButton[][] squares;
    JLabel resultLabel;
    private String tester;
    private TicTacToeModel model;
    private Boolean returnWinCondition = false;
    private String buttonText;
    public String finalWinner;
    int actualWidth;
    int counter = 0;
    public Boolean draw = false;
    Boolean gameOver = false;
    
    public TicTacToeView(int width){
        this.model = new TicTacToeModel();
        init(width);
        actualWidth = width;
    }
        
    public void init(int width){
        this.width = width;
        this.setLayout(new BoxLayout (this, BoxLayout.Y_AXIS));
        JPanel squaresPanel = new JPanel ( new GridLayout (width, width));
        squares = new JButton[width][width];
        
        for(int row =0; row < width; ++row ){
            for(int col = 0; col < width; ++col){
                squares[row][col] = new JButton();
                squares[row][col].addActionListener(this);
                squares[row][col].setText("");
                squares[row][col].setName("Square" + row + col);
                squares[row][col].setPreferredSize(new Dimension(64,64));
                squaresPanel.add( squares[row][col]); 
            } 
        }
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        resultLabel.setText("Welcome to Tic-Tac-Toe");
        
        this.add(squaresPanel);
        this.add(resultLabel);   
    }
    
    public String winConditions(){
        
        //check to see if there is a win vertically
        boolean winCondition = false;
        for (int i = 0; i < actualWidth; i++){
            tester = squares[i][0].getText();
            if(tester.equals("")){
                
            }
            if(tester.equals("X")||tester.equals("O")){
                winCondition = true;
                String notTester;
                String emptyString = "";
                if(tester.equals("X")){
                    notTester = "O";
                }
                else{
                    notTester = "X";
                }
                    for (int j = 1; j < actualWidth;j++){
                        if (notTester.equals(squares[i][j].getText())||emptyString.equals(squares[i][j].getText())){
                            winCondition = false;
                        }  
                    }
                if(winCondition == true){
                    return tester;
                }
            }
        }

 
        //checking to see if there is a win horizontally
        
        for (int i = 0; i < actualWidth; i++){
            tester = squares[0][i].getText();
            if(tester.equals("")){
               
            }
            if(tester.equals("X")||tester.equals("O")){
                winCondition = true;
                String notTester;
                String emptyString = "";
                if(tester.equals("X")){
                    notTester = "O";
                }
                else{
                    notTester = "X";
                }
                    for (int j = 1; j < actualWidth; j++){ 
                        if (notTester.equals(squares[j][i].getText())||emptyString.equals(squares[j][i].getText())){
                            winCondition = false;
                    }
                }
                if(winCondition == true){
                    return tester;
                }    
            }
        }
        
        //testing the frontward diagonal
        tester = squares[0][0].getText();
        for(int i = 1; i < actualWidth; i++){
            if (tester.equals(squares[i][i].getText())){
                winCondition = true;  
            }
            else{
                winCondition = false;
                break;
            }
        }
        //checking to see if win condition was actually met
        if(winCondition == true){
            return tester;
        }
        //Variables used to allow checking backward diagonal win conditions
        int columnChecker = actualWidth-1;
        int rowChecker = 0;
        tester = squares[rowChecker][columnChecker].getText();
        //checking the backwards diagonal
        for(int i =0; i < actualWidth-1;i++){
            rowChecker += 1;
            columnChecker -= 1;
            if(tester.equals(squares[rowChecker][columnChecker].getText())){
                winCondition = true;
            }
            else{
                winCondition = false;
                break;
            }
            
        }
        //checking to see if win condition was actually met
        if(winCondition == true){
            return tester;
        }

        //basically the NOBODY won solution
        return (" ");
        
    }
    
        @Override
        public void actionPerformed(ActionEvent e){
            
            if(e.getSource() instanceof JButton && gameOver == false){
                JButton button =(JButton)(e.getSource());
                buttonText = button.getText();
                button.setText(model.setMark(buttonText));
                String finalResult = winConditions();
                if (isDraw() == true && finalResult.equals(" ")){
                    resultLabel.setText("The game is a tie!");
                }
                if(finalResult.equals("X")||finalResult.equals("O")){
                    resultLabel.setText("The winner is " + finalResult);
                    gameOver = true;
                }
                
        }
    }

    public Boolean isDraw(){
        if (model.getCounter() >= Math.pow(actualWidth, 2) ){
            draw = true;
        }
        return draw;
    }

}
