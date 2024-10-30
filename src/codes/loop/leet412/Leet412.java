package codes.loop.leet412;

import java.util.ArrayList;
import java.util.List;

public class Leet412 {
	public List<String> fizzBuzz(int n) {
		List<String> answer = new ArrayList<String>();

		for (int i = 1; i <= n; i++) {
			if (isFizz(i) && isBuzz(i)) {
				answer.add("FizzBuzz");
			} else if (isFizz(i) && !isBuzz(i)) {
				answer.add("Fizz");
			} else if (!isFizz(i) && isBuzz(i)) {
				answer.add("Buzz");
			} else {
				answer.add(String.valueOf(i));
			}
		}

		return answer;
	}

	private boolean isFizz(int i) {
		return i % 3 == 0;
	}

	private boolean isBuzz(int i) {
		return i % 5 == 0;
	}
}
