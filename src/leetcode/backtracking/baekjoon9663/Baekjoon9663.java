package leetcode.backtracking.baekjoon9663;

import java.io.*;

public class Baekjoon9663 {

	public static int N;
	public static int count;
	public static int[] board;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		board = new int[N];

		nQueen(0);
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
	}

	private static void nQueen(int row) {
		if (row == N) {
			count++;
			return;
		}

		for (int col = 0; col < N; col++) {
			if (checkValid(row, col)) {
				board[row] = col;
				nQueen(row + 1);
			}
		}

	}

	private static boolean checkValid(int row, int col) {
		for (int i=0; i< row; i++) {
			if (board[i] == col || Math.abs(board[i] - col) == Math.abs(i - row)) {
				return false;
			}
		}

		return true;
	}
}
