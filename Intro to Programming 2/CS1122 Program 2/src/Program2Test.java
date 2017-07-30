import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Test;

public class Program2Test {
   String path = ""; // Assume Java working folder

   @Test
   public void implementsInterfaceTest( ) {
      Program2 lab = new Program2( );
      if ( !( lab instanceof Program2Interface ) ) {
         fail( "Class:Program2 does not implement Interface:Program2Interface" );
      }
   }

   @Test
   public void pixelateTest5x5( ) {
      Program2 lab = new Program2( );
      String filename = "test1.ppm";
      String filename2 = "test1sol.ppm";
      BufferedImage source = null;
      try {
         source = lab.loadImage( path + filename );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( %s ): FileNotFoundException",
               path + filename ) );
      }
      if ( source == null ) {
         fail( String.format( "loadImage( %s ): Returned null",
               path + filename ) );
      }
      BufferedImage result = lab.pixelateImage( source );
      BufferedImage solution = null;
      try {
         solution = lab.loadImage( path + filename2 );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( \"%s\" ): FileNotFoundException",
               filename2 ) );
      }
      if ( solution == null ) {
         fail( String.format( "loadImage( %s ): Returned null", filename2 ) );
      }
      if ( !compareImages( result, solution ) ) {
         fail( String.format( "pixelateImage( %s ): result:%s != solution:%s",
               filename, stringifyImage( result ),
               stringifyImage( solution ) ) );
      }
   }

   @Test
   public void invertTest5x5( ) {
      Program2 lab = new Program2( );
      String filename = "test2.ppm";
      String filename2 = "test2sol.ppm";
      BufferedImage source = null;
      try {
         source = lab.loadImage( path + filename );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( %s ): FileNotFoundException",
               path + filename ) );
      }
      if ( source == null ) {
         fail( String.format( "loadImage( %s ): Returned null",
               path + filename ) );
      }
      BufferedImage result = lab.invertImage( source );
      BufferedImage solution = null;
      try {
         solution = lab.loadImage( path + filename2 );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( \"%s\" ): FileNotFoundException",
               filename2 ) );
      }
      if ( solution == null ) {
         fail( String.format( "loadImage( %s ): Returned null", filename2 ) );
      }
      if ( !compareImages( result, solution ) ) {
         fail( String.format( "invertImage( %s ): result:%s != solution:%s",
               filename, stringifyImage( result ),
               stringifyImage( solution ) ) );
      }
   }

   @Test
   public void grayifyTest5x5( ) {
      Program2 lab = new Program2( );
      String filename = "test3.ppm";
      String filename2 = "test3sol.ppm";
      BufferedImage source = null;
      try {
         source = lab.loadImage( path + filename );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( %s ): FileNotFoundException",
               path + filename ) );
      }
      if ( source == null ) {
         fail( String.format( "loadImage( %s ): Returned null",
               path + filename ) );
      }
      BufferedImage result = lab.grayifyImage( source );
      BufferedImage solution = null;
      try {
         solution = lab.loadImage( path + filename2 );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( \"%s\" ): FileNotFoundException",
               filename2 ) );
      }
      if ( solution == null ) {
         fail( String.format( "loadImage( %s ): Returned null", filename2 ) );
      }
      if ( !compareImages( result, solution ) ) {
         fail( String.format( "invertImage( %s ): result:%s != solution:%s",
               filename, stringifyImage( result ),
               stringifyImage( solution ) ) );
      }
   }

   @Test
   public void pixelateTest( ) {
      Program2 lab = new Program2( );
      String filename = "baboon.ppm";
      String filename2 = "baboon_pixelated.ppm";
      BufferedImage source = null;
      try {
         source = lab.loadImage( path + filename );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( %s ): FileNotFoundException",
               path + filename ) );
      }
      if ( source == null ) {
         fail( String.format( "loadImage( %s ): Returned null",
               path + filename ) );
      }
      BufferedImage result = lab.pixelateImage( source );
      BufferedImage solution = null;
      try {
         solution = lab.loadImage( path + filename2 );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( \"%s\" ): FileNotFoundException",
               filename2 ) );
      }
      if ( solution == null ) {
         fail( String.format( "loadImage( %s ): Returned null", filename2 ) );
      }
      if ( !compareImages( result, solution ) ) {
         fail( String.format( "pixelateImage( %s ): result:%s != solution:%s",
               filename, stringifyImage( result ),
               stringifyImage( solution ) ) );
      }
   }

   @Test
   public void invertTest( ) {
      Program2 lab = new Program2( );
      String filename = "baboon.ppm";
      String filename2 = "baboon_inverted.ppm";
      BufferedImage source = null;
      try {
         source = lab.loadImage( path + filename );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( %s ): FileNotFoundException",
               path + filename ) );
      }
      if ( source == null ) {
         fail( String.format( "loadImage( %s ): Returned null",
               path + filename ) );
      }
      BufferedImage result = lab.invertImage( source );
      BufferedImage solution = null;
      try {
         solution = lab.loadImage( path + filename2 );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( \"%s\" ): FileNotFoundException",
               filename2 ) );
      }
      if ( solution == null ) {
         fail( String.format( "loadImage( %s ): Returned null", filename2 ) );
      }
      if ( !compareImages( result, solution ) ) {
         fail( String.format( "invertImage( %s ): result:%s != solution:%s",
               filename, stringifyImage( result ),
               stringifyImage( solution ) ) );
      }
   }

   @Test
   public void grayifyTest( ) {
      Program2 lab = new Program2( );
      String filename = "baboon.ppm";
      String filename2 = "baboon_gray.ppm";
      BufferedImage source = null;
      try {
         source = lab.loadImage( path + filename );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( %s ): FileNotFoundException",
               path + filename ) );
      }
      if ( source == null ) {
         fail( String.format( "loadImage( %s ): Returned null",
               path + filename ) );
      }
      BufferedImage result = lab.grayifyImage( source );
      BufferedImage solution = null;
      try {
         solution = lab.loadImage( path + filename2 );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( \"%s\" ): FileNotFoundException",
               filename2 ) );
      }
      if ( solution == null ) {
         fail( String.format( "loadImage( %s ): Returned null", filename2 ) );
      }
      if ( !compareImages( result, solution ) ) {
         fail( String.format( "invertImage( %s ): result:%s != solution:%s",
               filename, stringifyImage( result ),
               stringifyImage( solution ) ) );
      }
   }

   @Test
   public void loadTest( ) {
      Program2 lab = new Program2( );
      String filename = "baboon.ppm";
      String filename2 = "baboon.ppm";
      BufferedImage source = null;
      try {
         source = lab.loadImage( path + filename );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( %s ): FileNotFoundException",
               path + filename ) );
      }
      if ( source == null ) {
         fail( String.format( "loadImage( %s ): Returned null",
               path + filename ) );
      }
      BufferedImage result = source;
      BufferedImage solution = null;
      try {
         solution = loadImage( path + filename2 );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( \"%s\" ): FileNotFoundException",
               filename2 ) );
      } catch ( FileFormatException e ) {
         fail( String.format( "loadImage( \"%s\" ): FileFormatException",
               filename2 ) );
      }
      if ( solution == null ) {
         fail( String.format( "loadImage( %s ): Returned null", filename2 ) );
      }
      if ( !compareImages( result, solution ) ) {
         fail( String.format( "invertImage( %s ): result:%s != solution:%s",
               filename, stringifyImage( result ),
               stringifyImage( solution ) ) );
      }
   }

   @Test
   public void saveTest( ) throws FileFormatException {
      Program2 lab = new Program2( );
      String filename = "baboon.ppm";
      String filename2 = "SAVETESTbaboon.ppm";
      BufferedImage source = null;
      try {
         source = lab.loadImage( path + filename );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( %s ): FileNotFoundException",
               path + filename ) );
      }
      if ( source == null ) {
         fail( String.format( "loadImage( %s ): Returned null",
               path + filename ) );
      }
      BufferedImage solution = source;
      try {
         lab.saveImage( filename2, source );
      } catch ( Exception e ) {
         fail( "saveImage(" + filename2 + ") failed: " + e.getMessage( ) );
      }
      BufferedImage result = null;
      try {
         result = loadImage( path + filename2 );
      } catch ( FileNotFoundException e ) {
         fail( String.format( "loadImage( \"%s\" ): FileNotFoundException",
               filename2 ) );
      } catch ( FileFormatException e ) {
         fail( String.format( "loadImage( \"%s\" ): FileFormatException",
               filename2 ) );
      }
      if ( solution == null ) {
         fail( String.format( "loadImage( %s ): Returned null", filename2 ) );
      }
      if ( !compareImages( result, solution ) ) {
         fail( String.format( "saveImage( %s ): result:%s != solution:%s",
               filename, stringifyImage( result ),
               stringifyImage( solution ) ) );
      }
   }

   public boolean compareImages( BufferedImage i1, BufferedImage i2 ) {
      if ( i1.getWidth( ) != i2.getWidth( )
            || i1.getHeight( ) != i2.getHeight( ) ) {
         return false;
      }
      for ( int x = 0; x < i1.getWidth( ); x++ ) {
         for ( int y = 0; y < i1.getHeight( ); y++ ) {
            int c1 = i1.getRGB( x, y );
            int c2 = i2.getRGB( x, y );
            if ( c1 != c2 ) {
               return false;
            }
         }
      }
      return true;
   }

   public String stringifyImage( BufferedImage i1 ) {
      String output = "<IMAGE:" + i1.getWidth( ) + ", " + i1.getHeight( )
            + ", [ ";
      for ( int y = 0; y < i1.getHeight( ); y++ ) {
         output += "[ ";
         for ( int x = 0; x < i1.getWidth( ); x++ ) {
            Color c1 = new Color( i1.getRGB( x, y ) );
            output += c1 + " ";
         }
         output += "]<br/> ";
      }
      return output + "]>";
   }

   public class FileFormatException extends Exception {
   }

   public BufferedImage loadImage( String filename )
                                                     throws FileNotFoundException,
                                                     FileFormatException {
      Scanner scanner = new Scanner( new File( filename ) );
      BufferedImage image = null;
      try {
         String magicNumber = scanner.next( ); // Should be P3
         if ( !magicNumber.equals( "P3" ) ) {
            throw new FileFormatException( );
         }
         scanner.nextLine( );
         while( scanner.hasNext( ) && !scanner.hasNextInt( ) ) {
            String foo = scanner.nextLine( );
            if ( !(foo.trim( ).isEmpty( ) || foo.startsWith( "#" )) ) {
               throw new FileFormatException( );
            }
         }
         int width = scanner.nextInt( );
         int height = scanner.nextInt( );
         while( scanner.hasNext( ) && !scanner.hasNextInt( ) ) {
            String foo = scanner.nextLine( );
            if ( !(foo.trim( ).isEmpty( ) || foo.startsWith( "#" )) ) {
               throw new FileFormatException( );
            }
         }
         int colorScale = scanner.nextInt( ); // Should be 255
         if ( colorScale != 255 ) {
            throw new FileFormatException( );
         }
         image = new BufferedImage( width, height,
               BufferedImage.TYPE_INT_RGB );
         for ( int y = 0; y < height; y++ ) {
            for ( int x = 0; x < width; x++ ) {
               while( scanner.hasNext( ) && !scanner.hasNextInt( ) ) {
                  String foo = scanner.nextLine( );
                  if ( !(foo.trim( ).isEmpty( ) || foo.startsWith( "#" )) ) {
                     throw new FileFormatException( );
                  }
               }
               int red = scanner.nextInt( );
               int green = scanner.nextInt( );
               int blue = scanner.nextInt( );
               Color c = new Color( red, green, blue );
               image.setRGB( x, y, c.getRGB( ) );
            }
         }
      } catch ( FileFormatException e ) {
         throw e;
      } catch ( Exception e ) {
         throw new FileFormatException( );
      }
      
      return image;
   }

}
