package oop.games;

import java.io.IOException;

public class TicTacToe {
	private static char[][] grid = { { '-', '-', '-' }, { '-', '-', '-' }, { '-', '-', '-' } };
	private static char Player1;
	private static char Player2;
	private static char CurrentPlayer;

	public static void initGame(char first) {
		if (first != 'O' && first != 'X') {
			throw new IllegalArgumentException("Players must be either X or O");
		}
		init();
		Player1 = first;
		if (Player1 == 'X') {
			Player2 = 'O';
		} else {
			Player2 = 'X';
		}
		CurrentPlayer = Player1;
	}

	public static void playGame() {
	}

	public static void echoGame() {
		System.out.println("   -----");
		for (int i = 0; i < 3; i++) {
			System.out.println("   |" + grid[i][0] + grid[i][1] + grid[i][2] + "|");
		}
		System.out.println("   -----");
	}

	public static char winner() {
		if (isWin()) {
			CurrentPlayer = (CurrentPlayer == Player1) ? Player2 : Player1;
			return CurrentPlayer;
		}
		return ' ';
	}

	public static boolean gameOver() {
		if (isDraw()) {
			return true;
		}
		if (isWin()) {
			return true;
		}

		return false;
	}

	private static boolean isWin() {
		for (int i = 0; i < 3; i++) {
			if (grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
				if (grid[i][0] == 'X') {
					return true;
				}
				if (grid[i][0] == 'O') {
					return true;
				}
			}
		}
		for (int j = 0; j < 3; j++) {
			if (grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j]) {
				if (grid[0][j] == 'X') {
					return true;
				}
				if (grid[0][j] == 'O') {
					return true;
				}
			}
		}
		if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
			if (grid[0][0] == 'X') {
				return true;
			}
			if (grid[0][0] == 'O') {
				return true;
			}
		}
		if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]) {
			if (grid[1][1] == 'X') {
				return true;
			}
			if (grid[1][1] == 'O') {
				return true;
			}
		}

		return false;
	}

	private static boolean isDraw() {
		int c = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (!available(i, j)) {
					c++;
				}
			}
		}
		return c > 8 ? true : false;
	}

	private static void init() {
		CurrentPlayer = ' ';
		Player1 = ' ';
		Player2 = ' ';
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = '-';
			}
		}
	}

	public static void play(int row, int col) {
		CurrentPlayer = (CurrentPlayer == Player1) ? Player2 : Player1;
		grid[row][col] = CurrentPlayer;
	}

	public static boolean available(int row, int col) {
		return grid[row][col] == '-';
	}
}