package ca.utoronto.utm.paint;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
/**
 * This is the top level View+Controller, it contains other aspects of the View+Controller.
 * @author arnold
 *
 */
public class View extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	
	private PaintModel model;
	private LineThickness Linethickness=new LineThickness(1);
	
	// The components that make this up
	private PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private ColorChooserPanel colorChooserPanel;
	private PaintObjects po;

	private JLabel mode = new JLabel("Tool: Circle");
	private JLabel color = new JLabel("Color: Black");
	private JLabel paint = new JLabel("Paint: Unfill ");
	
	public View(PaintModel model) {
		super("Paint"); // set the title and do other JFrame init
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(createMenuBar());
		
		Container c=this.getContentPane();
		// c.add(new JButton("North"),BorderLayout.NORTH);
		// c.add(new JButton("South"),BorderLayout.SOUTH);
		// c.add(new JButton("East"),BorderLayout.EAST);
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		c.add(this.shapeChooserPanel,BorderLayout.WEST);

		
		this.colorChooserPanel = new ColorChooserPanel(this);
		this.po = new PaintObjects(this);
		
		c.add(this.colorChooserPanel,BorderLayout.EAST);
		this.model=model;
		
		this.paintPanel = new PaintPanel(model, this, Linethickness);
		c.add(this.paintPanel, BorderLayout.CENTER);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new GridLayout(1 , 2));
		panelSouth.add(mode);
		panelSouth.add(color);
		panelSouth.add(paint);
		panelSouth.add(po);

		c.add(panelSouth, BorderLayout.SOUTH);
		
		//this.pack();
		this.setSize(1000,600);
		this.setVisible(true);
	}
	
	public void setMode(String m){
		this.mode.setText("Tool: " + m);
	}
	
	public void setColor(String c){
		this.color.setText("Color: " + c);
	}
	public void setPaint(String c){
		this.paint.setText("Paint: " + c);
	}
	
	public PaintPanel getPaintPanel(){
		return paintPanel;
	}
	
	public ColorChooserPanel getColorChooserPanel(){
		return colorChooserPanel;
	}
	
	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}

	private JMenuBar createMenuBar() {
		
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;
		JMenuItem menuItem;
		JCheckBoxMenuItem checkMenuItem1;
		JCheckBoxMenuItem checkMenuItem2;
		JCheckBoxMenuItem checkMenuItem3;
		JCheckBoxMenuItem checkMenuItem4;
		JCheckBoxMenuItem checkMenuItem5;

		menu = new JMenu("File");

		// a group of JMenuItems
		menuItem = new JMenuItem("New");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Open");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Exit");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuBar.add(menu);

		menu = new JMenu("Edit");

		// a group of JMenuItems
		menuItem = new JMenuItem("Cut");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Copy");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Paste");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menu.addSeparator();// -------------

		menuItem = new JMenuItem("Undo");
		menuItem.addActionListener(this);
		menu.add(menuItem);

		menuItem = new JMenuItem("Redo");
		menuItem.addActionListener(this);
		menu.add(menuItem);
		
		menuBar.add(menu);
		
		menu = new JMenu("Line Width");

		// a group of JMenuItems
		checkMenuItem1 = new JCheckBoxMenuItem("1");
		checkMenuItem1.addActionListener(this);
		checkMenuItem1.setSelected(true);
		menu.add(checkMenuItem1);

		checkMenuItem2 = new JCheckBoxMenuItem("2");
		checkMenuItem2.addActionListener(this);
		menu.add(checkMenuItem2);

		checkMenuItem3 = new JCheckBoxMenuItem("3");
		checkMenuItem3.addActionListener(this);
		menu.add(checkMenuItem3);

		checkMenuItem4 = new JCheckBoxMenuItem("4");
		checkMenuItem4.addActionListener(this);
		menu.add(checkMenuItem4);
		
		checkMenuItem5 = new JCheckBoxMenuItem("5");
		checkMenuItem5.addActionListener(this);
		menu.add(checkMenuItem5);

		menuBar.add(menu);

		
		
		menuBar.add(menu);
		LineThicknessActionListener lt = new LineThicknessActionListener(Linethickness,
				checkMenuItem1,
				checkMenuItem2,checkMenuItem3, checkMenuItem4,checkMenuItem5);
		
		checkMenuItem1.addActionListener(lt);
		checkMenuItem2.addActionListener(lt);
		checkMenuItem3.addActionListener(lt);
		checkMenuItem4.addActionListener(lt);
		checkMenuItem5.addActionListener(lt);
		
		return menuBar;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		if(e.getActionCommand() == "New"){
			this.dispose();
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					new Paint();
				}
			});
		}
		
		else if(e.getActionCommand() == "Exit"){
			this.dispose();
		}
		
		else if(e.getActionCommand() == "Undo"){
			this.model.undo();
		}
		
		else if(e.getActionCommand() == "Redo"){
			this.model.redo();
		}
		
	}
}