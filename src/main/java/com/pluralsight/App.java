package com.pluralsight;

//all imports
import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class App {
    ///Utilities
    //function for interacting with file
    static BufferedWriter writeToFile;
    static BufferedReader readFile;

    static ArrayList<com.pluralsight.Transaction> transaction = new ArrayList<>();
    static Scanner input = new Scanner(System.in);
    //to call on user
    static String userName;
    static boolean runHome = true;

///Task-list
   /*Steps
   1. Plan out page ☑️
   2. Create Home Page Method ☑️
   3. Create following methods ☑️
   4. Plan out back end page ☑️
   5. create backend functions ☑️
   6. Create methods' functions
     - parse (learn)☑️
     - date/time/zone☑️
     -fileReader/writer☑️(BroCode)
     (created flow chart) ☑️
       1) add elements into ArrayList ☑️
       2) write ArrayList into file ☑️
        - Ask AI for 1-time option ☑️

      1) File loader☑️
        - learn ☑️(very cool)
      2) Sign In page☑️
      3) Home page☑️
        4) Deposit☑️
        5) Payment☑️
        6) Ledger☑️
          7) All Entries☑️
          8) Deposits☑️
          9) Payments☑️
          10) Reports (learn) ☑️
             11) Current Month☑️ (
             12) Previous Month☑️
             13) Current Year☑️
             14) Search☑️

       15) exceptions
       16) edit output ☑️
          - use repeat instead of lines (AI can help for numbers)☑️
       17) clear buffer ☑️
       17) clean comments
          - checkk AI version

       18) readMe ☑️
    */

    ///main
    public static void main(String[] args) {


        loadTransactions();
        runSignInScreen();
        runHomeScreen();


    }


    /// back-end: Read file once =================================================================
//     load data to ArrayList
//    (will save new data to og file later)
    private static void loadTransactions() {
        try {
            //set-up file reader
            readFile = new BufferedReader(new FileReader("transactions.csv"));
            readFile.readLine(); //read Header

            String line;
            while ((line = readFile.readLine()) != null) {
                // Parser: Text Line -> String Array _i don't like it, use minimal_
                String[] parts = line.split("\\|");

                // Parser translation: csv String ->  Object for Transaction
                com.pluralsight.Transaction t = new com.pluralsight.Transaction(
                        LocalDate.parse(parts[0]),
                        LocalTime.parse(parts[1]),
                        parts[2],
                        parts[3],
                        Double.parseDouble(parts[4])
                );

                // Adding the object into ArrayList
                transaction.add(t);

            } //always remember
            readFile.close();

        } catch (IOException e) {
            System.out.println("---- No transactions.csv found.----");
        }
    }

    /// O: Welcome + sign in page ================================================================
    private static void runSignInScreen() {
        boolean runSignIn = true;

        while (runSignIn) {
            System.out.println("\n" + "=".repeat(30) + "--- BitBOOK ---" + "=".repeat(30) + "\n");
            System.out.println(" ".repeat(27) + "Welcome to BitBOOK!");
            System.out.println(" ".repeat(22) + "A trusted and reliable Ledger\n");
            System.out.println(" ".repeat(33) + "❖  ❖  ❖\n");
            //logging-in menu
            System.out.println(" ".repeat(26) + "【 1 】    ✦    【 2 】");
            System.out.println(" ".repeat(25) + "Sign-in            Sign-up \n");
            System.out.print(" ".repeat(29) + "ㅡ>     ");
            int login = input.nextInt();
            input.nextLine(); //clear buffer

            try {
                //email input
                System.out.println(" ".repeat(29) + "Enter your email.");
                System.out.print(" ".repeat(29) + "ㅡ>  ");
                String email = input.nextLine().trim();
                //ensure email is valid
                while (!email.contains("@") || !email.contains(".") || email.length() < 10) {
                    System.out.println(" ".repeat(30) + "Invalid email.");
                    System.out.print(" ".repeat(29) + "ㅡ>  ");
                    email = input.nextLine();
                }
            } catch (InputMismatchException e) {
                System.out.println(" ".repeat(30) + "Invalid input.");
                throw new RuntimeException(e);
            }
            //name to call on the user
            System.out.println(" ".repeat(29) + "Enter your name.");
            System.out.print(" ".repeat(29) + "ㅡ>  ");
            userName = input.nextLine();
            //close sign-in page
            if (userName != null) {
                runSignIn = false;
            }
        }
    }

    /// H: Home page =============================================================================
    private static void runHomeScreen() {
        while (runHome) { //header
            System.out.println("\n" + "=".repeat(30) + "--- HOME ---" + "=".repeat(30) + "\n");
            System.out.println(" ".repeat(30) + "Hello " + userName + ",\n");
            //Home Menu
            System.out.println(" ".repeat(25) + "--- BitBOOK services---\n");
            System.out.println(" ".repeat(27) + "【 D 】- Add Deposit"); //positive input
            System.out.println(" ".repeat(27) + "【 P 】- Add Payment"); //negative input
            System.out.println(" ".repeat(27) + "【 L 】- View Ledger"); //reports
            System.out.println(" ".repeat(25) + "-".repeat(23));
            System.out.println(" ".repeat(33) + "【 X 】"); //exit app
            System.out.println(" ".repeat(35) + "EXIT\n");
            System.out.print(" ".repeat(29) + "ㅡ>    ");
            // scan char
            char level2Screen = input.next().toUpperCase().charAt(0); //1st index only
            input.nextLine(); //clear buffer ☑️
            //remote control
            switch (level2Screen) {
                case 'D' -> runDepositScreen();
                case 'P' -> runPaymentScreen();
                case 'L' -> runLedgerScreen();
                case 'X' -> {
                    runHome = false;
                    exitScreen();
                } //learn (very cool)
                default -> System.out.println(" ".repeat(25) + "-----Invalid Input-----");            }
        }
    }

         /// D: Add Deposit =======================================================================
            private static void runDepositScreen() {
        //control screen
        boolean deposit = true;
        //control input
        boolean entryCompleted = false;

        while (deposit) { //header
            System.out.println("\n" + "=".repeat(28) + "--- ADD DEPOSIT ---" + "=".repeat(28) + "\n");
            while (!entryCompleted) {
                LocalDate date = LocalDate.now();
                LocalTime time = LocalTime.now(); //formatted (no more nanoseconds!

                System.out.println(" ".repeat(28) + "Enter Description.");
                System.out.print(" ".repeat(29) + "ㅡ>  ");
                String description = input.nextLine();

                System.out.println(" ".repeat(28) + "Enter the Vendor.");
                System.out.print(" ".repeat(29) + "ㅡ>  ");
                String vendor = input.nextLine();

                System.out.println(" ".repeat(28) + "Enter the amount.");
                System.out.print(" ".repeat(29) + "ㅡ>  ");
                double amount = input.nextDouble();
                input.nextLine(); //clear buffer☑️

                //creat object for new deposit
                Transaction newEntry = new Transaction(date, time, description, vendor, amount);
                transaction.add(newEntry);

                //confirmation-output control
                boolean confirmed = false;
                while (!confirmed) { //output new depo
                    System.out.println("\n" + " ".repeat(22) + "-------Confirm Deposit-------\n");
                    System.out.printf(" ".repeat(25) + "Amount:      【 $%,.2f 】\n", newEntry.getAmount());
                    System.out.printf(" ".repeat(25) + "Vendor:      【 %s 】\n", newEntry.getVendor());
                    System.out.printf(" ".repeat(25) + "Description: 【 %s 】\n", newEntry.getDescription());
                    //confirmation menu
                    System.out.println("\n" + " ".repeat(26) + "【 Y 】     ✦     【 N 】");
                    System.out.println(" ".repeat(26) + "  Yes               No\n");
                    System.out.print(" ".repeat(29) + "ㅡ>    ");
                    char confirm = input.next().toUpperCase().charAt(0);
                    input.nextLine(); //clear buffer☑️
                    //control switch! bestie^^
                    switch (confirm) {
                        case 'Y' -> {
                            confirmed = true;//close confirmation      menu: add-more-depo  | save
                            System.out.println("\n" + " ".repeat(26) + "【 + 】     ✦     【 D 】");
                            System.out.println(" ".repeat(26) + "Add-More           Done");
                            System.out.print(" ".repeat(29) + "ㅡ>    ");

                            char saveChoice = input.next().toUpperCase().charAt(0);
                            input.nextLine(); //clear buffer☑️
                            if (saveChoice == 'D') {
                                entryCompleted = true; //close confirmation
                                //save once
                                saveToFile(newEntry, "DEPOSIT"); //display "deposit saved"
                            }
                        }
                        case 'N' -> {
                            confirmed = true; //close confirmation
                            transaction.remove(transaction.size() - 1);
                            entryCompleted = false; //repeat depo entry
                        }
                    }
                }
            }
            //back Home/Exit  menu
            showNavigationFooter();
            char exitMenu = input.next().toUpperCase().charAt(0);
            input.nextLine(); //clear buffer☑️

            switch (exitMenu) {
                case 'H' -> deposit = false; //close depo screen
                case 'x' -> exitScreen(); //display exit screen
            }
        }
    }

         /// P: Make Payments ======================================================================
            private static void runPaymentScreen() {
        boolean payment = true;
        boolean entryCompleted = false;

        while (payment) {
            System.out.println("\n" + "=".repeat(28) + "--- ADD PAYMENT ---" + "=".repeat(28) + "\n");
            while (!entryCompleted) {
                LocalDate date = LocalDate.now();
                LocalTime time = LocalTime.now();

                System.out.println(" ".repeat(28) + "Enter Description.");
                System.out.print(" ".repeat(29) + "ㅡ>  ");
                String description = input.nextLine();

                System.out.println(" ".repeat(28) + "Enter the Vendor.");
                System.out.print(" ".repeat(29) + "ㅡ>  ");
                String vendor = input.nextLine();

                System.out.println(" ".repeat(28) + "Enter the amount.");
                System.out.print(" ".repeat(29) + "ㅡ>  ");
                double amount = input.nextDouble();
                input.nextLine();

                double negativeAmount = -Math.abs(amount);
                Transaction newEntry = new Transaction(date, time, description, vendor, negativeAmount);
                transaction.add(newEntry);

                boolean confirmed = false;
                while (!confirmed) {
                    System.out.println("\n" + " ".repeat(22) + "-------Confirm Deposit-------\n");
                    System.out.printf(" ".repeat(25) + "Amount:      【 $%,.2f 】\n", newEntry.getAmount());
                    System.out.printf(" ".repeat(25) + "Vendor:      【 %s 】\n", newEntry.getVendor());
                    System.out.printf(" ".repeat(25) + "Description: 【 %s 】\n", newEntry.getDescription());

                    System.out.println("\n" + " ".repeat(26) + "【 Y 】     ✦     【 N 】");
                    System.out.println(" ".repeat(26) + "  Yes               No\n");
                    System.out.print(" ".repeat(29) + "ㅡ>    ");
                    char confirm = input.next().toUpperCase().charAt(0);
                    input.nextLine(); //crear buffer
                    switch (confirm) {
                        case 'Y' -> {
                            confirmed = true;
                            System.out.println("\n" + " ".repeat(26) + "【 + 】     ✦     【 D 】");
                            System.out.println(" ".repeat(25) + "Add-More         Done");
                            System.out.print(" ".repeat(29) + "ㅡ>    ");

                            char saveChoice = input.next().toUpperCase().charAt(0);
                            input.nextLine(); //clear buffer
                            if (saveChoice == 'D') {
                                entryCompleted = true;
                                saveToFile(newEntry, "PAYMENT"); //display 'payment saved'
                            }
                        }
                        case 'N' -> {
                            confirmed = true;
                            transaction.remove(transaction.size() - 1);
                            entryCompleted = false;
                        }
                    }
                }
            }
            showNavigationFooter();
            char exitMenu = input.next().toUpperCase().charAt(0);
            input.nextLine();
            switch(exitMenu){
                case 'H'-> payment = false;
                case 'x' -> exitScreen();
            }

        }
    }

         /// L: Ledger Menu ========================================================================
            private static void runLedgerScreen() {
        boolean ledger = true;
        while (ledger) { //ledger header
            System.out.println("\n" + "=".repeat(28) + "--- LEDGER MENU ---" + "=".repeat(28));
            //ledger menu
            System.out.println("\n" + " ".repeat(26) + "【 A 】- All Entries"); // +/-
            System.out.println(" ".repeat(26) + "【 D 】- All Deposits"); // +
            System.out.println(" ".repeat(26) + "【 P 】- All Payments"); // -
            System.out.println(" ".repeat(26) + "【 R 】- Reports"); // perod of time + search
            System.out.println(" ".repeat(25) + "-".repeat(23));
            System.out.println(" ".repeat(26) + "【 H 】     ✦     【 X 】"); //easier than navigation bar
            System.out.println(" ".repeat(26) + "Home            EXIT\n");
            System.out.print(" ".repeat(29) + "ㅡ>    ");
            char ledgerMenu = input.next().toUpperCase().charAt(0);
            input.nextLine(); //clear buffer☑️

            //control switch
            switch (ledgerMenu) {
                case 'A' -> runAllEntriesScreen();
                case 'D' -> runDepositsScreen();
                case 'P' -> runPaymentsScreen();
                case 'R' -> runReportsScreen();
                case 'H' -> ledger = false;
                case 'X' -> exitScreen();
            }
        }
    }

             /// A: All - display all entries (newest - oldest) ====================================
                private static void runAllEntriesScreen() { //header
        System.out.println("\n    " + "=".repeat(30) + "--- ALL ENTRIES ---" + "=".repeat(30) + "\n");
        // table-header row
        System.out.printf("    %-12s | %-8s | %-20s | %-20s | %-10s\n",
                "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
        System.out.println("    " + "-".repeat(85)+ "\n");
        //iterate backwards
        for (int i = transaction.size() - 1; i >= 0; i--) {
            Transaction t = transaction.get(i);
            //format output
            System.out.printf("    %-12s | %-8s | %-20s | %-20s 【 $%,-10.2f 】\n",
                    t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
            System.out.println("    " + "—".repeat(85));
        }
        // page end marker
        System.out.println("\n" + "=".repeat(40) + "---E-N-D---" + "=".repeat(40) + "\n");
        // manual navigation  bar (menu)
        System.out.println(" ".repeat(31) + "【 L 】      ✦      【 H 】      ✦     【 X 】");
        System.out.println(" ".repeat(26) + "Ledger Menu         Home            EXIT\n");
        System.out.print(" ".repeat(29) + "ㅡ>    ");
        char entriesMenu = input.next().toUpperCase().charAt(0);
        input.nextLine(); //clear buffer☑️
        // contron switch 🩶
        switch (entriesMenu) {
            case 'L' -> runLedgerScreen();
            case 'H' -> runHomeScreen();
            case 'X' -> exitScreen();
        }
    }

             /// D: Deposits - display only deposits ===============================================
                 private static void runDepositsScreen() { //screen header
        System.out.println("\n    " + "=".repeat(30) + "--- ALL DEPOSITS ---" + "=".repeat(30) + "\n");

        System.out.printf("    %-12s | %-8s | %-20s | %-20s | %-10s\n",
                "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
        System.out.println("    " + "-".repeat(85)+ "\n");

        for (int i = transaction.size() - 1; i >= 0; i--) {
            Transaction t = transaction.get(i);
            //output only positive entries
            if (t.getAmount() > 0) {
                System.out.printf("    %-12s | %-8s | %-20s | %-20s 【 $%,-10.2f 】\n",
                        t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                System.out.println("    " + "—".repeat(85));
            }
        }
        System.out.println("\n" + "=".repeat(40) + "---E-N-D---" + "=".repeat(40) + "\n");
        System.out.println(" ".repeat(31) + "【 L 】      ✦      【 H 】      ✦     【 X 】");
        System.out.println(" ".repeat(26) + "Ledger Menu         Home            EXIT\n");
        System.out.print("    ㅡ> ");
        char entriesMenu = input.next().toUpperCase().charAt(0);
        input.nextLine();
        switch (entriesMenu) {
            case 'L' -> runLedgerScreen();
            case 'H' -> runHomeScreen();
            case 'X' -> exitScreen();
        }
    }

              /// P: Payments - display the payments only ===========================================
                 private static void runPaymentsScreen() {
        System.out.println("\n    " + "=".repeat(30) + "--- ALL PAYMENTS ---" + "=".repeat(30) + "\n");
        System.out.printf("    %-12s | %-8s | %-20s | %-20s | %-10s\n",
                "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
        System.out.println("    " + "-".repeat(85)+ "\n");

        for (int i = transaction.size() - 1; i >= 0; i--) {
            Transaction t = transaction.get(i);
            //output only negative entries
            if (t.getAmount() < 0) {
                System.out.printf("    %-12s | %-8s | %-20s | %-20s 【 $%,-10.2f 】\n",
                        t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                System.out.println("    " + "—".repeat(85));
            }
        }
        System.out.println("\n    " + "=".repeat(40) + "---E-N-D---" + "=".repeat(40) + "\n");
        System.out.println(" ".repeat(31) + "【 L 】      ✦      【 H 】      ✦     【 X 】");
        System.out.println(" ".repeat(26) + "Ledger Menu         Home            EXIT\n");
        System.out.print(" ".repeat(29) + "ㅡ>    ");
        char entriesMenu = input.next().toUpperCase().charAt(0);
        input.nextLine();
        switch (entriesMenu) {
            case 'L' -> runLedgerScreen();
            case 'H' -> runHomeScreen();
            case 'X' -> exitScreen();
        }
    }

              /// R: Reports - shows option for display method ======================================
                 private static void runReportsScreen() {
        boolean reports = true;
        while (reports) { //screen header
            System.out.println("\n" + "=".repeat(28) + "--- REPORT MENU ---" + "=".repeat(28));
            //menu
            System.out.println("\n" + " ".repeat(26) + "【 1 】- Current Month"); //.now
            System.out.println(" ".repeat(26) + "【 2 】- Previous Month"); //.now - 1
            System.out.println(" ".repeat(26) + "【 3 】- Current Year"); //.now
            System.out.println(" ".repeat(26) + "【 0 】- Search"); //compare input with object elements
            System.out.println(" ".repeat(25) + "-".repeat(23));
            System.out.println(" ".repeat(26) + "【 H 】     ✦     【 X 】");
            System.out.println(" ".repeat(26) + "Home            EXIT\n"); // exit menu
            System.out.print(" ".repeat(29) + "ㅡ>    ");

            char reportChoice = input.next().toUpperCase().charAt(0);
            input.nextLine(); //clear buffer☑️
            // control switch🩶
            switch (reportChoice) {
                case '1' -> runCurrentMonthScreen();
                case '2' -> runPreviousMonthScreen();
                case '3' -> runCurrentYearScreen();
                case '0' -> runSearchScreen();
                case 'H' -> reports = false;
                case 'X' -> exitScreen();
            }
        }
    }

                    /// 1: Month to date =============================================================
                        private static void runCurrentMonthScreen() { //screen header
        System.out.println("\n    " + "=".repeat(30) + "--- CURRENT MONTH ---" + "=".repeat(30) + "\n");
        //current date
        LocalDate now = LocalDate.now();
        //get current month & year out of current date
        int currentMonth = now.getMonthValue();
        int currentYear = now.getYear();
        //table-row header
        System.out.printf("    %-12s | %-8s | %-20s | %-20s | %-10s\n",
                "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
        System.out.println("    " + "-".repeat(85));
        //start from bottom of ArrayList(i=size -1) and iterate backward (i--)
        for (int i = transaction.size() - 1; i >= 0; i--) {
            Transaction t = transaction.get(i); // ArrayList element~ object t
            //compare transaction's month+year w current month+year
            if (t.getMonth() == currentMonth && t.getYear() == currentYear) {
                System.out.printf("    %-12s | %-8s | %-20s | %-20s 【 $%,-10.2f 】\n", //format output
                        t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                System.out.println("    " + "—".repeat(85));
            }
        }
        // 'end of screen' marker
        System.out.println("\n" + "=".repeat(40) + "---E-N-D---" + "=".repeat(40) + "\n");
        //manual navication menu
        System.out.println(" ".repeat(12) + "【 R 】      ✦      【 L 】      ✦     【 H 】     ✦     【 X 】");
        System.out.println(" ".repeat(10) + "Report Menu        Ledger Menu             Home              EXIT\n");
        System.out.print(" ".repeat(29) + "ㅡ>    ");
        char entriesMenu = input.next().toUpperCase().charAt(0);
        input.nextLine(); //clear buffer ☑️
        switch (entriesMenu) { //control switch for menu
            case 'R' -> runReportsScreen();
            case 'L' -> runLedgerScreen();
            case 'H' -> runHomeScreen();
            case 'X' -> exitScreen();
        }
    }

                    /// 2: Previous Month ============================================================
                         private static void runPreviousMonthScreen() {
        //same system as currentMonth screen
        // get current date - 1 month = previous month
        LocalDate lastMonthDate = LocalDate.now().minusMonths(1);
        int lastMonth = lastMonthDate.getMonthValue(); //pull out Month from lastMonth's date
        int lastMMsYear = lastMonthDate.getYear(); //pull out Year from lastMonth's date

        System.out.println("\n    " + "=".repeat(30) + "--- PREVIOUS MONTH ---" + "=".repeat(30) + "\n");
        //iterate backwards for better output
        for (int i = transaction.size() - 1; i >= 0; i--) {
            Transaction t = transaction.get(i);
            //compare our object's month & year w lastMonth & lastMonth's Year
            if (t.getMonth() == lastMonth && t.getYear() == lastMMsYear) {
                System.out.printf("    %-12s | %-8s | %-20s | %-20s 【 $%,-10.2f 】\n",
                        t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                System.out.println("    " + "—".repeat(85));
            }
        }
        //end of page marker + menue bar
        System.out.println("\n" + "=".repeat(40) + "---E-N-D---" + "=".repeat(40) + "\n");
        System.out.println(" ".repeat(12) + "【 R 】      ✦      【 L 】      ✦     【 H 】     ✦     【 X 】");
        System.out.println(" ".repeat(10) + "Report Menu        Ledger Menu             Home              EXIT\n");
        System.out.print(" ".repeat(29) + "ㅡ>    ");
        char entriesMenu = input.next().toUpperCase().charAt(0);
        input.nextLine();
        switch (entriesMenu) { //menu control-switch
            case 'R' -> runReportsScreen();
            case 'L' -> runLedgerScreen();
            case 'H' -> runHomeScreen();
            case 'X' -> exitScreen();
        }
    }

                    /// 3: Year to Date ==============================================================
                        private static void runCurrentYearScreen() {
        //cut current year value out of current date (date.now)
        int currentYear = LocalDate.now().getYear();
        System.out.println("\n    " + "=".repeat(30) + "--- CURRENT YEAR ---" + "=".repeat(30) + "\n");

        for (int i = transaction.size() - 1; i >= 0; i--) {
            Transaction t = transaction.get(i);
            //compare object's year w current Year var
            if (t.getYear() == currentYear) {
                System.out.printf("    %-12s | %-8s | %-20s | %-20s 【 $%,-10.2f 】\n",
                        t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                System.out.println("    " + "—".repeat(85));
            }
        }
        System.out.println("\n" + "=".repeat(40) + "---E-N-D---" + "=".repeat(40) + "\n");
        System.out.println(" ".repeat(12) + "【 R 】      ✦      【 L 】      ✦     【 H 】     ✦     【 X 】");
        System.out.println(" ".repeat(10) + "Report Menu        Ledger Menu             Home              EXIT\n");
        System.out.print(" ".repeat(29) + "ㅡ>    ");
        char entriesMenu = input.next().toUpperCase().charAt(0);
        input.nextLine();
        switch (entriesMenu) {
            case 'R' -> runReportsScreen();
            case 'L' -> runLedgerScreen();
            case 'H' -> runHomeScreen();
            case 'X' -> exitScreen();
        }
    }

                     /// 4: Search by Keyword ========================================================
                         private static void runSearchScreen() {
        // search screen control
        boolean search = true;
        while (search) {
            System.out.println("\n" + "-".repeat(30) + " SEARCH BitBOOK " + "-".repeat(30));
            System.out.println(" ".repeat(12) + "Enter any keyword (Vendor, Description, or Amount):\n");
            System.out.print(" ".repeat(29) + "ㅡ>  ");
            String keyword = input.nextLine().toLowerCase();

            System.out.println("\n    " + "=".repeat(30) + "--- SEARCH RESULTS ---" + "=".repeat(30) + "\n");
            System.out.printf("    %-12s | %-8s | %-20s | %-20s | %-10s\n",
                    "DATE", "TIME", "DESCRIPTION", "VENDOR", "AMOUNT");
            System.out.println("    " + "-".repeat(85));

            //iteration loop control
            boolean found = false;
            for (int i = transaction.size() - 1; i >= 0; i--) {
                Transaction t = transaction.get(i);
                if (t.getDescription().toLowerCase().contains(keyword) ||
                        t.getVendor().toLowerCase().contains(keyword) ||
                        String.valueOf(t.getAmount()).contains(keyword)) {

                    System.out.printf("    %-12s | %-8s | %-20s | %-20s 【 $%,-10.2f 】\n",
                            t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
                    System.out.println("    " + "—".repeat(85));
                    found = true;
                }
            }

            if (!found) {
                System.out.println("\n" + " ".repeat(18) + "No transactions found for " + keyword + "\n");
            }
            //close search function
            search = false;

            System.out.println("\n" + "=".repeat(40) + "---E-N-D---" + "=".repeat(40) + "\n");
            System.out.println(" ".repeat(5) + "【 S 】      ✦      【 R 】      ✦      【 L 】      ✦     【 H 】     ✦     【 X 】");
            System.out.println(" ".repeat(5) + "Search              Report Menu        Ledger Menu           Home              EXIT\n");
            System.out.print(" ".repeat(29) + "ㅡ>  ");

            char entriesMenu = input.next().toUpperCase().charAt(0);
            input.nextLine();

            switch (entriesMenu) {
                case 'S' -> search = true; //restart search screen
                case 'R' -> runReportsScreen();
                case 'L' -> runLedgerScreen();
                case 'H' -> runHomeScreen();
                case 'X' -> exitScreen();
            }
        }


    }

    ///utilities =====================================================================================
    // Save to File once! (at the comand od 'D' - Done
    private static void saveToFile(Transaction t, String type) {
        try {
            writeToFile = new BufferedWriter(new FileWriter("transactions.csv", true));
            String fileLine = String.format("%s|%s|%s|%s|%.2f\n", //need to study
                    t.getDate(), t.getTime(), t.getDescription(), t.getVendor(), t.getAmount());
            writeToFile.write(fileLine);

            writeToFile.close(); //impo
            //print 'saved' message                                                  payment / depo
            System.out.println("\n" + " ".repeat(22) + "=".repeat(10) + " " + type + " SAVED " + "=".repeat(10) + "\n");        } catch (IOException e) {
            System.out.println(" ".repeat(24) + "Error saving transaction.");
        }
    }

    //Bottom Navigation (could be improved to include every screen's navigation bar + their switches)
    private static void showNavigationFooter() {
        System.out.println(" ".repeat(25) + "【 H 】      ✦      【 X 】");
        System.out.println(" ".repeat(26) + "Home               EXIT\n");
        System.out.print(" ".repeat(29) + "ㅡ>    ");

    }

    ///Exit system
    private static void exitScreen() {
        System.out.println(" ".repeat(7) + "————————————————————————————————————————————————————————————");
        System.out.println(" ".repeat(19) + "Thank You for using BitBOOK, " + userName);
        System.out.println(" ".repeat(7) + "————————————————————————————————————————————————————————————");

        System.exit(0); //shutting down everything
    }

    //close scanner
}


