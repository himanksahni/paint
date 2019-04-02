package ca.utoronto.utm.paint;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBoxMenuItem;

/**
 * ActionListener for the line width drop down menu
 * @author csc207student 
 *
 */
public class LineThicknessActionListener implements ActionListener {
	
	LineThickness Linethickness;
	JCheckBoxMenuItem checkMenuItem1;
	JCheckBoxMenuItem checkMenuItem2; 
	JCheckBoxMenuItem checkMenuItem3;
	JCheckBoxMenuItem checkMenuItem4;
	JCheckBoxMenuItem checkMenuItem5;
	
	
	/**
	 * Creates an ActionListener for the Line Width drop down menu
	 * @param Linethickness Linethickness
	 * @param checkMenuItem1 JCheckBoxMenuItem
	 * @param checkMenuItem2 JCheckBoxMenuItem
	 * @param checkMenuItem3 JCheckBoxMenuItem
	 * @param checkMenuItem4 JCheckBoxMenuItem
	 * @param checkMenuItem5 JCheckBoxMenuItem
	 */
	LineThicknessActionListener(LineThickness Linethickness,JCheckBoxMenuItem checkMenuItem1,
	JCheckBoxMenuItem checkMenuItem2,JCheckBoxMenuItem checkMenuItem3,
	JCheckBoxMenuItem checkMenuItem4,JCheckBoxMenuItem checkMenuItem5){
		this.Linethickness = Linethickness;
		this.checkMenuItem1 = checkMenuItem1;
		this.checkMenuItem2 = checkMenuItem2;
		this.checkMenuItem3 = checkMenuItem3;
		this.checkMenuItem4 = checkMenuItem4;
		this.checkMenuItem5 = checkMenuItem5;
		
		
	}

	/**
	 * Sets a new Linethickness depending on the button pressed
	 * Checks the currently selected Linethickness
	 */
	public void actionPerformed(ActionEvent e) {
		
		String name = e.getActionCommand();
		int thickness = Integer.parseInt(name);
		this.Linethickness.setThickness(thickness);
		checkMenuItem1.setSelected(false);
		checkMenuItem2.setSelected(false);
		checkMenuItem3.setSelected(false);
		checkMenuItem4.setSelected(false);
		checkMenuItem5.setSelected(false);
		JCheckBoxMenuItem CurrentItem = (JCheckBoxMenuItem) e.getSource();
		CurrentItem.setSelected(true);
		
		
		 
		
	}
	

}