//For use in dynamic arrays
import java.util.ArrayList;

/**This class is an object designed to serve as a year of rainfall: it stores
12 months of rainfall measurements in a double[], and has various methods for
the manipulation and getting of the data stored. The class also validates input
received to verify that the rainfall measurements are non-negative real
numbers.*/
class RainFall
{
  //Internal array of month names for use in multiple methods
  private final String[] MONTHS = {"January", "February", "March", "April",
                                  "May", "June", "July", "August", "September",
                                  "October", "November", "December"};
  //Declaring internal array to hold 12 months of rainfall measurements. Scope
  //needed for multiple methods.
  private double[] allRainFall;


  /**Constructor to instantiate RainFall object with filled allRainFall array.
  Performs validation of double[] passed as argument.
  @param rain Double[] of rainfall measurements. This must be an array of 12
  non-negative doubles.*/
  public RainFall(double[] rain) throws IllegalArgumentException
  {
    //Sizing internal array to hold 12 values
    allRainFall = new double[MONTHS.length];
    //If the passed array has more or less than 12 values, throw exception.
    if (rain.length != MONTHS.length)
    {
      throw new IllegalArgumentException("An array of " + MONTHS.length +
                                          " values is required.");
    }
    //If any of the values of the passed array are negative, throw an exception.
    for (int i = 0; i < MONTHS.length; i++)
    {
      if (rain[i] < 0)
      {
        throw new IllegalArgumentException("Array values must be " +
                                            "non-negative.");
      }
      //If the passed value is legal, assign it to the internal array at the
      //same index.
      allRainFall[i] = rain[i];
    }
  }


  /**Public method to calculate and return the total yearly rainfall.
  @return The total amount of rainfall for the year.*/
  public double getYearlyRainFall()
  {
    //Initialize the yearly rainfall to a default value of 0
    double yearlyRainFall = 0;
    //Iterate through array, adding each value to the sum
    for (int i = 0; i < allRainFall.length; i++)
    {
      yearlyRainFall += allRainFall[i];
    }

    return yearlyRainFall;
  }


  /**Public method to return the average monthly rainfall
  @return The average monthly rainfall.*/
  public double getMonthlyRainFall()
  {
    //Initialize the variable with the yearly rainfall, divided by 12 months
    double monthlyRainFall = (getYearlyRainFall() / MONTHS.length);
    return monthlyRainFall;
  }


  /**Public method to return the name(s) of the month(s) with the most amount of
  rainfall during the year. It is able to return multiple names, should multiple
  months have the greatest amount of rainfall (equal rainfall values for
  multiple months). It utilizes an ArrayList to create a dynamic, malleable
  array, then returns a String[].
  @return A String[], containing the name(s) of the month(s) the had the most
  rainfall. The array will only be the size of the number of elements it
  contains; it can hold 1 to 12 values.*/
  public String[] getMonthlyMostName()
  {
    //ArrayList to hold the names of the months with the most rain, declared
    //with a size of 1
    ArrayList<String> monthlyMost = new ArrayList<String>(1);
    //Setting default month to January
    monthlyMost.add(0, MONTHS[0]);
    //Index of the month in the constant array that currently has the most
    //rainfall (will update as iterations continue), defaulting to the first
    //month.
    int indexOfMost = 0;
    //Iterate through the rainfall values
    for (int i = 1; i < allRainFall.length; i++)
    {
      //If the current month had more rainfall than the greatest amount found
      //so far...
      if (allRainFall[i] > allRainFall[indexOfMost])
      {
        //Clear the ArrayList holding the names of the months with the greatest
        //values found so far
        monthlyMost.clear();
        //Reset the ArrayList with the name of the current month
        monthlyMost.add(0, MONTHS[i]);
        //Reset the index of the greatest value to the current index
        indexOfMost = i;
      }
      //If the rainfall of the current month equals the rainfall of the greatest
      //month so far...
      else if (allRainFall[i] == allRainFall[indexOfMost])
      {
        //Add the current month to the ArrayList of greatest months
        monthlyMost.add(MONTHS[i]);
      }
    }
    //Return the resulting ArrayList of the names of the months with the most
    //rainfall, converting to a String[]
    return monthlyMost.toArray(new String[monthlyMost.size()]);
  }


  /**Public method to return the name(s) of the month(s) with the least amount
  of rainfall during the year. It is able to return multiple names, should
  multiple months have the least amount of rainfall (equal rainfall values for
  multiple months). It utilizes an ArrayList to create a dynamic, malleable
  array, then returns a String[].
  @return A String[], containing the name(s) of the month(s) the had the least
  rainfall. The array will only be the size of the number of elements it
  contains; it can hold 1 to 12 values.*/
  public String[] getMonthlyLeastName()
  {
    //ArrayList to hold the names of the months with the most rain, declared
    //with a size of 1
    ArrayList<String> monthlyLeast = new ArrayList<String>(1);
    //Setting default month to January
    monthlyLeast.add(0, MONTHS[0]);
    //Index of the month in the constant array that currently has the least
    //rainfall (will update as iterations continue), defaulting to the first
    //month.
    int indexOfLeast = 0;
    //Loop through the rainfall values
    for (int i = 1; i < allRainFall.length; i++)
    {
      //If the current month had less rainfall than the least amount found
      //so far...
      if (allRainFall[i] < allRainFall[indexOfLeast])
      {
        //Clear the ArrayList holding the names of the months with the smallest
        //values found so far
        monthlyLeast.clear();
        //Reset the ArrayList with the name of the current month
        monthlyLeast.add(0, MONTHS[i]);
        //Reset the index of the least value to the current index
        indexOfLeast = i;
      }
      //If the rainfall of the current month equals the rainfall of the least
      //month so far...
      else if (allRainFall[i] == allRainFall[indexOfLeast])
      {
        //Add the current month to the ArrayList of least months
        monthlyLeast.add(MONTHS[i]);
      }
    }
    //Return the resulting ArrayList of the names of the months with the least
    //rainfall, converting to a String[]
    return monthlyLeast.toArray(new String[monthlyLeast.size()]);
  }


  /**Public method to return the greatest amount of monthly rainfall during the
  year. The method ignores which month it was that received the rainfall, and
  returns the amount of rainfall. The method also ignores whether or not
  multiple months recieved the same amount of rain.
  @return The largest amount of monthly rainfall received during the year.*/
  public double getMonthlyMostInches()
  {
    //The index of the array of rainfall that has the largest value, initialized
    //to the first month as a default
    int indexOfMost = 0;
    //Iterate through the array of rainfall measurements; if the current index
    //has a greater value than the highest value found so far, reset the stored
    //index.
    for (int i = 1; i < allRainFall.length; i++)
    {
      if (allRainFall[i] > allRainFall[indexOfMost])
      {
        indexOfMost = i;
      }
    }
    return allRainFall[indexOfMost];
  }


  /**Public method to return the smallest amount of monthly rainfall during the
  year. The method ignores which month it was that received the rainfall, and
  returns the amount of rainfall. The method also ignores whether or not
  multiple months recieved the same amount of rain.
  @return The smallest amount of monthly rainfall received during the year.*/
  public double getMonthlyLeastInches()
  {
    //The index of the array of rainfall that has the smallest value,
    //initialized to the first month as a default
    int indexOfLeast = 0;
    //Iterate through the array of rainfall measurements; if the current index
    //has a smaller value than the smallest value found so far, reset the stored
    //index.
    for (int i = 1; i < allRainFall.length; i++)
    {
      if (allRainFall[i] < allRainFall[indexOfLeast])
      {
        indexOfLeast = i;
      }
    }
    return allRainFall[indexOfLeast];
  }
}
