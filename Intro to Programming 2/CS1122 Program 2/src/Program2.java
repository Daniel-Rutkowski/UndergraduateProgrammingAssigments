import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This program loads, saves, and modifies .ppm pictures.
 * 
 * Date Last Modified: 02 / 18 / 2017
 * 
 * @author Daniel Rutkowski
 *
 *         CS1122, Spring 2017
 */

public class Program2 implements Program2Interface {

	private int maxRGB = 0; // The max RGB value of the file
	private int x = 0; // The width of the file
	private int y = 0; // The height of the file

	public static void main(String[] args) throws FileNotFoundException {

	}

	@Override
	public BufferedImage loadImage(String filename)
			throws FileNotFoundException, NullPointerException, NoSuchElementException {
		File fin = new File(filename);
		Scanner scan = new Scanner(fin);
		maxRGB = 0;
		BufferedImage image = null; // Image to be scanned in
		scan.nextLine();
		scan.nextLine();
		x = scan.nextInt();
		y = scan.nextInt();
		maxRGB = scan.nextInt();
		image = new BufferedImage(x, y, BufferedImage.TYPE_INT_RGB);
		for (int j = 0; j < y; j++) {
			for (int k = 0; k < x; k++) {
				int pixelRed = scan.nextInt(); // Red value of the pixel
				int pixelGreen = scan.nextInt(); // Green value of the pixel
				int pixelBlue = scan.nextInt(); // Blue value of the pixel
				Color pixelColor = new Color(pixelRed, pixelGreen, pixelBlue); // Color made from combining pixelRed, pixelGreen, and pixelBlue.
				image.setRGB(k, j, pixelColor.getRGB());

			}

		}
		scan.close();
		return image;
	}

	@Override
	public void saveImage(String filename, BufferedImage image) throws FileNotFoundException, NullPointerException, NoSuchElementException {
		File fin = new File(filename);
		PrintWriter pwt = null;
		pwt = new PrintWriter(fin);
		pwt.println("P3");
		pwt.println("# This file was saved from another image.");
		pwt.println(x + " " + y);
		pwt.println(maxRGB);
		for (int j = 0; j < y; j++) {
			for (int k = 0; k < x; k++) {
				Color pixelColor = new Color(image.getRGB(k, j));
				pwt.print(pixelColor.getRed() + " " + pixelColor.getGreen() + " " + pixelColor.getBlue() + "  ");
			}
			pwt.println();
		}
		pwt.close();

	}

	@Override
	public BufferedImage invertImage(BufferedImage image) throws NullPointerException {
		BufferedImage invertedImage = image; // Image to be inverted
		for (int j = 0; j < x; j++) {
			for (int k = 0; k < y; k++) {
				int rgbValue = invertedImage.getRGB(j, k); // rgb value of pixel
				Color pixelColor = new Color(rgbValue, true); // Color of pixel defined by rgb value
				pixelColor = new Color(maxRGB - pixelColor.getRed(), maxRGB - pixelColor.getGreen(),
						maxRGB - pixelColor.getBlue());
				invertedImage.setRGB(j, k, pixelColor.getRGB());

			}
		}
		return invertedImage;
	}

	@Override
	public BufferedImage grayifyImage(BufferedImage image) throws NullPointerException {
		BufferedImage grayifiedImage = image; // Image to be changed
		for (int j = 0; j < x; j++) {
			for (int k = 0; k < y; k++) {
				int rgbValue = grayifiedImage.getRGB(j, k); // rgb value of pixel
				Color pixelColor = new Color(rgbValue, true); // Color of pixel defined by rgb value
				int luminescence = (int) (.2989 * pixelColor.getRed() + .5870 * pixelColor.getGreen()
						+ .1140 * pixelColor.getBlue());
				pixelColor = new Color(luminescence, luminescence, luminescence);
				grayifiedImage.setRGB(j, k, pixelColor.getRGB());

			}
		}
		return grayifiedImage;
	}

	@Override
	public BufferedImage pixelateImage(BufferedImage image) throws NullPointerException {
		BufferedImage pixelatedImage = image; // Image to be changed
		for (int row = 2; row < x; row += 5) {
			for (int col = 2; col < y; col += 5) {
				int rgbValue = pixelatedImage.getRGB(row, col); // rgb value of pixel
				for (int i = row - 2; i <= row + 2; i++) {
					for (int j = col - 2; j <= col + 2; j++) {
						pixelatedImage.setRGB(i, j, rgbValue);
					}
				}
			}
		}
		return pixelatedImage;
	}

}
