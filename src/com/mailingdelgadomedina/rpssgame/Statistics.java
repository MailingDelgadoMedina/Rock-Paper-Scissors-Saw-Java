package com.mailingdelgadomedina.rpssgame;

public class Statistics {
	   int[] rounds = new int[4];

	   @Override

	   public String toString() {

	       String res = "\n1 for wins, -1 for loss , 0 for tie\n";

	       for (int i = 1; i <= 3; i++) {

	           res += "Round " + i + " :" + rounds[i] + " ";

	       }

	       return res;

	   }
}
