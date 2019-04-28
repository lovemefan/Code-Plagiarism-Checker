package Calculator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DocProcessing {
	BufferedReader bufferedReader;
	BufferedWriter bufferedWriter;
	File inputFile,outPut;
	String Line = null;
	
	/**
	 * �޲ι���
	 */
	public DocProcessing() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * �вι��죬ʵ�ִ������ļ�
	 * @param inputFile:�����ļ���ַ
	 * @param outPut:����ļ���ַ
	 */
	public DocProcessing(String inputFile, String outPut){
		this.inputFile = new File(inputFile);
		this.outPut = new File(outPut);
		try {
			bufferedReader = new BufferedReader(new FileReader(this.inputFile));
			bufferedWriter = new BufferedWriter(new FileWriter(this.outPut));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ�ļ��ڵ�һ��
	 * @return
	 */
	public String getException() {
		try {
			while((Line = bufferedReader.readLine()) != null){
				return Line;
			}
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * �������뵽�ļ�
	 */
	public void saveEceptionToFile(String data){
		try {
			bufferedWriter.write(data);
			bufferedWriter.newLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void closeFile(){
		try {
			bufferedWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
