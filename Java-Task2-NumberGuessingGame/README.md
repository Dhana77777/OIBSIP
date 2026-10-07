# Java Task 2 - Number Guessing Game

## Project Description

This project is a Java-based Number Guessing Game developed as part of the Oasis Infobyte Internship (OIBSIP).

The computer randomly selects a number between 1 and 100, and the player gets a maximum of 7 attempts to guess the number.

## Features

- Generates a random number between 1 and 100
- Allows the user to enter guesses
- Displays "Too High" and "Too Low" hints
- Tracks the number of attempts
- Maximum of 7 attempts per round
- Displays the correct number if the player loses
- Allows the player to play multiple rounds
- Calculates the score based on the number of attempts
- Displays the final score
- Handles invalid input
- Validates numbers outside the range 1 to 100

## Technologies Used

- Java
- Scanner
- Random
- Loops
- Conditional Statements
- Input Validation

## How to Run

1. Open the project in VS Code or any Java IDE.
2. Open the `src` folder.
3. Open `NumberGuessingGame.java`.
4. Run the Java program.
5. Enter your guesses in the terminal.

## Game Rules

- The computer selects a random number between 1 and 100.
- The player gets 7 attempts.
- If the guess is lower than the secret number, the game displays "Too Low".
- If the guess is higher than the secret number, the game displays "Too High".
- If the player guesses correctly, the round is completed.
- The player can choose to play another round.

## Project Structure

```text
Java-Task2-NumberGuessingGame/
│
├── README.md
│
├── src/
│   └── NumberGuessingGame.java
│
└── screenshots/
