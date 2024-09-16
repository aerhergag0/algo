package leetcode.leet1195;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;

public class Leet1195 {
	private int n;
	private int currentNumber = 1;

	public Leet1195(int n) {
		this.n = n;
	}

	// printFizz.run() outputs "fizz".
	public synchronized void fizz(Runnable printFizz) throws InterruptedException {
		while (currentNumber <= n) {
			if (currentNumber % 3 != 0 || currentNumber % 5 == 0) {
				wait();
				continue;
			}
			printFizz.run();
			currentNumber += 1;
			notifyAll();
		}
	}

	// printBuzz.run() outputs "buzz".
	public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
		while (currentNumber <= n) {
			if (currentNumber % 5 != 0 || currentNumber % 3 == 0) {
				wait();
				continue;
			}
			printBuzz.run();
			currentNumber += 1;
			notifyAll();
		}
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		while (currentNumber <= n) {
			if (currentNumber % 15 != 0) {
				wait();
				continue;
			}
			printFizzBuzz.run();
			currentNumber += 1;
			notifyAll();
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public synchronized void number(IntConsumer printNumber) throws InterruptedException {
		while (currentNumber <= n) {
			if (currentNumber % 3 == 0 || currentNumber % 5 == 0) {
				wait();
				continue;
			}
			printNumber.accept(currentNumber);
			currentNumber += 1;
			notifyAll();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Leet1195 data = new Leet1195(15);
		List<String> answer = new ArrayList<>();
		Thread thread1 = new Thread(() -> {
			try {
//				data.fizz(() -> System.out.print("fizz"));
				data.fizz(() -> answer.add("fizz"));
			} catch (Exception e) {
			}
		});
		Thread thread2 = new Thread(() -> {
			try {
//				data.buzz(() -> System.out.print("buzz"));
				data.buzz(() -> answer.add("buzz"));
			} catch (Exception e) {
			}
		});
		Thread thread3 = new Thread(() -> {
			try {
//				data.fizzbuzz(() -> System.out.print("fizzbuzz"));
				data.fizzbuzz(() -> answer.add("fizzbuzz"));
			} catch (Exception e) {
			}
		});
		Thread thread4 = new Thread(() -> {
			try {
//				data.number(i -> System.out.print(i));
				data.number(i -> answer.add(String.valueOf(i)));
			} catch (Exception e) {
			}
		});
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread1.join();
		thread2.join();
		thread3.join();
		thread4.join();

		System.out.println(answer);
	}

}
