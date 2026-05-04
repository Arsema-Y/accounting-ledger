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
