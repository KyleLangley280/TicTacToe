
package project.pkg2.gui.help;

import java.awt.EventQueue;
import javax.swing.*;

public class TicTacToeController {
    
    private TicTacToeModel model;
    private TicTacToeView view;
    private String buttonText;
    private int width;
    public TicTacToeController() { 
        this.model = new TicTacToeModel();
    }
    

        public int getActualWidth() {
        return view.actualWidth;
    }
    
    

    
    public static void main(String[] args) {
       
      EventQueue.invokeLater(() -> {
        JFrame window = new JFrame("TicTacToe Game");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().add(new TicTacToeView(100));
        window.setSize(300,300);
        window.setVisible(true);
        });
        
    }  
}
    

