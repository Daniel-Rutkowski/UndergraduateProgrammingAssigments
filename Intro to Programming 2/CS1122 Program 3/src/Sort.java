import java.util.ArrayList;
import java.util.Collections;


/**
 * This program implements and tests multiple sorting algorithms.
 * 
 * Date Last Modified: 03 /2 / 2017
 * 
 * @author Daniel Rutkowski
 *
 *         CS1122, Spring 2017
 * 
 */

public class Sort implements SortInterface {

	public static void main(String[] args) {

		Sort test = new Sort();

		ArrayList<Integer> testList = new ArrayList<Integer>();

		for (int i = 0; i < 10; i++) {
			testList.add(i, (int) (Math.random() * 100));
		}

		ArrayList<Integer> solution = new ArrayList<Integer>();
		solution.addAll(testList);

		System.out.println("Original " + testList);
		Collections.sort(solution);
		test.shellsort(testList, 0, 9, false);

		// Collections.sort(solution.subList(2, 5));
		// test.mysort(testList, 2, 4, true);

		System.out.println("Expected " + solution);
		System.out.println("Actual " + testList);

	}

	/**
	 * This method sorts using bubble sort.
	 * 
	 * @param list
	 *            : The list to be sorted.
	 * @param lowindex
	 *            : The index of where to start sorting the array list.
	 * @param highindex
	 *            : The index of where to stop sorting the array list.
	 * @param reversed
	 *            : If the array list should be reversed in descending or
	 *            ascending order
	 * 
	 */
	@Override
	public void bubblesort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed) {
		if (list.equals(null) || list.size() == 0) {
			return;
		}

		for (int i = lowindex; i < highindex; i++) {
			for (int j = i + 1; j < highindex + 1; j++) {
				if (reversed) {
					if (list.get(i) < list.get(j)) {
						int temp = list.get(i);
						list.set(i, list.get(j));
						list.set(j, temp);
					}
				} else {
					if (list.get(j) < list.get(i)) {
						int temp = list.get(j);
						list.set(j, list.get(i));
						list.set(i, temp);
					}
				}
			}
		}
	}

	/**
	 * This method sorts using insertion sort.
	 * 
	 * @param list
	 *            : The list to be sorted.
	 * @param lowindex
	 *            : The index of where to start sorting the array list.
	 * @param highindex
	 *            : The index of where to stop sorting the array list.
	 * @param reversed
	 *            : If the array list should be reversed in descending or
	 *            ascending order
	 * 
	 */
	@Override
	public void insertionsort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed) {
		if (list.equals(null) || list.size() == 0) {
			return;
		}

		if (reversed) {
			int temp;
			for (int i = lowindex; i < highindex; i++) {
				for (int j = highindex; j > lowindex; j--) {
					if (list.get(j) > list.get(j - 1)) {
						temp = list.get(j);
						list.set(j, list.get(j - 1));
						list.set(j - 1, temp);
					}
				}
			}

		} else {
			int temp;
			for (int i = lowindex; i < highindex; i++) {
				for (int j = highindex; j > lowindex; j--) {
					if (list.get(j) < list.get(j - 1)) {
						temp = list.get(j);
						list.set(j, list.get(j - 1));
						list.set(j - 1, temp);
					}
				}
			}
		}
	}

	/**
	 * This method sorts using selection sort.
	 * 
	 * @param list
	 *            : The list to be sorted.
	 * @param lowindex
	 *            : The index of where to start sorting the array list.
	 * @param highindex
	 *            : The index of where to stop sorting the array list.
	 * @param reversed
	 *            : If the array list should be reversed in descending or
	 *            ascending order
	 * 
	 */
	@Override
	public void selectionsort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed) {
		if (list.equals(null) || list.size() == 0) {
			return;
		}

		if (!reversed) {
			for (int i = lowindex; i < highindex; i++) {
				int smallest = i; // value to be compared to the others to find the smallest

				for (int j = i + 1; j < highindex + 1; j++) {

					if (list.get(j) < list.get(smallest)) {
						smallest = j;
					}
				}

				int temp = list.get(smallest);
				list.set(smallest, list.get(i));
				list.set(i, temp);
			}
		}

		if (reversed) {
			for (int i = lowindex; i < highindex; i++) {
				int smallest = i; // value to be compared to the others to find the smallest

				for (int j = i + 1; j < highindex + 1; j++) {

					if (list.get(j) > list.get(smallest)) {
						smallest = j;
					}
				}

				int temp = list.get(smallest);
				list.set(smallest, list.get(i));
				list.set(i, temp);
			}
		}
	}

	/**
	 * This method sorts using shell sort.
	 * 
	 * @param list
	 *            : The list to be sorted.
	 * @param lowindex
	 *            : The index of where to start sorting the array list.
	 * @param highindex
	 *            : The index of where to stop sorting the array list.
	 * @param reversed
	 *            : If the array list should be reversed in descending or
	 *            ascending order
	 * 
	 */
	@Override
	public void shellsort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed) {
		if (list.equals(null) || list.size() == 0) {
			return;
		}

		if (reversed) {
			int inner;  // used to increment my inner loop
			double temp;  // used to swap values

			int h = 1; // used for h sorting the list

			while (h <= list.size()) {

				for (int outer = h; outer < highindex + 1; outer++) {
					temp = list.get(outer);
					inner = outer;

					while (inner > h - 1 && list.get(inner - h) <= temp && (inner - h) >= lowindex) {
						list.set(inner, list.get(inner - h));
						inner = inner - h;
					}
					list.set(inner, (int) (temp));
				}
				h++;
				h = (int) (Math.pow(2, h)) - 1;
			}
		} else {
			int inner;  // used to increment my inner loop
			double temp; // used to swap values

			int h = 1; // used for h sorting the list

			while (h <= list.size()) {

				for (int outer = h; outer < highindex + 1; outer++) {
					temp = list.get(outer);
					inner = outer;

					while (inner > h - 1 && list.get(inner - h) >= temp && (inner - h) >= lowindex) {
						list.set(inner, list.get(inner - h));
						inner = inner - h;
					}
					list.set(inner, (int) (temp));
				}
				h++;
				h = (int) (Math.pow(2, h)) - 1;
			}
		}

	}

	/**
	 * This method sorts using quick sort.
	 * 
	 * @param list
	 *            : The list to be sorted.
	 * @param lowindex
	 *            : The index of where to start sorting the array list.
	 * @param highindex
	 *            : The index of where to stop sorting the array list.
	 * @param reversed
	 *            : If the array list should be reversed in descending or
	 *            ascending order
	 * 
	 */
	@Override
	public void quicksort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed) {
		if (list.equals(null) || list.size() == 0) {
			return;
		}

		if (reversed) {

			int i = lowindex; // variable used for low index
			int j = highindex; // variable used for high index
			int pivot = list.get(lowindex + (highindex - lowindex) / 2); // The pivot to divide the list at

			while (i <= j) {

				while (list.get(i) > pivot) {
					i++;
				}

				while (list.get(j) < pivot) {
					j--;
				}

				if (i <= j) {
					quicksortSwap(list, i, j);
					i++;
					j--;
				}
			}

			if (lowindex < j) {
				quicksort(list, lowindex, j, reversed);
			}

			if (i < highindex) {
				quicksort(list, i, highindex, reversed);
			}

		} else {
			int i = lowindex; // variable used for low index
			int j = highindex; // variable used for high index
			int pivot = list.get(lowindex + (highindex - lowindex) / 2); // The pivot to divide the list at

			while (i <= j) {

				while (list.get(i) < pivot) {
					i++;
				}

				while (list.get(j) > pivot) {
					j--;
				}

				if (i <= j) {
					quicksortSwap(list, i, j);
					i++;
					j--;
				}
			}

			if (lowindex < j) {
				quicksort(list, lowindex, j, reversed);
			}

			if (i < highindex) {
				quicksort(list, i, highindex, reversed);
			}
		}
	}

	/**
	 * Swaps the smallest value with the first value of the unsorted sub array
	 * for quick sort
	 * 
	 * @param list
	 *            : The list to be sorted.
	 * @param i
	 *            : The first integer to be switched.
	 * @param j
	 *            : The second integer to be switched.
	 * 
	 * 
	 */
	public void quicksortSwap(ArrayList<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

	/**
	 * This method sorts using merge sort.
	 * 
	 * @param list
	 *            : The list to be sorted.
	 * @param lowindex
	 *            : The index of where to start sorting the array list.
	 * @param highindex
	 *            : The index of where to stop sorting the array list.
	 * @param reversed
	 *            : If the array list should be reversed in descending or
	 *            ascending order
	 * 
	 */
	@Override
	public void mergesort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed) {

		if (list.size() <= 1) {
			return;
		}

		int center = lowindex + (highindex - lowindex) / 2 + 1; // Middle of the range to be sorted in the array list

		ArrayList<Integer> firstList = new ArrayList<Integer>(); // first half of the original list

		for (int i = lowindex; i < (center); i++) {
			firstList.add(list.get(i));
		}

		ArrayList<Integer> secondList = new ArrayList<Integer>(); // second half of the original list

		for (int i = (center); i <= (highindex); i++) {
			secondList.add(list.get(i));
		}

		mergesort(firstList, 0, firstList.size() - 1, reversed);
		mergesort(secondList, 0, secondList.size() - 1, reversed);
		merge(firstList, secondList, list, lowindex, reversed);

	}

	/**
	 * This method merges the two lists from merge sort back into the original list
	 * 
	 * @param firstList
	 *            : The first list to be merged back into the original list.
	 * @param secondList
	 *            : The second list to be merged back into the original list.
	 * @param list
	 *            : The original list to be sorted.
	 * @param wholeIndex 
	 * 			  :  The index used to set each value within the original list.
	 * @param reversed
	 *            : If the array list should be reversed in descending or
	 *            ascending order
	 * 
	 */
	private void merge(ArrayList<Integer> firstList, ArrayList<Integer> secondList, ArrayList<Integer> list,
			int wholeIndex, boolean reversed) {

		int iFirst = 0;
		int iSecond = 0;

		if (reversed) {
			while (iFirst < firstList.size() && iSecond < secondList.size()) {

				if (firstList.get(iFirst) > secondList.get(iSecond)) {
					list.set(wholeIndex, firstList.get(iFirst));
					iFirst++;

				} else {
					list.set(wholeIndex, secondList.get(iSecond));
					iSecond++;
				}
				wholeIndex++;
			}

		} else {
			while (iFirst < firstList.size() && iSecond < secondList.size()) {

				if (firstList.get(iFirst) < secondList.get(iSecond)) {
					list.set(wholeIndex, firstList.get(iFirst));
					iFirst++;

				} else {
					list.set(wholeIndex, secondList.get(iSecond));
					iSecond++;
				}
				wholeIndex++;
			}
		}

		ArrayList<Integer> end;
		int restIndex;

		if (iFirst >= firstList.size()) {
			end = secondList;
			restIndex = iSecond;
		} else {
			end = firstList;
			restIndex = iFirst;
		}

		for (int i = restIndex; i < end.size(); i++) {
			list.set(wholeIndex, end.get(i));
			wholeIndex++;
		}

	}

	/**
	 * This method sorts using my sort, a combination of quick sort and
	 * selection sort.
	 * 
	 * @param list
	 *            : The list to be sorted.
	 * @param lowindex
	 *            : The index of where to start sorting the array list.
	 * @param highindex
	 *            : The index of where to stop sorting the array list.
	 * @param reversed
	 *            : If the array list should be reversed in descending or
	 *            ascending order
	 * 
	 */
	@Override
	public void mysort(ArrayList<Integer> list, int lowindex, int highindex, boolean reversed) {
		if (list.size() <= 10) {
			selectionsort(list, lowindex, highindex, reversed);
		}

		if (list.equals(null) || list.size() == 0) {
			return;
		}

		if (reversed) {

			int i = lowindex; // variable used for low index
			int j = highindex; // variable used for high index
			int pivot = list.get(lowindex + (highindex - lowindex) / 2); // The pivot to divide the list at

			while (i <= j) {

				while (list.get(i) > pivot) {
					i++;
				}

				while (list.get(j) < pivot) {
					j--;
				}

				if (i <= j) {
					mysortSwap(list, i, j);
					i++;
					j--;
				}
			}

			if (lowindex < j) {
				mysort(list, lowindex, j, reversed);
			}

			if (i < highindex) {
				mysort(list, i, highindex, reversed);
			}

		} else {
			int i = lowindex; // variable used for low index
			int j = highindex; // variable used for high index
			int pivot = list.get(lowindex + (highindex - lowindex) / 2); // The pivot to divide the list at

			while (i <= j) {

				while (list.get(i) < pivot) {
					i++;
				}

				while (list.get(j) > pivot) {
					j--;
				}

				if (i <= j) {
					mysortSwap(list, i, j);
					i++;
					j--;
				}
			}

			if (lowindex < j) {
				mysort(list, lowindex, j, reversed);
			}

			if (i < highindex) {
				mysort(list, i, highindex, reversed);
			}
		}
	}


	/**
	 * Swaps the smallest value with the first value of the unsorted sub array
	 * for my sort
	 * 
	 * @param list
	 *            : The list to be sorted.
	 * @param i
	 *            : The first integer to be switched.
	 * @param j
	 *            : The second integer to be switched.
	 * 
	 * 
	 */
	public void mysortSwap(ArrayList<Integer> list, int i, int j) {
		int temp = list.get(j);
		list.set(j, list.get(i));
		list.set(i, temp);
	}
}
