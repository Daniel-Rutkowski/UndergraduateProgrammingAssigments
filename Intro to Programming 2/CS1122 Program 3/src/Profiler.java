import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * This program tests and times multiple sorting algorithms.
 * 
 * Date Last Modified: 03 /18 / 2017
 * 
 * @author Daniel Rutkowski
 *
 *         CS1122, Spring 2017
 * 
 */

public class Profiler {

	public static void main(String[] args) {

		int numberToBeTested = 100000; // Size of the array to be tested
		
		int numberOfIterations = 1000; // Number of times to sort the array to
										// create an average time

		// Generate a random data set of the specified size
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numberToBeTested; i++) {
			list.add(i, (int) (Math.random() * 100));
		}

		// Used to sort the random data to test already sorted lists
		// Collections.sort(list);

		long startTime, endTime;
		double durationTest;
		double durationError;
		Sort sorter = new Sort();
		startTime = System.currentTimeMillis();
		for (int i = 0; i < numberOfIterations; i++) {
			// Run the sort method
			sorter.mysort(list, 0, list.size() - 1, false);
		}
		endTime = System.currentTimeMillis();
		// Find the average execution time
		durationTest = ((double) (endTime - startTime)) / numberOfIterations;

		startTime = System.currentTimeMillis();
		for (int i = 0; i < numberOfIterations; i++) {
			list.add(i, (int) (Math.random() * 100));
		}
		endTime = System.currentTimeMillis();
		durationError = ((double) (endTime - startTime)) / numberOfIterations;

		System.out.println(list);
		System.out.println("Total time: " + (durationTest - durationError));
	}
}
