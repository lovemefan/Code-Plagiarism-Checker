package 实验一;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		final int P = 30;   //学生数
		final int ID = 17201100;//学号基数
		Scanner scan = new Scanner(System.in);
		Student[] stu = new Student[P];//30个对象数组
		for(int i = 0;i < P;i ++) {//进行初始化
			stu[i] = new Student();
		}
		boolean[] flags1 = new boolean[P];//设立开关
		for(int i = 0;i < P;i ++) {//排除重复学号
			int t;
			do {
				t = (int)(Math.random()*P+ID);
			}while(flags1[t-ID] == true);
			stu[i].studentID = t;
			flags1[t-ID] = true;
		}
		char[][] name = new char[P][];//字符
		for(int i = 0;i < P;i ++) {//随机取名字字数
			int t = (int)(Math.random()*5+3);
			name[i] = new char[t];
		}
		char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		for(int i = 0;i < P;i ++) {//随机
			for(int j = 0;j < name[i].length;j ++) {
				int index = (int)(Math.random()*letters.length);//字母下标
				name[i][j] = letters[index];
			}
			stu[i].studentName = String.valueOf(name[i]);//把单个的字符转换成字符串
		}
		for(int i = 0;i < P;i ++) {//随机生成分数
			for(int j = 0;j < stu[i].scores.length;j ++) {
				stu[i].scores[j] = (int)(Math.random()*100+1);
			}
		}
			System.out.println("请输入学生姓名：");
			String newName = scan.nextLine();//输入新学生的姓名
			System.out.println("请输入学生学号：");
			int newID = scan.nextInt();//新学生的学号
			System.out.println("请输入四门课的成绩，以空格分隔：");
			int[] newScores = new int[4];
			for(int i = 0;i < newScores.length;i ++) {//新学生的成绩
				newScores[i] = scan.nextInt();
			}
			Student newStudent = new Student(newID,newName,newScores[0],newScores[1],newScores[2],newScores[3]);//把输入的数据存入对象
			int max = newStudent.max();//新同学的最高成绩
			double averageScore = newStudent.averageScore();//新同学的平均分
			int m = 0;//最高成绩者的序号
			double studentAverageScore = 0;//最高成绩者的平均成绩
			for(int i = 0;i < P;i ++) {//寻找最高成绩者的序号
				if(studentAverageScore < stu[i].averageScore()) {
					studentAverageScore = stu[i].averageScore();
					m = i;
				}
			}
			int studentMax = stu[m].max();//最高成绩者的最高成绩
			double allAverageScore = 0;//全班所有人的平均成绩总和
			for(int i = 0;i < P;i ++) {
				allAverageScore += stu[i].averageScore();
			}
			double classAverageScore = allAverageScore/P;//班级的平均成绩
			if(newScores[0] > 100 || newScores[0] < 0 || newScores[1] > 100 || newScores[1] < 0 || newScores[2] > 100 || newScores[2] < 0 || newScores[3] > 100 || newScores[3] < 0) {
				System.out.println("课程成绩不能高于100分，不能小于0分！！");
			}else if(averageScore < studentAverageScore){
				System.out.println(newName +"(ID:"+ newID +") 平均分："+ averageScore +" 最高分："+ max);
				System.out.println(stu[m].studentName+"(ID:"+stu[m].studentID+") 平均分："+ studentAverageScore +" 最高分："+ studentMax);
				if(averageScore < classAverageScore) {
					System.out.println(newName +"的平均成绩低于全班的平均分。");
				}else if(averageScore == classAverageScore) {
					System.out.println(newName +"的平均成绩等于全班的平均分。");
				}else {
					System.out.println(newName +"的平均成绩高于全班的平均分。");
				}
			}else if(averageScore >= studentAverageScore){
				System.out.println(newName +"(ID:"+ newID +") 平均分："+ averageScore +" 最高分："+ max);
				System.out.println(newName +"现在是班上成绩最好的学生了");
				System.out.println(newName +"的平均成绩高于全班的的平均分");
			}
			scan.close();
	}
}

