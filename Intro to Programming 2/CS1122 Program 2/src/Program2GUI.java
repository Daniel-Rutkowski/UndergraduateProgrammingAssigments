import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Program2GUI extends JPanel implements ActionListener {

	/**
	 * This program loads, saves, and modifies .ppm pictures.
	 * 
	 * Date Last Modified: 02 / 18 / 2017
	 * 
	 * @author Daniel Rutkowski
	 *
	 *         CS1122, Spring 2017
	 */

	private static final long serialVersionUID = 1L;
	JFrame window = null;       // Components for the GUI
	BorderLayout layout = null;
	JPanel tools = null;
	JPanel picture = null;
	JButton loadButton = null;
	JButton saveButton = null;
	JButton invertButton = null;
	JButton grayscaleButton = null;
	JButton pixelateButton = null;
	ImageIcon image = new ImageIcon(); // Image to be displayed
	final JFileChooser fc = new JFileChooser(); // File chooser for the load and save buttons
	Program2 test = new Program2(); // Instance of Program2

	public void init() {
		window = new JFrame("Program 2: Image Manipulator - inator");
		window.setSize(800, 800);

		layout = new BorderLayout();
		window.getContentPane().setLayout(layout);
		window.getContentPane().add(this, BorderLayout.CENTER);

		picture = new JPanel();
		picture.setLayout(new FlowLayout());
		window.getContentPane().add(picture, BorderLayout.CENTER);

		tools = new JPanel();
		tools.setLayout(new FlowLayout());
		window.getContentPane().add(tools, BorderLayout.SOUTH);

		JLabel displayedPicture = new JLabel(image);
		window.getContentPane().add(displayedPicture, BorderLayout.CENTER);

		loadButton = new JButton("Load");
		tools.add(loadButton);

		saveButton = new JButton("Save");
		tools.add(saveButton);

		invertButton = new JButton("Invert");
		tools.add(invertButton);

		grayscaleButton = new JButton("Grayscale");
		tools.add(grayscaleButton);

		pixelateButton = new JButton("Pixelate");
		tools.add(pixelateButton);

		loadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File directory = new File("C:\\Users\\Daniel\\Desktop\\Java Programs\\CS1122 Program 2");
				fc.setCurrentDirectory(directory);
				fc.showOpenDialog(picture);
				File fin = fc.getSelectedFile();
				String filePath = null;
				try {
					filePath = fin.getPath();
					image.setImage(test.loadImage(filePath));
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(window, "INPUT NOT ACCEPTED!");
					window.repaint();
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(window, "INPUT NOT ACCEPTED!");
					window.repaint();
				} catch (NoSuchElementException e1) {
					JOptionPane.showMessageDialog(window, "INPUT NOT ACCEPTED!");
					window.repaint();
				} finally {
					window.repaint();
				}
			}
		});

		saveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File directory = new File("C:\\Users\\Daniel\\Desktop\\Java Programs\\CS1122 Program 2");
				fc.setCurrentDirectory(directory);
				fc.showOpenDialog(picture);
				File fin = fc.getSelectedFile();
				String filePath = null;
				try {
					filePath = fin.getPath();
					test.saveImage(filePath, (BufferedImage) image.getImage());
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(window, "INPUT NOT ACCEPTED!");
					window.repaint();
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(window, "INPUT NOT ACCEPTED!");
					window.repaint();
				} catch (NoSuchElementException e1) {
					JOptionPane.showMessageDialog(window, "INPUT NOT ACCEPTED!");
					window.repaint();
				} finally {
					window.repaint();
				}
			}
		});

		invertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					image.setImage(test.invertImage((BufferedImage) image.getImage()));
					window.repaint();
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(window, "INPUT NOT ACCEPTED!");
					window.repaint();
				}
			}
		});

		grayscaleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					image.setImage(test.grayifyImage((BufferedImage) image.getImage()));
					window.repaint();
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(window, "INPUT NOT ACCEPTED!");
					window.repaint();
				}
			}
		});

		pixelateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					image.setImage(test.pixelateImage((BufferedImage) image.getImage()));
					window.repaint();
				} catch (NullPointerException e1) {
					JOptionPane.showMessageDialog(window, "INPUT NOT ACCEPTED!");
					window.repaint();
				}
			}
		});

		setVisible(true);
		window.setVisible(true);

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Program2GUI app = new Program2GUI();
		app.init();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		window.repaint();
	}

}
