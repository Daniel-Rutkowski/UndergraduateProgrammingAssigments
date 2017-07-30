/**
 * WRITE APPROPRIATE DOCUMENTATION FOR ALL CLASSES, VARIABLE, AND METHODS
 * 
 * @author Daniel Rutkowski
 *
 */


public class CO2Data implements Comparable< CO2Data > {
   /**
    * site_code:long_name : site_name_abbreviation.
    * site_code:comment : Site code is an abbreviation for the sampling site name.
    */
   private String site_code;

   /**
    * time_components:_FillValue : -9
    * time_components:long_name : integer_components_of_UTC_date/time
    * time_components:order : year, month, day, hour, minute, second
    * time_components:comment : Calendar time components as integers.  Times and dates are UTC. Time-averaged values are reported at the beginning of the averaging interval.
    */
   private int    year;
   private int    month;
   private int    day;
   private int    hour;
   private int    minute;
   private int    second;

   /** 
    * value:_FillValue : -999.999
    * value:long_name : measured_mole_fraction_of_trace_gas_in_dry_air
    * value:units : micromol mol-1
    * value:comment : Mole fraction reported in units of micromol mol-1 (10-6 mol per mol of dry air); equivalent to ppm (parts per million).
    * value_unc:_FillValue : -999.999
    * value_unc:long_name : estimated_uncertainty_in_reported_value
    * value_unc:units : micromol mol-1
    * value_unc:comment : This is the standard deviation of the reported mean value when nvalue is greater than 1. See provider_comment if available.
    * nvalue:_FillValue : -9
    * nvalue:long_name : number_of_measurements_contributing_to_reported_value
    * nvalue:comment : Number of individual measurements used to compute reported value. See provider_comment if available.
    */
   private double value;
   private double valueUnc;
   private int    nvalue;

   /**
    * latitude:_FillValue : -999.999
    * latitude:standard_name : latitude
    * latitude:long_name : sample_latitude_in_decimal_degrees
    * latitude:units : degrees_north
    * latitude:comment : Latitude at which air sample was collected.
    * longitude:_FillValue : -999.999
    * longitude:standard_name : longitude
    * longitude:long_name : sample_longitude_in_decimal_degrees
    * longitude:units : degrees_east
    * longitude:comment : Longitude at which air sample was collected.
    * altitude:_FillValue : -999.999
    * altitude:standard_name : altitude
    * altitude:long_name : sample_altitude_in_meters_above_sea_level
    * altitude:units : m
    * altitude:comment : Altitude (in meters above sea level) is surface elevation (masl) plus sample intake height (magl). See provider_comment if available.
    * elevation:_FillValue : -999.999
    * elevation:standard_name : elevation
    * elevation:long_name : surface_elevation_in_meters_above_sea_level
    * elevation:units : m
    * elevation:comment : Surface elevation in meters above sea level. See provider_comment if available.
    */
   private double latitude;
   private double longitude;
   private double altitude;
   private double elevation;

   /**
    * intake_height:_FillValue : -999.999
    * intake_height:long_name : sample_intake_height_in_meters_above_ground_level
    * intake_height:units : m
    * intake_height:comment : Sample intake height in meters above ground level (magl). See provider_comment if available.
    */
   private double intake_height;

   /** 
    * instrument: type of instrument used to take measurement.
    */
   private String instrument;

   /**
    * qcflag:_FillValue : NA
    * qcflag:long_name : quality_control_flag
    * qcflag:comment : This quality control flag is provided by the contributing PIs. See provider_comment if available.
    * qcflag:provider_comment : This is the NOAA 3-character quality control flag.  Column 1 is the REJECTION flag. An alphanumeric other than a period (.) in the FIRST column indicates a sample with obvious problems during collection or analysis. This measurement should not be interpreted. Column 2 is the SELECTION flag. An alphanumeric other than a period (.) in the SECOND column indicates a sample that is likely valid but does not meet selection criteria determined by the goals of a particular investigation. Column 3 is the INFORMATION flag. An alphanumeric other than a period (.) in the THIRD column provides additional information about the collection or analysis of the sample.
    */
   private String qcflag;

   /**
    * Test the quality control flag to determine if the data is valid.
    * @return true if the data is valid, false otherwise.
    */
   public boolean isValid( ) {
	// YOUR CODE HERE
	   if (qcflag.equals("...")) {
		    return true;
	   } else {
		   return false;
	   }
      
   }

   /**
    * Compare two data elements by comparing their values.
    * @return -1 if this.value <  o.value, 
    *          0 if this.value == o.value,
    *          1 if this.value >  o.value.
    */
   @Override
   public int compareTo( CO2Data o ) {
      return ( new Double( value ) ).compareTo( o.value );
   }

   /**
    * Formates the data into a human-readable string.
    */
   @Override
   public String toString( ) {
      return String.format(
            "<CO2DATA: %3s %02d/%02d/%4d %02d:%02d:%02d %8.3f %3s>",
            site_code,
            month,
            day,
            getYear(),
            hour,
            minute,
            second,
            value,
            qcflag );
   }

   /**
    * Constructor used to initialize all data components.
    * 
    * @param site_code
    * @param year
    * @param month
    * @param day
    * @param hour
    * @param minute
    * @param second
    * @param value
    * @param valueUnc
    * @param nvalue
    * @param latitude
    * @param longitude
    * @param altitude
    * @param elevation
    * @param intake_height
    * @param instrument
    * @param qcflag
    */
   public CO2Data(
         String site_code,
         int year,
         int month,
         int day,
         int hour,
         int minute,
         int second,
         double value,
         double valueUnc,
         int nvalue,
         double latitude,
         double longitude,
         double altitude,
         double elevation,
         double intake_height,
         String instrument,
         String qcflag ) {
      this.site_code = site_code;
      this.year = year;
      this.month = month;
      this.day = day;
      this.hour = hour;
      this.minute = minute;
      this.second = second;
      this.value = value;
      this.valueUnc = valueUnc;
      this.nvalue = nvalue;
      this.latitude = latitude;
      this.longitude = longitude;
      this.altitude = altitude;
      this.elevation = elevation;
      this.intake_height = intake_height;
      this.instrument = instrument;
      this.qcflag = qcflag;
   }


public int getYear() {
	return year;
}

public void setYear(int year) {
	this.year = year;
}

public int getMonth() {
	return month;
}

public void setMonth(int month) {
	this.month = month;
}

public int getDay() {
	return day;
}

public void setDay(int day) {
	this.day = day;
}
public double getValue() {
	return value;
}

public void setValue(double value) {
	this.value = value;
}

public double getValueUnc() {
	return valueUnc;
}

public void setValueUnc(double valueUnc) {
	this.valueUnc = valueUnc;
}

public int getNvalue() {
	return nvalue;
}

public void setNvalue(int nvalue) {
	this.nvalue = nvalue;
}

public double getLatitude() {
	return latitude;
}

public void setLatitude(double latitude) {
	this.latitude = latitude;
}

public double getLongitude() {
	return longitude;
}

public void setLongitude(double longitude) {
	this.longitude = longitude;
}

public double getAltitude() {
	return altitude;
}

public void setAltitude(double altitude) {
	this.altitude = altitude;
}

public double getElevation() {
	return elevation;
}

public void setElevation(double elevation ) {
	this.elevation = elevation;
}

public double getIntake_height() {
	return intake_height;
}

public void setIntake_height(double intake_height) {
	this.intake_height = intake_height;
}

public String getInstrument() {
	return instrument;
}

public void set(String instrument) {
	this.instrument = instrument;
}

}
