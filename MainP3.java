//Anthony Franklin afranklin18@cnm.edu
//RockPS Frame Program plays rock paper scissors using embedded layout managers
//MainP3.java

//02/22/2022

import javax.swing.JFrame;

public class MainP3 {
    public static void main(String[] args) {
        RockPS rps = new RockPS();
        RockFrame frame = new RockFrame(rps);
        frame.setTitle("Anthony Franklin - P3: Rock Paper Scissors");
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
