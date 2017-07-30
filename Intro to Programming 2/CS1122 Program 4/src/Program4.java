import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * This program reads in and displays data using a queue.
 * 
 * Date Last Modified: 04 /7 / 2017
 * 
 * @author Daniel Rutkowski
 *
 *         CS1122, Spring 2017
 * 
 */

public class Program4 {

	public static void main(String[] args) throws IOException, QueueFullException, QueueEmptyException, FileNotFoundException {
		//File fin = new File( args[0] );
		File fin = new File( "input1.txt" );
		
		Scanner scan = null;
		try {
			scan = new Scanner(fin);
			scan.useDelimiter("");
			String firstDigit = scan.next();  // first number of the file
			String secondDigit = scan.next(); // second number in the file
			int size = Integer.parseInt(firstDigit + "" + secondDigit); // combination of the first and second number to create a size variable
			
			
			Queue<Character> queue = new Queue<Character>( size ); // the queue of the specified size
			if ( size == 0 ) {
				throw new QueueFullException();
			}
			
				while ( scan.hasNext() ) {
					if ( !queue.isFull() ) {
						queue.enqueue( scan.next().charAt(0) );
					} else {
						for ( int i = 0; i < size; i++ ) {
							System.out.print( queue.dequeue() );
						}
						System.out.println();
					}
				}
				while ( !queue.isEmpty() ) {
					System.out.print( queue.dequeue() );
				}
				System.out.println();
		
		} finally {
			if (scan != null) {
			scan.close();
			}
		}
			
	}

}
