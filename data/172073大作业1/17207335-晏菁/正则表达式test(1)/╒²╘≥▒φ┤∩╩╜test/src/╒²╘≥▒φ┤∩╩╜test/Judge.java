package ������ʽtest;

public class Judge {
	//�ж�str�Ƿ������ȷ���ʽ
		public boolean judge(String str){
			String temp1="";
			String temp2="";
			String temp="Null";
			int k=0;
			int m=0;
				
			temp1=str.substring(0,1);
			if((temp1.matches("[\\+\\-\\*\\/]"))){
				System.out.println("ERROR #�����ǰ��������");
				return false;
			}
			//�ж������ַ����Ƿ񺬷Ƿ��ַ�	
			for(int i=0;i<str.length()-1;i++){
				temp1=str.substring(i, i+1);
				if(!temp1.matches("[[0-9]\\+\\-\\*\\/\\(\\)]")){
					System.out.println("ERROR #���ʽ�к��Ƿ��ַ�");
					return false;
				}
			}
			//�жϱ��ʽ����������
			for(int i=0;i<str.length()-1;i++){
				temp1=str.substring(i,i+1);
				temp2=str.substring(i+1,i+2);
				if(temp1.matches("\\(")&&temp2.matches("\\)")){
					System.out.println("ERROR #���ʽ���п�����");
					return false;
				}
				else if( (temp1.matches("[\\+\\-\\*\\/]")) &&temp2.matches("[\\+\\-\\*\\/]") ){
					System.out.println("ERROR #���������");
					return false;
				}
				else if((!temp1.matches("[[0-9]\\)]")) && (temp2.matches("[\\+\\-\\*\\/]"))){
					if(!temp1.matches("[0-9]")){
					System.out.println("ERROR #�����ǰ��������");
					return false;
					}
				}
				else if((temp2.matches("\\(")) && (!temp1.matches("[\\+\\-\\*\\/]")) && (i!=0)){
					System.out.println("ERROR #���ŷǵ�һ���ַ���֮ǰ�������");
					return false;
				}
				else if((temp1.matches("[\\+\\-\\*\\/]")) && (!temp2.matches("[[0-9]\\(]"))){
					if(!temp2.matches("[0-9]")){
					System.out.println("ERROR #���������������");
					return false;
					}
				}
				else if((temp1.matches("\\)")) && (!temp2.matches("[\\+\\-\\*\\/]")) && (i!=(str.length()-1))){
					System.out.println("ERROR #С���ź�������������ŷ����һ���ַ�");
					return false;
				}
			}
			
			//�ж������Ƿ�ƥ��
			for(int i=0;i<str.length();i++){
				temp1=str.substring(i,i+1);
				if( (temp.matches("\\(")) ){
					k++;
				}
				else if(temp.matches("\\)")){
					m++;
				}
			}
			if(k!=m){
				System.out.println("ERROR	#���Ų�ƥ��");
				return false;
			}
			
			return true;
		}

}
