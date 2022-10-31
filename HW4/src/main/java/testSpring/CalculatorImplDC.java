package testSpring;

public class CalculatorImplDC implements Calculator{

	@Override
	public int factorial(int n) {
		// TODO Auto-generated method stub
		if (n == 0) {
			return 1;
		}
		else return n * factorial(n-1);
	}

	@Override
	public int fibo(int n) {
		// TODO Auto-generated method stub
		if (n == 0 || n == 1) {
			return 1;
		}
		else {
			return fibo(n-2) + fibo(n-1);
		}
	}

}
