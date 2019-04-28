package work2;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.IOException;

public class FirstWork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1 = null;//需要写入infile的内容
		String s2 = null;//需要写入resultfile的内容
		InFile F1 =new InFile(s1);
		ResultFile F2 = new ResultFile(s2);
		F1.creatfile(s1);
		F2.writerfile(s2);
	}

	}


