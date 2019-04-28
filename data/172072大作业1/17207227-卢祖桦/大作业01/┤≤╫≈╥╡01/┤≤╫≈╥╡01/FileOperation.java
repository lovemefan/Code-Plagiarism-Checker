package ´ó×÷Òµ01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileOperation {

	public String[] read(File f, int num) {
		// TODO Auto-generated method stub
		String []s = new String[num];
		try (Scanner input = new Scanner(f);){
			for(int i = 0;i<num;i++) {
				 s[i] = input.nextLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return s;
	}

	public void write(File f1, double[] result, int num, String[] s) {
		// TODO Auto-generated method stub
		try (PrintWriter output = new PrintWriter(f1);){
			for(int i =0;i<num;i++) {
				output.println(s[i] +"="+ result[i]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
	}

}
