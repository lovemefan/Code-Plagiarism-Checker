package dazuoye;

public class main {
	public static void main(String[] args) {
		read shuru = new read("D:/ccc.txt");
		shuru.readMethod();
		int i=0;
		String xp[]=new String[100];
		while(shuru.getreadMethod()[i]!=null){
			adjust shuru2=new adjust(shuru.getreadMethod()[i]);
			write xieru = new write(shuru2.work(),"D:/kkk.txt");
			xieru.writeMethod();
			//System.out.println(k.work());
			xp[i]=shuru2.getshuzu();
			i++;
		}
	}
}
