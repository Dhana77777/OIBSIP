```markdown
# ATM Interface

## Project Overview

This project is a console-based ATM Interface developed using Java.

The application allows a user to log in using a User ID and PIN and perform basic banking operations such as checking balance, depositing money, withdrawing money, transferring money, and viewing transaction history.

## Features

- User ID and PIN authentication
- Maximum 3 login attempts
- Check account balance
- Deposit money
- Withdraw money
- Transfer money to another account
- Transaction history
- Insufficient balance validation
- Invalid input handling
- Multiple sample accounts for testing

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- HashMap
- Java Collections
- Console-based interface

## Project Structure

```text
Java-Task3-ATMInterface/
├── src/
│   ├── Main.java
│   ├── ATM.java
│   ├── Account.java
│   ├── Transaction.java
│   └── Bank.java
├── screenshots/
│   └── task3 screenshot.jpeg
└── README.md
```

## Classes

### Main.java

Starts the ATM application.

### ATM.java

Handles login, ATM menu, deposits, withdrawals, transfers, balance checking, and transaction history.

### Account.java

Stores account details, balance, and transactions.

### Transaction.java

Represents individual banking transactions.

### Bank.java

Manages the available accounts and authentication.

## Sample Login Credentials

### Account 1

User ID: user123  
PIN: 1234  
Initial Balance: ₹10,000

### Account 2

User ID: user456  
PIN: 5678  
Initial Balance: ₹5,000

## ATM Operations

1. Check Balance
2. Deposit
3. Withdraw
4. Transfer
5. Transaction History
6. Exit

## How to Run

Open the `src` folder in the terminal and compile the Java files:

```bash
javac *.java
```

Run the application:

```bash
java Main
```

## Screenshot

The `screenshots` folder contains the output screenshot of the working ATM Interface.

## Internship Task

This project was developed as part of the **OASIS INFOBYTE Java Development Internship**.

**Task:** ATM Interface
```
