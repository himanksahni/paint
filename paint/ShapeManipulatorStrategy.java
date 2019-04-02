package ca.utoronto.utm.paint;

import java.awt.event.MouseEvent;

public interface ShapeManipulatorStrategy {
	
	public Shape createShape(Point centre, PaintPanel p);
}
