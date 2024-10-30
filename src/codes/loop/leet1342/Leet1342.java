package codes.loop.leet1342;

public class Leet1342 {
	public int numberOfSteps(int num) {
		int cnt = 0;
		int n = num;

		while (n != 0) {
			if (n % 2 == 0) {
				n /= 2;
				cnt++;
			} else {
				n -= 1;
				cnt++;
			}
		}

		return cnt;
	}
}
