package dazuoye;

public class judge {
	private String a;

	public judge() {

	}

	public judge(String a) {
		this.a = a;
	}

	public int panduan() {
		String b[] = a.split(",");
		if( "(FR".equals(b[0])==true){
			return 1;
			//System.out.println("Ϊ¥��ָ��");
		}
		else{
			return 0;
			//System.out.println("Ϊ����ָ��");
		}
		
	}
	
	public int panduan2(){
		String b[] = a.split(",");
		return Integer.valueOf(b[1]);//����¥�����Ҫȥ��¥��
	}
	
	public String panduan3(){
		String b[] = a.split(",");
		return b[2];
	}
	
	public double panduan4(){
		String b[] = a.split(",");
		return Integer.valueOf(b[3]);
	}
	
	public double panduan5(){
		String b[] = a.split(",");
		return Integer.valueOf(b[2]);
	}
}
