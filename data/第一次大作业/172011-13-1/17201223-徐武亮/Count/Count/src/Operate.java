import java.util.*;    

public class Operate {
	
	private String[] result ;//������飬���ʽ�Ϸ���������������Ϸ������������
	private boolean[] correct; //����ʽ�ĺϷ��ԣ�true�Ϸ���false���Ϸ���Ĭ��true
	
	public Operate(){
		
	}
	
	public void set(String[] result){//��ʼ������
		this.result = result;
		boolean[] co = new boolean[result.length];
		for (int i = 0 ;i <result.length ;i++){
			co[i] = true;
		}
		this.correct = co;
	}
	
	public void checkout(){
		for(int j = 0; j<result.length ; j++){//�����жϱ��ʽ�ĺϷ���
			String corre = result[j].substring(0, result[j].length()-1);
		    Checkout chec = new Checkout(corre,correct[j]);
		    chec.check();
		    result[j] = chec.getdata();
		    correct[j] = chec.getcorr();
	
		}
		for(int k = 0; k<result.length ; k++){//���Ϸ��ı��ʽ��ȥ����
			if (correct[k] == true){
				Result res = new Result("("+result[k]+")#");			
				double a = res.caculate();//�õ�������
				String re = result[k].substring(0, result[k].length());
				result[k] = re + "=" + a;
			}
			
		}
	}
	public String[] getresult(){
		return result;
	}
	public boolean[] getcorrect(){
		return correct;
	}

}
