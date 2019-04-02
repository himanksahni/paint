package ca.utoronto.utm.paint;

import java.awt.*;
import java.awt.event.MouseEvent; 
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.SwingUtilities;

/**
 * MouseListener for shapes
 * @author csc207student
 *
 */
public class ShapeMouseListener implements MouseMotionListener, MouseListener {
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private PaintPanel panel;
	private View view; // So we can talk to our parent or other components of the view
	private LineThickness LineThickness;
	private String mode; // modifies how we interpret input (could be better?)
	private Color color;
	private Circle circle; // the circle we are building
	private Rectangle rectangle; // the rectangle we are building
	private Square square;
	private Squiggle squiggle;
	private Point previous=null;
	//private Point next=null;
	private boolean fil;
	private boolean drag = false;
	
	ShapeMouseListener(PaintPanel panel, PaintModel model,View view,LineThickness LineThickness,String mode,
			Color color, Circle circle, Rectangle rectangle, Square square, Squiggle squiggle,
			Point previous,boolean fil,boolean drag){
		
		this.model = model;
		this.view = view;
		this.LineThickness = LineThickness;
		this.mode = mode;
		this.color = color;
		this.circle = circle;
		this.rectangle = rectangle;
		this.square = square;
		this.squiggle = squiggle;
		this.previous = previous;
		this.fil = fil;
		this.drag = drag;
		this.panel = panel;
		
	}
	
	/**
	 * Sets a new mode depending on which button is pushed
	 * @param mode String
	 */
	public void setNewMode(String mode){
		this.mode = mode;
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {

		}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.mode=="Squiggle"){
			this.model.addPoint(new Point(e.getX(), e.getY(), this.panel.getColor(),this.LineThickness.getThickness()));
			this.squiggle.addPoint(new Point(e.getX(), e.getY()));
			
		} else if(this.mode=="Circle"){
			if (drag == true){
				this.model.removeLast();
			}
			drag = true;
			int radius = (int) Math.sqrt(Math.pow(e.getX() - this.circle.getCentre().getX(), 2) 
					+ Math.pow(e.getY() - this.circle.getCentre().getY(), 2));
			this.circle.setRadius(radius);
			this.circle.setLineThickness(this.circle.getLineThickness());
			this.circle.setColor(this.panel.getColor());
			this.model.addShapes(this.circle);
			
			
		}else if(this.mode=="Rectangle"){
			if (drag == true){
				this.model.removeLast();
			}
			drag = true;
			int length = Math.abs(e.getX()-this.rectangle.getCentre().getX());
			int breadth = Math.abs(e.getY()-this.rectangle.getCentre().getY());
			int x = this.rectangle.getCentre().getX();
			int y = this.rectangle.getCentre().getY();
			this.rectangle.setLength(length);
			this.rectangle.setLineThickness(this.rectangle.getLineThickness());
			this.rectangle.setColor(this.panel.getColor());
			this.rectangle.setBreadth(breadth);

			this.model.addShapes(this.rectangle);

			
		}else if(this.mode=="Square"){
			if (drag == true){
				this.model.removeLast();
			}
			drag = true;
			int length = Math.abs(e.getX()-this.square.getCentre().getX());
			int breadth = Math.abs(e.getY()-this.square.getCentre().getY());

			this.square.setSide1(length);
			this.square.setSide2(breadth);
			this.square.setLineThickness(this.square.getLineThickness());
			this.square.setColor(this.panel.getColor());
			this.model.addShapes(this.square);

		}else if(this.mode=="Polyline"){

			
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(this.mode=="Squiggle"){
			
		} else if(this.mode=="Circle"){
			
		}else if(this.mode == "Polyline"){

			//resets for a new polyline

			if(SwingUtilities.isRightMouseButton(e)){
				previous = null;
				//next = null;
				return;
			}

			if (previous != null){
				Point next = new Point(e.getX(),e.getY());
				Line l1 = new Line(this.previous,next);
				l1.setColor(this.panel.getColor());
				l1.setLinethickness(this.LineThickness.getThickness());
				this.model.addShapes(l1);
				this.previous = next;

			}else if (previous == null){
				previous = new Point(e.getX(),e.getY());
				return;}}}

	@Override
	public void mousePressed(MouseEvent e) {
		if(this.mode=="Squiggle"){
			//this.model.addPoint(new Point(e.getX(), e.getY(), new Color(0,0,0,0),this.LineThickness.getThickness()));
			this.squiggle = new Squiggle(this.panel.getColor(), this.LineThickness.getThickness());
			this.squiggle.addPoint(new Point(e.getX(), e.getY()));
			
		} else if(this.mode=="Circle"){
			Point centre = new Point(e.getX(), e.getY());
			this.circle= (Circle) this.panel.getStrategy().createShape(centre,this.panel);

		} else if(this.mode=="Rectangle"){
			Point centre = new Point(e.getX(), e.getY());		
			this.rectangle= (Rectangle) this.panel.getStrategy().createShape(centre,this.panel);

		
		}else if(this.mode=="Square"){
			Point centre = new Point(e.getX(), e.getY());
			this.square= (Square) this.panel.getStrategy().createShape(centre,this.panel);

		}
	}

	@Override
	public void mouseReleased(MouseEvent e) { 
		if(this.mode=="Squiggle"){
			this.model.clearPoints();
			this.model.addShapes(this.squiggle);
			
		} else if(this.mode=="Circle"){
			if(this.circle!=null){
				int radius = (int) Math.sqrt(Math.pow(e.getX() - this.circle.getCentre().getX(), 2) + Math.pow(e.getY() - this.circle.getCentre().getY(), 2));
				this.circle.setRadius(radius);
				this.circle.setLineThickness(this.circle.getLineThickness());
				this.circle.setColor(this.panel.getColor());
				this.model.addShapes(this.circle);
				this.circle.setFiled(this.panel.isFil());
				this.circle=null;
				this.model.removeLast();
				this.drag = false;}
		} else if(this.mode=="Rectangle"){
			if(this.rectangle!=null){
				int length = Math.abs(e.getX()-this.rectangle.getCentre().getX());
				int breadth = Math.abs(e.getY()-this.rectangle.getCentre().getY());
				int x = this.rectangle.getCentre().getX();
				int y = this.rectangle.getCentre().getY();
				if (e.getX() < this.rectangle.getCentre().getX()){
					x = e.getX();
				}
				if (e.getY() < this.rectangle.getCentre().getY()){
					y = e.getY();
				}
				Point newcenter = new Point(x,y);
				this.rectangle.setCentre(newcenter);
				this.rectangle.setLength(length);
				this.rectangle.setBreadth(breadth);
				this.rectangle.setLineThickness(this.rectangle.getLineThickness());
				this.rectangle.setColor(this.panel.getColor());
				this.rectangle.setFilled(this.panel.isFil());
				this.model.addShapes(this.rectangle);
				this.rectangle=null;
				this.model.removeLast();
				this.drag = false; }
		}else if(this.mode=="Square"){
			if(this.square!=null){
				int length = Math.abs(e.getX()-this.square.getCentre().getX());
				int breadth = Math.abs(e.getY()-this.square.getCentre().getY());
				int x = this.square.getCentre().getX();
				int y = this.square.getCentre().getY();
				if (e.getX() < this.square.getCentre().getX()){
					x = e.getX(); 
				}
				if (e.getY() < this.square.getCentre().getY()){
					y = e.getY();
				}
				Point newcenter = new Point(x,y);
				this.square.setCentre(newcenter);
				this.square.setSide1(length);
				this.square.setSide2(breadth);
				this.square.setLineThickness(this.square.getLineThickness());
				this.square.setColor(this.panel.getColor());
				this.square.setFilled(this.panel.isFil());

				this.model.addShapes(this.square);
				this.square=null;
				this.model.removeLast();
				this.drag = false;
			}}}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		}
	}
