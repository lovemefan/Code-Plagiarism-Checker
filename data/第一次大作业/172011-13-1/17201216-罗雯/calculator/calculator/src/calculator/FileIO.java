package calculator;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIO {
	//写入文件
	public void writeFile(ArrayList<String> result) throws IOException {
		PrintWriter output = new PrintWriter(new File("Result.txt"));
		
		for (int i = 0; i < result.size(); i++) {
			output.println(result.get(i));
		}
		
		output.close();
	}
		
	//从文件中读取表达式
	public ArrayList<String> readFile() throws IOException {
		ArrayList<String> expressions = new ArrayList<>(); 
		String file = "Expressions.txt";
		String temp;
		
		Scanner input = new Scanner(new File(file));
		while (input.hasNextLine()) {
			temp = input.nextLine();
			if (expressions.lastIndexOf(temp) == -1) {
				expressions.add(temp.replaceAll(" ", ""));
			}
		}
		input.close();
		
		return expressions;
	}
}
