package leetcode.dfsbfs.baekjoon20058;

import java.io.*;
import java.util.Arrays;

public class Baekjoon20058 {

	static int N;
	static int Q;
	static int[][] iceBoard;
	static int[] L;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			String[] s = br.readLine().split(" ");
			N = Integer.parseInt(s[0]);
			Q = Integer.parseInt(s[1]);
			iceBoard = new int[(int) Math.pow(2, N)][(int) Math.pow(2,N)];

			for (int i=0; i< iceBoard.length; i++) {
				String[] ices = br.readLine().split(" ");
				for (int j = 0; j < iceBoard.length; j++) {
					iceBoard[i][j] = Integer.parseInt(ices[j]);
				}
			}

			L = new int[Q];
			String[] Larr = br.readLine().split(" ");
			for (int i = 0; i < L.length; i++) {
				L[i] = Integer.parseInt(Larr[i]);
			}

			for (int i = 0; i < Q; i++) {
//				tornado(L[i]);
//				fireball();
			}

			System.out.println(Arrays.deepToString(iceBoard));
		}
	}

//	private static int[][] tornado(int L) {
//
//		// 격자 단위 길이
//		int gridLen = (int) Math.pow(2,L);
//		for(int i = 0; i< (int) Math.pow(2, N-L); i++) {
//
//		}
//
//	}

//	private int[][] rotate() {
//
//	}
//
//	private static int[][] fireball() {
//	}
}
