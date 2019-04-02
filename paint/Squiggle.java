package ca.utoronto.utm.paint;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.*;
public class Squiggle extends Shape implements DrawingCommands{
	
	private ArrayList<Point> points = new ArrayList<Point>();
	private Color color;
	private int lineThickness;
	
	/**
	 * Creates a squiggle
	 * @param c Color
	 * @param l integer for the Linethickness
	 */
	public Squiggle(Color c, int l){
		this.color = c;
		this.lineThickness = l;
	}
	
	/**
	 * Adds point to the point arraylist
	 * @param p Point
	 */
	public void addPoint(Point p){
		this.points.add(p);
	}
	
	/**
	 * 
	 * @return the linethickness
	 */
	public int getLineThickness() {
		return lineThickness;
	}

	/**
	 * Sets a new linethickness
	 * @param lineThickness An integer
	 */
	public void setLineThickness(int lineThickness) {
		this.lineThickness = lineThickness;
	}
	
	/**
	 * 
	 * @return the color of the squiggle
	 */
	public Color getColor(){
		return this.color;
	}
	
	/**
	 * sets a new color to the squiggle
	 * @param c
	 */
	public void setColor(Color c){
		this.color = c;
	}
	
	public void execute(Graphics2D g2d){
		g2d.setStroke(new BasicStroke(this.lineThickness));
		g2d.setColor(this.getColor());
		for (int i = 0; i < points.size() - 1; i++){
			g2d.drawLine(points.get(i).getX(),points.get(i).getY(),points.get(i+1).getX(),points.get(i+1).getY());
		}
	}
}
