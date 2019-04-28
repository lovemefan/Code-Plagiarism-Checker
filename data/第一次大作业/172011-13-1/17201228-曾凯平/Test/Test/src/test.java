
public class test {
	
		static boolean isNumber(String str) {//�жϱ��ʽ�ǲ���ֻ��һ������
			for(int i=0;i<str.length();i++) {
				if(!Character.isDigit(str.charAt(i)) && str.charAt(i)!='.')
					return false;
			}
			return true;
		}
		static Double getResult(String str) {
			if(str.isEmpty() || isNumber(str)) {//�ݹ�ͷ
				return str.isEmpty() ? 0  : Double.parseDouble(str);
			}
			
			//�ݹ���
			if(str.contains(")")) {
				int lIndex = str.lastIndexOf("(");//���һ��������
				int rIndex = str.indexOf(")", lIndex);//���ڵ�������
				return getResult(str.substring(0,lIndex)
						         + getResult(str.substring(lIndex+1, rIndex))
						         + str.substring(rIndex+1));
			}
			if(str.contains("+")) {
				int index = str.lastIndexOf("+");
				return getResult(str.substring(0,index)) 
						         + getResult(str.substring(index+1));
			}
			if(str.contains("-")) {
				int index = str.lastIndexOf("-");
				return getResult(str.substring(0,index)) 
						         - getResult(str.substring(index+1));
			}
			if(str.contains("*")) {
				int index = str.lastIndexOf("*");
				return getResult(str.substring(0,index))
						         * getResult(str.substring(index+1));
			}
			if(str.contains("/")) {
				int index = str.lastIndexOf("/");
				return getResult(str.substring(0,index)) 
						         / getResult(str.substring(index+1));
			}
			return null;//����
		}
		
		public static void main(String[] args) {
			String str = "(15+5)*3-(3+3)*6";
			System.out.println(getResult(str));
		}
	}
