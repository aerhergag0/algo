package leetcode.dfsbfs.baekjoon20058.practice.ex1;

public class RotatePracticeEx1 {
	public static void main(String[] args) {
		int n = 16;
		int subGridSize = 4;

		int [][] board = new int[n][n];
		int cnt= 1;
		for (int i = 0; i < board.length ; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = cnt;
				cnt++;
			}
		}

		printBoard(board);

	}

	private static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.printf("%4d", board[i][j]);
			}

			System.out.println();
		}
	}
}
