package com.watsonas.codility;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountNonDivisibleWithVirtualThreads {

	static ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

	public static int[] solution(int[] A) {
		int[] result = new int[A.length];

		for (int i = 0; i < A.length; i++) {
			int target = A[i];
			final int targetIndex = i;

			executor.submit(() -> {
				int divisors = 0;
				for (int j = 0; j < A.length; j++) {
					if (A[j] == 1 || A[j] == target) {
						divisors++;
					} else {
						if ((target % A[j]) == 0) {
							divisors++;
						}
					}
					result[targetIndex] = A.length - divisors;
				}

			});
		}

		try {
			executor.shutdown();
			executor.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
		}

		return result;
	}
}
