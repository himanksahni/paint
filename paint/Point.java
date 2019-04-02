package ca.utoronto.utm.paint;

import java.awt.*;

/**
 * A point is represented by an x and y coordinate
 * @author csc207student 
 *
 */
public class Point{
	int x, y;
	Color color;
	int Linethickness;
	
	/**
	 * Creates a point using an x and y coordinate and a color
	 * @param x An integer
	 * @param y An integer
	 * @param c A color
	 */
	Point(int x, int y, Color c,int Linethickness){
		this.x=x; this.y=y;
		this.color = c;
		this.Linethickness = Linethickness;
	}
	
	/**
	 * Creates a point using an x and y coordinate
	 * @param x An integer
	 * @param y An integer
	 */
	Point(int x, int y){
		this.x=x; this.y=y;
	}
	
	/**
	 * 
	 * @return the x coordinate an integer
	 */
	public int getX() {
		return x;
	}

	/**
	 * sets the x coordinate
	 * @param x An integer
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * 
	 * @return the y coordinate an integer
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y coordinate
	 * @param y An integer
	 */
	public void setY(int y) {
		this.y = y;   
	}
	
	/**
	 * 
	 * @return returns the colour of the point
	 */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * Sets the color of the point
	 * @param c A color
	 */
	public void setColor(Color c){
		this.color = c;
	}
	
	/**
	 * 
	 * @return the Linethickness
	 */
	public int getLinethickness(){
		return this.Linethickness;
	}
	
	/**
	 * Sets the linethickness to a new thickness
	 * @param thickness
	 */
	public void setLinethickness(int thickness){
		this.Linethickness = thickness;
	}
}
