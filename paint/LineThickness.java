package ca.utoronto.utm.paint;

/**
 * Line Thickness represents the width of the line
 * @author csc207student 
 *
 */
public class LineThickness {
	private int Thickness;   
	 
	/**
	 * Creates the LineThickness 
	 * @param Thickness An integer
	 */
	LineThickness(int Thickness){
		this.Thickness = Thickness;
	}   
	
	/**
	 * Sets the thickness
	 * @param new_Thickness An integer
	 */
	public void setThickness(int new_Thickness){
		this.Thickness = new_Thickness;
	}
	
	/**
	 * 
	 * @return the thickness
	 */
	public int getThickness(){
		return this.Thickness;
	}
	

}