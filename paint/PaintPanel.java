package ca.utoronto.utm.paint;

import javax.swing.*;  
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

/**
 * class handles drawing all the shapes onto the application
 * @author csc207student
 *
 */
class PaintPanel extends JPanel implements Observer {  
	private PaintModel model; // slight departure from MVC, because of the way painting works
	private View view; // So we can talk to our parent or other components of the view
	private LineThickness LineThickness;
	private String mode; // modifies how we interpret input (could be better?)
	private Color color;
	private Circle circle; // the circle we are building
	private Rectangle rectangle; // the rectangle we are building
	private Square square;
	private Squiggle squiggle;
	private Point previous=null;
	private boolean fil;

	private boolean drag = false;
	ShapeMouseListener listener;

	private ShapeManipulatorStrategy strategy;
	private StrategyFactory factory=new StrategyFactory();
	private Shape shape;

	private ArrayList<ArrayList<Point>> Squiggles =new ArrayList<ArrayList<Point>>();

	
	public PaintPanel(PaintModel model, View view,LineThickness linethickness){
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(300,300));
		
		this.mode="Circle"; // bad code here?
		this.color = Color.black;
		
		this.strategy= new CircleStrategy();
		this.model = model;
		this.model.addObserver(this);
		
		this.view=view;
		this.LineThickness = linethickness;
		this.fil=false;
		this.listener = new ShapeMouseListener(this, this.model, this.view,this.LineThickness,this.mode,
				this.color, this.circle,this.rectangle,this.square,this.squiggle,this.previous,this.fil,
				this.drag);
		this.addMouseListener(this.listener);
		this.addMouseMotionListener(this.listener);
	}

	/**
	 *  View aspect of this
	 */
	public void paintComponent(Graphics g) {
		// Use g to draw on the JPanel, lookup java.awt.Graphics in
		// the javadoc to see more of what this can do for you!!
		
        super.paintComponent(g); //paint background
        Graphics2D g2d = (Graphics2D) g; // lets use the advanced api
		// setBackground (Color.blue); 
		// Origin is at the top left of the window 50 over, 75 down
		g2d.setColor(Color.black);
		
		// Draw Shapes
		ArrayList<Shape> shapes = this.model.getShapes();
		for(Shape s: this.model.getShapes()){
			s.execute(g2d);
		}
		
		// Draw Lines
		ArrayList<Point> points = this.model.getPoints();
		for(int i=0;i<points.size()-1; i++){
			Point p1=points.get(i); 
			Point p2=points.get(i+1);
			g2d.setColor(p1.getColor());
			g2d.setStroke(new BasicStroke(p1.getLinethickness()));
			g2d.drawLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());
		}
		g2d.dispose();
	}

	@Override
	public void update(Observable o, Object arg) {
		// Not exactly how MVC works, but similar.
		this.repaint(); // Schedule a call to paintComponent
	}
	
	/**
	 *  Controller aspect of this 
	 */
	public void setMode(String mode){
		this.mode = mode;
		this.listener.setNewMode(mode);
	}
	public void setColor(Color color){
		this.color=color;
	}
	
	public Color getColor(){
		return this.color;
	}
	
	public boolean isFil() {
		return fil;
	}

	public void setFil(boolean fil) {
		this.fil = fil;
	}

	
	public void setStrategy(String s){
		this.strategy=factory.makeStrategy(s);
	}
	public ShapeManipulatorStrategy getStrategy(){
		return this.strategy;
	}
	


	public LineThickness getLineThickness() {
		return LineThickness;
	}

	public void setLineThickness(LineThickness lineThickness) {
		LineThickness = lineThickness;
	}}
