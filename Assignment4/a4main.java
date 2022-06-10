import java.util.Scanner;

/**This class will calculate the average monthly rainfall over a period of
years specified by the user. The user will be prompted to provide the amount
 of rainfall in inches per month, which the program will use to calculate the
 average rainfall. The results of this calculation will be displayed for the
 user. */

class a4main
{

  //Instantiate Scanner object
  static Scanner keyboard = new Scanner(System.in);
  //Declare static variables for use in miultiple methods
  static int years;
  static int months;
  static double totalRainfall = 0;
  static double averageRainfall;


  //Method to obtain user input for the number of years to be included in the
  //calculation
  static void inputYears()
  {
    //Declare boolean flag
    boolean error;
    //Prompt user for input
    System.out.println("How many years of rainfall are to be considered in " +
                        "the average?");

    //Obtain and validate input
    while(true)
    {
      //Reset flag
      error = false;

      System.out.print("Years: ");
      try
      {
        years = keyboard.nextInt();
        if(years < 1)
        {
          error = true;
        }
      } catch(Exception e)
      {
        error = true;
      }
      finally
      {
        if(error == true)
        {
          System.out.println("Invalid input. Please provide a positive real " +
                                "integer.");
          //Clear input buffer for next attempt to obtain valid user input
          keyboard.nextLine();
        } else
        {
          break;
        }
      }
    }
  }


  //Method to obtain user input for the amount of rainfall per month
  static void inputMonths()
  {
    //Declare array of names of the months of the year
    String[] month = {"January", "February", "March", "April", "May", "June",
                        "July", "August", "September", "October", "November",
                        "December"};
    //Temporary variable to hold user input during validation
    double input = -1;
    //Boolean flag
    boolean error;

    //Iterate through years
    for(int i = 0; i < years; i++)
    {
      //Iterate through each month of the current year i
      for(int j = 0; j < 12; j++)
      {
        //Prompt user for input
        System.out.println("How many inches of rainfall were there in " +
                            month[j] + " of year " + (i+1) + "?");
        //Obtain and validate input
        while(true)
        {
          //Reset flag
          error = false;
          System.out.print("Rainfall: ");

          try
          {
            input = keyboard.nextDouble();

            if(input < 0)
            {
              error = true;
            }
          } catch(Exception e)
          {
            error = true;
          }
          finally
          {
            if(error == true)
            {
              System.out.println("Invalid input. Please provide a non-negative"
                                  + " real number.");
              //Clear input buffer for next attempt to obtain valid user input
              keyboard.nextLine();
            } else
            {
              //Add the rainfall of the current month j to the total rainfall
              totalRainfall += input;
              break;
            }
          }
        }
      }
    }
  }


  //Simple method to calculate the average monthly rainfall
  static void calculate()
  {
    months = years * 12;
    averageRainfall = totalRainfall/months;
  }


  public static void main(String[] args)
  {
    inputYears();
    inputMonths();
    calculate();

    System.out.println("Over a period of " + months + " months, there was " +
                        "a total of " + totalRainfall + " inches of rainfall." +
                        " The average monthly rainfall was " + averageRainfall +
                        " inches.");
  }
}
