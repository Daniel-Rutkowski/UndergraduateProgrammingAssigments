import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

/**
*	This program implements and tests multiple sorting algorithms.
*       
*       Date Last Modified: 03/2/2017
*	@author Daniel Rutkowski
*
*	CS1122, Spring 2017
*	
*/

public class SortTest {

	private Sort instance = new Sort();

	// Bubble sort, a list of 1 element
	@Test
	public void test() {

		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 1; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 0, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}

	}

	// Bubble sort, a list of 2 element
	@Test
	public void test2() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 2; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 1, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}

	}

	// Bubble sort, a list of 3 element
	@Test
	public void test3() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 2, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Bubble sort, a list of 100 element
	@Test
	public void test4() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 99, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Bubble sort, a reversed list
	@Test
	public void test5() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		Collections.reverse(solution);
		instance.bubblesort(testList, 0, 9, true);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Bubble sort, an already sorted list
	@Test
	public void test6() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		Collections.sort(testList);
		instance.bubblesort(testList, 0, 9, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Bubble sort, an empty list
	@Test
	public void test7() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		ArrayList<Integer> solution = new ArrayList<Integer>();

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 0, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}

	}

	// Bubble sort, a list of 10 elements ( even list )
	@Test
	public void test8() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 9, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Bubble sort, a list of 11 elements ( odd list )
	@Test
	public void test9() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 11; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 10, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Bubble sort, a list of 10 elements with different indexes
	@Test
	public void test10() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution.subList(4, 8));
		instance.bubblesort(testList, 4, 7, false);

		if (!testList.subList(4, 8).equals(solution.subList(4, 8))) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Bubble sort, a list of 6 elements with Max Element in front
	@Test
	public void test11() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(10);
		testList.add(6);
		testList.add(2);
		testList.add(7);
		testList.add(3);
		testList.add(5);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Bubble sort, a list of 6 elements with Maximum Element in back
	@Test
	public void test12() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(17);
		testList.add(12);
		testList.add(5);
		testList.add(7);
		testList.add(20);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Bubble sort, a list of 7 elements with Max Element in middle
	@Test
	public void test13() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(13);
		testList.add(12);
		testList.add(18);
		testList.add(7);
		testList.add(1);
		testList.add(4);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Bubble sort, a list of 6 elements with Minimum Element in front
	@Test
	public void test14() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(16);
		testList.add(2);
		testList.add(17);
		testList.add(3);
		testList.add(15);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Bubble sort, a list of 6 elements with Minimum Element in back
	@Test
	public void test15() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(17);
		testList.add(12);
		testList.add(5);
		testList.add(7);
		testList.add(1);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Bubble sort, a list of 7 elements with Minimum Element in middle
	@Test
	public void test16() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(13);
		testList.add(12);
		testList.add(1);
		testList.add(7);
		testList.add(10);
		testList.add(4);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Bubble sort, a list of elements in reverse order
	@Test
	public void test17() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(13);
		testList.add(12);
		testList.add(11);
		testList.add(10);
		testList.add(9);
		testList.add(8);
		testList.add(7);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Bubble sort, a list of full of the same element
	@Test
	public void test18() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.bubblesort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Bublesort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, a list of 1 element
	@Test
	public void test19() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 1; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 0, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}

	}

	// Insertion sort, a list of 2 element
	@Test
	public void test20() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 2; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 1, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}

	}

	// Insertion sort, a list of 3 element
	@Test
	public void test21() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 2, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, a list of 100 element
	@Test
	public void test22() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 99, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, a reversed list
	@Test
	public void test23() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		Collections.reverse(solution);
		instance.insertionsort(testList, 0, 9, true);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, an already sorted list
	@Test
	public void test24() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		Collections.sort(testList);
		instance.insertionsort(testList, 0, 9, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, an empty list
	@Test
	public void test25() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		ArrayList<Integer> solution = new ArrayList<Integer>();

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 0, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}

	}

	// Insertion sort, a list of 10 elements ( even list )
	@Test
	public void test26() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 9, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, a list of 11 elements ( odd list )
	@Test
	public void test27() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 11; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 10, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, a list of 10 elements with different indexes
	@Test
	public void test28() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution.subList(4, 8));
		instance.insertionsort(testList, 4, 7, false);

		if (!testList.subList(4, 8).equals(solution.subList(4, 8))) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, a list of 6 elements with Max Element in front
	@Test
	public void test29() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(10);
		testList.add(6);
		testList.add(2);
		testList.add(7);
		testList.add(3);
		testList.add(5);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, a list of 6 elements with Maximum Element in back
	@Test
	public void test30() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(17);
		testList.add(12);
		testList.add(5);
		testList.add(7);
		testList.add(20);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, a list of 7 elements with Max Element in middle
	@Test
	public void test31() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(13);
		testList.add(12);
		testList.add(18);
		testList.add(7);
		testList.add(1);
		testList.add(4);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, a list of 6 elements with Minimum Element in front
	@Test
	public void test32() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(16);
		testList.add(2);
		testList.add(17);
		testList.add(3);
		testList.add(15);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, a list of 6 elements with Minimum Element in back
	@Test
	public void test33() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(17);
		testList.add(12);
		testList.add(5);
		testList.add(7);
		testList.add(1);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, a list of 7 elements with Minimum Element in middle
	@Test
	public void test34() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(13);
		testList.add(12);
		testList.add(1);
		testList.add(7);
		testList.add(10);
		testList.add(4);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, a list of elements in reverse order
	@Test
	public void test35() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(13);
		testList.add(12);
		testList.add(11);
		testList.add(10);
		testList.add(9);
		testList.add(8);
		testList.add(7);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Insertion sort, a list of full of the same element
	@Test
	public void test36() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.insertionsort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Insertionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, a list of 1 element
	@Test
	public void test37() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 1; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 0, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}

	}

	// Selection sort, a list of 2 element
	@Test
	public void test38() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 2; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 1, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}

	}

	// Selection sort, a list of 3 element
	@Test
	public void test39() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 2, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, a list of 100 element
	@Test
	public void test40() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 99, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, a reversed list
	@Test
	public void test41() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		Collections.reverse(solution);
		instance.selectionsort(testList, 0, 9, true);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, an already sorted list
	@Test
	public void test42() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		Collections.sort(testList);
		instance.selectionsort(testList, 0, 9, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, an empty list
	@Test
	public void test43() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		ArrayList<Integer> solution = new ArrayList<Integer>();

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 0, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}

	}

	// Selection sort, a list of 10 elements ( even list )
	@Test
	public void test44() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 9, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, a list of 11 elements ( odd list )
	@Test
	public void test45() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 11; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 10, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, a list of 10 elements with different indexes
	@Test
	public void test46() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution.subList(4, 8));
		instance.selectionsort(testList, 4, 7, false);

		if (!testList.subList(4, 8).equals(solution.subList(4, 8))) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, a list of 6 elements with Max Element in front
	@Test
	public void test47() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(10);
		testList.add(6);
		testList.add(2);
		testList.add(7);
		testList.add(3);
		testList.add(5);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, a list of 6 elements with Maximum Element in back
	@Test
	public void test48() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(17);
		testList.add(12);
		testList.add(5);
		testList.add(7);
		testList.add(20);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, a list of 7 elements with Max Element in middle
	@Test
	public void test49() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(13);
		testList.add(12);
		testList.add(18);
		testList.add(7);
		testList.add(1);
		testList.add(4);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, a list of 6 elements with Minimum Element in front
	@Test
	public void test50() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(16);
		testList.add(2);
		testList.add(17);
		testList.add(3);
		testList.add(15);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, a list of 6 elements with Minimum Element in back
	@Test
	public void test51() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(17);
		testList.add(12);
		testList.add(5);
		testList.add(7);
		testList.add(1);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, a list of 7 elements with Minimum Element in middle
	@Test
	public void test52() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(13);
		testList.add(12);
		testList.add(1);
		testList.add(7);
		testList.add(10);
		testList.add(4);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, a list of elements in reverse order
	@Test
	public void test53() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(13);
		testList.add(12);
		testList.add(11);
		testList.add(10);
		testList.add(9);
		testList.add(8);
		testList.add(7);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Selection sort, a list of full of the same element
	@Test
	public void test54() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.selectionsort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Selectionsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, a list of 1 element
	@Test
	public void test55() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 1; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.shellsort(testList, 0, 0, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}

	}

	// Shell sort, a list of 2 element
	@Test
	public void test56() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 2; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.shellsort(testList, 0, 1, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}

	}

	// Shell sort, a list of 3 element
	@Test
	public void test57() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.shellsort(testList, 0, 2, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, a list of 100 element
	@Test
	public void test58() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.shellsort(testList, 0, 99, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, a reversed list
	@Test
	public void test59() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		Collections.reverse(solution);
		instance.shellsort(testList, 0, 9, true);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, an already sorted list
	@Test
	public void test60() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		Collections.sort(testList);
		instance.shellsort(testList, 0, 9, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, an empty list
	@Test
	public void test61() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		ArrayList<Integer> solution = new ArrayList<Integer>();

		Collections.sort(solution);
		instance.shellsort(testList, 0, 0, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}

	}

	// Shell sort, a list of 10 elements ( even list )
	@Test
	public void test62() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.shellsort(testList, 0, 9, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, a list of 11 elements ( odd list )
	@Test
	public void test63() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 11; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.shellsort(testList, 0, 10, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, a list of 10 elements with different indexes
	@Test
	public void test64() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution.subList(4, 8));
		instance.shellsort(testList, 4, 7, false);

		if (!testList.subList(4, 8).equals(solution.subList(4, 8))) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, a list of 6 elements with Max Element in front
	@Test
	public void test65() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(10);
		testList.add(6);
		testList.add(2);
		testList.add(7);
		testList.add(3);
		testList.add(5);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.shellsort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, a list of 6 elements with Maximum Element in back
	@Test
	public void test66() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(17);
		testList.add(12);
		testList.add(5);
		testList.add(7);
		testList.add(20);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.shellsort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, a list of 7 elements with Max Element in middle
	@Test
	public void test67() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(13);
		testList.add(12);
		testList.add(18);
		testList.add(7);
		testList.add(1);
		testList.add(4);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.shellsort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, a list of 6 elements with Minimum Element in front
	@Test
	public void test68() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(16);
		testList.add(2);
		testList.add(17);
		testList.add(3);
		testList.add(15);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.shellsort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, a list of 6 elements with Minimum Element in back
	@Test
	public void test69() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(17);
		testList.add(12);
		testList.add(5);
		testList.add(7);
		testList.add(1);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.shellsort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, a list of 7 elements with Minimum Element in middle
	@Test
	public void test70() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(13);
		testList.add(12);
		testList.add(1);
		testList.add(7);
		testList.add(10);
		testList.add(4);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.shellsort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, a list of elements in reverse order
	@Test
	public void test71() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(13);
		testList.add(12);
		testList.add(11);
		testList.add(10);
		testList.add(9);
		testList.add(8);
		testList.add(7);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.shellsort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Shell sort, a list of full of the same element
	@Test
	public void test72() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.shellsort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Shellsort Failed: testList does not equal solution");
		}
	}

	// Merge sort, a list of 1 element
	@Test
	public void test73() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 1; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mergesort(testList, 0, 0, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}

	}

	// Merge sort, a list of 2 element
	@Test
	public void test74() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 2; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mergesort(testList, 0, 1, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}

	}

	// Merge sort, a list of 3 element
	@Test
	public void test75() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mergesort(testList, 0, 2, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Merge sort, a list of 100 element
	@Test
	public void test76() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mergesort(testList, 0, 99, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Merge sort, a reversed list
	@Test
	public void test77() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		Collections.reverse(solution);
		instance.mergesort(testList, 0, 9, true);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Merge sort, an already sorted list
	@Test
	public void test78() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		Collections.sort(testList);
		instance.mergesort(testList, 0, 9, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Merge sort, an empty list
	@Test
	public void test79() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		ArrayList<Integer> solution = new ArrayList<Integer>();

		Collections.sort(solution);
		instance.mergesort(testList, 0, 0, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}

	}

	// Merge sort, a list of 10 elements ( even list )
	@Test
	public void test80() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mergesort(testList, 0, 9, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Merge sort, a list of 11 elements ( odd list )
	@Test
	public void test81() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 11; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mergesort(testList, 0, 10, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Merge sort, a list of 10 elements with different indexes
	@Test
	public void test82() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution.subList(4, 8));
		instance.mergesort(testList, 4, 7, false);

		if (!testList.subList(4, 8).equals(solution.subList(4, 8))) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Merge sort, a list of 6 elements with Max Element in front
	@Test
	public void test83() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(10);
		testList.add(6);
		testList.add(2);
		testList.add(7);
		testList.add(3);
		testList.add(5);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mergesort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Merge sort, a list of 6 elements with Maximum Element in back
	@Test
	public void test84() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(17);
		testList.add(12);
		testList.add(5);
		testList.add(7);
		testList.add(20);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mergesort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Merge sort, a list of 7 elements with Max Element in middle
	@Test
	public void test85() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(13);
		testList.add(12);
		testList.add(18);
		testList.add(7);
		testList.add(1);
		testList.add(4);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mergesort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Merge sort, a list of 6 elements with Minimum Element in front
	@Test
	public void test86() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(16);
		testList.add(2);
		testList.add(17);
		testList.add(3);
		testList.add(15);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mergesort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Merge sort, a list of 6 elements with Minimum Element in back
	@Test
	public void test87() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(17);
		testList.add(12);
		testList.add(5);
		testList.add(7);
		testList.add(1);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mergesort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Merge sort, a list of 7 elements with Minimum Element in middle
	@Test
	public void test88() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(13);
		testList.add(12);
		testList.add(1);
		testList.add(7);
		testList.add(10);
		testList.add(4);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mergesort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Merge sort, a list of elements in reverse order
	@Test
	public void test89() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(13);
		testList.add(12);
		testList.add(11);
		testList.add(10);
		testList.add(9);
		testList.add(8);
		testList.add(7);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mergesort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Merge sort, a list of full of the same element
	@Test
	public void test90() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mergesort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Mergesort Failed: testList does not equal solution");
		}
	}

	// Quick sort, a list of 1 element
	@Test
	public void test91() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 1; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.quicksort(testList, 0, 0, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}

	}

	// Quick sort, a list of 2 element
	@Test
	public void test92() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 2; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.quicksort(testList, 0, 1, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}

	}

	// Quick sort, a list of 3 element
	@Test
	public void test93() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.quicksort(testList, 0, 2, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// Quick sort, a list of 100 element
	@Test
	public void test94() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.quicksort(testList, 0, 99, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// Quick sort, a reversed list
	@Test
	public void test95() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		Collections.reverse(solution);
		instance.quicksort(testList, 0, 9, true);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// Quick sort, an already sorted list
	@Test
	public void test96() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		Collections.sort(testList);
		instance.quicksort(testList, 0, 9, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// Quick sort, an empty list
	@Test
	public void test97() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		ArrayList<Integer> solution = new ArrayList<Integer>();

		Collections.sort(solution);
		instance.quicksort(testList, 0, 0, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}

	}

	// Quick sort, a list of 10 elements ( even list )
	@Test
	public void test98() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.quicksort(testList, 0, 9, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// Quick sort, a list of 11 elements ( odd list )
	@Test
	public void test99() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 11; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.quicksort(testList, 0, 10, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// Quick sort, a list of 10 elements with different indexes
	@Test
	public void test100() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution.subList(4, 8));
		instance.quicksort(testList, 4, 7, false);

		if (!testList.subList(4, 7).equals(solution.subList(4, 7))) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// Quick sort, a list of 6 elements with Max Element in front
	@Test
	public void test101() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(10);
		testList.add(6);
		testList.add(2);
		testList.add(7);
		testList.add(3);
		testList.add(5);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.quicksort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// Quick sort, a list of 6 elements with Maximum Element in back
	@Test
	public void test102() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(17);
		testList.add(12);
		testList.add(5);
		testList.add(7);
		testList.add(20);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.quicksort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// Quick sort, a list of 7 elements with Max Element in middle
	@Test
	public void test103() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(13);
		testList.add(12);
		testList.add(18);
		testList.add(7);
		testList.add(1);
		testList.add(4);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.quicksort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// Quick sort, a list of 6 elements with Minimum Element in front
	@Test
	public void test104() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(16);
		testList.add(2);
		testList.add(17);
		testList.add(3);
		testList.add(15);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.quicksort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// Quick sort, a list of 6 elements with Minimum Element in back
	@Test
	public void test105() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(17);
		testList.add(12);
		testList.add(5);
		testList.add(7);
		testList.add(1);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.quicksort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// Quick sort, a list of 7 elements with Minimum Element in middle
	@Test
	public void test106() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(13);
		testList.add(12);
		testList.add(1);
		testList.add(7);
		testList.add(10);
		testList.add(4);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.quicksort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// Quick sort, a list of elements in reverse order
	@Test
	public void test107() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(13);
		testList.add(12);
		testList.add(11);
		testList.add(10);
		testList.add(9);
		testList.add(8);
		testList.add(7);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.quicksort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// Quick sort, a list of full of the same element
	@Test
	public void test108() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.quicksort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Quicksort Failed: testList does not equal solution");
		}
	}

	// My sort, a list of 1 element
	@Test
	public void test109() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 1; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mysort(testList, 0, 0, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}

	}

	// My sort, a list of 2 element
	@Test
	public void test110() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 2; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mysort(testList, 0, 1, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}

	}

	// My sort, a list of 3 element
	@Test
	public void test111() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mysort(testList, 0, 2, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}

	// My sort, a list of 100 element
	@Test
	public void test112() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mysort(testList, 0, 99, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}

	// My sort, a reversed list
	@Test
	public void test113() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		Collections.reverse(solution);
		instance.mysort(testList, 0, 9, true);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}

	// My sort, an already sorted list
	@Test
	public void test114() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		Collections.sort(testList);
		instance.mysort(testList, 0, 9, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}

	// My sort, an empty list
	@Test
	public void test115() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		ArrayList<Integer> solution = new ArrayList<Integer>();

		Collections.sort(solution);
		instance.mysort(testList, 0, 0, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}

	}

	// My sort, a list of 10 elements ( even list )
	@Test
	public void test116() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mysort(testList, 0, 9, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}

	// My sort, a list of 11 elements ( odd list )
	@Test
	public void test117() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 11; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mysort(testList, 0, 10, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}

	// My sort, a list of 10 elements with different indexes
	@Test
	public void test118() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution.subList(4, 8));
		instance.mysort(testList, 4, 7, false);

		if (!testList.subList(4, 7).equals(solution.subList(4, 7))) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}

	// My sort, a list of 6 elements with Max Element in front
	@Test
	public void test119() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(10);
		testList.add(6);
		testList.add(2);
		testList.add(7);
		testList.add(3);
		testList.add(5);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mysort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}

	// My sort, a list of 6 elements with Maximum Element in back
	@Test
	public void test120() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(17);
		testList.add(12);
		testList.add(5);
		testList.add(7);
		testList.add(20);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mysort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}

	// My sort, a list of 7 elements with Max Element in middle
	@Test
	public void test121() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(13);
		testList.add(12);
		testList.add(18);
		testList.add(7);
		testList.add(1);
		testList.add(4);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mysort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}

	// My sort, a list of 6 elements with Minimum Element in front
	@Test
	public void test122() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(1);
		testList.add(16);
		testList.add(2);
		testList.add(17);
		testList.add(3);
		testList.add(15);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mysort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}

	// My sort, a list of 6 elements with Minimum Element in back
	@Test
	public void test123() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(17);
		testList.add(12);
		testList.add(5);
		testList.add(7);
		testList.add(1);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mysort(testList, 0, 5, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}

	// My sort, a list of 7 elements with Minimum Element in middle
	@Test
	public void test124() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(4);
		testList.add(13);
		testList.add(12);
		testList.add(1);
		testList.add(7);
		testList.add(10);
		testList.add(4);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mysort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}

	// My sort, a list of elements in reverse order
	@Test
	public void test125() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(13);
		testList.add(12);
		testList.add(11);
		testList.add(10);
		testList.add(9);
		testList.add(8);
		testList.add(7);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mysort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}

	// My sort, a list of full of the same element
	@Test
	public void test126() {
		ArrayList<Integer> testList = new ArrayList<Integer>();
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		testList.add(2);
		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		Collections.sort(solution);
		instance.mysort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			fail("Mysort Failed: testList does not equal solution");
		}
	}
}
