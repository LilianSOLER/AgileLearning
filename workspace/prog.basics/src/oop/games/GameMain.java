package oop.games;

import java.io.IOException;

public class GameMain {

  public static void main(String args[]) throws IOException {
    Utils.initUtils();
    System.out.println("Hello!");
    while (true) {
      System.out.println("What do you want to play:");
      System.out.println("  0) Nothing, I am done");
      System.out.println("  1) Tic Tac Toe");
      int i;
      i = Utils.readInt();
      switch (i) {
      case 0:
        System.out.println("OK, bye now.");
        return;
      case 1:
        System.out.println("OK, let's play TicTacToe then...");
        TicTacToe.initGame('X');
        TicTacToe.playGame();
        break;
      default:
        System.out.println("I am sorry, I don't understand.");
        break;
      }
    }
  }

}
