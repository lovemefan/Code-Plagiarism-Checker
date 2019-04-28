package 大作业;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Duru {
	public void duru(File f) throws IOException {
		String[] A = new String[100];
		String[] D = new String[100];
		String[] C = new String[100];
		JiSuan jisuan = new JiSuan();
		JianCha jiancha = new JianCha();
		String B = new String();
		String[] jc = new String[100];
		File f1 = new File("src\\大作业\\result");
		int s=0;
		B = "#";
		jisuan.clearInfoForFile(f1);
		for(int i=0;i<=99;i++) {
			A[i] = new String();
			D[i] = new String();
			C[i] = new String();
			jc[i] = new String();
		}
		//jiancha.jckh(f);
		int i=0;
		try (Scanner input = new Scanner(f);){
			while(input.hasNextLine()) {
				int l=0,n2 = 0;
				A[i] = input.nextLine();				
				C[i] = A[i].concat(B);
				D[i] = jiancha.jckg(C[i]);//去空格
				C[i] = D[i].concat(B);
				System.out.println("读入了"+C[i]);
				n2=jiancha.jc1(C[i],f1);//此处插入检查jc1 传入C[i]
				l=n2;
				if(n2 == 0) {
					String[] js = jisuan.shurubds(C[i]);
					if(js!=null) {
					for(int ii = 0;ii<js.length;ii++) {
						jc[i] = jc[i] + js[ii];
					}
					for(int ii = 0;ii<i;ii++) {
						if(jc[i].equals(jc[ii])) {
							l=1;
							break;
							}
					}
					if(l==0) {
						s = jisuan.counter(js);
						try{
							FileWriter output = new FileWriter(f1,true);
							output.write(D[i]+"="+s);
							output.write("\r\n");
							output.flush();				
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} 
					}
					}
				}
				i++;													
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		File f = new File("src\\大作业\\mark");
		Duru cc = new Duru();
		cc.duru(f);
		
	}
}
