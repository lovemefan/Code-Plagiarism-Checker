
public class RegularExpression {
		static String s= "";
		public RegularExpression(String s){
			this.s = s;
		}
		public static boolean Checking()
		{
			int ans = 0;
			for (int i = 0;i <s.length();i++)
			{
				if (s.charAt(i)==')')
					ans--;
				else if (s.charAt(i)=='(')
					ans++;
				if (s.charAt(i)!=')'&&s.charAt(i)!='('&&s.charAt(i)!='*'&&s.charAt(i)!='-'&&s.charAt(i)!='+'&&s.charAt(i)!='/'&&(s.charAt(i)<'0'&&s.charAt(i)>'9'))
					return false;
				if (ans<0)
					return false;
			}
			if (ans != 0)
				return false; 
			if (s.matches("[\\S]*[+-/*/][+-/*/][\\S]*")) {
				return false;
			}
			if (s.matches("[\\S]*[)][0-9][\\S]*")) {
				return false;
			}
			if (s.matches("[\\S]*[0-9][(][\\S]*")) {
				return false;
			}
			if (s.matches("[\\S]*[(][/*+/][\\S]*")) {
				return false;
			}
			if (s.matches("[\\S]*[+-/*/][)][\\S]*")) {
				return false;
			}
			if (s.matches("[\\S]*[(][)][\\S]*")) {
				return false;
			}
			if (s.length()>0)
				if ((s.charAt(s.length()-1)==')')||(s.charAt(s.length()-1)>='0'&&s.charAt(s.length()-1)<='9'))
					return true;
				else 
					return false;
			return true;
		}
}
