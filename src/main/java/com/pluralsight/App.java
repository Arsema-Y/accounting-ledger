package com.pluralsight;


import java.util.Scanner;


public class App {
    static Scanner input = new Scanner(System.in);
    static String userName;


   /*Steps
   1. Plan out page ☑️
   2. Create Home Page Method ☑️
   3. Create following methods
   4. Plan out back end page ☑️
   4. create backend functions
    */


    public static void main(String[] args) {


        runHome();


    }


    ///O: Welcome + sign in page

    /// H: Home page - show option of what action user wants to take
    private static void runHome() {
        boolean runHome = true;


        while (runHome) {
            System.out.println("Welcome to BitBook!\n");
            System.out.println("A trusted and reliable \n Accounting Ledger\n");


            //logging in
            System.out.println("(1) Sign-in  (2) Sign-up ");
            int login = input.nextInt();
            input.nextLine(); //clear buffer


            //prompt email
            System.out.print("Enter your email: ");
            String email = input.nextLine();


            while (!email.contains("@") || !email.contains(".")) {
                System.out.println("Invalid email.");
                System.out.print("Please enter a valid email: ");
                email = input.nextLine();
            }

            //prompt name
            System.out.print("Enter your name: ");
            userName = input.nextLine();

            //Home: screens choice
            System.out.println("Hello " + userName + ",");
            System.out.println("With BitBook, you can   D - Add a Deposit\n" +
                    "                        P - Make a Payment \n" +
                    "                        L - View Ledger \n" +
                    "                        X - Exit BitBook");
            char level2Screen = input.next().toUpperCase().charAt(0);
            switch (level2Screen) {
                case 'D' -> runDepositScreen();
                case 'P' -> runPaymentScreen();
                case 'L' -> runLedgerScreen();
                case 'X' -> {
                    runHome = false;
                    if (!runHome) {
                        System.out.println("Thank You for using BitBook.");
                    }
                }
            }


        }
    }


    /// D: Add Deposit - loop: prompt user for deposit information
    /* + save it to the transactions file
     * + H: Home - run Home method
     * + X: Exit
     */
    private static void runDepositScreen() {
        boolean deposit = true;
        while (deposit) {
            System.out.println("+ - Add another deposit");
            char addMore = input.next().toUpperCase().charAt(0);
            if (addMore == +) {
                boolean add = true;
                while (add) {
                    //add deposit loop
                }
            }

            System.out.println("H - Home");
            System.out.println("X - Done");
            char level2Screen = input.next().toUpperCase().charAt(0);
            switch (level2Screen) {
                case 'H' -> deposit = false;
                case 'X' -> {
                    deposit = false;
                    if (!deposit) {
                        System.out.println("Thank You for using BitBook.");
                    }
                }
            }
        }
    }


    /// P: Make Payments (Debit) - loop: prompt user for debit information
//  + save it to the transactions file
    private static void runPaymentScreen() {
        System.out.println("test");


    }


    /// L: Ledger - shows options of display method
    private static void runLedgerScreen() {
        System.out.println("test");


    }


    /// A: All - display all entries (newest - oldest)
    private static void runAllEnteriesScreen() {
        System.out.println("test");


    }


    /// D: Deposits - display only deposits into the account (positive values)
//H: Home - back to Home method
// + X: Exit
    private static void runDepoitsScreen() {
        System.out.println("test");


    }


    /// P: Payments - display the payments only (negative values)
//H: Home - back to Home method
// + X: Exit
    private static void runPaymentsScreen() {
        System.out.println("test");


    }


    /// R: Reports - shows option for display method
    private static void runReportsScreen() {
        System.out.println("test");


    }


    /// 1: Month to date - start of current month till present day
    /* 0: Ledger - back to ledger method
     * H: Home
     */
    private static void runPresentMonthScreen() {
        System.out.println("test");


    }


    /// 2: Previous Month - month before present month (MM-1)
    /* 0: Ledger - back to ledger method
     * H: Home
     */
    private static void runLastMonthScreen() {
        System.out.println("test");


    }


    /// 3: Year to Date - new year till present day
    /* 0: Ledger - back to ledger method
     * H: Home
     */
    private static void runPresentYearScreen() {
        System.out.println("test");


    }


    /// 4: Search by Vendor - prompts user for the vendor name
    /*   + runs comparison with given name
     *   + displays matching entries
     * 0: Ledger - back to ledger method
     * H: Home
     */
    private static void runSearchScreen() {
        System.out.println("test");


    }


    ///H: Home - back to Home method
//+ X: Exit


///x: Exit
    /* closing message
     * H: Home - back to home
     */


}

