
public class W {
	String q;
	
	W(){
		
	}
	
	W(String q){
		this.q = q;
	}
	
	public int pan(){
		int s = 0;
		int o = 0;
		int j = 0;
		//#���Ų����
		for(int i=0;i<q.length();i++){
			if(q.charAt(i)=='('){
				j++;
			}
			if(q.charAt(i)==')'){
				o++;
			}
		}
		
		if(j!=o){
			s = 4;
		}
		
		//0,+,-,*,/����ǰ
		if(s!=4){
			if(q.matches("0.*")||q.matches("\\+.*")||q.matches("\\-.*")||q.matches("\\/.*")||q.matches("\\*.*")||q.matches("\\).*")){
				s = 10;
			}
		}
		
		//#���������
		if(s!=4&&s!=10){
			for(int i=0;i<q.length();i++){
				if(q.charAt(i)=='+'||q.charAt(i)=='-'||q.charAt(i)=='*'||q.charAt(i)=='/'){
					if(q.charAt(i+1)=='+'||q.charAt(i+1)=='-'||q.charAt(i+1)=='*'||q.charAt(i+1)=='/'){
						s = 2;
					}
				}
			}
		}
		
		//#�����������
		if(s!=4&&s!=10&&s!=2){
			for(int i=0;i<q.length();i++){
				if(q.charAt(i)=='('&&i!=(q.length()-1)){
					if(q.charAt(i+1)=='+'||q.charAt(i+1)=='-'||q.charAt(i+1)=='*'||q.charAt(i+1)=='/'){
						s = 5;
					}
				}
			}
		}
		
		//#��ǰ�������
		if(s!=4&&s!=10&&s!=2&&s!=5){
			for(int i=0;i<q.length();i++){
				if(q.charAt(i)==')'&&i!=0){
					if(q.charAt(i-1)=='+'||q.charAt(i-1)=='-'||q.charAt(i-1)=='*'||q.charAt(i-1)=='/'){
						s = 6;
					}
				}
			}
		}
		
		//#��ǰ���������
		if(s!=4&&s!=10&&s!=2&&s!=5&&s!=6){
			for(int i=0;i<q.length();i++){
				if(q.charAt(i)=='('&&i!=0){
					if(q.charAt(i-1)!='+'&&q.charAt(i-1)!='-'&&q.charAt(i-1)!='*'&&q.charAt(i-1)!='/'){
						s = 7;
					}
				}
			}
		}
		
		//#�����������
		if(s!=4&&s!=10&&s!=2&&s!=5&&s!=6&&s!=7){
			for(int i=0;i<q.length();i++){
				if(q.charAt(i)==')'&&i!=(q.length()-1)){
					if(q.charAt(i+1)!='+'&&q.charAt(i+1)!='-'&&q.charAt(i+1)!='*'&&q.charAt(i+1)!='/'){
						s = 8;
					}
				}
			}
		}
		
		//#���ʽ���зǷ��ַ�
		if(s!=4&&s!=10&&s!=2&&s!=5&&s!=6&&s!=7&&s!=8){
			for(int i=0;i<q.length();i++){
				if(q.charAt(i)!='0'&&q.charAt(i)!='1'&&q.charAt(i)!='2'&&q.charAt(i)!='3'&&q.charAt(i)!='4'&&q.charAt(i)!='5'&&q.charAt(i)!='6'&&q.charAt(i)!='7'&&q.charAt(i)!='8'&&q.charAt(i)!='9'&&q.charAt(i)!='('&&q.charAt(i)!=')'&&q.charAt(i)!='+'&&q.charAt(i)!='-'&&q.charAt(i)!='*'&&q.charAt(i)!='/'){
					s = 9;
				}
			}
		}
		
		//#������
		if(s!=4&&s!=10&&s!=2&&s!=5&&s!=6&&s!=7&&s!=8&&s!=9){
			for(int i=0;i<q.length();i++){
				if(q.charAt(i)=='('&&i!=(q.length()-1)){
					if(q.charAt(i)==')'){
						s = 3;
					}
				}
			}
		}
		
		//#���Ų����
		int y = 0;
		int x = 0;
		if(s!=4&&s!=10&&s!=2&&s!=5&&s!=6&&s!=7&&s!=8&&s!=9){
			for(int i=0;i<q.length();i++){
				if(q.charAt(i)=='('){
					y = i;
				}
				if(q.charAt(i)==')'){
					x = i;
				}
				if(y>x){
					s = 4;
				}
			}
		}
		return s;
	}

}
