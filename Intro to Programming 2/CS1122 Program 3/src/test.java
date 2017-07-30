import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collections;

public class test {
	
	private static Sort instance = new Sort();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		instance.insertionsort(testList, 0, 6, false);

		if (!testList.equals(solution)) {
			System.out.println("fail");
		}
	}

}
