// BE SURE TO COMMENT YOUR CODE
import java.io.FileNotFoundException;
import java.awt.image.BufferedImage;

/**
 * Public API for Program2.
 * 
 * You must implement this interface in your Program2 class.
 * 
 * @author Leo Ureel
 */
public interface Program2Interface {

   /**
    * Load the specified PPM image file.
    * The image file must be in the PPM P3 format
    * @see http://netpbm.sourceforge.net/doc/ppm.html
    * 
    * Don't forget to add a load button to the application!
    * 
    * @param filename
    * @return BufferedImage
    * @throws FileNotFoundException
    */
   public BufferedImage loadImage( String filename ) throws FileNotFoundException;

   /**
    * Save the specified image to a PPM file.
    * The image file must be in the PPM P3 format
    * @see http://netpbm.sourceforge.net/doc/ppm.html
    * 
    * Don't forget to add a save button to the application!
    * 
    * @param filename
    * @param BufferedImage
    * @throws FileNotFoundException
    */
   public void saveImage( String filename, BufferedImage image ) throws FileNotFoundException;
   
   /**
    * Invert an image by subtracting each RGB component from its max value
    *
    * For example:
    * rbg( 255, 255, 255 ) -- invert --> rbg( 0, 0, 0 )
    * rbg( 0, 0, 0 ) -- invert --> rbg( 255, 255, 255 )
    * rbg( 255, 110, 63 ) -- invert --> rbg( 0, 145, 192 )
    * rbg( 0, 145, 192 ) -- invert --> rbg( 255, 110, 63 )
    *
    * @param image - the image to be inverted, do not modify!
    * @return a new inverted image
    */
   public BufferedImage invertImage( BufferedImage image );

   /**
    * Convert an image to grayscale using the following formula:
    * intensity = 0.2989*red + 0.5870*green + 0.1140*blue
    * new rgb( intensity, intensity, intensity );
    * 
    * For example:
    * rbg( 0, 255, 255 ) -- grayify --> rbg( 178, 178, 178 )
    * rbg( 255, 0, 255 ) -- grayify --> rbg( 105, 105, 105 )
    * rbg( 255, 255, 0 ) -- grayify --> rbg( 225, 225, 225 )
    * rbg( 21, 11, 11 ) -- grayify --> rbg( 13, 13, 13 )
    *
    * @param image - the image to be converted to grayscale, do not modify!
    * @return a new image that displays in shades of gray
    */
   public BufferedImage grayifyImage( BufferedImage image );

   /**
    * Pixelates the image by dividing it into 5x5 regions, then assigning
    * all pixels in the region the same color as the central pixel.
    *
    * For example:
    * [0,0,0] [0,0,0] [0,0,0] [0,0,0] [0,0,0]
    * [0,0,0] [5,5,5] [5,5,5] [5,5,5] [0,0,0]
    * [0,0,0] [5,5,5] [1,2,3] [5,5,5] [0,0,0]
    * [0,0,0] [5,5,5] [5,5,5] [5,5,5] [0,0,0]
    * [0,0,0] [0,0,0] [0,0,0] [0,0,0] [0,0,0]
    * 
    * is pixelated to 
    * 
    * [1,2,3] [1,2,3] [1,2,3] [1,2,3] [1,2,3]
    * [1,2,3] [1,2,3] [1,2,3] [1,2,3] [1,2,3]
    * [1,2,3] [1,2,3] [1,2,3] [1,2,3] [1,2,3]
    * [1,2,3] [1,2,3] [1,2,3] [1,2,3] [1,2,3]
    * [1,2,3] [1,2,3] [1,2,3] [1,2,3] [1,2,3]
    * 
    * @param image - the image to be converted to grayscale, do not modify!
    * @return a new image that displays in shades of gray
    */
   public BufferedImage pixelateImage( BufferedImage image );
}
