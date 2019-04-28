package calculator;

import java.io.*;
import java.util.ArrayList;

/*
 * 启动程序类
 */

public class StartProgram {
	public static void main(String[] args) {
		String message = null;
		File inputFile = new File("输入表达式.txt");
		File outputFile = new File("输出表达式.txt");
		if (!inputFile.exists()) {
			message = "ERROR\r\n#未找到输入文件";
			printFile(message, outputFile);
			return;
		}
		String outputContext = "";
		ArrayList expArr = readFile(inputFile);

		for (Object object : expArr) {
			String exp = (String) object;
			if (exp != null) {
				exp = exp.trim().replace(" ", "");
			}
			if ("".equals(exp)) {
				continue;
			}
			String result = new Calculator(exp).calculate();
			try {
				Double.valueOf(result);
			} catch (NumberFormatException e) {
				outputContext += "ERROR\r\n#" + result + "\r\n";
				continue;
			}

			outputContext += exp + "=" + result + "\r\n";
		}
		System.out.println(outputContext);
		printFile(outputContext, outputFile);
	}

	private static ArrayList readFile(File fin) {
		ArrayList expArr = new ArrayList();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fin), "UTF-8"));

			String line = null;
			while ((line = br.readLine()) != null) {
				expArr.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return expArr;
	}

	private static void printFile(String context, File file) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			fw.write(context);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
