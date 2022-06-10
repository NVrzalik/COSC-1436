//For obtaining user input
import java.util.Scanner;
//For dynamic array manipulation
import java.util.ArrayList;

/**This class serves as a demonstration of the RainFall class. The program
prompts the user for 12 months of rainfall measurements, and returns the total
amount of rainfall for the year, the average monthly rainfall, the month that
had the most rain, and the month that had the least rain. It also performs
input validation to ensure that the measurements provided are not only non-
negative real numbers, but also values that could constitute legitimate
rainfall measurements (in inches).*/
class a8main
{
  //Constant array of months of the year, for use in multiple methods
  static final String[] MONTHS = {"January", "February", "March", "April",
                                  "May", "June", "July", "August", "September",
                                  "October", "November", "December"};


  /**The main method.*/
  public static void main(String[] args)
  {
    //Explanation of program for user
    System.out.println("This program accepts as input 12 months of rainfall " +
                        "measurements, and will return: the total amount of " +
                        "rainfall for the year, the average monthly rainfall," +
                        " the month that had the most rain, the month that " +
                        "had the least rain.");
    //Obtain rainfall measurements from the user
    double[] rainfall = getRainFall();
    //Call RainFall constructor, passing the user's input as the argument.
    RainFall year = new RainFall(rainfall);
    //Display the total amount of rainfall during the year
    displayTotalRainFall(year);
    //Display the average amount of monthly rainfall
    displayAverageRainFall(year);
    //Display the month which recieved the most rain and its rainfall
    displayMonthMost(year);
    //Display the month which recieved the least rain and its rainfall
    displayMonthLeast(year);
  }


  /**Method to obtain 12 months of rainfall measurements from the user. The
  method performs input validation to ensure that only non-negative real numbers
  that could potentially be realistic rainfall measurements are accepted.
  Measurements are in inches of rain.
  @return An array of 12 months of rainfall measurements.*/
  static double[] getRainFall()
  {
    //Declaring double[] to have a capacity of 12 elements
    double[] rainfall = new double[MONTHS.length];
    //Iterate through the months of the year
    for (int i = 0; i < MONTHS.length; i++)
    {
      do
      {
        //Prompt the user to provide the rainfall measurement of the current
        //month of the iteration
        System.out.print("What was the rainfall for " + MONTHS[i] + " (in " +
                          "inches)? ");
        //Obtain user input
        double input = getInput();
        //If the input for the month exceeds 400 inches, notify the user and
        //prompt again for valid input
        if (input > 400)
        {
          System.out.println("The provided rainfall measurement greatly " +
                              "exceeds the current world record for most " +
                              "rainfall in one calendar month. Please confirm" +
                              " the accuracy of the provided measurement.");
        }
        //If the input is negative, or failed preliminary validation in
        //getInput(), notify user and prompt again
        else if (input < 0)
        {
          System.out.println("Please provide a valid rainfall measurement." +
                              " Input must be a non-negative real number in " +
                              "decimal form. The units are in inches (do " +
                              "not include the units in your input).");
        }
        //If the input is within the acceptable range, add it to the rainfall
        //array at the current index
        else
        {
          rainfall[i] = input;
          break;
        }
      } while (true);
    }
    return rainfall;
  }


  /**Method to obtain numeric input from the user. If the input provided is not
  a double, the method returns -1.
  @return The user's input, or -1 in the case of a failure.*/
  static double getInput()
  {
    //Instantiate Scanner object
    Scanner keyboard = new Scanner(System.in);
    //Initialize variable to hold user's input; set to -1 as redundant failsafe
    double input = -1;
    //Parse user input for a double
    try
    {
      input = Double.parseDouble(keyboard.nextLine());
    }
    //In case of failure, ensure variable is set to -1
    catch (Exception e)
    {
      input = -1;
    }
    return input;
  }


  /**Method to display the total amount of rainfall during the year. It utilizes
  the RainFall class' getYearlyRainFall() method to obtain the correct value.
  @param year The RainFall object that holds the rainfall measurements to be
  used.*/
  static void displayTotalRainFall(RainFall year)
  {
    //Display the total amount of rainfall
    System.out.print("The total rainfall for the year was " +
                        year.getYearlyRainFall() + " inches; ");
  }


  /**Method to display the average monthly rainfall during the year. It utilizes
  the RainFall class' getMonthlyRainFall() method to obtain the correct value.
  @param year The RainFall object that holds the rainfall measurements to be
  used.*/
  static void displayAverageRainFall(RainFall year)
  {
    //Display the average monthly rainfall
    System.out.print("the average rainfall per month was " +
                      year.getMonthlyRainFall() + " inches; ");
  }


  /**Method to display the name(s) of the month(s) that receieved the most
  rainfall, as well as the amount of rain receieved during the month(s). It
  utilizes the RainFall class' getMonthlyMostName() to obtain the name(s) of
  month(s) to be displayed, and the RainFall class' getMonthlyMostInches() to
  obtain the greatest amount of rain received during the year. The method
  contains conditional checks to intelligently display the name of the month,
  depending upon how many months need to be displayed.
  @param year The RainFall object that holds the rainfall measurements to be
  used.*/
  static void displayMonthMost(RainFall year)
  {
    //Obtain the names of months to be displayed from the RainFall class
    String[] mostMonths = year.getMonthlyMostName();
    //Obtain the rainfall measurement to be displayed from the RainFall class
    double mostRainFall = year.getMonthlyMostInches();
    //If the array contains only one name, display it
    if (mostMonths.length == 1)
    {
      System.out.print("the month with the most rainfall during the year " +
                        "was " + mostMonths[0]);
    }
    //Otherwise, display the message needed for multiple months
    else
    {
      System.out.print("the months with the most rainfall during the year " +
                        "were ");
      //If there are only two months in the array, display them both
      if (mostMonths.length == 2)
      {
        System.out.print(mostMonths[0] + " and " + mostMonths[1]);
      }
      //Otherwise, iterate through the array and display each element
      else
      {
        for (int i = 0; i < mostMonths.length; i++)
        {
          //If there are more elements to display after the current element,
          //use a comma
          if (mostMonths.length - i > 1)
          {
            System.out.print(mostMonths[i] + ", ");
          }
          //If the current element is the last element, use "and"
          else
          {
            System.out.print("and " + mostMonths[i]);
          }
        }
      }
    }
    //If only one month is displayed, give the rainfall amount
    if (mostMonths.length == 1)
    {
      System.out.print(", with " + mostRainFall + " inches of rain; ");
    }
    //If more than one month is displayed, give the rainfall amount of "each"
    else
    {
      System.out.print(", with " + mostRainFall + " inches of rain each; ");
    }
  }


  /**Method to display the name(s) of the month(s) that receieved the least
  rainfall, as well as the amount of rain receieved during the month(s). It
  utilizes the RainFall class' getMonthlyLeastName() to obtain the name(s) of
  month(s) to be displayed, and the RainFall class' getMonthlyLeastInches() to
  obtain the smallest amount of rain received during the year. The method
  contains conditional checks to intelligently display the name of the month,
  depending upon how many months need to be displayed.
  @param year The RainFall object that holds the rainfall measurements to be
  used.*/
  static void displayMonthLeast(RainFall year)
  {
    //Obtain the names of months to be displayed from the RainFall class
    String[] leastMonths = year.getMonthlyLeastName();
    //Obtain the rainfall measurement to be displayed from the RainFall class
    double leastRainFall = year.getMonthlyLeastInches();
    //If the array contains only one name, display it
    if (leastMonths.length == 1)
    {
      System.out.print("the month with the least rainfall during the year " +
                        "was " + leastMonths[0]);
    }
    //Otherwise, display the message needed for multiple months
    else
    {
      System.out.print("the months with the least rainfall during the year " +
                        "were ");
      //If there are only two months in the array, display them both
      if (leastMonths.length == 2)
      {
        System.out.print(leastMonths[0] + " and " + leastMonths[1]);
      }
      //Otherwise, iterate through the array and display each element
      else
      {
        for (int i = 0; i < leastMonths.length; i++)
        {
          //If there are more elements to display after the current element,
          //use a comma
          if (leastMonths.length - i > 1)
          {
            System.out.print(leastMonths[i] + ", ");
          }
          //If the current element is the last element, use "and"
          else
          {
            System.out.print("and " + leastMonths[i]);
          }
        }
      }
    }
    //If only one month is displayed, give the rainfall amount
    if (leastMonths.length == 1)
    {
      System.out.println(", with " + leastRainFall + " inches of rain.");
    }
    //If more than one month is displayed, give the rainfall amount of "each"
    else
    {
      System.out.println(", with " + leastRainFall + " inches of rain each.");
    }
  }
}
