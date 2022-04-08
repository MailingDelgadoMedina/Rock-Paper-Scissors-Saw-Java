package com.mailingdelgadomedina.rpssgame;

import java.util.Scanner;

public class Game{
	  Scanner sc = new Scanner(System.in);
	  
	   Player[] players = new Player[3];

	   int[][] rulesArray = new int[5][5];// rules array 1st row is for rock,2nd row is for paper and so on

	

	  

	   Game(Player player1,Player player2){ // Game constructor

	       players[1] = player1;

	       players[2] = player2;

	       players[0] = new Player("computer");

	       rulesArray[1][1] = -1; // column refers to the opponent, rock vs rock =-1

	       rulesArray[1][2] = 0; // rock loses against paper, hence

	       // rulesArray[1][2]=0, 2nd column is for paper

	       rulesArray[1][3] = 1; // rock wins against scissors, hence

	       // rulesArray[1][3]=1, 3rd column is for

	       // scissors

	       rulesArray[1][4] = 1;

	       rulesArray[2][1] = 1;

	       rulesArray[2][2] = -1;

	       rulesArray[2][3] = 0;

	       rulesArray[2][4] = 0;

	       rulesArray[3][1] = 0;

	       rulesArray[3][2] = 1;

	       rulesArray[3][3] = -1;

	       rulesArray[3][4] = 0;

	       rulesArray[4][1] = 0;

	       rulesArray[4][2] = 1;

	       rulesArray[4][3] = 1;

	       rulesArray[4][4] = -1;

	   }

	   public void start() {

	       int sel = showmenu(); // shows the menu

	       if (sel == 1)

	           playGame();

	       else if (sel == 2) {

	           showrules();

	       } else if (sel == 3) {

	           showStat();

	       } else if (sel == 4) {

	           System.out.println("Goodbye");

	           return;

	       }
	   }

	   public void playGame() { // method to play game

	       players[1].win = 0;

	       players[2].win = 0;

	       players[1].loss = 0;

	       players[2].loss = 0;

	       players[1].stat = new Statistics();

	       players[2].stat = new Statistics();

	       int round = 1;

	       String[] weapons = new String[5]; // weapons array defines the weapons
	       while (round <= 3  ) {

	    	

	           weapons[1] = "rock";

	           weapons[2] = "paper";

	           weapons[3] = "scissors";

	           weapons[4] = "saw";
	           
	           
	           System.out.println("________________________________________________________________________________________________");

	           System.out.println("Round :" + round);

	           System.out.println("Select Weapon :" + players[1].name);

	           System.out.println("1.Rock, 2.Paper, 3.Scissors, 4.Saw");
	                   
	           int w1 = sc.nextInt(); // first player chooses weapons

	           System.out.println("________________________________________________________________________________________________");

	           
	           System.out.println("Select Weapon :" + players[2].name);

	           System.out.println("1.Rock, 2.Paper, 3.Scissors, 4.Saw");

	           int w2 = sc.nextInt(); // second player chooses weapons

	           int random = (int) (Math.random() * 4 + 1); // computer chooses a random weapon
	           System.out.println("________________________________________________________________________________________________");

	           System.out.println("computer selected :" + weapons[random]); // defines weapons depending on the number

	           System.out.println(" round " + round + ",Computer vs " + players[1].name);

	           System.out.println(players[1].name + " selected :" + weapons[w1]);
	       


	           if (rulesArray[random][w1] == 1) { // Computer chooses random, First player chooses weapon (w1), check in the rules Array

	               System.out.println("computer won");
	               System.out.println("------------------------------------------------------------------------------------------");
	               players[0].win++;

	               players[1].loss++;

	               players[1].stat.rounds[round] = -1;

	           } else if (rulesArray[random][w1] == 0) {

	               players[1].win++;

	               players[1].stat.rounds[round] = 1;

	               System.out.println(players[1].name + " won");
	               System.out.println("------------------------------------------------------------------------------------------");
	           } else {

	               players[1].stat.rounds[round] = 0;

	               System.out.println("it is a tie");
	               System.out.println("--------------------------------------------------------------------------------------------");
	           }

	           System.out.println(" round " + round + ",Computer vs " + players[2].name);

	           System.out.println(players[2].name + " selected :" + weapons[w2]);

	           if (rulesArray[random][w2] == 1) {// second player chooses w2 weapon, check in rules array

	               System.out.println("computer won");
	               System.out.println("--------------------------------------------------------------------------------------------");
	               players[0].win++;

	               players[2].loss++;

	               players[2].stat.rounds[round] = -1;

	           } else if (rulesArray[random][w2] == 0) {

	               System.out.println(players[2].name + " won");

	               players[2].win++;

	               players[2].stat.rounds[round] = 1;

	           } else {

	               System.out.println("it is a tie");

	               players[2].stat.rounds[round] = 0;

	           }

	           round++;

	       }

	       System.out.println("Over All Winner : "); // calculate the overall winner

	       if (players[1].win > players[2].win) {

	           System.out.println(players[1].name + " won ");

	       } else if (players[2].win > players[1].win) {

	           System.out.println(players[2].name + " won ");

	       } else {

	           if (players[1].loss > players[2].loss)

	               System.out.println(players[2].name + " won ");

	           else if (players[2].loss > players[1].loss)

	               System.out.println(players[1].name + " won ");

	           else

	               System.out.println("It is a tie");

	       }

	       start();

	   }

	   public void showrules() {
		   			System.out.println("-----------------------------------------------------------------------------------------------");
		   			System.out.print("Two players will play against computers for three rounds:");

	    		   System.out.println("For each round every player will select a weapon, and computer will select a random weapon.");

	               System.out.println("Rock breaks scissors and Saw therefore rock wins over scissors and saw. Rock loses against paper.");

	               System.out.println( "Scissors cut paper therefore scissors win over paper. Scissors lose against rock and Saw.");

	               System.out.println("Paper covers rock therefore paper wins over rock. Paper loses against scissors and saw");

	               System.out.println( "Saw cuts through scissors and paper therefore saw wins over scissors and paper. Saw loses against rock.");

	               System.out.println( "If player and computer make the same selection, there is a tie");

	               System.out.println("Player with most number of wins against computer wins.");
	               System.out.println("-----------------------------------------------------------------------------------------------");
	       start();

	   }

	   public void showStat() {
		   System.out.println("***********************************************************************************************");

	       System.out.println(players[1].name + " wins :" + players[1].win + " times, loses " + players[1].loss + " times "

	               + players[1].stat);
           System.out.println("--------------------------------------------------------------------------------------------");

	       System.out.println(players[2].name + " wins :" + players[2].win + " times, loses " + players[2].loss + " times "

	               + players[2].stat);
	       System.out.println("***********************************************************************************************");

	       start();

	   }

	   public int showmenu() {

	       System.out.println("1.Play Game");

	       System.out.println("2.Show Game Rules");

	       System.out.println("3.Show statistics");

	       System.out.println("4.Exit");

	       int sel = sc.nextInt();

	       return sel;

	   }
	       
	       
	       
}
