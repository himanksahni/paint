package ca.utoronto.utm.paint;

import java.awt.*;
import java.util.ArrayList;

/**
 * A square consists of two sides, a center point and a color
 * @author csc207student  
 *
 */
public class Square extends Shape implements DrawingCommands{
	
	private int side1;
	private int side2;
	private Point centre;
	private Color color;
	private boolean isFilled;
	private PaintModel model;
	private int LineThickness;
	
	/**
	 * 
	 * @return the linethickness   
	 */
	public int getLineThickness() {
		return LineThickness;
	}

	/**
	 * sets a new linethickness
	 * @param lineThickness
	 */
	public void setLineThickness(int lineThickness) {
		LineThickness = lineThickness;
	}

	/**
	 * Creates a square using two sides and a center point
	 * @param side1 An integer
	 * @param side2 An integer
	 * @param centre A point
	 */
	public Square(int side1,int side2, Point centre, LineThickness linethickness){
		
		this.centre=centre;
		this.side1=side1;
		this.side2=side2;
		this.LineThickness=linethickness.getThickness();

	}

	/**
	 * 
	 * @return A boolean if the square is filled or not
	 */
	public boolean isFilled() {
		return isFilled;
	}

	/**
	 * Sets the square to be filled or not
	 * @param isFilled A boolean
	 */
	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}


	/**
	 * 
	 * @return side1 of square
	 */
	public int getSide1() {
		return side1;
	}


	/**
	 * sets side1 of square
	 * @param side1 An integer
	 */
	public void setSide1(int side1) {
		this.side1 = side1;
	}


	/**
	 * 
	 * @return side2 of the square
	 */
	public int getSide2() {
		return side2;
	}

	/**
	 * sets side2 of the square
	 * @param side2 An integer
	 */
	public void setSide2(int side2) {
		this.side2 = side2;
	}


	/**
	 * 
	 * @return The center point of square
	 */
	public Point getCentre() {
		return centre;
	}


	/**
	 * Sets a new center point for square
	 * @param centre A point
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
	
	/**
	 * 
	 * @return the color of the square
	 */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * sets a new color to the square
	 * @param c Color
	 */
	public void setColor(Color c){
		this.color = c;
	}

	@Override
	public void execute(Graphics2D g2d) {
			int x = this.getCentre().getX();
			int y = this.getCentre().getY();
			int length = this.getSide1();
			this.setSide2(length);
			int breadth= this.getSide2();
			
			if (this.isFilled()==true){
				g2d.setStroke(new BasicStroke(this.LineThickness));
				g2d.setColor(this.getColor());
				g2d.fillRect(x, y, length, breadth);
				g2d.drawRect(x, y, length, breadth);
			}
			else{
				g2d.setStroke(new BasicStroke(this.LineThickness));
				g2d.setColor(this.getColor());
				g2d.drawRect(x, y, length, breadth);
			
			}

		}
		
		
	}
