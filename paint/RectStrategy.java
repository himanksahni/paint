package ca.utoronto.utm.paint;

public class RectStrategy implements ShapeManipulatorStrategy {


	@Override
	public Rectangle createShape(Point centre, PaintPanel p) {
//		Point centre = new Point(e.getX(), e.getY());
		return new Rectangle(0,0,centre, p.getLineThickness());
	}
}   
