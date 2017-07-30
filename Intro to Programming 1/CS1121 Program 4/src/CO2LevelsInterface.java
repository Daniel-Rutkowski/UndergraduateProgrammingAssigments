import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Describes the API used to analyze NOAA Atmospheric CO2 Data.
 * 
 * DO NOT MODIFY THIS FILE
 */


public interface CO2LevelsInterface {

   /**
    * Load the CO2Data data from the specified file.
    * NOTE: Reads all data from file into the array list.
    * 
    * @param filename : filepath / filename of data file on disk.
    * @return an ArrayList of CO2Data containing all values read from the file
    */
	
	
   public ArrayList<CO2Data> loadData( String filename ) throws FileNotFoundException;

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
   public ArrayList<CO2Data> getData( Integer year, Integer month, Integer day );
   
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
   public Double getAverage( Integer year, Integer month, Integer day );

   
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
   public Double getMax( Integer year, Integer month, Integer day );
   
   
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
   public Double getMin( Integer year, Integer month, Integer day );
   
   /**
    * @return : The first year of data.
    */
   public Integer beginYear( );
   
   /**
    * @return : The final year of data.
    */
   public Integer endYear( );
   
}
