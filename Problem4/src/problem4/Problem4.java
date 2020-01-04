/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem4;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author cgallinaro
 */
public class Problem4 {

    public static final int SCENE_WIDTH = 800;
    public static final int SCENE_HEIGHT = 800;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //create new JFrame
        JFrame frame = new JFrame();
        frame.setTitle("balls");
        
        //set the size
        frame.setSize(SCENE_WIDTH, SCENE_HEIGHT);
        frame.setResizable(false);
        
        //create the scene and add it to the JFrame
        SceneComponent comp = new SceneComponent();
        frame.add(comp);
        
        //make the frame visible and set the close opperation
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
}
