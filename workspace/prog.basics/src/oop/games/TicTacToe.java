package oop.games;

import java.io.IOException;

public class TicTacToe {
  
  public static char[] array = { ' ', ' ', ' ' };
  public static char[][] grid = {array,array,array};
  
  public static char Player1;
  public static char Player2;
  
  public static boolean firstTurn = true;
  public static int turn = 0;
  
  public static int row;
  public static int col;
  
  public static boolean isWin = false;

  public static void initGame(char first) {
	  if(first != 'X' && first != 'O') {
		  throw new IllegalArgumentException("Players must be X or O");
	  }
	  char second = 'X';
	  Player1 = first;
	  if(first == 'X') {
		  second = 'O';
	  }
	  Player2 = second;
	  initGrid();	  
	  firstTurn = true;
	  turn = 0;
	  isWin = false;
  }
  
  public static void initGrid() {
	  for(int i = 0; i < 3 ; i++) {
		  for(int j = 0; j < 3; j++) {
			  grid[i][j] = ' ';
		  }
	  }
  }
  
  public static void playGame() throws IOException {
	  while(turn < 9 || !isWin) {
		  displayPlayerTurn();
		  askPlayerCoord();
		  displayGrid();
	  }
  }
	  
  
  public static void displayPlayerTurn() {
	  System.out.print("Player ");
	  if(firstTurn) {
		  System.out.print(Player1);
	  } else {
		  System.out.print(Player2);
	  }
	  System.out.println(" : row, col ?");
  }
  
  public static void askPlayerCoord() throws IOException {
	  readPlayerCoord();
	  while(!Character.isDigit(row)||!Character.isDigit(col)) {
		  System.out.println("You can't play in this coordinates.\n"
		  		+ "You must write row and col between 1 and 3");
		  readPlayerCoord();
	  }
	  while(grid[row][col] != ' ') {
		  System.out.println("You can't play in this coordinates.\n"
			  		+ "You must write row and col that are not already taken");
		  readPlayerCoord();
	  }
	  firstTurn = !firstTurn;
	  turn += 1;
  }
  
  public static void readPlayerCoord() throws IOException{
	  char[] Coords = Utils.readLine().replaceAll(" ", "").replaceAll(",", "").toCharArray();
	  row = Coords[0];
	  col = Coords[1];
  }
  
  public static void displayGrid() {
	  System.out.println("-----");
	  for(int i = 0; i < 3; i++) {
		  System.out.print("|");
		  for(int j = 0; j < 3; j++) {
			  System.out.print(grid[i][j]);
		  }
		  System.out.println("|");
	  }
	  System.out.println("-----");
  }
}
