package com.mailingdelgadomedina.rpssgame;

import java.util.Scanner;

public class GameDriver {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		  String player1 = "";

	       String player2 = "";

	       Scanner sc = new Scanner(System.in);

	       while ((player1.length() < 5 || player1.length() > 20) || (player2.length() < 5 || player2.length() > 20)

	               || player1.equals(player2)) {

	           System.out.println("What is the name of the first player?");

	           player1 = sc.nextLine();

	           System.out.println("What is the name of the second player?");

	           player2 = sc.nextLine();

	       }

	       Game game1 = new Game(new Player(player1), new Player(player2));

	       game1.start();
		
		

	}

}
