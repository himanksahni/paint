package ca.utoronto.utm.paint;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class PaintSelectorPlus extends JFrame implements ChangeListener{
	private View view;
	private int red;
	private int blue;
	private int green;
	private JLabel redLabel = new JLabel("Red:");
	private JLabel blueLabel = new JLabel("Blue:");
	private JLabel greenLabel = new JLabel("Green:");
	private JSlider redBar = new JSlider(0, 0, 255, 0);
	private JSlider blueBar = new JSlider(0, 0, 255, 0);
	private JSlider greenBar = new JSlider(0, 0, 255, 0);
	
	public PaintSelectorPlus(View view){
		super("Color Selector");
		this.view = view;
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(4, 2));
		redBar.setName("Red");
		blueBar.setName("Blue");   
		greenBar.setName("Green");
		this.add(redLabel);
		this.add(redBar);
		this.add(greenLabel);
		this.add(greenBar);
		this.add(blueLabel);
		this.add(blueBar);
		redBar.addChangeListener(this);
		blueBar.addChangeListener(this);
		greenBar.addChangeListener(this);
		
		this.pack();
		this.setVisible(true);
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() == redBar){
			this.red = redBar.getValue();
		}
		if (e.getSource() == blueBar){
			this.blue = blueBar.getValue();
		}
		if (e.getSource() == greenBar){
			this.green = greenBar.getValue();
		}
		this.view.getPaintPanel().setColor(new Color(this.red,this.green,this.blue));
		this.view.setColor("Custom");
		this.view.getColorChooserPanel().clearColor();
	}
}
