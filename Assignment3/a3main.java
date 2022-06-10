import java.util.Scanner;

/**This program is designed to calculate the solution(s) to a quadratic
equation in the form of ax^2 + bx + c = 0 by means of the quadratic formula.
The user is to provide the values for the variables a, b, and c via command
line, after which the program will produce the solution(s) for x. In its current
state, the program is only able to accept real numbers in integer/decimal form
as values for the three given variables. The solutions are not simplified, but
calculated and rounded to the greatest precision possible.*/

class a3main
{

  //Method to get input from the user.
  static double[] getInput()
  {
    //Arrays to hold variable names and values
    char[] variables = {'a', 'b', 'c'};
    double[] input = new double[3];
    //Instantiate scanner object
    Scanner keyboard = new Scanner(System.in);

    //Loop requests valid values from user for each variable until obtained.
    for(int i = 0; i < 3; i++)
    {
      while(true)
      {
        System.out.print(variables[i] + " = ");
        try
        {
          input[i] = keyboard.nextDouble();
          break;
        } catch (Exception e)
        {
          System.out.println("Invalid input. Please provide a real number in" +
                              " decimal form.");
          keyboard.nextLine();
        }
      }
    }
    //Output array of variables' values
    return input;
  }



  //Simple method to calculate the solution in the case of a linear equation
  static double linearEquation(double b, double c)
  {
    return (-c)/b;
  }



  //Method to calculate the solution in the case of no discriminant.
  static double noDiscriminant(double a, double b)
  {
    return (-b)/(2*a);
  }



  //Method to calculate both complex solutions in the case of a negative
  //discriminant
  static String[] negDiscriminant(double a, double b, double c)
  {
    double denominator = 2*a;
    double real = -b/denominator;
    double imaginary = Math.sqrt(-((b*b) - (4*a*c))/(denominator*denominator));

    String[] solutions = new String[2];

    solutions[0] = real + " + " + imaginary + "(i)";
    solutions[1] = real + " - " + imaginary + "(i)";;
    //Return array of solutions in text form
    return solutions;
  }



  //Method to calculate both real solutions in the case of a positive
  //discriminant
  static double[] posDiscriminant(double a, double b, double c)
  {
    double denominator = 2*a;
    double lead = (-b)/denominator;
    double radical = Math.sqrt((b*b) - (4*a*c)/(denominator*denominator));
    double x1 = lead + radical;
    double x2 = lead - radical;
    double[] solutions = {x1, x2};
    //Return array of solutions as doubles
    return solutions;
  }



  //Method to display the solution in the case of a linear equation
  static void displayLinear(double x)
  {
    System.out.println("This is a linear equation. x = " + x);
  }


  //Method to display the solution in the case of an equation without a
  //discriminant
  static void displayNoDis(double x)
  {
    System.out.println("This quadratic has no discriminant. x = " + x);
  }


  //Method to display the solution in the case of an equation with a negative
  //discriminant
  static void displayNegDis(String[] solutions)
  {
    System.out.println("This quadratic equation has a negative discriminant. " +
                        "There are two complex solutions for x. These are " +
                        solutions[0] + ", and  " + solutions[1]);
  }


  //Method to display the solution in the case of an equation with a positive
  //discriminant
  static void displayPosDis(double[] solutions)
  {
    System.out.println("This quadratic equation has a positive discriminant. " +
                        "There are two real solutions for x. These are " +
                        solutions[0] + ", and  " + solutions[1]);
  }



  //Main method
  public static void main(String[] args)
  {
    //Description for user and request for input
    System.out.println("This program will solve quadratic equations in the " +
                      "form of ax^2 + bx + c = 0. Please enter real number " +
                      "values in decimal form for variables a, b, and c.");

    //Obtain user input, and store in variables
    double[] input = getInput();
    double a = input[0];
    double b = input[1];
    double c = input[2];
    //Decision tree to determine appropriate methods for calculation and display
    //of results
    if(a == 0) //Linear equation
    {
      double x = linearEquation(b, c);
      displayLinear(x);
    } else if((b*b)-(4*a*c) == 0) //No discriminant
    {
      double x = noDiscriminant(a, b);
      displayNoDis(x);
    } else if((b*b)-(4*a*c) < 0) //Negative discriminant
    {
      String[] solutions = negDiscriminant(a, b, c);
      displayNegDis(solutions);
    } else //Positive discriminant
    {
      double[] solutions = posDiscriminant(a, b, c);
      displayPosDis(solutions);
    }
  }
}
