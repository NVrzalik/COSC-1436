class a2main {

  //Initializing variables to hold gathered survey data
  static double surveySize = 12467;
  static double energyDrinkPercent = 0.14;
  static double citrusFlavorPercent = 0.64;

  //Declaring variables to hold data to be computed
  static long energyDrinkSize;
  static long citrusFlavorSize;


  public static void main(String[] args) {

    //Calculate customers who purchase energy drinks, and then those
    //who prefer citrus falvors. Round the results for readability.
    energyDrinkSize = Math.round(surveySize * energyDrinkPercent);
    citrusFlavorSize = Math.round(energyDrinkSize * citrusFlavorPercent);

    //Print the computed data. Strings are broken into multiple methods to improve code readability.
    System.out.print("Approximately " + energyDrinkSize + " of the customers who ");
    System.out.println("participated in the survey purchase one or more energy drinks per week.");
    System.out.println("Approximately " + citrusFlavorSize + " of the above prefer citrus flavored energy drinks.");

  }


}
