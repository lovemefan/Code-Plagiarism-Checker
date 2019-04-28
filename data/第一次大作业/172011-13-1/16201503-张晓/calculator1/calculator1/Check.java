package calculator1;

public class Check {
	 
	public boolean orderOperations(char b1, char b2) // 运算顺序
	{
		if (b1 == '+') {
			if (b2 == '+')
				return true;
			else if (b2 == '-')
				return true;
			else if (b2 == '*')
				return false;
			else if (b2 == '/')
				return false;
			else if (b2 == '(')
				return false;
			else if (b2 == ')')
				return true;
		} else if (b1 == '-') {
			if (b2 == '+')
				return true;
			else if (b2 == '-')
				return true;
			else if (b2 == '*')
				return false;
			else if (b2 == '/')
				return false;
			else if (b2 == '(')
				return false;
			else if (b2 == ')')
				return true;
		} else if (b1 == '*') {
			if (b2 == '+')
				return true;
			else if (b2 == '-')
				return true;
			else if (b2 == '*')
				return true;
			else if (b2 == '/')
				return true;
			else if (b2 == '(')
				return false;
			else if (b2 == ')')
				return true;
		} else if (b1 == '/') {
			if (b2 == '+')
				return true;
			else if (b2 == '-')
				return true;
			else if (b2 == '*')
				return true;
			else if (b2 == '/')
				return true;
			else if (b2 == '(')
				return false;
			else if (b2 == ')')
				return true;
		} else if (b1 == '(') {
			if (b2 == '+')
				return false;
			else if (b2 == '-')
				return false;
			else if (b2 == '*')
				return false;
			else if (b2 == '/')
				return false;
			else if (b2 == '(')
				return false;
			else if (b2 == ')')
				return true;
		} else if (b1 == ')') {
			return true;
		}
		return false;
	}
}


