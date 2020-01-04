/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem4;

import java.util.Random;

/**
 *
 * @author manxboy
 */
public class Ball {
    public Vec2d pos;
    public Vec2d velocity;
    
    public Ball(Vec2d pos) {
        this.pos = pos;
        this.velocity = Vec2d.RIGHT;
    }
    
    
    /**
     * Test wether this ball will collide with the other ball in this frame
     * @param b the other ball to test ageist
     * @return true if colliding/will collide, else false
     */
    public boolean willCollideWithBallThisFrame(Ball b) {
        double distance = this.pos.sub(b.pos).length();
        
        return distance < RADIUS * 2;
    }
    
    /**
     * tests then calculates the collision between two balls, if in range
     * @param b the other ball to collide with
     */
    public void collideWithBall(Ball b) {
        
        //check wether the balls will actualy collide this frame
        if (willCollideWithBallThisFrame(b)) {
            
            //get the vector between the two balls
            Vec2d difference = this.pos.sub(b.pos);
        
            //get the magnitude of the difference
            double distance = difference.length();
        
            //derive the unit vector in the direction of the collision
            Vec2d collisionUnit = difference.normalize();
        
            //calcuate the magnitude of the velocty of each ball along the axis defined by the collision unit vector
            double collisionComponentA = velocity.dot(collisionUnit);
            double collisionComponentB = b.velocity.dot(collisionUnit);
        
            //perform 1-dimesional elastic collision on the axis defined by the collision unit vector
            velocity = velocity.add(collisionUnit.mult(collisionComponentB - collisionComponentA));
            b.velocity = b.velocity.add(collisionUnit.mult(collisionComponentA - collisionComponentB));
        }
    }
    
    public void tick() {
        pos = pos.add(velocity);
    }
    
    public static final double RADIUS = 10;
}
