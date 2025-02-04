package csc223.ec;

import java.util.Scanner;

public class TicTacToe implements Game {

// Implement the game of Tic Tac Toe. The game is played as follows:

// The game is played on a 3x3 grid.
// The player is given a choice of playing as 'X' or 'O'.
// The players take turns to place their symbol on the grid.
// The player wins if they can get three of their symbols in a row, column, or diagonal.
// The game ends in a draw if all the cells are filled and no player has won.

    char[][] board;
    char[] guide;
    char player1Character;
    char player2Character;
    int turn;
    char activeCharacter;
    int playerWon;

    Scanner scan = new Scanner(System.in);

    public TicTacToe() {
        this.board = new char[][] { {' ', ' ', ' '},
                                    {' ', ' ', ' '},
                                    {' ', ' ', ' '}};
        this.guide = new char[] {'A', 'B', 'C', '0', '1', '2'};
        this.turn = 1;
        this.activeCharacter = ' ';
        this.playerWon = 0;
    }

    public void startGame() {
        for (int i = 0; i<3; i++) {
            for (int j = 0; j<3; j++) {
                this.board[i][j] = ' ';
            }
        }

        System.out.print("Player 1, please choose either X or O as your character: ");
        this.player1Character = scan.nextLine().charAt(0);
        System.out.println();

        if (player1Character == 'X') {
            this.player2Character = 'O';
        }
        else {
            this.player2Character = 'X';
        }

        while (isGameOver() != true) {
            takeTurn();
        }

        printBoard();

        endGame();
    }


    public void printBoard() {
        //print A-C
        System.out.print("   ");
        for (int i=0; i<3; i++) {
            System.out.print(this.guide[i] + " ");
        }
        System.out.println();
        System.out.print("   _ _ _");
        System.out.println();

        //print row 1
        System.out.print('0' + " |");
        for (int i = 0; i<3; i++) {
            System.out.print(this.board[0][i] + " ");
        }
        System.out.println();

        //print row 2
        System.out.print('1' + " |");
        for (int i = 0; i<3; i++) {
            System.out.print(this.board[1][i] + " ");
        }
        System.out.println();

        //print row 3
        System.out.print('2' + " |");
        for (int i = 0; i<3; i++) {
            System.out.print(this.board[2][i] + " ");
        }
        System.out.println();
    }


    public void takeTurn() {
        if (this.turn % 2 == 1) {
            System.out.println("Player 1's turn.");
        }
        else {
            System.out.println("Player 2's turn.");
        }

        printBoard();

        System.out.print("Choose your next move from the square (e.g. A0): ");
        String playerChoice = scan.nextLine();

        if (this.turn % 2 != 0) {
            this.activeCharacter = this.player1Character;
        }
        else {
            this.activeCharacter = this.player2Character;
        }

        if (playerChoice.charAt(0) == 'A') {
            this.board[playerChoice.charAt(1) - '0'][0] = this.activeCharacter;
        }
        else if (playerChoice.charAt(0) == 'B') {
            this.board[playerChoice.charAt(1) - '0'][1] = this.activeCharacter;
        }
        else if (playerChoice.charAt(0) == 'C') {
            this.board[playerChoice.charAt(1) - '0'][2] = this.activeCharacter;
        }
        else {
            System.out.println("Please choose a valid place next time");
        }
        this.turn++;
        System.out.println();
    }
    public boolean isGameOver() {
        for (int i=0;i<3;i++) {
            if ((this.board[0][i] == 'X' || this.board[0][i] == 'O') && ((this.board[0][i] == this.board[1][i]) && this.board[0][i] == this.board[2][i])) {
                if (this.board[0][i] == 'X' && player1Character == 'X') {this.playerWon = 1;}
                else if (this.board[0][i] == 'O' && player1Character == 'O') {this.playerWon = 1;}
                else {this.playerWon = 2;}
                return true;
            }
            else if ((this.board[i][0] == 'X' || this.board[i][0] == 'O') && ((this.board[i][0] == this.board[i][1]) && this.board[i][0] == this.board[i][2])) {
                if (this.board[i][0] == 'X' && player1Character == 'X') {this.playerWon = 1;}
                else if (this.board[i][0] == 'O' && player1Character == 'O') {this.playerWon = 1;}
                else {this.playerWon = 2;}
                return true;
            }
        }
        if ((this.board[0][0] == 'X' || this.board[0][0] == 'O') && (this.board[0][0] == this.board[1][1] && this.board[0][0] == this.board[2][2])) {
            if (this.board[0][0] == 'X' && player1Character == 'X') {this.playerWon = 1;}
            else if (this.board[0][0] == 'O' && player1Character == 'O') {this.playerWon = 1;}
            else {this.playerWon = 2;}
            return true;
        }
        else if ((this.board[0][2] == 'X' || this.board[0][2] == 'O') && (this.board[0][2] == this.board[1][1] && this.board[0][2] == this.board[2][0])) {
            if (this.board[0][2] == 'X' && player1Character == 'X') {this.playerWon = 1;}
            else if (this.board[0][2] == 'O' && player1Character == 'O') {this.playerWon = 1;}
            else {this.playerWon = 2;}
            return true;
        }
        else if (this.turn == 10) {
            this.playerWon = 0;
            return true;
        }
        return false;
    }

    public void endGame() {
        if (playerWon == 1) {
            System.out.println("Player 1 has won!");
        }
        else if (playerWon == 2) {
            System.out.println("Player 2 has won!");
        }
        else {
            System.out.println("Draw!");
        }
    }

    public void playGame() {
        startGame();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.playGame();
    }

}
