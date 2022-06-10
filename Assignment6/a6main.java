import java.util.Scanner;

/**This class converts a given distance in meters to either kilometers, inches,
or feet, and displays the result to the user. The program prompts the user to
enter a distance, after which a menu of options will be provided, allowing the
user to convert the distance into their prefered unit of measure, or to quit
the program.*/

class a6main
{
  //Instantiate Scanner object for use in multiple methods.
  static Scanner keyboard = new Scanner(System.in);


  //Main
  public static void main(String[] args)
  {
    //Obtain distance in meters from user
    double meters = getDistance();
    //Variable that will hold the user's menu selection
    int selection;
    //Loop will continue until the user quits the program
    do
    {
      //Display the menu
      menu();

      try
      {
        //Obtain user's selection
        selection = keyboard.nextInt();
      }
      catch (Exception e)
      {
        //If invalid input is provided, user is prompted again
        System.out.println("To select an option, please enter 1, 2, 3, or 4.\n");
        //Consume invalid response
        keyboard.nextLine();
        //Repeat loop
        continue;
      }
      //Response to user's valid selection
      if (selection == 1)
      {
        showKilometers(meters);
      }
      else if (selection == 2)
      {
        showInches(meters);
      }
      else if (selection == 3)
      {
        showFeet(meters);
      }
      else if (selection == 4)
      {
        System.out.println("Bye!");
        break;
      }
      //If the user enters an invalid integer, prompt again
      else
      {
        System.out.println("To select an option, please enter 1, 2, 3, or 4.\n");
      }

    } while (true);
  }


  /**Method to obtain the distance in meters provided by the user.
  @return The distance in meters as a double.*/
  static double getDistance()
  {
    //Variable to hold the distance
    double meters;
    //User is prompted until valid input is provided
    do
    {
      System.out.print("Enter a distance in meters: ");

      try
      {
        //Obtain the distance in meters
        meters = keyboard.nextDouble();
      }
      catch (Exception e)
      {
        //If invalid input is provided, the user is prompted again
        System.out.println("Please enter a valid numeric value.");
        //Consume the invalid response
        keyboard.nextLine();
        //Repeat the loop
        continue;
      }
      //If a negative distance is given, prompt the user again and repeat the loop
      if (meters < 0)
      {
        System.out.println("Please enter a positive numeric value.");
        continue;
      }
      //Otherwise, return the distance
      return meters;

    } while (true);

  }


  /**Method to display the menu of options for the user.*/
  static void menu()
  {
    System.out.print("1. Convert to kilometers\n2. Convert to inches\n" +
                      "3. Convert to feet\n4. Quit the program\n\n" +
                      "Enter your choice: ");
  }


  /**Method to convert meters to kilometers, then display the result.
  @param meters The distance in meters provided by the user.*/
  static void showKilometers(double meters)
  {
    double kilometers = meters * .001;
    System.out.println(meters + " meters is " + kilometers + " kilometers.\n");
  }


  /**Method to convert meters to inches, then display the result.
  @param meters The distance in meters provided by the user.*/
  static void showInches(double meters)
  {
    double inches = meters * 39.37;
    System.out.println(meters + " meters is " + inches + " inches.\n");
  }


  /**Method to convert meters to feet, then display the result.
  @param meters The distance in meters provided by the user.*/
  static void showFeet(double meters)
  {
    double feet = meters * 3.281;
    System.out.println(meters + " meters is " + feet + " feet.\n");
  }

}
