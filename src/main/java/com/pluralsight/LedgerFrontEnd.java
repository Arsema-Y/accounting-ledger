package com.pluralsight;

import java.util.Scanner;

public class LedgerFrontEnd {
    static Scanner input = new Scanner(System.in);

    /*Steps
    1. Plan out page ☑️
    2. Create Home Page Method
    3. Create following methods
    4. Plan out back end page
    4. create backend functions
     */

    public static void main(String[] args) {

        runHome();


    }

  ///H: Home page - show option of what action user wants to take
    private static void runHome(){
        boolean runHome = true;

        while(runHome){
            System.out.println("Welcome to BitBook!\n");
            System.out.println("A trusted and reliable \n Accounting Ledger\n");

            //logging in
            System.out.println("(1) Sign-in  (2) Sign-up ");
            int login = input.nextInt();
            input.nextLine(); //clear buffer

            //prompt email
            System.out.print("Enter your email: ");
            String email = input.nextLine();

            while(!email.contains("@") || !email.contains(".")){
                System.out.println("Invalid email.");
                System.out.print("Please enter a valid email: ");
                email = input.nextLine();
            }

            System.out.println("Enter your name: ");
            String userName = input.nextLine();

            System.out.println("Hello " + userName +",");
            System.out.println("With BitBook, you can   D - Add a Deposit\n" +
                               "                        P - Make a Payment \n" +
                               "                        L - View Ledger \n" +
                               "                        X - Exit BitBook");
            char level2Screen = input.next().toUpperCase().charAt(0);
            switch(level2Screen){
               case 'D' -> ;
               case 'P' -> ;
               case 'L' -> ;
               case 'X' -> runHome = false;
                  if(!runHome){
                      System.out.println("Thank You for using BitBook.");
                      System.out.println("\n\n H - Home");
                      char Home = input.next().toUpperCase().charAt(0);
                      if(Home == 'H'){
                          runHome = true;
                      }
                  }
             }

        }
    }


  ///D: Add Deposit - loop: prompt user for deposit information
     /* + save it to the transactions file
     * + H: Home - run Home method
     * + X: Exit
     */
  private static void runDepositScreen(String userName){

 }
}


  ///P: Make Payments (Debit) - loop: prompt user for debit information
    //  + save it to the transactions file
private static void runPaymentScreen(String userName){


}


   ///L: Ledger - shows options of display method
private static void runLedgerScreen(String userName){


}

      ///A: All - display all entries (newest - oldest)
private static void runAllEnteriesScreen(String userName){


}

      ///D: Deposits - display only deposits into the account (positive values)
         //H: Home - back to Home method
         // + X: Exit
private static void runDepoitsScreen(String userName){


}

     ///P: Payments - display the payments only (negative values)
       //H: Home - back to Home method
      // + X: Exit
private static void runPaymentsScreen(String userName){


}

     ///R: Reports - shows option for display method
private static void runReportsScreen(String userName){


}

          ///1: Month to date - start of current month till present day
private static void runPresentMonthScreen(String userName){


}

         ///2: Previous Month - month before present month (MM-1)
private static void runLastMonthScreen(String userName){


}

         ///3: Year to Date - new year till present day
private static void runPresentYearScreen(String userName){


}

         ///4: Search by Vendor - prompts user for the vendor name
          /*   + runs comparison with given name
          *   + displays matching entries
          */
private static void runSearchScreen(String userName){


}

         ///0: Ledger - back to ledger method

        ///H: Home


      ///H: Home - back to Home method
     //+ X: Exit



  ///x: Exit
    /* closing message
     * H: Home - back to home
     */

