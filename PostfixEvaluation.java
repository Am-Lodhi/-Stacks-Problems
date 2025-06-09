import java.util.Stack;

class PostfixEvaluation {

	public static int add(int num1, int num2) {
		return num2 + num1;
	}

	public static int difference(int num1, int num2) {
		return num2 - num1;
	}

	public static int product(int num1, int num2) {
		return num2 * num1;
	}

	public static int quotient(int num1, int num2) {
		return num2 / num1;
	}

	public static void main(String[] args) {
		String exp = "562+*3-";
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < exp.length(); i++) {
			if (Character.isDigit(exp.charAt(i))) {
				// Conver to Integer
				int num = exp.charAt(i) - '0';
				stack.push(num);
			} else {
				char choice = exp.charAt(i);

				int num1 = stack.pop();
				int num2 = stack.pop();

				switch (choice) {
					case '+':
						stack.push(add(num1, num2));
						break;
					case '-':
						stack.push(difference(num1, num2));
						break;
					case '*':
						stack.push(product(num1, num2));
						break;
					case '/':
						stack.push(quotient(num1, num2));
						break;
					default:
						System.out.println("Invalid...");
						break;
				}
			}
		}
		System.out.println("Your answer is: " + stack.pop());
	}

}