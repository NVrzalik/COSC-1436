class a1main {

    //Declaring variables to hold personal info
    static String name = "Nicholas Vrzalik";
    static String address = "19424 Ballard Rd. Elmendorf, TX 78112";
    static String phone = "210-419-7989";
    static String major = "Computer Science";

    //Creating array to hold list of personal info
    static String[] info = {name, address, phone, major};

    //Function to display contents of array
    public static void main(String[] args) {

      //For-loop iterating through array
      for(int i=0; i<info.length; i++){
        System.out.println(info[i]);
      }

    }
}
