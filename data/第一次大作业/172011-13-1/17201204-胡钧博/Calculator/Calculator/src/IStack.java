//��׺���ʽת��Ϊ��׺���ʽ
import java.util.Stack;
public class IStack {
	
		IStack(){
			
		}	
		public static String inFix(String b){
			String[] strings = b.split(" ");
			Stack<String> s = new Stack<String>(); //������������ջ
			String post = "";  //Ҫ����ĺ�׺���ʽ
		    for(int i = 0 ; i < strings.length ; i ++){
				String temp; //��ʱ�ַ�������
				String ch = strings[i]; //��ȡ����׺���ʽ��ÿһ���ַ����������ж�
				switch(ch){
				case "(":     //�����������ֱ��ѹ���ջ
					s.push(ch);
					break;
				case "+":      //����'+' '-',��ջ�е����������ȫ������ȥ��ֱ������������Ϊֹ�������������ȥ
				case "-":
					while(s.size() != 0){
						temp = s.pop();
						// ֻ�бȵ�ǰ���ȼ��ߵĻ�����ȵĲŻᵯ����������У������Ӽ������ţ�ֱ��ֹͣ��ǰѭ��

						if(temp == "("){
							s.push("(");
							break;
						}
							post += temp+" ";
					
					}
					s.push(ch); 
					break;
					
				//�����'*'��'/'���򵯳��������У�ֱ������'+'��'-'��'('Ϊֹ����󽫲�����ѹ��ջ��
				case "*":
				case "/":
					while(s.size() != 0){
						temp = s.pop();
						if(temp == "+" || temp == "-" || temp == "("){
							s.push(temp);
							break;
						}
						else{
							post += temp+" ";
						}
					}
					s.push(ch);
					break;
					
				//����������������ţ������ջ���ĵ�һ��������������������������ջ������������
				case ")":
					while ((temp = s.pop()) != ")") {
						post += temp;
					} 
					
					while(!s.isEmpty()){
						temp = s.pop();
						if(temp == "("){
							break;
						}
						else{
							post += temp+" ";
						}
					}
					break;
				//Ĭ������������ȡ���������֣���ֱ�������������	
				default:
					post += ch+" ";
					break;
				}
			}
			//�����ջ��Ϊ�գ����ʣ�������һ�ε����������������
			while(s.size() != 0){
				post += s.pop();
			}
			
			return post;
			
		}
}
