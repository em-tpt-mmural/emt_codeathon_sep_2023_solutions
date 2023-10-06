package src;

import java.util.*;
class CricketMatch {
    private static final int totalBallsPerOver = 6;
    private static final int toalOvers = 10;
    private static final int totalBatsmen = 11;

    private int team1Score = 0;
    private int team2Score = 0;
    private int team1Wickets = 0;
    private int team2Wickets = 0;
    private String[] team1Players = {"Rohit Sharma", "Shubman Gill", "Virat Kohli", "KL Rahul", "Ishan Kishan", "Hardik Pandya", "Ravindra Jadeja", "Washington Sundar", "Kuldeep Yadav", "Mohammed Siraj","jasprit Bumrah"};
    private String[] team2Players = {"Pathumn Nissanka", "Kusal Perera", "Kusal Mendis", "Sadeera Samarawickrama", "Charith Asalanka", "Dhananjaya de Silva", "Dasun Shanaka", "Dunith Wellalage", "Dushan Hemantha", "Pramod Madushan","Mateesha"};
    private Random r = new Random();
    public synchronized void playInnings(String teamName, String[] players) {
        System.out.println(teamName + " is batting first");
        int totalRuns = 0;
        int wickets = 0;
        for (int over = 1; over <= toalOvers; over++) {
            System.out.println("Over " + over);
            for (int ball = 1; ball <= totalBallsPerOver; ball++) {
                int run = r.nextInt(8); // 0 to 7
                if (run == 0) {
                    wickets++;
                    System.out.println(players[wickets - 1] + " is out!");
                    if (wickets == totalBatsmen) {
                        break;
                    }
                } else {
                    totalRuns += run;
                    System.out.println(players[wickets] + " scored " + run);
                }
            }
        }
        if (teamName.equals("India")) {
            team1Score = totalRuns;
            team1Wickets = wickets;
        } else {
            team2Score = totalRuns;
            team2Wickets = wickets;
        }
    }
    public void startMatch() {
        double toss = Math.random() * 2;
        if (toss < 1) {
            System.out.println("toss won by India");
            playInnings("India", team1Players);
            playInnings("Sri Lanka", team2Players);
        } else {
            System.out.println("toss won by Sri Lanka");
            playInnings("Sri Lanka", team2Players);
            playInnings("India", team1Players);
        }
        System.out.println("india-batting scoresheet");
        display("India", team1Players, team1Score, team1Wickets);
        System.out.println("Sri Lanka - batting scoresheet");
        display("Sri Lanka", team2Players, team2Score, team2Wickets);
        if (team1Score > team2Score) {
            System.out.println("Match Result: Team 1 (India) Won By " + (team1Score - team2Score) + " Runs");
        } else if (team1Score < team2Score) {
            System.out.println("Match Result: Team 2 (Sri Lanka) Won By " + (team2Score - team1Score) + " Runs");
        } else {
            System.out.println("match result: match tied");
        }
    }
    private void display(String teamName, String[] players, int totalScore, int wickets) {
        for (int i = 0; i < players.length; i++) {
            System.out.println(players[i] + " " + getRandomScore(players[i]) + " (" + (i < wickets ? "Out" : "Not Out") + ")");
        }
        System.out.println("Extras " + getRandomScore("Extras") + " Total Score " + totalScore + " in " + (wickets > 0 ? (toalOvers - 1) : toalOvers) + " overs");
    }
    private String getRandomScore(String playerName) {
        StringBuilder scorecard = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int run = r.nextInt(8);
            if (run == 7) {
                scorecard.append("E,");
            } else {
                scorecard.append(run).append(" ");
            }
        }
        scorecard.deleteCharAt(scorecard.length() - 1);
        return playerName + " " + scorecard.toString();
    }
}
public class Codeathon08_Murali {
    public static void main(String[] args) {
        CricketMatch cm = new CricketMatch();
        cm.startMatch();
        System.out.println("won the cup");
    }
}
