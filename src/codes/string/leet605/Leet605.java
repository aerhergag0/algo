package codes.string.leet605;


public class Leet605 {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int cnt = 0;

		if (n == 0) {
			return true;
		}

		for (int i = 0; i < flowerbed.length; i++) {
			if (flowerbed[i] == 0) {

				boolean emptyLeft = (i == 0) || (flowerbed[i - 1] == 0);
				boolean emptyRight = (i == flowerbed.length - 1) || (flowerbed[i + 1] == 0);

				if (emptyLeft && emptyRight) {
					flowerbed[i] = 1;
					cnt++;
					if (cnt >= n) {
						return true;
					}
					i++;
				}
			}
		}

		return cnt >= n;
	}
}
