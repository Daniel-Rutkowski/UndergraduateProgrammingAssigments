import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Authors: Daniel Rutkowski and Kavya Reddy Theram 

public class Program4 extends JPanel implements ActionListener {
	JFrame window = null;
	BorderLayout layout = null;
	JPanel tools = null;
	JTextField filenameField;
	JTextField yearField = null;
	JTextField monthField = null;
	JTextField dayField = null;
	JButton graphButton = null;

	// Private instance variable for a CO2 array list to be used within Program 4

	private ArrayList<CO2Data> data = new ArrayList<CO2Data>();
	Program3 program3 = new Program3();

	// Constants to represent the offset of the graph from the edge of the frame

	private static final int BORDERX = 20;
	private static final int BORDERY = 20;

	/**
	 * Initialization: Setup window.
	 */
	public void init() {
		window = new JFrame("Program 4: Graph CO2 Data");
		window.setSize(800, 600);

		layout = new BorderLayout();
		window.getContentPane().setLayout(layout);
		window.getContentPane().add(this, layout.CENTER);

		tools = new JPanel();
		tools.setLayout(new FlowLayout());
		window.getContentPane().add(tools, layout.SOUTH);

		tools.add(new JLabel("Filename:"));
		filenameField = new JTextField("data.txt");
		tools.add(filenameField);
		filenameField.setText("co2_mlo_surface-insitu_1_ccgg_HourlyData.txt");

		tools.add(new JLabel("Year:"));
		yearField = new JTextField("1985");
		tools.add(yearField);

		tools.add(new JLabel("Month:"));
		monthField = new JTextField("7");
		tools.add(monthField);

		tools.add(new JLabel("Day:"));
		dayField = new JTextField("20");
		tools.add(dayField);

		graphButton = new JButton("Graph");
		tools.add(graphButton);

		// YOUR CODE HERE
		graphButton.addActionListener(this);

		this.setVisible(true);
		window.setVisible(true);

		// Ends the program after closing the window.
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * Draw to the screen
	 */
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		// Draws the x and y axis for the graph.

		g2d.drawRect(BORDERX, BORDERY, 0, window.getHeight() - 2 * BORDERY);
		g2d.drawRect(BORDERX, window.getHeight() - 2 * BORDERY - 85, window.getWidth() - 4 * BORDERX, 0);

		// Here we call the code to graph the data.

		graphData(g2d);
	}

	/**
	 * Graph the data specified in the fields.
	 * 
	 * @param g2d
	 */
	public void graphData(Graphics2D g2d) {
		// Your Code Here
		boolean first = true;
		double x1 = 0;
		double y1 = 0;
		double x2 = 0;
		double y2 = 0;
		int dataLength = data.size();
		double scale = 0;

		if (dataLength < 1) {
			return;
		} else {
			scale = (window.getWidth() - 100) / ((double) data.size());
		}
		for (int i = 0; i < data.size(); i++) {

			if (data.get(i).isValid()) {

				if (first) {
					x1 = BORDERX + 10;
					y1 = (window.getHeight() - 2 * BORDERY) - data.get(i).getValue();
					y2 = (window.getHeight() - 2 * BORDERY) - data.get(i).getValue();
					x2 = ((BORDERX + 10) + scale);
					first = false;
				} else {
					y1 = y2;
					x2 = x2 + scale;
					y2 = ((window.getHeight() - 2 * BORDERY) - data.get(i).getValue());
				}

				g2d.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
				x1 = x2;
			} else {
				x2 = x2 + scale;
			}

		}

	}

	/**
	 * Load the Data when the Graph button is pushed.
	 * creates the program 3 object
	 * 
	 * @throws FileNotFoundException
	 */

	public void loadData() {
		try {
			String filename = filenameField.getText();
			Integer year = null;
			Integer month = null;
			Integer day = null;
			
			if (yearField.getText().equals("") || yearField.getText().equals("null")) {
			} else {
				year = Integer.parseInt(yearField.getText());
			}
			if (monthField.getText().equals("") || monthField.getText().equals("null")) {
			} else {
				month = Integer.parseInt(monthField.getText());
			}
			if (dayField.getText().equals("") || dayField.getText().equals("null")) {
			} else {
				day = Integer.parseInt(dayField.getText());
			}
			
			program3.loadData(filename);
			data = program3.getData(year, month, day);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Handle the button press
	 * 
	 * @param e
	 */
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Your Code Here
		loadData();
		window.repaint();
	}

/**
 * Main method creates an instance of Program4 and launches it.
 * 
 * @param args
 */
	
	public static void main(String[] args) {
		Program4 app = new Program4();
		app.init();
	}
}
