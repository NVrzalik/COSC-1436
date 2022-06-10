/**This class creates a savings account object. It contains the fields
and methods necessary to provide a basic simulation of a savings
account */

class SavingsAccount
{
  //Holds the account's current annual interest rate.
  private double annualInterestRate;
  //Holds the account's current balance.
  private double balance;
  //Holds a running count of the account's total number of withdrawals.
  private int withdrawCount;
  //Holds a running count of the account's total number of deposits.
  private int depositCount;
  //Holds a running total of the account's earned interest.
  private double totalInterest;


  /**Constructor to instantiate the SavingsAccount object with the
  appropriate values.
  @param startBalance The account's starting balance.
  @param rate The account's annual interest rate in decimal form (not
  as a percentage).*/
  public SavingsAccount(double startBalance, double rate)
                        throws Exception
  {
    //If startBalance or rate are negative, throw an exception
    if (startBalance < 0 || rate < 0)
    {
      throw new Exception();
    }
    //If the starting balance contains fractional cents, throw
    //an exception.
    else if (!checkCents(startBalance))
    {
      throw new Exception();
    }
    //Set initial values
    balance = startBalance;
    annualInterestRate = rate;
    withdrawCount = 0;
    depositCount = 0;
    totalInterest = 0;
  }

  /**Method to make a withdrawal. The withdrawal amount must be
  positive, and cannot result in a negative account balance. The
  method will update the account balance and the withdraw count.
  @param amount The withdrawal amount.*/
  public void withdraw(double amount) throws Exception
  {
    //If the amount withdrawn is negative, throw an exception.
    if (amount < 0)
    {
      throw new Exception();
    }
    //If the withdrawal results in a negative balance, throw an
    //exception.
    if (balance - amount < 0)
    {
      throw new Exception();
    }
    //If the amount contains fractions of cents, throw an
    //exception.
    if (!checkCents(amount))
    {
      throw new Exception();
    }
    //If the amount withdrawn is zero, do nothing. Otherwise, update
    //the balance and withdraw count.
    if (amount != 0)
    {
      balance -= amount;
      withdrawCount++;
    }

  }

  /**Method to make a deposit. The deposit amount must be
  positive. The method will update the account balance and the
  deposit count.
  @param amount The deposit amount.*/
  public void deposit(double amount) throws Exception
  {
    //If the amount deposited is negative, throw an exception.
    if (amount < 0)
    {
      throw new Exception();
    }

    if (!checkCents(amount))
    {
      throw new Exception();
    }
    //If the amount deposited is zero, do nothing. Otherwise, update
    //the balance and deposit count.
    if (amount != 0)
    {
      balance += amount;
      depositCount++;
    }
  }

  /**Method to calculate and add the monthly interest; it updates the
  account balance and the interest total.*/
  public void addMonthlyInterest()
  {
    //Initialize double variable with the current month's
    //interest.
    double monthlyInterest = balance * (annualInterestRate / 12);
    //Round the interest amount to the nearest cent.
    monthlyInterest *= 100;
    monthlyInterest = Math.round(monthlyInterest);
    monthlyInterest /= 100;
    //Update the interest and balance totals.
    totalInterest += monthlyInterest;
    balance += monthlyInterest;
  }

  /**Method to set a new annual interest rate for the account. The
  rate must be non-negative.
  @param rate The new annual interest rate.*/
  public void changeInterestRate(double rate) throws Exception
  {
    //If the rate is negative, throw an Exception
    if (rate < 0)
    {
      throw new Exception();
    }
    //Set the rate.
    annualInterestRate = rate;
  }

  /**Method to return the current withdrawal count.
  @return The withdrawal count.*/
  public int getWithdrawCount()
  {
    return withdrawCount;
  }

  /**Method to return the current deposit count.
  @return The deposit count.*/
  public int getDepositCount()
  {
    return depositCount;
  }

  /**Method to return the current account balance.
  @return The account balance.*/
  public double getBalance()
  {
    return balance;
  }

  /**Method to return the current amount of the account's earned
  interest.
  @return The amount of earned interest.*/
  public double getTotalInterest()
  {
    return totalInterest;
  }

  /**Method to check that a monetary value contains no fractional
  cents (for example: $1.001).
  @param amount The monetary value to be checked.
  @return Boolean flag to indicate whether the value contains
  fractional cents or not. A value of "true" means it does not,
  while a value of "false" means that it does.
  */public static boolean checkCents(double amount)
  {
    //Round the amount to the 100ths place, and assign it to a
    //variable.
    double check = amount * 100;
    check = Math.round(check);
    check /= 100;
    //If the rounded amount is the same as the original amount,
    //return true.
    if (check == amount)
    {
      return true;
    }
    //If not, return false.
    else
    {
      return false;
    }
  }
}
