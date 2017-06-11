import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

	private static CalculatorCore calculator = new CalculatorCore();
	
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the Calculator:");
		char command = '+';
		double number = 0.0d;
		
		while (command != 'q')
		{
			if (command == '=')
				printResult();
			else {
				number = requestNumber();
				calculator.doOperation(command, number);
			}
				command = requestOperation();
		}
	}
	
	private static double requestNumber() throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("[number] ? ");
		String line = bufferedReader.readLine();
		return Double.parseDouble(line);
	}
	
	private static char requestOperation() throws IOException
	{
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("[operation] ? ");
		String line = bufferedReader.readLine();
		return line.charAt(0);
	}
	
	private static void printResult()
	{
		System.out.println("[result] >> " + calculator.getResult());
	}

}
