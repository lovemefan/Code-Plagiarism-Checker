package ����ҵ;
/**
 * 
 * @author ����ʯ
 * 
 */
import java.util.Stack;

import ����ҵ.InfixToPostfix;
import ����ҵ.Examine;
import ����ҵ.Io;
import ����ҵ.PostfixToResult;

public class Main {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>();
		Io o = new Io();
		String accept = o.fileReader();
		accept = accept.replaceAll(" ", "");//�ѽ��յ���������ո�ȥ��
		String regex = "\\s";
		String[] input = accept.split(regex);//���յ��Ķ������ʽ���зָ�����ַ���������
		String re = "";
		String err = "";
		String rep = "";
		int j = 0;
		Examine[] exa = new Examine[input.length];
		for (int i = 0; i < input.length; i++) {
			System.out.println(input[i]);
			if (i>0){//�������ظ�������ʽ
				if(input[i].equals(input[i-1])){
					System.out.println("ERROR\n#�����ظ�");
					rep = input[i] + "=" + "\r\n" + "ERROR\r\n#�����ظ�";
					j++;
				}
			}
			if(j==0){//����ظ�ֱ�����������ж�
				exa[i] = new Examine(input[i]);
				exa[i].examine(input[i]);
				if (exa[i].flag ) {
					InfixToPostfix infix = new InfixToPostfix(stack, input[i]);
					infix.change();
					String post = infix.getPost();
					Stack<Double> postResult = new Stack<>();
					PostfixToResult res = new PostfixToResult(post, postResult);
					res.operate();
					String  result = String.valueOf(res.getResult());
					res.denominator(result);
					re = input[i] + "=" + res.denominator(result) + " ";
					System.out.println(re);
				}else{
					err = input[i] + "=" + "\r\n" + exa[i].say[exa[i].i];
				}
			}
			
			String all = rep + re + err;
			String[] res = all.split(" ");
			Io io = new Io(res);
			io.fileWiter();
			re = "";//���������ַ������г�ʼ��
			err = "";
			rep = "";
			j=0;//��j��Ϊ0
		}
	}
}
