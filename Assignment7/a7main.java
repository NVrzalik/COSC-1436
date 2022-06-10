//Imported for the Scanner class
import java.util.Scanner;

/**This class serves as an interface with the SavingsAccount
class, and is designed to simulate the tracking of the
activity of a bank account. It prompts the user to provide the
annual interest rate of the account, the starting balance,
and the number of months that are to be tracked. The user is
then asked to provide the amount deposited and withdrawn
for each month. When finished, the program will display the
final balance of the account, the total number of deposits
withdrawals, and the total amount of interest earned
(compounded monthly).*/

class a7main
{
  //Declare SavingsAccount object for use in multiple methods.
  static SavingsAccount account;

  /**The main method.*/
  public static void main(String[] args) throws Exception
  {
    //Prompt user for annual interest rate and store in variable.
    double annualInterestRate = getInterestRate();
    //Prompt user for starting balance and store in variable.
    double startingBalance = getStartingBalance();
    //Prompt user for the number of months to be tracked.
    int months = getMonths();
    //Instantiate SavingsAccount object with the starting
    //balance and interest rate.
    account = new SavingsAccount(startingBalance, annualInterestRate);
    //Perform the necessary calculations for each month.
    calculateLoop(months);
    //Display the results of the calculations and tracking
    //for the user, formatting the double values as monetary
    //values.
    System.out.printf("The final balance of the account is $%,.2f; " +
                        "there were " + account.getDepositCount() +
                        " deposits, and " + account.getWithdrawCount() +
                        " withdrawals; $%,.2f in interest was earned.\n",
                        account.getBalance(),
                        account.getTotalInterest());
  }

  /**Method to obtain the annual interest rate from the
  user. The user is prompted until a valid, positive
  rate has been submitted.
  @return The annual interest rate for the account.*/
  static double getInterestRate()
  {
    //Declare variable to hold the rate.
    double rate;
    //Prompt user until valid input has been received.
    do
    {
      System.out.print("What is the annual interest rate for the " +
                      "savings account (as a percentage)? ");
      //Calling method to obtain a double from the user, then
      //change format from percentage to decimal by division.
      rate = getInput(true) / 100;

      if (rate > 0)
      {
        return rate;
      }
      else
      {
        System.out.println("Please enter a valid interest rate. This " +
                            "must be a positive number in decimal " +
                            "form. Please do not include a percent " +
                            "sign.");
      }
    } while (true);
  }

  /**Method to obtain the starting account balance from the
  user. The user is prompted until a valid, positive balance
  is received.
  @return The starting balance for the account.*/
  static double getStartingBalance()
  {
    //Declare variable to hold the starting balance.
    double startingBalance;
    //Prompt user until valid input has been submitted.
    do
    {
      System.out.print("What is the starting balance for the savings " +
                      "account? $");

      //Calling method to obtain a double from the user.
      startingBalance = getInput(true);
      //If the starting balance contains fractional cents, prompt
      //the user again.
      if (!SavingsAccount.checkCents(startingBalance))
      {
        System.out.println("Please enter a valid starting balance" +
                            "; fractional cents are not permitted.");
      }
      //If the starting balance is greater than 0, return the
      //amount
      else if (startingBalance > 0)
      {
        return startingBalance;
      }
      //Otherwise, prompt the user again.
      else
      {
        System.out.println("Please enter a valid starting balance. " +
                            "This must be a positive number in " +
                            "decimal form.");
      }
    } while (true);
  }

  /**Method to obtain from the user the number of months to be
  tracked. The user is prompted until a valid, non-negative integer
  value has been submitted.
  @return The number of months to be tracked for the account.*/
  static int getMonths()
  {
    //Declare variable to hold the number of months.
    int months;
    //Prompt the user until valid input has been submitted.
    do
    {
      System.out.print("How many months have passed since the " +
                      "account was established? ");

      //Calling method to obtain an int from the user.
      months = (int)getInput(false);

      if (months >= 0)
      {
        return months;
      }
      else
      {
        System.out.println("Please enter the number of months that " +
                            "have passed. This must be a non-" +
                            "negative integer.");
      }
    } while (true);
  }

  /**Method to obtain valid numeric input from the user. It
  can obtain either an int or a double. Invalid input is replaced
  with a value of -1.
  @param type A boolean flag to determine the data type needed
  from the user; a value of "true" will request a double, while
  a value of "false" will request an int.
  @return The valid input received from the user. If the input
  was invalid, the return value is -1.*/
  static double getInput(boolean type)
  {
    //Instantiate Scanner object to receive input from user.
    Scanner keyboard = new Scanner(System.in);
    //Initialize variable that will hold the user's input.
    double input = 0;

      try
      {
        //If the flag is set to true, obtain a double
        if (type)
        {
          input = Double.parseDouble(keyboard.nextLine());
        }
        //If the flag is set to false, obtain an int
        else if (!type)
        {
          input = Integer.parseInt(keyboard.nextLine());
        }
      }
      //If input is invalid, set return value to -1.
      catch (Exception e)
      {
        input = -1;
      }

      return input;
  }

  /**Method to obtain the amount deposited into the account for the
  current month. The user is prompted for a valid, non-negative value
  until received.
  @param month The number of the current month being tracked.
  @return The amount deposited into the account for the current month.
  The value could be 0.*/
  static double getMonthlyDeposit(int month)
  {
    //Declare variable to hold the user's input.
    double deposit;
    //Prompt user for valid input until received.
    do
    {
      System.out.print("What was the amount deposited into the " +
                      "account during month " + month + "? $");

      //Calling method to obtain a double from the user.
      deposit = getInput(true);
      //If the deposit contains no fractional cents, proceed to next
      //condition.
      if (!SavingsAccount.checkCents(deposit))
      {
        System.out.println("Please enter a valid monetary value; " +
                            "fractional cents are prohibited.");
      }
      //If the deposit is greater than or equal to 0, return
      //the amount.
      else if (deposit >= 0)
      {
        return deposit;
      }
      //Otherwise, prompt user again.
      else
      {
        System.out.println("Please enter the deposited amount for the" +
                            " month. This amount must be a non-" +
                            "negative number in decimal form.");
      }
    } while (true);
  }

  /**Method to obtain the amount withdrawn from the account for the
  month. The user will be prompted until valid, non-negative input
  is submitted. If the amount submitted results in a negative account
  balance, the user will be notified and prompted again for valid
  input.
  @param month The number of the current month being tracked.
  @return The amount withdrawn from the account during the current
  month.*/
  static double getMonthlyWithdraw(int month)
  {
    //Declare variable to hold user input.
    double withdrawal;
    //Prompt the user for valid input until received.
    do
    {
      System.out.print("What was the amount withdrawn from the " +
                      "account during month " + month + "? $");

      //Calling method to obtain a double from the user.
      withdrawal = getInput(true);
      //If the amount submitted results in a negative balance, notify
      //the user and prompt again.
      if (account.getBalance() - withdrawal < 0)
      {
        System.out.println("The withdrawal amount provided " +
                            "results in a negative balance. " +
                            "Please provide a valid withdrawal " +
                            "amount.");
      }
      //If the withdrawal contains no fractional cents, proceed to next
      //condition.
      else if (!SavingsAccount.checkCents(withdrawal))
      {
        System.out.println("Please enter a valid monetary value; " +
                            "fractional cents are prohibited.");
      }
      //If the withdrawal is greater than or equal to 0, return
      //amount.
      else if (withdrawal >= 0)
      {
        return withdrawal;
      }
      //Otherwise, prompt the user again.
      else
      {
        System.out.println("Please enter the withdrawn amount for the" +
                            " month. This amount must be a non-" +
                            "negative number in decimal form.");
      }
    } while (true);
  }

  /**Method to iterate through the months being tracked, obtaining
  the necessary information for each and storing it in the
  SavingsAccount object.
  @param months The number of months being tracked. These will be
  iterated through.*/
  static void calculateLoop(int months) throws Exception
  {
    //For loop to iterate through months
    for (int i = 1; i <= months; i++)
    {
      //Obtain deposit amount for the month from the user.
      double deposit = getMonthlyDeposit(i);
      //Deposit the amount in the SavingsAccount object.
      account.deposit(deposit);
      //Obtain withdrawal amount for the month from the user.
      double withdrawal = getMonthlyWithdraw(i);
      //Withdraw the amount from the SavingsAccount object.
      account.withdraw(withdrawal);
      //Apply monthly interest to the account.
      account.addMonthlyInterest();
    }
  }

}
