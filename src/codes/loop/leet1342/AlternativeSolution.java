package codes.loop.leet1342;

public class AlternativeSolution {
	public int numberOfSteps (int num) {
		return Integer.toBinaryString(num).length() - 1 + Integer.bitCount(num);
	}
}
