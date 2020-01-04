/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problem4;

/**
 * Basic immutable Vector class
 * @author manxboy
 */
public class Vec2d {
    
    /**
     * X component of the vector
     */
    public final double x;
    
    /**
     * Y component of the vector
     */
    public final double y;
    
    
    /**
     * Construct a new vector with the given components
     * @param x the x component
     * @param y the y component
     */
    public Vec2d(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Construct a new vector with angle a from the origin
     * @param a the angle
     */
    public Vec2d(double a) {
        this.x = Math.cos(a);
        this.y = Math.sin(a);
    }
    
    /**
     * Get the resulting sum of the vector and two vector components as a new Vector
     * @param x the x component to sum with
     * @param y the y component to sum with
     * @return a new vector representing the result
     */
    public Vec2d add(double x, double y) {
        return new Vec2d(this.x + x, this.y + y);
    }
    
    /**
     * Get the resulting sum of this vector and another Vector
     * @param v the other Vector to sum with
     * @return a new vector representing the result
     */
    public Vec2d add(Vec2d v) {
        return new Vec2d(x + v.x, y + v.y);
    }
    
    /**
     * Get the resulting difference of the vector and two vector components as a new Vector
     * @param x the x component to sub from this
     * @param y the y component to sub from this
     * @return a new vector representing the result
     */
    public Vec2d sub(double x, double y) {
        return new Vec2d(this.x - x, this.y - y);
    }
    
    /**
     * Get the resulting difference of this vector and another Vector
     * @param v the other Vector to difference
     * @return a new vector representing the result
     */
    public Vec2d sub(Vec2d v) {
        return new Vec2d(x - v.x, y - v.y);
    }
    
    /**
     * Get the scalar Multiplication of this Vector and a scalar
     * @param s the scalar
     * @return a new Vector representing the result
     */
    public Vec2d mult(double s) {
        return new Vec2d(x * s, y * s);
    }
    
    /**
     * Get the scalar division of this Vector and a scalar
     * @param s the scalar
     * @return a new Vector representing the result
     */
    public Vec2d div(double s) {
        return new Vec2d(x / s, y / s);
    }
    
    /**
     * Get the normalized version of this vector
     * @return a new Vector representing the result
     */
    public Vec2d normalize() {
        return div(length());
    }
    
    /**
     * Get the dot product or scalar product of this Vector and another Vector
     * @param v the other Vector
     * @return the dot product
     */
    public double dot(Vec2d v) {
        return (x * v.x) + (y * v.y);
    }
    
    /**
     * Get the length (magnitude) of the vector
     * @return the length
     */
    public double length() {
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
    }
    
    /**
     * Get the angle of the vector from the positive X axis
     * @return the angle
     */
    public double angle() {
        return Math.atan2(y, x);
    }
    
    
    /*==UNIT VECTORS==========================================================*/
    
    public static final Vec2d UP    = new Vec2d(0,  1);
    public static final Vec2d DOWN  = new Vec2d(0, -1);
    
    public static final Vec2d LEFT  = new Vec2d(-1, 0);
    public static final Vec2d RIGHT = new Vec2d(1,  0);
    
    public static final Vec2d ZERO  = new Vec2d(0,  0);
}
