//Anthony Franklin afranklin18@cnm.edu
//RockPS Frame Program plays rock paper scissors using embedded layout managers
//RockFrame.java

//02/22/2022

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.beans.Visibility;
import javax.swing.*;

public class RockFrame extends JFrame {

    private RockPS rps;
    //Variables
    private static final int WIDTH = 775;
    private static final int HEIGHT = 700;

    //Component declarations (references)
    private JTextField playerChoiceBox;  //displays player choice
    private JTextField compChoiceBox;
    JTextField games;
    JTextField wins;
    JTextField losses;
    JTextField roundWins;
    JTextField roundLosses;
    JTextField roundTies;
    private JPanel scoreBox = new JPanel(new GridLayout(7, 2, 5, 5));       // contains running score of the round(s)/game(s)
    private JTextArea outputBox = new JTextArea();       // displays output from RockPS program
    private JPanel quitPanel = new JPanel(new GridLayout(1, 2, 5, 0));
    private JButton quitButton;
    private JButton againButton;
    private JPanel choicePanel = new JPanel(new GridLayout(2, 1, 0, 5));
    private JPanel cButtonPanel = new JPanel(new FlowLayout());
    private JPanel cTextPanel = new JPanel(new GridLayout(2, 2, 5, 5));
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;


    //Constructor
    public RockFrame(RockPS rock) {
        rps = rock;
        setTitle("Rock Paper Scissors");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //set layout(s)
        setLayout(new BorderLayout(10, 10));
        initComponents();
        setVisible(true);
    }

    private void resetGame() {
        rps.reset();
        playerChoiceBox.setText("");
        compChoiceBox.setText("");
    }

    private void initComponents() {
        quitButton = new JButton("Quit?");
        againButton = new JButton("Again?");
        rockButton = new JButton("ROCK\n\u270a");
        paperButton = new JButton("PAPER\n\u270b");
        scissorsButton = new JButton("SCISSORS\n\u270c");

        //Creating panel with quit/again options
        quitButton.setBackground(Color.red);
        quitButton.setForeground(Color.white);
        againButton.setBackground(Color.green);
        againButton.setForeground(Color.white);
        quitPanel.add(againButton);
        quitPanel.add(quitButton);
        againButton.setVisible(false);

        //Creating Panel with RPS Buttons, Player choice and Comp choice
        cButtonPanel.add(rockButton);
        cButtonPanel.add(paperButton);
        cButtonPanel.add(scissorsButton);

        playerChoiceBox = new JTextField();
        playerChoiceBox.setEditable(false);
        playerChoiceBox.setHorizontalAlignment(JTextField.CENTER);
        playerChoiceBox.setFont(playerChoiceBox.getFont().deriveFont(48f));
        JLabel pChoiceLabel = new JLabel("Player Chose: ");
        compChoiceBox = new JTextField();
        compChoiceBox.setEditable(false);
        compChoiceBox.setHorizontalAlignment(JTextField.CENTER);
        compChoiceBox.setFont(compChoiceBox.getFont().deriveFont(48f));
        JLabel cChoiceLabel = new JLabel("Computer Chose: ");
        cTextPanel.add(pChoiceLabel);
        cTextPanel.add(playerChoiceBox);
        cTextPanel.add(cChoiceLabel);
        cTextPanel.add(compChoiceBox);
        choicePanel.add(cTextPanel);
        choicePanel.add(cButtonPanel);

        //Creating output panel
        Font font = new Font("Arial Black", Font.BOLD, 12);
        outputBox.setFont(font);
        outputBox.setText("Anthony Franklin afranklin18@cnm.edu\nRock Paper Scissors\nPaper beats rock, rock beats scissors, scissors beats paper.\n*****GOOD LUCK, HAVE FUN!!*****");
        outputBox.setEditable(false);
        outputBox.setBackground(Color.DARK_GRAY);
        outputBox.setForeground(Color.WHITE);

        //Creating scorebox panel
        JLabel gamesLabel = new JLabel("Games Played: ");
        games = new JTextField(Integer.toString(rps.games));
        games.setEditable(false);
        JLabel winsLabel = new JLabel("Player Wins: ");
        wins = new JTextField(Integer.toString(rps.wins));
        wins.setEditable(false);
        JLabel lossLabel = new JLabel("Player Losses: ");
        losses = new JTextField(Integer.toString(rps.losses));
        losses.setEditable(false);
        JLabel roundLabel = new JLabel("Current Game: ");
        JLabel roundLabelBlank = new JLabel();
        JLabel roundWinsLabel = new JLabel("Player Wins: ");
        roundWins = new JTextField(Integer.toString(rps.playerWins));
        roundWins.setEditable(false);
        JLabel roundLossLabel = new JLabel("Player Losses: ");
        roundLosses = new JTextField(Integer.toString(rps.compWins));
        roundLosses.setEditable(false);
        JLabel roundTiesLabel = new JLabel("Ties: ");
        roundTies = new JTextField(Integer.toString(rps.ties));
        roundTies.setEditable(false);

        //adding components to scorebox
        scoreBox.add(gamesLabel);
        scoreBox.add(games);
        scoreBox.add(winsLabel);
        scoreBox.add(wins);
        scoreBox.add(lossLabel);
        scoreBox.add(losses);
        scoreBox.add(roundLabel);
        scoreBox.add(roundLabelBlank);
        scoreBox.add(roundWinsLabel);
        scoreBox.add(roundWins);
        scoreBox.add(roundLossLabel);
        scoreBox.add(roundLosses);
        scoreBox.add(roundTiesLabel);
        scoreBox.add(roundTies);

        //add components to layout(s)
        add(quitPanel, BorderLayout.SOUTH);
        add(choicePanel, BorderLayout.WEST);
        add(outputBox, BorderLayout.NORTH);
        add(scoreBox, BorderLayout.EAST);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sayGoodbye();
                JOptionPane.showMessageDialog(getParent(), rps.getGoodBye());
                System.exit(0);
            }
        });
        againButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetGame();
                outputBox.setText("Rock Paper Scissors\nPaper beats rock, rock beats scissors, scissors beats paper.\n*****GOOD LUCK, HAVE FUN!!*****");
            }
        });
        rockButton.addActionListener(new Listener());
        paperButton.addActionListener(new Listener());
        scissorsButton.addActionListener(new Listener());
    }

    //Inner class(es) for listeners
    private class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int choice;
            if (e.getSource() == rockButton) choice = 0;
            else if (e.getSource() == paperButton) choice = 1;
            else choice = 2;
            rps.setGameStart(choice);
            playerChoiceBox.setText(rps.getUserChoice());
            compChoiceBox.setText(rps.getCompChoice());
            outputBox.setText(rps.getRoundWinLose());
            games.setText(Integer.toString(rps.games));
            wins.setText(Integer.toString(rps.wins));
            losses.setText(Integer.toString(rps.losses));
            roundWins.setText(Integer.toString(rps.playerWins));
            roundLosses.setText(Integer.toString(rps.compWins));
            roundTies.setText(Integer.toString(rps.ties));
            if (rps.getGameOver()) {
                againButton.setVisible(true);
                outputBox.setText("Do you want to play again?");
            }
        }

    }

    private void sayGoodbye() {
        outputBox.setText(rps.getGameOverString());
    }

}
