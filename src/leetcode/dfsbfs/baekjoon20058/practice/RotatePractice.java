package leetcode.dfsbfs.baekjoon20058.practice;

public class RotatePractice {
	public static void main(String[] args) {
		int n = 16;
		int[][] board = new int[n][n];
		int cnt = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = cnt;
				cnt++;
			}
		}

		int divideGridSize = 4;

		printBoard(board);

		for (int i = 0; i < n; i += divideGridSize) {
			for (int j = 0; j < n; j += divideGridSize) {
				rotateSubgrid(board, i, j, divideGridSize);
			}
		}

		printBoard(board);
	}

	private static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.printf("%4d ", board[i][j]);
			}
			System.out.println();
		}

		System.out.println();
	}

	private static void rotateSubgrid(int[][] board, int rowStart, int colStart, int size) {
		int[][] temp = new int[size][size];

		// 부분 그리드를 temp에 복사
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				temp[j][size - 1 - i] = board[rowStart + i][colStart + j];
			}
		}

		// 회전된 부분을 원래 보드에 다시 복사
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				board[rowStart + i][colStart + j] = temp[i][j];
			}
		}
	}
}
