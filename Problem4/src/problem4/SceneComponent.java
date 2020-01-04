/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author manxboy
 */
public class SceneComponent extends JComponent implements ActionListener {
    
    /*Array of all the balls in the scene*/
    private Ball[] balls = new Ball[10];
    
    private static int STARTING_VELOCITY_MAGNITUDE = 3;
    
    //timer for physics tick interrupt
    Timer timer;
    
    public SceneComponent() {
        super();
        
        //initialize all of the balls in the scene
        for (int i = 0; i < balls.length; i++) {
            
            
            //choose random position for the ball to be placed, inside the bounds of the pane, taking into account the size of the ball
            int x = (int) ( (Math.random() * (Problem4.SCENE_HEIGHT - (Ball.RADIUS * 2))) + Ball.RADIUS );
            int y = (int) ( (Math.random() * (Problem4.SCENE_WIDTH - (Ball.RADIUS * 2))) + Ball.RADIUS );
            
            Ball ball = new Ball(new Vec2d(x, y));
            
            //set the velocity by choosing a random angle and scaling it by the starting velocity magnitude
            ball.velocity = new Vec2d(Math.random() * 2).mult(STARTING_VELOCITY_MAGNITUDE);
            
            //add the ball to the list
            balls[i] = ball;
        }
        
        //add tick timer
        timer = new Timer(10, this);
        timer.start();
    }
    
    @Override()
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        //set the color of the balls
        g.setColor(Color.red);
        
        //loop over all of the balls
        for (Ball ball : balls) {
            //draw an arc, with its top left coordinates equal to the position
            //of the ball minus the radius, it's diameter equal to two times the
            //radius, and spanning from 0 degrees to 360 (a full circle)
            g.fillArc(
                    (int) (ball.pos.x - Ball.RADIUS),
                    (int) (ball.pos.y - Ball.RADIUS),
                    (int) (Ball.RADIUS * 2),
                    (int) (Ball.RADIUS * 2),
                    0,
                    360
            );
        }
    }

    @Override
    /**
     * Listener for the physics tick interrupt timer
     */
    public void actionPerformed(ActionEvent e) {
        
        //loop over all of the balls
        for (int i = 0; i < balls.length; i++) {
            
            //grab the ball
            Ball ball = balls[i];
            
            //check wether the ball in colliding with the wall, if so, take the
            //component perpendicular to the wall and ensure that it is pointing
            //towards the center of the panel
            
            if (ball.pos.x > getWidth() - Ball.RADIUS) ball.velocity = new Vec2d(Math.abs(ball.velocity.x) * -1d, ball.velocity.y);
            
            if (ball.pos.y > getHeight() - Ball.RADIUS) ball.velocity = new Vec2d(ball.velocity.x, Math.abs(ball.velocity.y) * -1d);
            
            if (ball.pos.x < Ball.RADIUS) ball.velocity = new Vec2d( Math.abs(ball.velocity.x), ball.velocity.y);
            
            if (ball.pos.y < Ball.RADIUS) ball.velocity = new Vec2d(ball.velocity.x, Math.abs(ball.velocity.y));
            
            //loop over every other ball in the scene, starting from the new ball
            //from this to avoid checking any ball -> ball collision twice
            for (int j = i + 1; j < balls.length; j++) {
                //calcuate and apply the collision, if any
                ball.collideWithBall(balls[j]);
            }
            
            //make the ball do a physics tick
            ball.tick();
        }
        
        //call for the panel to repaint
        repaint();
    }
}
