
//import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;
import java.io.*;
import java.util.*;

public class File {

	public File() {

	}

	// 将文件打开，并将表达式存至变长数组
	public static ArrayList<String> FileR() throws Exception {
		ArrayList<String> ex = new ArrayList<String>();
		java.io.File file = new java.io.File("expression.txt");
		// PrintWriter output = new PrintWriter(file);

		Scanner input = new Scanner(file);

		while (input.hasNextLine()) {
			String temp = input.nextLine();
			ex.add(temp);
		}
		input.close();
		return ex;
	}

	public static void FileW(ArrayList ex, ArrayList result) throws Exception {
		java.io.File file = new java.io.File("result.txt");
		PrintWriter fp = new PrintWriter(file);
		int index = ex.size();

		for (int i = 0; i < index; i++) {
			fp.println(ex.get(i));
			fp.println(result.get(i));
		}
		fp.close();

	}
}