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
			//System.out.println("为楼层指令");
		}
		else{
			return 0;
			//System.out.println("为电梯指令");
		}
		
	}
	
	public int panduan2(){
		String b[] = a.split(",");
		return Integer.valueOf(b[1]);//所在楼层或者要去的楼层
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
