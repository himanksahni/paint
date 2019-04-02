package ca.utoronto.utm.paint;
  
import java.awt.*;
public interface DrawingCommands {
	
	/**
	 * Interface for executing the shapes
	 * @param g2d Graphics2D
	 */
	public void execute(Graphics2D g2d);

}
