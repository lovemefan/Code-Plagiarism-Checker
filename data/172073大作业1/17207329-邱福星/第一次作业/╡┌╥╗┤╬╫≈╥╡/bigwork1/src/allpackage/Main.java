package allpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
/*
 * ��ȡ�ļ�����ָ��
 * ɸѡָ��
 * ִ��ָ��
 * ������
 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int i = 0,k = 0;
		double answer;
		int[] num = new int[25];
		String[] filelist = new String[30]; //�洢�ļ�ԭָ��

		Resolve resolve = new Resolve();
		Output output = new Output();
		
		File f = new File("work1");
		Scanner input = new Scanner(f);
		
		for(i = 0;input.hasNextLine();i++) {//��ȡ�ļ����ݲ�ȥ�ո�
			filelist[i] = input.nextLine();
			filelist[i] = resolveEx(filelist[i]);
			if(isTong(filelist,i)) { //����ļ����ݳ�����ͬ��ɾȥ��
				i--;
			}
		}
		input.close();
		for(int j= 0;j<i;j++) {
			if(filelist[j].length() == 0)
				num[j] = 9;
		}
		for(k = 0;k < i;k++) {
			if(num[k] != 9)//������ʽΪ��
				num[k] = resolve.isLegal(filelist[k]);
			answer = 0;
			if(num[k] == 0){
				Compute compute = new Compute(filelist[k]);
				answer = compute.dataCompute();
				
			}
			output.outputAnswer(num[k],filelist[k],answer);
		}
	}
	//����ո�
	static String resolveEx(String filelist) {
		filelist = filelist.replaceAll(" ","");
		return filelist;
	}
	//������ͬ�ַ���
	static boolean isTong(String[] filelist,int i) {
		for(int j = 0;j < i;j++) {
			if(filelist[i].compareTo(filelist[j]) == 0) {
				return true;
			}
		}
		return false;
	}

}
