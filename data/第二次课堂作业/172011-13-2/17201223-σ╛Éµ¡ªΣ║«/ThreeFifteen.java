package homework;

import java.util.Scanner;

public class ThreeFifteen {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int lottery=(int)(Math.random()*1000);
		int[] a={lottery/100,(lottery/10)%10,lottery%10 };
		System.out.print("��������µ����֣�����0��1000֮�䣩:");
		int guess=input.nextInt();
		int[] b={guess/100,(guess/10)%10,guess%10};
		int m=0,i,j,k=-1;
		for (i=0;i<3;i++){
			for (j=0;j<3;j++){
				if (b[i]==a[j]){
					m=m+1000;
					b[i]=a[j]=k;
					k=k-1;
				}
			}
		}
		if (lottery==guess)
			m=10000;
		System.out.println("���������������"+lottery);
		System.out.println("�㹲��õĽ���Ϊ" +m+ "��Ԫ������");
	}
	

}
