import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class HelloWorld {
	public static void main(String[] args) throws IOException
	{
		
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String line = bufferedReader.readLine();
		System.out.println("Hello World " + line);
	}
}
