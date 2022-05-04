//Anthony Franklin afranklin18@cnm.edu
//RockPS Frame Program plays rock paper scissors using embedded layout managers
//RockPS.java

//02/22/2022

import java.util.*;

public class RockPS {
    public int choice, compChoice, wins, losses, games, compWins, playerWins, ties;

    public String[] outcome = {"You win, great job! ", "The computer wins ", "Draw! "};
    public String result = "";
    private boolean isGame;

    //Array of choices:
    public String[] options = {"\u270a", "\u270b", "\u270c"};
    Random rand;
    //Constructor

    public RockPS() {
        rand = new Random();
    }

    //Methods:
    private void checkGame() {
        if (compWins < 2 && playerWins < 2) {
            isGame = false;
        } else if (playerWins == 2) {
            games++;
            wins++;
            isGame = true;
        } else {
            games++;
            losses++;
            isGame = true;
        }
    }

    private void checkRound() {
        switch (choice) {
            case 0:
                if (compChoice == 0) {
                    ties++;
                    result = outcome[2];
                } else if (compChoice == 1) {
                    compWins++;
                    result = outcome[1];
                } else {
                    playerWins++;
                    result = outcome[0];
                }
                break;
            case 1:
                if (compChoice == 0) {
                    playerWins++;
                    result = outcome[0];
                } else if (compChoice == 1) {
                    ties++;
                    result = outcome[2];
                } else {
                    compWins++;
                    result = outcome[1];
                }
                break;
            case 2:
                if (compChoice == 0) {
                    compWins++;
                    result = outcome[1];
                } else if (compChoice == 1) {
                    playerWins++;
                    result = outcome[0];
                } else {
                    ties++;
                    result = outcome[2];
                }
                break;
        }
        checkGame();
    }

    public void setGameStart(int userChoice) {
        choice = userChoice;
    }

    public String getUserChoice() {
        return options[choice];
    }

    public String getCompChoice() {
        compChoice = rand.nextInt(3);
        return options[compChoice];
    }

    public String getRoundWinLose() {
        checkRound();
        return (result + "\n" + "Player Score: " + playerWins + "\nComputer Score: " + compWins + "\nDraws: " + ties);
    }

    public boolean getGameOver() {
        return isGame;
    }

    public String getGameOverString() {
        return ("\nSCORE: \nGames played: " + games + "\nPlayer wins: " + wins + "\nPlayer losses: " + losses);
    }

    public String getGoodBye() {
        return ("\nThanks for playing with me! Final outcome: \nGames played: " + games + "\nPlayer wins: " + wins + "\nPlayer losses: " + losses);
    }

    public void reset() {
        compWins = 0;
        playerWins = 0;
        ties = 0;
    }

}
