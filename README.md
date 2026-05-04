# ⌇ BitBOOK: Your Trusted Accounting Ledger

BitBOOK is a Java console-based ledger application designed to help users track their financial health with precision. Whether you're adding a quick deposit or searching for a specific payment, BitBook keeps your data organized and persisted in a clean CSV format.

## ❖ Application Flow Chart
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

## ✦ Home Screen
The main hub of BitBOOK where you choose your starting path.
> **[<img width="803" height="326" alt="image" src="https://github.com/user-attachments/assets/7eb1eaaa-2380-40bb-9f42-c7f2b8cd07e0" />
]**

## ✦ Add Deposit / Payment
Hands-on data entry with automatic date/time stamping (formatted to eliminate those pesky nanoseconds!) and a confirmation loop to ensure accuracy before saving to the file.
> **[INSERT SCREENSHOT OF DEPOSIT/PAYMENT ENTRY HERE]**

## ✦ Ledger Views
Clean, table-style displays of your history. All entries are shown from **Newest to Oldest** for easy tracking.
- **All Entries:** Every single transaction in the file.
- **Deposits:** Filtered for positive values only.
- **Payments:** Filtered for negative values (debits).
> **[INSERT SCREENSHOT OF LEDGER TABLE HERE]**

## ✦ Report & Global Search
Advanced logic to slice your data by Month, Year, or a specific keyword.
- **Month/Year Filters:** Logic-based filtering using `LocalDate`.
- **Global Search:** Finds matches across Vendors, Descriptions, or even specific Amounts.
> **[INSERT SCREENSHOT OF SEARCH RESULTS HERE]**
