package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

/**
 * model for the application
 * @author csc207student
 *
 */
public class PaintModel extends Observable {
	
	private ArrayList<Point> points=new ArrayList<Point>();
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private ArrayList<Shape> undone = new ArrayList<Shape>();
	
	/**
	 * 
	 * @return An arrayList of Shapes
	 */
	public ArrayList<Shape> getShapes() {
		return shapes;
	}
	
	/**
	 * 
	 * @param shapes sets an new arraylist of shapes
	 */
	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}
	
	/**
	 * removes the most recent shape created
	 */
	public void undo(){
		if (this.shapes.isEmpty() == false){
			Shape u = this.shapes.get(this.shapes.size() - 1);
			this.shapes.remove(this.shapes.size() - 1);
			this.undone.add(u);
			this.setChanged();
			this.notifyObservers();
		}
	}
	
	/**
	 * creates the most recent shape removed
	 */
	public void redo(){
		if (this.undone.isEmpty() == false){
			Shape u = this.undone.get(this.undone.size() - 1);
			this.undone.remove(this.undone.size() - 1);
			this.shapes.add(u);
			this.setChanged();
			this.notifyObservers();
		}
	}
	
	/**
	 * removes the last shape in the shapes array
	 */
	public void removeLast(){
		if (shapes.isEmpty() == false){
			this.shapes.remove(this.shapes.size() - 1);
		}
	}
	
	/**
	 * Adds shape to the shapes arraylist
	 * @param c Shape
	 */
	public void addShapes(Shape c){
		this.shapes.add(c);
		this.undone.clear();
		this.setChanged();
		this.notifyObservers();
	}
	 
	/**
	 * removes all the points
	 */
	public void clearPoints(){
		points.clear();
	}
	
	/**
	 * Adds point to the point arraylist
	 * @param p Point
	 */
	public void addPoint(Point p){
		this.points.add(p);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * 
	 * @return The point arraylist
	 */
	public ArrayList<Point> getPoints(){
		return points;
	}

}
