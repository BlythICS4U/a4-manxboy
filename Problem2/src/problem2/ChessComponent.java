/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author manxboy
 */
public class ChessComponent extends JComponent {
    
    @Override
    public void paintComponent(Graphics g) {
        //clear the buffer
        super.paintComponent(g);
        
        //get the width of the component
        int width = getWidth();
        
        //get the height of the component
        int height = getHeight();
        
        //get the value of the smallest dimension, effectivily the size of the
        //largest square that can fit in the frame
        int min = Math.min(width, height);
        
        //find the size of each cell by taking the width and dividing it by the
        //number of rows/columns
        int cell_size = min / 8;
        
        //toggle for the color
        boolean red = true;
        
        //loop over all the columns
        for (int x = 0; x < 8; x++) {
            //loop over all the rows
            for (int y = 0; y < 8; y++) {
                
                //toggle the color to be either red or black
                if (red) {
                    g.setColor(Color.red);
                    red = false;
                } else {
                    g.setColor(Color.black);
                    red = true;
                }
                
                //create the square from the coordinates x and y, scaling by cell_size,
                //with a width and height of cell_size
                g.fillRect(x * cell_size, y * cell_size, cell_size, cell_size);
                                
            }
            
            //invert red for the start of the next line
            red = !red;
        }
        
    }
    
}
