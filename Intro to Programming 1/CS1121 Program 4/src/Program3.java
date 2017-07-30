import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Program3 implements CO2LevelsInterface {
	
	private ArrayList<CO2Data> data = new ArrayList<CO2Data>();
	public int minI = 0;
	public int maxI = 0;

	    /**
	    * Load the CO2Data data from the specified file.
	    * NOTE: Reads all data from file into the array list.
	    * 
	    * @param filename : filepath / filename of data file on disk.
	    * @return an ArrayList of CO2Data containing all values read from the file
	    */
	
	public ArrayList<CO2Data> loadData(String filename) throws FileNotFoundException {
		data.clear();
		File fin = new File(filename);
		Scanner scan = null;
		try {
			scan = new Scanner(fin);
			String[] s = new String[17];
			while (scan.hasNext()) {
				String temp = scan.next();
				if (temp.equals("#")) {
					scan.nextLine();
				} else {
					s[0] = temp;
					for (int i = 1; i < 17; i++) {
						s[i] = scan.next();
					}
					data.add(new CO2Data(s[0], Integer.parseInt(s[1]), Integer.parseInt(s[2]), Integer.parseInt(s[3]),
							Integer.parseInt(s[4]), Integer.parseInt(s[5]), Integer.parseInt(s[6]),
							Double.parseDouble(s[7]), Double.parseDouble(s[8]), Integer.parseInt(s[9]),
							Double.parseDouble(s[10]), Double.parseDouble(s[11]), Double.parseDouble(s[12]),
							Double.parseDouble(s[13]), Double.parseDouble(s[14]), s[15], s[16]));
				}
			}
		} finally {
			if (scan != null) {
				scan.close();
			}

		}
		return data;

	}
	
	    /**
	    * Iterates through the data and returns a list of all CO2 values for the
	    * day specified by the year, month, and day arguments.
	    * 
	    * @param year is an integer, for example: 1974.
	    * @param month is an integer in the range 1 to 12.
	    * @param day is an integer representing the day of the month.
	    *            The range is 1 to 31, depending on the month.
	    * @return a ArrayList<CO2Data> containing all CO2Data entries for 
	    *         the specified argument. If the specified data does not exist,
	    *         the method returns an empty list.
	    */
	
	public ArrayList<CO2Data> getData(Integer year, Integer month, Integer day) {
		ArrayList<CO2Data> temp = new ArrayList<CO2Data>();
		for (int i = 0; i < data.size(); i++) {
				if ((year == null || data.get(i).getYear() == year) && (month == null || data.get(i).getMonth() == month) && (day == null || data.get(i).getDay() == day )) {
					temp.add(data.get(i));
			}
		}
		return temp;
	}

	    /**
	    * Iterates through the data and returns the average CO2 value for the
	    * day specified by the year, month, and day arguments.
	    * NOTE: Ignore invalid values.
	    * 
	    * @param year is an integer, for example: 1974.
	    * @param month is an integer in the range 1 to 12.
	    * @param day is an integer representing the day of the month.
	    *            The range is 1 to 31, depending on the month.
	    * @return a Double value that is an average of all data values measured
	    *         on the specified day. If the specified day does not exist,
	    *         the method returns null.
	    */
	
	public Double getAverage(Integer year, Integer month, Integer day) {
		
		ArrayList<CO2Data> temp = getData(year, month, day);
		boolean noValid = true;
		if ( temp.size() == 0) {
			return null;
		}
		
		double sum = 0; 
		int length = 0;
		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).isValid()) {
				noValid = false;
				sum += temp.get(i).getValue();
				length++;
			}
		}
		if (noValid) {return null;} 
		return sum /= length;

	}

	    /**
	    * Iterates through the data and returns the maximum CO2 value for the
	    * day specified by the year, month, and day arguments.
	    * NOTE: Ignore invalid values.
	    * 
	    * @param year is an integer, for example: 1974.
	    * @param month is an integer in the range 1 to 12.
	    * @param day is an integer representing the day of the month.
	    *            The range is 1 to 31, depending on the month.
	    * @return a Double value that is an maximum of all data values measured
	    *         on the specified day. If the specified day does not exist,
	    *         the method returns null.
	    */
	
	public Double getMin(Integer year, Integer month, Integer day) {
		
		ArrayList<CO2Data> temp = getData(year, month, day);
		boolean noValid = true;
		if ( temp.size() == 0) {
			return null;
		}
		
		double min = Double.MAX_VALUE;
		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).isValid()) {
				noValid = false;
				if ( min > temp.get(i).getValue()) {
					min = temp.get(i).getValue();
				}
			}
		}
		if (noValid) {return null;} 
		return min;
	}
	
	    /**
	    * Iterates through the data and returns the minimum CO2 value for the
	    * day specified by the year, month, and day arguments.
	    * NOTE: Ignore invalid values.
	    * 
	    * @param year is an integer, for example: 1974.
	    * @param month is an integer in the range 1 to 12.
	    * @param day is an integer representing the day of the month.
	    *            The range is 1 to 31, depending on the month.
	    * @return a Double value that is an minimum of all data values measured
	    *         on the specified day. If the specified day does not exist,
	    *         the method returns null.
	    */
	
	public Double getMax(Integer year, Integer month, Integer day) {
		
		ArrayList<CO2Data> temp = getData(year, month, day);
		boolean noValid = true;
		if ( temp.size() == 0) {
			return null;
		}
		
		double max = Double.MIN_VALUE;
		for (int i = 0; i < temp.size(); i++) {
			if (temp.get(i).isValid()) {
				noValid = false;
				if ( max < temp.get(i).getValue()) {
					max = temp.get(i).getValue();
				}
			}
		}
		if (noValid) {return null;} 
		return max;
	}

	    /**
	    * @return : The first year of data.
	    */
	
	public Integer beginYear() {
		
		boolean noValid = true;
		if ( data.size() == 0) {
			return null;
		}
		
		int year = Integer.MAX_VALUE;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).isValid()) {
				noValid = false;
				if ( year > data.get(i).getYear()) {
					year = data.get(i).getYear();
				}
			}
		}
		if (noValid) {return null;} 
		return year;
	}

	    /**
	    * @return : The final year of data.
	    */
	
	public Integer endYear() {
		
		boolean noValid = true;
		if ( data.size() == 0) {
			return null;
		}
		
		int year = Integer.MIN_VALUE;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).isValid()) {
				noValid = false;
				if ( year <= data.get(i).getYear()) {
					year = data.get(i).getYear();
				}
			}
		}
		if (noValid) {return null;} 
		return year;
		

	}

//	 public static void main( String [ ] args ) {
//
//	      Program3 obj = new Program3( ); 
//
//	      try {
//
//	         obj.loadData( "co2_mlo_surface-insitu_1_ccgg_MonthlyData.txt" );
//
//	         System.out.printf( ">Overall Average: %4.3f%n", obj.getAverage( 1974, 1, null ) );
//
//	         System.out.printf( ">Overall Max: %4.3f%n", obj.getMax( 1973, null, null ) );
//
//	         System.out.printf( ">Overall Min: %4.3f%n", obj.getMin( 1973, null, null ) );
//
//	         System.out.printf( ">Data: %s%n", obj.getData( null, null, null ) );
//	         
//	         System.out.printf( ">Begin Year: %d%n", obj.beginYear() );
//	         
//	         System.out.printf( ">End Year: %d%n", obj.endYear() );
//
//	      } catch ( FileNotFoundException e ) {
//
//	         e.printStackTrace();
//
//	      }
//
//	     try {
//
//	         obj = new Program3( );
//
//	         obj.loadData( "co2_brw_surface-insitu_1_ccgg_DailyData.txt" );
//
//	         System.out.printf( ">>Overall Average: %4.4f%n", obj.getAverage( 1974, 1, null ) );
//
//	         System.out.printf( ">>Overall Max: %4.4f%n", obj.getMax( 1974, 1, null ) );
//
//	         System.out.printf( ">>Overall Min: %4.4f%n", obj.getMin( 1974, 1, null ) );
//
//	         System.out.printf( ">>Data: %s%n", obj.getData( 1974, 1, null ) );
//	         
//	         System.out.printf( ">Begin Year: %d%n", obj.beginYear() );
//	         
//	         System.out.printf( ">End Year: %d%n", obj.endYear() );
//
//	      } catch ( FileNotFoundException e ) {
//
//	         e.printStackTrace();
//
//	      } 
//
//	   }

}
