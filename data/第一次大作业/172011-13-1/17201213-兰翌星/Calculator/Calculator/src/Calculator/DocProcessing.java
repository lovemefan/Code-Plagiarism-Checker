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
	 * 无参构造
	 */
	public DocProcessing() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * 有参构造，实现打开输入文件
	 * @param inputFile:输入文件地址
	 * @param outPut:输出文件地址
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
	 * 获取文件内的一行
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
	 * 按行输入到文件
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
