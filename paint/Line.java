package ca.utoronto.utm.paint;

import java.awt.*;
/**
 * Line consists of two points being connected
 * @author csc207student 
 *
 */
public class Line extends Shape implements DrawingCommands {
	Point point1;
	Point point2;
	Color color;
	int Linethickness;
	
	/**
	 * Creates a line by setting the Starting Point and the Ending Point
	 * @param point1 Starting Point
	 * @param point2 Ending Point
	 */
	Line(Point point1, Point point2){
		this.point1 = point1;
		this.point2 = point2;
	}
	
	/**
	 * 
	 * @return Starting Point
	 */
	public Point getPoint1() {
		return point1;
	}
	
	/**
	 * 
	 * @return Ending Point
	 */
	public Point getPoint2() {
		return point2;
	}
	
	/**
	 * 
	 * @return The Color of the line
	 */
	public Color getColor(){
		return color;
	}

	/**
	 * Sets the Starting Point
	 * @param point new Starting Point
	 */
	public void setPoint1(Point point) {
		point1 = point;
	}
	
	/**
	 * Sets the Ending Point
	 * @param point new Ending Point
	 */
	public void setPoint2(Point point) {
		point2 = point;
	}
	
	/**
	 * Sets a new color to the line
	 * @param c A color
	 */
	public void setColor(Color c){
		color = c;
	}
	
	/**
	 * 
	 * @return the Linethickness
	 */
	public int getLinethickness(){
		return Linethickness;
	}
	
	/**
	 * sets a new linethickness
	 * @param thickness Linethickness
	 */
	public void setLinethickness(int thickness){
		Linethickness = thickness;
	}

	@Override
	public void execute(Graphics2D g2d) {
		g2d.setColor(color);
		g2d.setStroke(new BasicStroke(Linethickness));
		g2d.drawLine(point1.getX(),point1.getY(),point2.getX(),point2.getY());
		
	}
}
