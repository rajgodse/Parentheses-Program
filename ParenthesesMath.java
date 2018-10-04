//Do the weird parentheses math
import java.io.*;
public class ParenthesesMath {
	
	public String problem;
	public String[] stringArray;
	
	public ParenthesesMath(String input) {
		problem = input;
	}
	
	public int calcPrecedence(String thing) {
		int counter = 0;
		int max_counter = 0;
		for (int i = 0; i < thing.length(); i++) {
			if (thing.charAt(i) == '(')
				counter++;
			else
				counter--;
			if (counter > max_counter)
				max_counter = counter;
		}
		return max_counter;
	}
	
	public String calculate() {
		int plusPos = 0;
		String dummy = problem.substring(0, problem.indexOf('+') - 1);
		while(problem.indexOf('+', plusPos + 1) > -1) {
			plusPos = problem.indexOf('+', plusPos + 1);
			String dumber;
			if (problem.indexOf(' ', plusPos + 2) > -1)
				dumber = problem.substring(plusPos + 2, problem.indexOf(' ', plusPos + 2));
			else
				dumber = problem.substring(plusPos + 2);
			if (calcPrecedence(dumber) > calcPrecedence(dummy))
				dummy = "(" + dummy + dumber.substring(1);
			else if (calcPrecedence(dumber) == calcPrecedence(dummy)) {
				dummy = dummy + dumber;
			}
			else
				dummy = dummy.substring(0, dummy.length() - 1) + dumber + ")";
		}
		return dummy;
	}
	
	public String toString() {
		return "Your answer is " + calculate();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter problem: ");
		ParenthesesMath calculator = new ParenthesesMath(input.readLine());
		
		System.out.println(calculator.toString());
	}
}
