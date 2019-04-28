package Zuoye;


import java.util.Scanner;

public class yaha1 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Stu[] stus = new Stu[30];

		for(int i=0;i<30;i++)
		{
			stus[i]=Stu.getStu();
		}

		Scanner in = new Scanner(System.in);
		System.out.println("请输入学生姓名: ");
		double sum = 0;
		double max = 0;
		double grades[] = new double[4];
		Stu newStu = new Stu();
		newStu.setName(in.nextLine());
		System.out.println("请输入学生学号: ");
		newStu.setId(in.nextLine());
		System.out.println("请输入四门课的成绩，以空格分隔: ");
		for(int i=0;i<4;i++)
		{
			grades[i] = in.nextInt();
			if(max<grades[i])
				max = grades[i];
			sum += grades[i];
		}
		newStu.setMax(max);
		newStu.setAverGrade(sum/4);
		newStu.setGrades(grades);
		System.out.println(newStu.getName()+"(ID:"+newStu.getId()+") 平均分 "+newStu.getAverGrade()
		+" 最高分 "+newStu.getMax());
		double best = newStu.getAverGrade();
		Stu bestStu = newStu;
		double average = 0;
		for(int i=0;i<30;i++)
		{
			average += stus[i].averGrade;
			if(best < stus[i].averGrade)
			{
				best = stus[i].averGrade;
				bestStu = stus[i];
			}
		}
		average/=30;
		System.out.println(bestStu.getName()+"(ID:"+bestStu.getId()+") 平均分 "+bestStu.getAverGrade()
		+" 最高分 "+bestStu.getMax());
		System.out.println(newStu.getName()+" 的平均成绩"+(newStu.getAverGrade()>average?"高于":"低于")+"全班的平均分");
	}
}
