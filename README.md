# 📘 BitBOOK 📘
###Your Trusted Accounting Ledger

BitBOOK is a Java console-based ledger application designed to help users track their financial health with precision. Whether you're adding a quick deposit or searching for a specific payment, BitBook keeps your data organized and persisted in a clean CSV format.

### ❖ Application Flow Chart
This diagram shows how to navigate through the different screens of the app:

[HOME SCREEN]
   │
   ├── (D) ──► [ADD DEPOSIT] ──────┐
   │             │                 │ (Loop/Confirm)
   │             └── (H/X) ────────┴─► Home or Exit
   │
   ├── (P) ──► [ADD PAYMENT] ──────┐
   │             │                 │ (Loop/Confirm)
   │             └── (H/X) ────────┴─► Home or Exit
   │
   └── (L) ──► [LEDGER MENU] ──────┐
                 │                 │
                 ├── (A) ──► [ALL ENTRIES]
                 ├── (D) ──► [DEPOSITS]
                 ├── (P) ──► [PAYMENTS]
                 └── (R) ──► [REPORT MENU] ───┐
                               │              │
                               ├── (1-3) ──► [DATE FILTERS]
                               └── (0) ──► [GLOBAL SEARCH]

---

### ✦ Welcom Screen
Log in to begin navigating BitBook
> **[<img width="803" height="326" alt="image" src="https://github.com/user-attachments/assets/7eb1eaaa-2380-40bb-9f42-c7f2b8cd07e0" /> ]**

### ✦ Home Screen
The main hub of BitBOOK where you choose your starting path.
> **[<img width="717" height="378" alt="image" src="https://github.com/user-attachments/assets/54c999a9-a666-41da-9c19-cae2ff85cbe9" /> ]**

### ✦ Add Deposit / Payment
Hands-on data entry with automatic date/time stamping (formatted to eliminate those pesky nanoseconds!) and a confirmation loop to ensure accuracy before saving to the file.
> **[
<img width="767" height="384" alt="image" src="https://github.com/user-attachments/assets/f60fbc22-ebf0-458c-90bc-841e8adc71bd" />
]**

### ✦ Ledger Views
Clean, table-style displays of your history. All entries are shown from **Newest to Oldest** for easy tracking.
- **All Entries:** Every single transaction in the file.
- **Deposits:** Filtered for positive values only.
- **Payments:** Filtered for negative values (debits).
> **[<img width="743" height="321" alt="image" src="https://github.com/user-attachments/assets/8f4ce721-357d-4301-ac0b-a716a1362bdd" />
]**

### ✦ Report & Global Search
Advanced logic to slice your data by Month, Year, or a specific keyword.
- **Month/Year Filters:** Logic-based filtering using `LocalDate`.
- **Global Search:** Finds matches across Vendors, Descriptions, or even specific Amounts.
> **[<img width="753" height="326" alt="image" src="https://github.com/user-attachments/assets/95bfa0d7-a16e-44cb-9dae-8f151f86cce7" />
]**
> **[<img width="756" height="110" alt="image" src="https://github.com/user-attachments/assets/ca49c1be-ab09-4e8f-815e-c3231550c365" />]**

---

### 🛠 Technologies Used
- **Java OOP:** Encapsulation and custom Object-Oriented design for Transactions.
- **Data Management:** File I/O using `BufferedReader` and `BufferedWriter` with CSV.
- **Time Management:** `java.time` (LocalDate, LocalTime, DateTimeFormatter) for professional stamping.
- **User Interface:** Console-based interaction using `Scanner` and dynamic formatting with `.repeat()`.

### ㅡ> How to Run
1. Open the project in your IDE (IntelliJ).
2. Ensure the `transactions.csv` is located in the root project folder.
3. Run the `App.java` file.
4. Sign in with your name and email to start your session!

---
*Created by Arsema Yifter - for Java Capstone Project-1*
*Contacts  email: MeleyMM88@gmail.com*


