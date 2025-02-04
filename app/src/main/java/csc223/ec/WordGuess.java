package csc223.ec;

import java.util.Scanner;

public class WordGuess {
    //A word is chosen by the computer.
    //The player is given a number of turns to guess the word.
    //The player guesses a letter.
    //If the letter is in the word, the computer reveals the position of the letter in the word.

    int chances;
    String word;
    int correct;

    Scanner scan = new Scanner(System.in);
    String[] wordList = new String[5];
    String[] wordBoard;
    char[] wordKey;


    public WordGuess() {
        //list of words that the computer can pick from
        wordList[0] = "frog";
        wordList[1] = "phone";
        wordList[2] = "cat";
        wordList[3] = "crypt";
        wordList[4] = "rythym";

        //picking random word and setting number of chances
        this.word = wordList[0 + (int)(Math.random() * ((4-0) + 1))];
        this.chances = 10;
    }

    public void startGame() {
        //A word is chosen by the computer.
        //The player is given a number of turns to guess the word.

        //picking random word and setting number of chances
        this.word = wordList[0 + (int)(Math.random() * ((4-0) + 1))];
        this.chances = 10;
        this.correct = 0;

        //creating the empty spaces for guessing: _ _ _ _ _ . . .
        this.wordBoard = new String[this.word.length()];
        
        //filling in word board with empty spaces
        for (int i=0;i<this.word.length();i++) {
            this.wordBoard[i] = "_";
        }

        //creating a key to check against when player guesses ex: [c, a, t]
        this.wordKey = new char[this.word.length()];

        for (int i=0; i<this.word.length();i++) {
            this.wordKey[i] = this.word.charAt(i);
        }

        while (isGameOver()!=true) {
            takeTurn();
        }

        endGame();

    }
    
    public void printBoard() {
        for (int i=0; i<this.word.length(); i++) {
            System.out.print(this.wordBoard[i] + " ");
        }
        System.out.println();
    }

    public void takeTurn() {

        //take a guess
        System.out.print("Guess the letter or the Entire word: ");
        String playerGuess = scan.nextLine();

        if (playerGuess.equals(this.word)) {
            this.correct = this.word.length();
        }

        //check if guess in in word
        else if (this.word.indexOf(playerGuess) != -1) {
            for (int i =0; i<this.word.length(); i++) {
                if (playerGuess.charAt(0) == this.wordKey[i]) {
                    this.wordKey[i] = '_';
                    this.wordBoard[i] = playerGuess.substring(0,1);
                    this.correct++;
                }
            }
            printBoard();
        }

        else {
            System.out.println(playerGuess + " is not in word.");
            this.chances --;
            System.out.println("You have " + this.chances + " chances remaining");
        }


    }

    public boolean isGameOver() {
        if (this.chances == 0) {
            return true;
        }
        else if (this.correct == this.word.length()) {
            return true;
        }
        else {
            return false;
        }
    }

    public void endGame() {
        if (this.chances == 0) {
            System.out.println("Sorry your guesses were wrong, the word was '" + this.word + "'");
        }
        else {
            System.out.println("Congrats, your guess was correct, the word was '" + this.word + "'");
        }


        System.out.print("Do You wanna Play Again(yes/no): ");
        String playAgain = scan.nextLine();

        if (playAgain.equals("yes")) {
            startGame();
        }
        else {
            System.out.println("Game Over");
        }
    }

    public void playGame() {
        startGame();
    }

    public static void main(String[] args) {
        WordGuess game = new WordGuess();
        game.playGame();
    }
}
