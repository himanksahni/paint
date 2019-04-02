package ca.utoronto.utm.paint;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Class handles the fill and unfill buttons
 * @author csc207student
 *
 */
public class PaintObjects extends JPanel implements ActionListener {
	
	private View view;
	private JButton fill, unfill, colorPlus;
	private PaintPanel paintPanel;
	
	/**
	 * Creates Paint Objects
	 * @param view View
	 */
	public PaintObjects(View view){
		this.view=view;
		
		this.setLayout(new GridLayout(1, 3));
		this.fill=new JButton("Fill");
		this.unfill=new JButton("Unfill");
		this.colorPlus = new JButton("Color...");
		this.add(this.fill);
		this.add(this.unfill);
		this.add(this.colorPlus);
		this.fill.addActionListener(this);
		this.unfill.addActionListener(this);
		this.colorPlus.addActionListener(this);
		this.unfill.setEnabled(false);
		
	}
	
	/**
	 * 
	 * @return the fill JButton
	 */
	public JButton getFill() {
		return fill;
	}
	
	/**
	 * sets the fill button
	 * @param fill JButton
	 */
	public void setFill(JButton fill) {
		this.fill = fill;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Color..."){
			new PaintSelectorPlus(this.view);
		}
		else{
			this.view.setPaint(e.getActionCommand());
				
			if (e.getActionCommand()=="Fill"){
					fill.setEnabled(false);
					unfill.setEnabled(true);
					this.view.getPaintPanel().setFil(true);
			}
				
			else if (e.getActionCommand()=="Unfill"){
					fill.setEnabled(true);
					unfill.setEnabled(false);
					this.view.getPaintPanel().setFil(false);
				}
			System.out.println(e.getActionCommand());
		}
	}	
}
