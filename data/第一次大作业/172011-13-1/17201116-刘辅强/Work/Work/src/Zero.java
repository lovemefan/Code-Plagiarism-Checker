import java.util.Scanner;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.HashMap;

public class Zero {
	static final double INF = 999999999;
	private static Scanner fileinput;
	public static void main(String[] args){
		// TODO Auto-generated method stub
//		Scanner input = new Scanner(System.in);
//		int cnt = 0;
//		String[] st = new String[100];
//			System.out.println("Please Input Operator :");
			InputStream inputfile = System.in;
			PrintStream outputfile = System.out;
			try {//���Դ��ļ�
				inputfile = new FileInputStream("input.txt");
				outputfile = new PrintStream("output.txt");
			} catch (Exception e) {
				System.err.println("ERROR\n#File not found.");
				System.exit(1);
			}
			fileinput  = new Scanner(inputfile);
			Map<String, Double> map = new HashMap<String, Double>();//��map��ƥ������ʽ�Ƿ�����˶��
			while (fileinput.hasNextLine())//�ļ��Ƿ������ĩβ
			{
				String str = fileinput.nextLine();
				str =str.replaceAll(" " ,"");
//				System.out.println(str);
//				String st = Checking(str);
				if (!Check(str))
				{
					outputfile.println("ERROR\n#" + str);
					continue ;
				}
//				System.out.println(str);
//				if (str == "-2+3")
//					System.out.println("sdsa");
//				for (int i = 1;i<=cnt&&f;i++)
//				{
//					if (st[i]==str)
//						f = false;
//				}
				if (map.get(str)==null)
				{
//					st [++cnt] = str;
					double value = Operation(str);
					if (value == INF)
						outputfile.println("ERROR\n#" + str);
					else
					{
						map.put(str, value);
						outputfile.println(str + " = " + value);
					}
				}
				else
					outputfile.println("This expression has occurred.");
			}
//			for (int i = 1;i<=cnt;i++)
//				System.out.println(st[i]);
	}
	public static boolean Check(String str)//�������ʽ�Ƿ�Ϸ�
	{
		if (str.length()==0)
			return false;
		int ans = 0;
		for (int i = 0;i <str.length();i++)
		{
			if (str.charAt(i)!=')'&&str.charAt(i)!='('&&str.charAt(i)!='*'&&str.charAt(i)!='-'&&str.charAt(i)!='+'&&str.charAt(i)!='/'&&(str.charAt(i)<'0'&&str.charAt(i)>'9'))
				return false;//�����˷Ƿ��ַ�
			if (str.charAt(i)==')')
				ans--;
			else if (str.charAt(i)=='(')
				ans++;
			if (ans<0)//���Ų�ƥ��
				return false;
		}
		if (ans != 0)//˵�����Ų�ƥ��
			return false; 
		//ƥ�����һ��������������
		if (str.length()>0)
			if ((str.charAt(str.length()-1)==')')||(str.charAt(str.length()-1)>='0'&&str.charAt(str.length()-1)<='9'))
				return true;
			else 
				return false;
		if (str.matches("[\\S]*[+-/*/][+-/*/][\\S]*")) {
			return false;
		}
		// ƥ��)�ұ������ֵ����
		if (str.matches("[\\S]*[)][0-9][\\S]*")) {
			return false;
		}
		// ƥ��(��������ֵ����
		if (str.matches("[\\S]*[0-9][(][\\S]*")) {
			return false;
		}
		// ƥ��(�ұ���*/�����
		if (str.matches("[\\S]*[(][/*+/][\\S]*")) {
			// System.out.println(s);
			return false;
		}
		// ƥ��)�����+-*/�����
		if (str.matches("[\\S]*[+-/*/][)][\\S]*")) {
			return false;
		}
		// ƥ�������
		if (str.matches("[\\S]*[(][)][\\S]*")) {
			return false;
		}//ƥ��+-*/  -  ( �ķǷ����
		//if (s.matches("[\\S]*[+-/*/][-][(][\\S]*")) {
			//return "Illegal characters appear next to right brackets.";
		//}
		return true;
	}
	public static int Priority(char c)//�ж����㸨�����ȼ�
	{
		int ans = 0;
		if (c == '-'||c == '+')
			ans = 1;
		else if (c == '*'||c == '/')
			ans = 2;
		else if (c == '(')
			ans = 3;
		return ans;
	}
	public static double Operation(String str)//����
	{
//		PrintStream outputfile = System.out;
		final int N = 100100;
		double[] num = new double [N];
		char[] pro = new char[N];
		int i = 0;
		int inttop = 0;
		int chartop = 0;
		int len = str.length();
		int temp = 0;
		int t = 0;//����Ƿ���ָ���
//		pro.Push('0');
		while (i<len||chartop != 0)
		{
			char c = ' ';
			if (i<len)
				c = str.charAt(i);
			if (c>='0'&&c<='9')
			{
				temp = temp * 10 + c - '0';
				i++;
				while (i<len)//��������
				{
					c =str.charAt(i);
					if (c>='0'&&c<='9')
					{
						temp = temp * 10 + str.charAt(i) - '0';
						i++;
					}
					else 
						break;
				}
				if (t == 2)//���Ǹ�����ı����ѹ��ջ
					temp = -temp;
				t = 1;
				num[++inttop] = temp;
				temp = 0;
			}
			else if (t==0&&c=='-')//�����Ƿ�Ϊ����
			{
				t = 2;
				i++;
			}
			else {
				if (chartop==0||(pro[chartop]=='('&&c!=')')||Priority(c)>Priority(pro[chartop]))//ѹ��ջ����������
				{
					t = 0;
					pro[++chartop] = c;
					i++;
					continue;
				}
				if (pro[chartop]== '('&&c==')')//����ջ
				{
					chartop--;
					i++;
					continue;
				}
				if ((i<len&&chartop!=0)||(pro[chartop]!='('&&c==')')||Priority(pro[chartop])>=Priority(c))//��ջ����
				{
					t = 1;
					switch(pro[chartop--])//��������
					{
						case '+':
						{
							double v1 = num[inttop--];
							double v2 = num[inttop--];
							num[++inttop] = v1 + v2;
							break;
						}
						case '-':
						{
							double v1 = num[inttop--];
							double v2 = num[inttop--];
							num[++inttop] = v2 - v1;
							break;
						}
						case '*':
						{
							double v1 = num[inttop--];
							double v2 = num[inttop--];
							num[++inttop] = v1 * v2;
							break;
						}
						case '/':
						{
							double v1 = num[inttop--];
							double v2 = num[inttop--];
							if (v1 == 0)//������������ ����������
							{
								return INF;
							}
							else 
								num[++inttop] = v2 / v1;
							break;
						}
					}
				}
			}
//			for (int j = 1;j<=inttop;j++)
//				System.out.print(num[j] + " ");
//			System.out.print("\n");
		}
//		st [++cnt] = str;
//		outputfile.println(str + " = " + num[inttop]);
		return num[inttop];
	}
}
