import java.util.Scanner;

public class assignment0 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int loops = scanner.nextInt();
		for (int i = 0; i < loops; ++i) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int sum = a+b;
			int product = a*b;
			System.out.println(sum + " " + product);
		}
		scanner.close();
	}
}