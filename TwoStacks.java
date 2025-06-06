
import java.util.Scanner;

public class TwoStacks {
	static int top1 = -1;
	static int top2;
	static Scanner sc = new Scanner(System.in);

	public static boolean push1(int[] arr, int size) {
		if (top1 + 1 != top2) {
			top1++;
			System.out.println("Enter num to add in Stack1: ");
			arr[top1] = sc.nextInt();
			System.out.println("*****************");
			for (int i = 0; i <= top1; i++) {
				System.out.println(arr[i] + " at " + i);
			}
			return true;
		} else {
			System.out.println("Stack is full NOW");
			return false;
		}

	}

	public static boolean push2(int[] arr, int size) {
		if (top2 - 1 != top1) {
			top2--;
			System.out.println("Enter num to add in Stack2: ");
			arr[top2] = sc.nextInt();
			System.out.println("*****************");
			for (int i = size - 1; i >= top2; i--) {
				System.out.println(arr[i] + " at " + i);
			}
			return true;
		} else {
			System.out.println("Stack is full NOW");
			return false;
		}

	}

	// POP methods
	public static boolean pop1(int[] arr) {
		int popped1;
		if (top1 == -1) {
			System.out.println("Stack1 is already empty");
			return false;
		}
		popped1 = arr[top1];		
		System.err.println();
		System.out.println("Value popped from " + top1 + " is : " + arr[top1]);
		top1--;
		return true;
	}

	public static boolean pop2(int[] arr, int size) {
		int popped2;
		if (top2 == size) {
			System.out.println("Stack2 is already empty");
			return false;
		}
		popped2 = arr[top2];
		System.err.println();
		System.out.println("Value popped from " + top2 + " is : " + arr[top2]);
		top2++;
		return true;
	}

	public static void main(String[] args) {
		int[] arr = new int[6];
		int size = arr.length;

		// Defining Tops
		top2 = size;
		outerloop: while (true) {
			boolean success;
			System.out.println("Press 1 to add in stack 1");
			System.out.println("Press 2 to add in stack 2");
			System.out.println("Press 3 to pop from stack 1");
			System.out.println("Press 4 to pop from stack 2");
			int choice = sc.nextInt();
			SWITCH:
			switch (choice) {
				case 1:
					success = push1(arr, size);
					if (!success)
						break SWITCH;
					break;
				case 2:
					success = push2(arr, size);
					if (!success)
						break SWITCH;
					break;
				case 3:
				    success = pop1(arr);
					if(!success) break SWITCH;
					break;
				case 4:
				    success = pop2(arr, size);
					if(!success) break SWITCH;
					break;
				default:
					System.err.println("Exitting !!! !!! !!!");
					return;
			}
		}
	}
}