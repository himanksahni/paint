package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

/**
 * Panel for selecting the shape or lines to be drawn
 * @author csc207student
 *
 */
class ShapeChooserPanel extends JPanel implements ActionListener {
	private View view; // So we can talk to our parent or other components of the view
	private JButton[] buttonList;
	
	public ShapeChooserPanel(View view) {	
		this.view=view;
		
		Icon Circle=new ImageIcon("Images/images/Circle.png");
		Icon Rectangle=new ImageIcon("Images/images/Rectangle.png");
		Icon Square=new ImageIcon("Images/images/Square.png");
		Icon Squiggle=new ImageIcon("Images/images/Squiggle.png");
		Icon Polyline=new ImageIcon("Images/images/Polyline.png");
		Icon Eraser=new ImageIcon("Images/images/eraser.png"); 
		
		
		this.setLayout(new GridLayout(6, 1));  
		JButton circle = new JButton("Circle",Circle);
		JButton rectangle = new JButton("Rectangle", Rectangle);
		JButton square = new JButton("Square",Square);
		JButton squiggle = new JButton("Squiggle",Squiggle);
		JButton polyline = new JButton("Polyline",Polyline);
		JButton eraser= new JButton("Eraser",Eraser);
		
		JButton [] Buttons = new JButton [6];
		Buttons[0] = circle;
		Buttons[1] = rectangle;
		Buttons[2] = square;
		Buttons[3] = squiggle;
		Buttons[4] = polyline;
		Buttons[5]= eraser;
		
		this.buttonList = Buttons; 
		
		this.add(circle);
		this.add(rectangle);
		this.add(square);
		this.add(squiggle);
		this.add(polyline);
		this.add(eraser);

		for (JButton button : Buttons){
			button.addActionListener(this);
		}
		this.buttonList[0].setEnabled(false);
	}
	
	/**
	 * Controller aspect of this
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.view.getPaintPanel().setMode(e.getActionCommand());
		this.view.getPaintPanel().setStrategy(e.getActionCommand());
		this.view.setMode(e.getActionCommand());
//		this.view.getPaintPanel().setStrategy(e.getActionCommand());
		for (int i = 0; i < this.buttonList.length; i++){
			if (this.buttonList[i].isEnabled() == false){
				this.buttonList[i].setEnabled(true);
			}
			if (this.buttonList[i].getText() == e.getActionCommand()){
				this.buttonList[i].setEnabled(false);
			}
		}
		System.out.println(e.getActionCommand());
	}

	
}
