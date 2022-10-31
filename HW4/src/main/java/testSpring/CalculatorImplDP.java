package testSpring;

public class CalculatorImplDP implements Calculator {

	@Override
	public int factorial(int n) {
		// TODO Auto-generated method stub
		int result = 1;
		for (int i = 1; i < n; i++) {
			result *= i;
		}
		return result;
	}

	@Override
	public int fibo(int n) {
		// TODO Auto-generated method stub
		int result = 0;
		int previos = 0, current = 1;
		
		for (int i = 1; i <= n; i++) {
			result = previos + current;
			previos = current;
			current = result;
		}
		return result;
	}

}
