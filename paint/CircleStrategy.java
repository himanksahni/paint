package ca.utoronto.utm.paint;

import java.util.Observable;
import java.util.Observer;

public class CircleStrategy implements ShapeManipulatorStrategy {
	private View view;
	
	
	@Override
	public Circle createShape(Point centre, PaintPanel panel) {
		return new Circle(centre,0, panel.getLineThickness());
	}

//	@Override
//	public void update(Observable o, Object arg) {
//		this.view.getPaintPanel().repaint();
//		
//	}

}