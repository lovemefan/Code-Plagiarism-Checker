package ����ҵ01;

import java.io.File;  
import java.util.Scanner;

/*��������*/
public class TestCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f1 = new File("src\\����ҵ01\\exp");
		File f2 = new File("src\\����ҵ01\\value");
		ExpFileOperate fo = new ExpFileOperate();
		
		System.out.println("**********��ѧ���ʽ������**********");
		System.out.println("	1.��ȷ������ʽ		");
		System.out.println("	2.�쳣������ʽ		");	
		System.out.print("���������ѡ�1��2����");
		Scanner input = new Scanner(System.in);
		int num = input.nextInt();
		
		System.out.print("������д��exp�ļ������ݵ�������");
		int n = input.nextInt();
		String[] infix = fo.readLine(f1,n);//��ȡ�ļ�ÿ�����ݲ���ֵ
		int[] result = new int[n];//���ʽ�����¼����
		
		switch(num) {
			case 1:			
				CalculateExpression exp = new CalculateExpression();//��������	
				for(int i=0; i<n; i++) { 
					exp.testExp(infix[i]);
					result[i] = exp.opnd.peek();//ÿ������浽������		
				}
				fo.writeFile(f2,infix,result,n);//д���ļ�
				break;
			case 2:
				CheckExpression ckExp = new CheckExpression();//��������	
				for(int i=0; i<n; i++) {				
					ckExp.checkExp(infix[i]);					
				}
				break;
			default:
				break;
		}	
	}

}

