package ca.utoronto.utm.paint;

import java.awt.*;

/**
 * A rectangle consists of length and breadth as well as a center and a color
 * @author csc207student 
 *
 */ 
public class Rectangle extends Shape implements DrawingCommands {
	
	private int length; 
	private int breadth;
	private Point centre;
	private Color color;
	private  boolean isFilled;
	private int lineThickness;

	/**
	 * Creates a rectangle using length, breadth and a center point
	 * @param length
	 * @param breadth
	 * @param centre    
	 */
	public Rectangle(int length, int breadth, Point centre, LineThickness linethickness){
		
		this.centre=centre;
		this.length=length;
		this.breadth=breadth;
		this.lineThickness=linethickness.getThickness();
	
	}
	
	/**
	 * 
	 * @return the linethickness
	 */
	public int getLineThickness() {
		return lineThickness;
	}

	/**
	 * Sets the linethickness to a new thickness
	 * @param lineThickness
	 */
	public void setLineThickness(int lineThickness) {
		this.lineThickness = lineThickness;
	}

	/**
	 * 
	 * @return the length of rectangle an integer
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Sets a new length of rectangle
	 * @param length An integer
	 */
	public void setLength(int length) {
		this.length = length;
	}


	/**
	 * 
	 * @return if the rectangle is filled
	 */
	public boolean isFilled() {
		return isFilled;
	}

	/**
	 * Sets the rectangle to be filled or not
	 * @param isFilled A Boolean
	 */
	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}


	/**
	 * 
	 * @return the breadth of the rectangle an integer
	 */
	public int getBreadth() {
		return breadth;
	}


	/**
	 * Sets the breadth of rectangle
	 * @param breadth An integer
	 */
	public void setBreadth(int breadth) {
		this.breadth = breadth;
	}


	/**
	 * 
	 * @return The center point of rectangle
	 */
	public Point getCentre() {
		return centre;
	}


	/**
	 * Sets a new center for rectangle
	 * @param centre A Point
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	/**
	 * 
	 * @return the color of the rectangle
	 */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * Sets a new color to rectangle
	 * @param c A Color
	 */
	public void setColor(Color c){
		this.color = c;
	}

	@Override
	public void execute(Graphics2D g2d) {
			int x = this.getCentre().getX();
			int y = this.getCentre().getY();
			int length = this.getLength();
			int breadth = this.getBreadth();
			if (this.isFilled()==true){
				g2d.setStroke(new BasicStroke(this.lineThickness));
				g2d.setColor(this.getColor());
				g2d.fillRect(x, y, length, breadth);
				g2d.drawRect(x, y, length, breadth);
			}
			else{
				g2d.setStroke(new BasicStroke(this.lineThickness));
				g2d.setColor(this.getColor());
				g2d.drawRect(x, y, length, breadth);
			
			}

		}
		
	}

