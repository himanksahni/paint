package ca.utoronto.utm.paint;
public class SquareStrategy implements ShapeManipulatorStrategy {

	@Override
	public Square createShape(Point centre, PaintPanel panel) {
		return new Square(0,0,centre, panel.getLineThickness());
	}

}
