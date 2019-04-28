package bigAssignments.calculator;
import java.io.*;
import java.util.*;

/**�жϲ��Ϸ����ʽ*/
public class JudgeLegal {
	int flag = 1;// �жϱ��ʽ�Ƿ�����쳣�����0Ϊ���ʽ��������һ���쳣�����1Ϊ���ʽ�Ϸ�
	int IsNull = 1; // �жϱ��ʽ�Ƿ�Ϊ�գ�1Ϊ�գ�0Ϊ�ǿ�
	Calculate file = new Calculate();
	File fileOut = new File("E:\\Eclipse\\src\\bigAssignments\\calculator\\Output");
	/**empty expression 
	  *  ������ʽΪ��*/
	void EmptyExp(String OneExp, File f){
		try {
			FileWriter fw = new FileWriter(f,true);
			if(OneExp.length() == 0) {
				fw.write("\nERROR\n#���ʽΪ��\n");
				flag = 0;
				fw.close();
			}else
				IsNull = 0;
		}catch(IOException  e) {
			e.printStackTrace();
		} 
	}
	/**empty parentheses
	  *  �����Ƿ����������*/
	void EmptyPare(String OneExp, File f) {
		try {
			FileWriter fw = new FileWriter(f,true);
			for(int i=0; i<OneExp.length(); i++) {
				if(OneExp.charAt(i) == '(' ) 
					if(OneExp.charAt(i+1) == ')' ) {
						fw.write("\nERROR\n#���ʽ���п�����\n");
						fw.close();
						flag = 0;
						break;
					}	
			}
		}catch(IOException  e) {
			e.printStackTrace();
		}		
	}
	/**illegal charachters 
	  * ��������Ƿ��ַ�*/
	void IllegalChar(String OneExp, File f) {
		try {
			FileWriter fw = new FileWriter(f,true);
			for(int i=0; i<OneExp.length(); i++) {
				char ch = OneExp.charAt(i);
				if(ch > 57 || ch < 40 || ch == 44 || ch == 46) {
					fw.write("\nERROR\n#���ʽ�����Ƿ��ַ�\n");
					fw.close();
					flag = 0;
					break;
				}
			}
		}catch(IOException  e) {
			e.printStackTrace();
		}
	}
	/** missmatching parentheses 
	  * �������Ų�ƥ��*/
	void MissmatchPare(String OneExp, File f) {
		try {
			FileWriter fw = new FileWriter(f,true);
			String[] LeftPar = ("," + OneExp + ",").split("\\(");
			String[] RightPar = ("," + OneExp + ",").split("\\)");
			if(LeftPar.length != RightPar.length) {
				fw.write("\nERROR\n#���ʽ���Ų�ƥ��\n");
				fw.close();
				flag = 0;
			}
		}catch(IOException  e) {
			e.printStackTrace();
		}
	}
	/** Consecutive Operator 
	  * �������������*/
	void  ConOper(String OneExp, File f) {
		try {
			FileWriter fw = new FileWriter(f,true);
			for(int i=0; i<OneExp.length()-1; i++) {
				String extract1 = "" + OneExp.charAt(i); // ��ȡ���ʽ�е�һ���ַ������ж�
				String extract2 = "" + OneExp.charAt(i+1);
				if(extract1.matches("[\\+\\-\\*\\/]") && extract2.matches("[\\+\\-\\*\\/]")) {
					fw.write("\nERROR\n#���������\n");
					fw.close();
					flag = 0;
				}
			}
		}catch(IOException  e) {
			e.printStackTrace();
		}
	}
	/** invalid operator
	  * ��Ч�����*/
	void InvalOper(String OneExp, File f) {
		try {
			FileWriter fw = new FileWriter(f,true);
			OneExp = "#" + OneExp + "#";
			for(int i=1; i<OneExp.length()-1; i++) {
				String current = "" + OneExp.charAt(i);
				String front = "" + OneExp.charAt(i-1);
				String back = "" + OneExp.charAt(i+1);
				if(current.matches("[\\+\\-\\*\\/]")) {
					if(front.matches("[^0-9\\)]")) {
						fw.write("\nERROR\n#�����ǰ��������\n");
						flag = 0; // �����ǰ��������
					}	// ���������������
					if(back.matches("[^0-9\\(]")) {
						fw.write("\nERROR\n#���������������\n");
						flag = 0;
					}
				}	//С����ǰ�������������ŷǵ�һ���ַ�
				else if(current.matches("\\(")) {
					if(front.matches("[^\\+\\-\\*\\/\\#\\(]")) {
						fw.write("\nERROR\n#���ŷǵ�һ���ַ���֮ǰ�������\n");
						flag = 0;
					}
				}	//С���ź��������������ŷ����һ���ַ�
				else if(current.matches("\\)")) {
					if(back.matches("[^\\+\\-\\*\\/\\#\\)]")) {
						fw.write("\nERROR\n#С���ź�������������ŷ����һ���ַ�\n");
						flag = 0;
					}
				}
			}
			fw.close();
		}catch(IOException  e) {
			e.printStackTrace();
		}
	}
	// ���ʽ�쳣����
	void Judge(File f) throws IOException{
		Calculate result;
		file.InitFile(fileOut);
		try(Scanner output = new Scanner(f)){
			while(output.hasNextLine()) {
				FileWriter fw = new FileWriter(fileOut,true);
				String S = output.nextLine();
				fw.write("���ʽ��" + S);
				fw.close();
				S = S.replaceAll(" ", "");
				EmptyExp(S,fileOut);
				if(IsNull == 0) {
					EmptyPare(S,fileOut);
					IllegalChar(S,fileOut);
					MissmatchPare(S,fileOut);
					ConOper(S,fileOut);
					InvalOper(S,fileOut);
				}
				if(flag == 1) {
					result = new Calculate();
					result.GetResult(fileOut,S);
				}
				flag = 1;
			}
		}
	}
}
