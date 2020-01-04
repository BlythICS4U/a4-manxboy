/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author cgallinaro
 */
public class Problem2 {

    
    public Problem2() {
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //create jframe and set properties
        
        JFrame frame = new JFrame("Chess");
        
        frame.setSize(400, 400);
                
        frame.setLayout(new BorderLayout());
        
        //create chess component
        ChessComponent chess = new ChessComponent();

        
        frame.add(chess, BorderLayout.CENTER);
                
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        frame.setVisible(true);
        
    }
    
}
