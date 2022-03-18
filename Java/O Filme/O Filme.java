import java.io.IOException;
import java.util.Scanner;

public class Dio {
	public static void main(String[] args) {
		double a, b, c;
		a = STDIN_SCANNER.nextDouble();
		b = STDIN_SCANNER.nextDouble();
		c = ((b - a) * 100.00) / a;
		System.out.printf("%.2f%%\n", c);
	}

	public final static Scanner STDIN_SCANNER = new Scanner(System.in);
}