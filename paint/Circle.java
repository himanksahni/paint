package ca.utoronto.utm.paint;

import java.awt.*;




public class Circle extends Shape implements DrawingCommands{

/**
 * A circle consists of a color, radius and center point
 * @author csc207student
 *
 */

	private Point centre;
	private int radius;
	private Color color;
	private boolean isFiled;
	private int LineThickness;

	

	/**
	 * Creates a circle by setting center point and radius
	 * @param centre A point
	 * @param radius An integer
	 */

	public Circle(Point centre, int radius, LineThickness LineThickness ) {
		super();
		this.centre = centre;
		this.radius = radius; 
		this.LineThickness= LineThickness.getThickness();
	}
	
	/**
	 * 
	 * @return the center point of circle
	 */
	public Point getCentre() {
		return centre;
	}

	/**
	 * Sets a new center point for circle
	 * @param centre A Point
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}

	/**
	 * 
	 * @return the Radius of the circle
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Sets a new radius for circle
	 * @param radius An integer
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	/**
	 * 
	 * @return the Color of the circle
	 */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * Sets a new color for circle
	 * @param c A color
	 */
	public void setColor(Color c){
		this.color = c;
	}

	/**
	 * 
	 * @return if circle is filled or not
	 */
	public boolean isFiled() {
		return isFiled;
	}

	/**
	 * Sets circle to fill or not
	 * @param isFiled A boolean
	 */
	public void setFiled(boolean isFiled) {
		this.isFiled = isFiled; 
	}

	@Override
	public void execute(Graphics2D g2d) {
			int x = this.getCentre().getX();
			int y = this.getCentre().getY();
			int radius = this.getRadius();
			
			if (this.isFiled()==true){
				g2d.setStroke(new BasicStroke(this.LineThickness));
				g2d.setColor(this.getColor());
				g2d.fillOval(x - radius, y - radius, radius*2, radius*2);
				g2d.drawOval(x - radius, y - radius, radius*2, radius*2);

			}
			else{
				g2d.setStroke(new BasicStroke(this.LineThickness));
				g2d.setColor(this.getColor());
				g2d.drawOval(x - radius, y - radius, radius*2, radius*2);	
			
			}}

	/**
	 * 
	 * @return the Linethickness
	 */
	public int getLineThickness() {
		return LineThickness;
	}

	/**
	 * set the linethickness to a new linethickness
	 * @param lineThickness A Linethickness
	 */
	public void setLineThickness(int lineThickness) {
		LineThickness = lineThickness;
	}

 }


