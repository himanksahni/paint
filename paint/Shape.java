package ca.utoronto.utm.paint;

import java.awt.*;

public abstract class Shape implements DrawingCommands{

	/**
	 * Abstract class for shapes
	 * Shapes are able to draw themselves
	 */
	public abstract void execute(Graphics2D g2d);
}
