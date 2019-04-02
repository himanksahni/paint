package ca.utoronto.utm.paint;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// https://docs.oracle.com/javase/8/docs/api/java/awt/Graphics2D.html
// https://docs.oracle.com/javase/tutorial/2d/

/**
 * The panel for the user to selected colors
 * @author csc207student
 *
 */
class ColorChooserPanel extends JPanel implements ActionListener {
	
	
	
	private View view; // So we can talk to our parent or other components of the view
	private JButton[] buttonList, p;

	
	public ColorChooserPanel(View view) {	

		this.view=view;		

		
		Icon Black=new ImageIcon("Images/images/Black.png");
		Icon Red=new ImageIcon("Images/images/Red.png");
		Icon Blue=new ImageIcon("Images/images/Blue.png");
		Icon Green=new ImageIcon("Images/images/Green.png");
		Icon Magenta=new ImageIcon("Images/images/Magenta.png");
		Icon White=new ImageIcon("Images/images/Grey.png");
		Icon Yellow=new ImageIcon("Images/images/Yellow.png");
		Icon Orange=new ImageIcon("Images/images/Orange.png");
		
		
		this.setLayout(new GridLayout(4, 2));
		JButton black = new JButton("Black", Black);
		JButton white = new JButton("White", White);
		JButton red = new JButton("Red",Red);
		JButton orange = new JButton("Orange",Orange);
		JButton yellow = new JButton("Yellow",Yellow);
		JButton green = new JButton("Green",Green);
		JButton blue = new JButton("Blue",Blue);
		JButton purple = new JButton("Purple",Magenta);
		
		Dimension dim = new Dimension(150,25);
		black.setPreferredSize(dim);
		white.setPreferredSize(dim);
		red.setPreferredSize(dim);
		orange.setPreferredSize(dim);
		yellow.setPreferredSize(dim);
		green.setPreferredSize(dim);
		blue.setPreferredSize(dim);
		purple.setPreferredSize(dim);
		
		JButton [] Buttons = new JButton [8];
		Buttons[0] = black;
		Buttons[1] = white;
		Buttons[2] = red;
		Buttons[3] = orange;
		Buttons[4] = yellow;
		Buttons[5] = green;
		Buttons[6] = blue;
		Buttons[7] = purple;

		
		this.buttonList = Buttons;
		
		this.add(black);
		this.add(white);
		this.add(red);
		this.add(orange);
		this.add(yellow);
		this.add(green);
		this.add(blue);
		this.add(purple);
		

		for (JButton button : Buttons){
			button.addActionListener(this);
		}
		this.buttonList[0].setEnabled(false);


	}
	
	public void clearColor(){
		for (int i = 0; i < this.buttonList.length; i++){
			if (this.buttonList[i].isEnabled() == false){
				this.buttonList[i].setEnabled(true);
			}
		}
	}
	
	public Color getColor(String color){
		if (color == "Black"){
			return Color.black;
		}
		else if (color == "White"){
			return Color.white;
		}
		else if (color == "Red"){
			return Color.red;
		}
		else if (color == "Orange"){
			return Color.orange;
		}
		else if (color == "Yellow"){
			return Color.yellow;
		}
		else if (color == "Green"){
			return Color.green;
		}
		else if (color == "Blue"){
			return Color.blue;
		}
		else{
			return Color.magenta;
		}
	}
	
	/**
	 * Controller aspect of this
	 */

	/**
	 * sets the color from the button
	 * Disables the button that is already selected
	 */
	public void actionPerformed(ActionEvent e) {
		this.view.getPaintPanel().setColor(this.getColor(e.getActionCommand()));
		this.view.setColor(e.getActionCommand());
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

