package TestStudent;

import java.util.Scanner;

public class TestStudent {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		Student[] student = new Student[30];
		int Averange = 0;			//全班平均值
		int sum = 0;				//计算全班总分
		int max = 0;				//最高同学平均值
		int temp = 0;				//替换当前最高平均值
		int k = 0;					//标记全班最高平均值的同学

		for (int n = 0;n < 30;n++) {
			student[n] = new Student();
			student[n].Grade = new int[4];//数组初始化不能放入每个同学的四门成绩随机循环中否则会将成绩初始化
			for (int i = 0;i < 4;i++) {
				student[n].setName(student[n].getName());
				//System.out.println(""+ student[n].Name);检查随机姓名生成情况

				student[n].setID("172011" + n);

				student[n].Grade[i] = (int)(Math.random() * 100);
				//System.out.println(+ student[n].Grade[i]);检查随机数生成情况

				temp += student[n].Grade[i];
				sum += student[n].Grade[i];
			}
			if (temp > max){
				max = temp;
				k = n;
				//System.out.println(+k);检查比较过程中是否存在问题
		}
		temp = 0;//循环后归零，防止阻碍下次比较
		}
		Averange = sum/120;
		//System.out.println(+ Averange);检查全班平均分是否正常

		System.out.println("Enter the name of student:");
		String x = input.nextLine();//接收姓名

		System.out.println("Enter the ID of student:");
		String y = input.nextLine();//接收学号

		System.out.println("Enter four grade of student:");
		int[] Grade= new int[4];//接收成绩
		for (int i = 0;i < 4;i++) {
			int z = input.nextInt();
			Grade[i] = z;
			
			if (Grade[i] >100){
				System.out.println("Grade cannot higher than 100!!!");
				System.exit(0);
			}
		}

		Student student1 = new Student(x,y,Grade);

		System.out.println(student1.getname() +"(ID: "+ student1.getID() +") averange: "
		+ student1.getAverange() +" highest: "+ student1.getHighest());

		System.out.println(student[k].getname() +"(ID: "+ student[k].getID() +") averange: "
				+ student[k].getAverange() +" highest: "+ student[k].getHighest());

		//System.out.println(+ student[k].Grade[0] +" "+ student[k].Grade[1] +" "+ student[k].Grade[2] +" "+ student[k].Grade[3]);


		if (student1.getAverange() > Averange) {//将输入同学的平均成绩与全班进行比较
			System.out.println(student1.getname() +"'s averange grade higher than class");
		}
		else {
			System.out.println(student1.getname() +"'s averange grade lower than class");
		}

		if (student1.getAverange() > student[k].getAverange()) {
			System.out.println(student1.getname() +"'s grade is the best of class");
		}
	}

}

