
public class CalculatorCore {
	private double m_result;
	
	CalculatorCore()
	{
		m_result = 0;
	}
	
	public void doOperation(char operation, double number)
	{
		switch(operation)
		{
		case '+':
			m_result = m_result + number;
			break;
		case '-':
			m_result = m_result - number;
		case '*':
			m_result = m_result * number;
		case '/':
			m_result = m_result / number;
		default:
			// do nothing
		}
	}
	
	public double getResult()
	{
		return m_result;
	}
}
