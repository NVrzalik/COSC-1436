import java.util.Scanner;
import java.io.*;

/**This class will write the contents of one text file to another, capitalizing
all alphabetic characters in the process. The user is prompted for the names of
the files to be read and written to, and the program will then copy and
capitalize the contents until nothing remains to be read in the readfile.*/

class a5main
{
  //Instantiate Scanner object for use in multiple methods
  static Scanner keyboard = new Scanner(System.in);

  //Main
  public static void main(String[] args) throws IOException
  {
    //Display initial message for user
    System.out.println("This program will write the contents of one text " +
                        "file to another, capitalizing all alphabetic " +
                        "characters. Please provide the name of the input " +
                        "file whose contents are to be copied, as well as " +
                        "the name of the file where the data is to be " +
                        "written.");

    //Obtain name of the input file from the user, then open it
    Scanner inputFile = new Scanner(getInputFileName());
    //Obtain name of the output file from the user, then open it
    PrintWriter outputFile = new PrintWriter(getOutputFileName());
    //Copy and capitalize contents from input file
    transfer(inputFile, outputFile);

  }



  /*Method to obtain the name of the input file from the user. Returns a
  File object to the main.*/
  static File getInputFileName()
  {

    do
    {
      //Prompt user for file name
      System.out.print("What is the name of the input file?  ");
      //Create File object with given name
      String name = keyboard.nextLine();
      File inputFile = new File(name);

      //Verify the file exists
      if (!inputFile.exists())
      {
        System.out.println("That file path does not exist. Please enter a " +
                            "different filename.");
      } else
      {
        return inputFile;
      }
    } while (true);

  }



  /*Method to obtain the name of the output file from the user. Returns a
  File object to the main.*/
  static File getOutputFileName()
  {

    do
    {
      //Prompt user for file name
      System.out.print("What is the name of the file that is to be written " +
                        "to?  ");
      //Create File object with given name
      String name = keyboard.nextLine();
      File outputFile = new File(name);

      //Verify that the user has entered a filename
      if (name.length() < 1)
      {
        //If not, prompt user to provide one
        System.out.println("Please enter a valid filename.");
      }
      /*Verify the file doesn't already exist. If it does, provide the user
      the chance to choose to overwrite it or to provide a different file
      name.*/
      else if (outputFile.exists())
      {
        System.out.print("This file already exists. Would you like to " +
                          "overwrite it? (Yes or No)  ");
        String overwrite = new String(keyboard.nextLine());

        if (overwrite.equalsIgnoreCase("yes"))
        {
          return outputFile;
        }

      }
      //Otherwise, return file to main
      else
      {
        return outputFile;
      }
    } while (true);

  }



  /*Method to copy and capitalize the contents of the input file, writing them
  to the output file.*/
  static void transfer(Scanner inputFile, PrintWriter outputFile) throws IOException
  {
    //Verify that the input file has content to copy
    if (!inputFile.hasNext())
    {
      //If not, notify the user and close the file
      System.out.println("The selected input file could not be copied.");
      outputFile.close();
    } else
    {
      //If it does, copy and capitalize the contents until every line is read
      while (inputFile.hasNext())
      {
        String line = inputFile.nextLine();
        outputFile.println(line.toUpperCase());
      }
      //Close the file
      outputFile.close();
      //Notify the user that the program has finished
      System.out.println("The file contents have been copied.");
    }
  }

}
