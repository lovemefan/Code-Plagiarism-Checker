package calculators;
//import java.util.Deque;
//import java.util.regex.*;
//import java.util.LinkedList;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

//��ͷ�������û���  ����ǰ�����ַ�  

public class Test {
	private String test = "";
	private int  testNum;
	int find=0;
	public Test(){
		
	}
	
	public String getTest(String number){
		test=number;
		//this.test=test;
		return test;
	}
	public Test(String test){
		this.test=test;
	}
	
	
	public int getTestNum(){
		return testNum;
	}
	
	public int testIt(String test){
		testNum=0;
		
		//�ж������Ƿ�ƥ��
        int testNum2=0;
		int left=0;
		int right=0;
		for(int i=0;i<test.length();++i){
			if(test.charAt(i)=='('){
				left=left+1;
				}
			if(test.charAt(i)==')'){
				right=right+1;
			}
			if(left<right){
				 testNum2=1;
			}
		}
		if(testNum2==0){
		if(left==right){
			testNum=0;
		}
		else{
			testNum=1;
			find=3;
			System.out.println("ERROR");
			System.out.println("#������Ŀ��ƥ��!");
		}
		}
		else{
			find=4;
			testNum=1;
			System.out.println("ERROR");
			System.out.println("#����˳��ƥ��  ���ȳ���!");
		}
		
		
		//�ж��Ƿ�Ϊ���ַ���
		if(test == ""){
			System.out.println("ERROR");
			System.out.println("#�ǿ��ַ���!");
			testNum=1;
			find=1;
		}
	
		//"[^\\+\\-\\*\\/\\(\\)\\.0-9]"
		//�ж��Ƿ��зǷ��ַ�
		if(test.matches(".*[^\\d|^\\+|^\\-|^\\*|\\/|^\\(|^\\)].*")){
			System.out.println("ERROR");
			System.out.println("#���зǷ��ַ�!");
			testNum=1;
			find=2;
		}
					
		if(testNum==0){
		//�ж��ַ�����ͷ�Ƿ��������
		if(test.matches("[\\+\\-\\*\\/][\\d].*")){
			System.out.println("ERROR");
			System.out.println("#��ͷ�������!");
			testNum=1;
			find=5;
		}
		
		//�ж��ַ�����β�������
		if(test.matches(".*[\\+\\-\\*\\/]")){
			System.out.println("ERROR");
			System.out.println("#��β�������!");
			testNum=1;
			find=6;
		}
		
		//�ж��Ƿ�ǰ�������      [\\+\\-\\*\\/][)]|[)][0-9.]
		if(test.matches(".*(\\+\\)|\\*\\)|-\\)|/\\)).*")==true){   ///
			System.out.println("ERROR");
			System.out.println("#��ǰ�������!");
			testNum=1;
			find=7;
		}
		//�ж��Ƿ񣨺��������
		if(test.matches(".*(\\(-|\\(\\+|\\(/|\\(\\*).*")){     ///
			System.out.println("ERROR");
			System.out.println("#�����������!");
			find=8;
			testNum=1;
		}
		//�ж��Ƿ�ǰ������ ���� ����������
		if(test.matches(".*(\\)\\d|\\d\\().*")==true){       ///
			System.out.println("ERROR");
			System.out.println("#��ǰ�����ֻ�  ����������!");
			find=9;
			testNum=1;
		}
		//�ж��Ƿ��ǿ�����
		if(test.matches(".*(\\(\\)).*")){            ///
			System.out.println("ERROR");
			System.out.println("#������!");
			testNum=1;
			find=10;
		}
		
		//�ж��Ƿ����ظ��������	
		if(test.matches("[\\S]*[+\\-/*/][+/*/][\\S]*")==true){      ///
			System.out.println("ERROR");
			System.out.println("#�����������������صĸ������!");
			testNum=1;
			find=11;
		}
		
		//�ж�/���Ƿ�Ϊ0
		if(test.matches(".*(\\/0).*")){     
			System.out.println("ERROR");
			System.out.println("# /��Ϊ0!");
			find=12;
			testNum=1;
		}
		
		}
		return testNum;
	}
	public String finding(int find){
		String[] finded=new String[13];
		finded[0]="";
		finded[1]="#�ǿ��ַ���";
		finded[2]="#���зǷ��ַ�!";
		finded[3]="#������Ŀ��ƥ��!";
		finded[4]="#����˳��ƥ��  ���ȳ���!";
		finded[5]="#��ͷ�������!";
		finded[6]="#��β�������!";
		finded[7]="#��ǰ��������򣩺�������!";
		finded[8]="#�����������!";
		finded[9]="#��ǰ�����ֻ�  ����������!";
		finded[10]="#������!";
		finded[11]="#�����������������صĸ������!";
		finded[12]="# /��Ϊ0!";
		return finded[find];
	}
	
	
	
}

	


