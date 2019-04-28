package dazuoye1;

import java.io.File;
import java.util.regex.Pattern;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import java.util.regex.Matcher;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Cal_1 {
	
	
	public void readLine(File f1, String[] shushi) {
		int i = 0;
		int j = 0;
		String str = null;/* ���ڽ����ļ���Ϣ�в���Ҫ����Ϣ */
		try (Scanner input = new Scanner(f1);){
			while(input.hasNextLine()) {
				str = input.next();//���ղ�Ҫ�����
				shushi[i] = input.nextLine();//��ʽ��д��
				shushi[i] = shushi[i].replaceAll("\\s", "");//��ʽ�������еĿո�ȥ��
				i++;
			}
			for ( i=0; i<shushi.length; i++ ) 
			{
				for (  j=i+1; j<shushi.length; j++ ) {
					if ( String.valueOf( shushi[i] ).equals( String.valueOf(shushi[j]) ))
					{
						shushi[j] = null;
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void readrecords(File f2) {
		int i = 0;
		String str = null;/* ���ڽ����ļ���Ϣ�в���Ҫ����Ϣ */
		try (Scanner input = new Scanner(f2);){
			while(input.hasNextLine()) {
				String s = input.nextLine();
				System.out.println(s);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Object compute(String shushi) throws ScriptException {//���ų�������������ʽ-
		String str = shushi;
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Object result = engine.eval(str);
		return result;
	}

	boolean UnmatchBrackets(String shushi) {// ������Ų�ƥ�䣬�򷵻� true;���򷵻�false
		int len = shushi.length();
		LinkedList<Character> stack = new LinkedList<Character>();
		// ѭ�������ַ���
		for (int i = 0; i < len; i++) {
			// ���������������ջ
			char  ch = (char) shushi.charAt(i);
			if (ch == '(') {
				stack.push(ch);
				// �����������
			} else if (ch == ')') {
				// ջ�գ���������û��ƥ��������ţ��򷵻�false
				if (stack.isEmpty()) {
					return true;
					// ջ���գ����ջ���Ƚ�
				} else if (stack.peek().equals(ch)) {
					return true;
				} else {
					stack.pop();
				}
			}
		}
		// ѭ��������ջ�ձ�ʾƥ�����ˣ����ձ�ʾ����������
		if (stack.isEmpty()) {
			return false;
		} else {
			return true;
		}

	}

	
	
	public void write ( File f2 , String[] shushi ) throws ScriptException
	{
		int i=0;
		/*������ʽ��ƥ������*/
		
		String regex1 = "";//���ַ�
		String regex2 = "\\(\\)";//������
		String regex3 = "[0-9\\\\.+-/*()= ]+";//�Ƿ��ַ�
		String regex4 = ".*[\\/\\*\\-\\+]{2,}.*";//���������
		String regex5 = "^[\\+\\-\\*\\/\\)].*";//�����ǰ��������
		String regex6 = ".*[\\(\\+\\/\\*\\-]";//���������������
		String regex7 = ".+\\d\\(.*";//����ǰ�������,�����Ų��ǵ�һ��
		String regex8 = ".+\\)\\d.*";//���ź��������
		/*���ж��Ƿ�����ȷ�ı��ʽ������Ǵ���ģ�������ȥ���Ŵ����������ȷ�ģ������ȥ���Ŵ���*/
		try ( PrintWriter output = new PrintWriter ( f2 ) )
		{
			while ( i<shushi.length-1 )
			{
				if ( shushi[i] != null )
				{
					boolean str = UnmatchBrackets(shushi[i]);
					if ( shushi[i].matches(regex1) == true )
					{
						output.println("���ʽΪ: ��"+shushi[i]);
						output.println( "ERROR");
						output.println("#���ʽΪ��");
						output.println(" ");
						
					}
					else if ( shushi[i].matches(regex2) == true ) {
						output.println("���ʽΪ: "+shushi[i]);
						output.println("ERROR");
						output.println("#���ʽ���п����� ");
						output.println(" ");
					}
					else if ( shushi[i].matches(regex3) == false ) {
						output.println("���ʽΪ: "+shushi[i]);
						output.println("ERROR ");
						output.println("#���ʽ�����Ƿ��ַ� ");
						output.println(" ");
					}
					else if ( str == true ) {
						output.println("���ʽΪ: "+shushi[i]);
						output.println("ERROR ");
						output.println("#���Ų�ƥ�� ");
						output.println(" ");
					}
					else if ( shushi[i].matches(regex4) == true ) {
						output.println("���ʽΪ: "+shushi[i]);
						output.println("ERROR ");
						output.println("#���������");
						output.println(" ");
					}
					else if ( shushi[i].matches(regex5) == true ) {
						output.println("���ʽΪ: "+shushi[i]);
						output.println("ERROR ");
						output.println("#�����ǰ��������");	
						output.println(" ");
					}
					else if ( shushi[i].matches(regex6) == true ) {
						output.println("���ʽΪ: "+shushi[i]);
						output.println("ERROR ");
						output.println("#���������������");
						output.println(" ");
					}
					else if ( shushi[i].matches(regex7) == true ) {
						output.println("���ʽΪ: "+shushi[i]);
						output.println("ERROR ");
						output.println("#���ŷǵ�һ���ַ���֮ǰ�������");
						output.println(" ");
	
					}
					else if ( shushi[i].matches(regex8) == true ) {
						output.println("���ʽΪ: "+shushi[i]);
						output.println("ERROR ");
						output.println("#С���ź�������������ŷ����һ���ַ�");
						output.println(" ");
					}
					else 
					{
						String m = shushi[i];
						Object num = compute(m);
						output.println("���Ϊ��"+shushi[i]+"="+num);
						output.println(" ");
					}
				}
				i++;
			}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public static void main(String[] args) throws ScriptException {
		// TODO Auto-generated method stub
		String shushi[] = new String[50];
		String biaodashi [] = new String[ shushi.length ];
		Cal_1 fo = new Cal_1();
		File f1 = new File("src\\jisuanshi");
		fo.readLine(f1, shushi);
		File f2 = new File("src\\jieguo");
		fo.write(f2, shushi);
		int i=0;
		System.out.println("�ü������Ѵ�����\\\\src\\\\jieguo��!");
		System.out.println("");
		fo.readrecords(f2);
	}

}
