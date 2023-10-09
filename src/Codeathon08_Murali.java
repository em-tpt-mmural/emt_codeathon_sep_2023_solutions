package src;

import java.util.Date;

public class Codeathon08_Murali {
    public static void main(String arg[])  {
        String teamA[] = {"Rohit Sharma", "Shubman Gill", "Virat Kohli", "KL Rahul", "Ishan Kishan",
                "Hardik Pandya", "Ravindra Jadeja", "Washington Sundar", "Kuldeep Yadav",
                "Mohammed Siraj", "Jasprit Bumrah"};
        String teamB[] = {"Pathum Nissanka", "Kusal Perera", "Kusal Mendis", "Sadeera Samarawickrama",
                "Charith Asalanka", "Dhananjaya de Silva", "Dasun Shanaka", "Dunith Wellalage",
                "Dushan Hemantha", "Pramod Madushan", "Matheesha Pathirana"};
        CricketTeam india = new CricketTeam("India", teamA);
        CricketTeam sriLanka = new CricketTeam("Sri Lanka", teamB);
        Thread teamAThread = new Thread(india);
        Thread teamBThread = new Thread(sriLanka);
        double r = Math.random() * 10;
        double toss = r % 2;
        for(int i = 0; i < 2; i++) {
            if(toss > 0 && toss < 1) {
                if(i == 0) {
                    System.out.println("India Batting first");
                } else {
                    System.out.println("\nIndia Batting Second");
                }
                teamAThread.start();
                try {
                    teamAThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                toss = 1.5;
            } else {
                if(i == 0) {
                    System.out.println("Sri Lanka Batting first");
                } else {
                    System.out.println("\nSri Lanka Batting Second");
                }
                teamBThread.start();
                try {
                    teamBThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                toss = 0.5;
            }
        }
        if(india.totalScore > sriLanka.totalScore) {
            System.out.println("India Won By " + (india.totalScore - sriLanka.totalScore));
            System.out.println("Today date: = " + new Date());
        }
        if(sriLanka.totalScore > india.totalScore) {
            System.out.println("Sri Lanka Won By " + (sriLanka.totalScore - india.totalScore));
            System.out.println("Today date: = " + new Date());
        }
    }
}

class CricketTeam implements Runnable {
    String teamName;
    String playerName[];
    int totalScore = 0;
    int runsPerBall[];
    CricketPlayer players[];

    CricketTeam(String team, String player[]) {
        teamName = team;
        playerName = player;
        runsPerBall = new int[60];
        players = new CricketPlayer[11];
    }

    @Override
    public void run() {
        int ballsBowled = 0;
        int extras = 0;
        int totalRuns = 0;

        for (int i = 0; i < 11; i++) {
            players[i] = new CricketPlayer(teamName, playerName[i]);
            totalRuns = 0;
            int ballLength = 0;
            extras = 0;
            for (int j = 0; ballsBowled < 60; j++) {
                double random = Math.random() * 10;
                int runs = (int) random % 8;
                ballsBowled++;
                ballLength++;
                totalRuns += runs;
                if (runs == 7) {
                    extras++;
                    runs = 6;
                }
                runsPerBall[j] = runs;
                if (runs == 0) {
                    break;
                }
            }
            if (ballLength == 0) {
                players[i].runsPerBall = new int[]{0, 0, 0};
            } else {
                players[i].runsPerBall = runsPerBall;
            }
            players[i].ballsBowled = ballLength;
            players[i].extras = extras;
            players[i].totalRuns = totalRuns;
            display(players[i]);
        }
        for (int i = 0; i < 10; i++) {
            totalScore = totalScore + players[i].totalRuns;
        }
        double overs = (double) ballsBowled / 6;
        System.out.println("\nTotal Score = " + totalScore + " total Overs = " + (int) (Math.round(overs * 10)) / 10.0);
    }

    void display(CricketPlayer player) {
        System.out.print(player.playerName + " " + player.ballsBowled + "(");
        for (int i = 0; i < 60; i++) {
            System.out.print(player.runsPerBall[i]);
            if (player.runsPerBall[i] == 0) {
                break;
            } else {
                System.out.print(",");
            }
        }
        System.out.print(") = " + player.totalRuns + "  (total extra = " + player.extras + ")");
        System.out.println();
    }
}

class CricketPlayer {
    String teamName;
    String playerName;
    int ballsBowled;
    int extras;
    int[] runsPerBall;
    int totalRuns;

    CricketPlayer(String team, String player) {
        teamName = team;
        playerName = player;
        runsPerBall = new int[60];
    }
}
