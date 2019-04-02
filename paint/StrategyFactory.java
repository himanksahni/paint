package ca.utoronto.utm.paint;

import java.awt.event.ActionListener;



public class StrategyFactory {

public ShapeManipulatorStrategy makeStrategy(String shape){



	if (shape=="Circle"){

		return new CircleStrategy();}
		
	if (shape=="Rectangle"){

		return new RectStrategy();
}
	
	if (shape=="Square"){

		return new SquareStrategy();
}

	return null;

}}