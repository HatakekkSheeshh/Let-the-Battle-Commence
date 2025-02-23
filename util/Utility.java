// package util;  

public class Utility {
	/**
	 * Test whether a specific number is a prime number.
	 * 
	 * @param num
	 *            the number
	 * @return <code>true</code> if <code>num</code> is a prime number.
	 */
	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		}
		for (int i = 2; i < num / 2; i++) {
			if (num % i == 0){
				return false;
			}
		}
		return true;
	}

	/**
	 * Test whether a specific number is a square number.
	 * 
	 * @param num
	 *            the number
	 * @return <code>true</code> if <code>num</code> is a square number.
	 */
	public static boolean isSquare(int num) {
		int x = (int) Math.sqrt(num);
		return x * x == num;
	}

	/**
	 * Test whether a specific number is a regular number.
	 * 
	 * @param num
	 *            the number
	 * @return <code>true</code> if <code>num</code> is a regular number.
	 */
	public static boolean isFibo(int num, int[] count) {
		if(num == 1 || num == 0) return true;

		int prev = 1;
		int curr = 1;
		count[0] = 2;
		while (curr <= num) {
			int next = prev + curr;
			count[0]++;
			if(next == num){
				return true;
			}
			prev = curr;
			curr = next;
		}
		return false;
	}

	/**
	 * 
	 * @param num
	 *            the number
	 * @return <code>true</code> if <code>num</code>  > GROUND_BOUNND = 999.
	 */
	public static boolean exceedBound(double num) {
		if(num > 999) return true;
		return false;
	}
}
