import java.util.Scanner;
//函数主方法
public class Main {
	private static Scanner input;

	public static void main(String[] args){
		//声明新生成绩
		int[] newsc = new int[4];
		//输入新生的姓名，学号
		input = new Scanner(System.in);
		System.out.println("名字：");
		String name = input.next();
		System.out.println("学号：");
		int id = input.nextInt();
		//输入新生的成绩
		while(true){
			System.out.println("分别输入四门成绩：");
			newsc[0] = input.nextInt();
			newsc[1] = input.nextInt();
			newsc[2] = input.nextInt();
			newsc[3] = input.nextInt();
			//判断输入的新生成绩是否越界
			if(newsc[0] < 0||newsc[0] > 100||newsc[1] < 0||newsc[1] > 100||newsc[2] < 0||newsc[2] > 100||newsc[3] < 0||newsc[3] > 100){
				System.out.println("你输入的成绩有误，请重新输入！");
				continue;
			}
			break;
		}
		Student n = new Student(name,id,newsc);
		//定义一个三十个学生的数组
		Student[] s = new Student[30];
		int i;
		//随机生成学生姓名，学号，成绩，并输入数组中
		for(i=0;i<30;i++){
			int num = 3+(int)(Math.random()*4);
			String Name = "";
			int ID = 17201200+(int)(Math.random()*30);
			for(int j = 0;j<num;j++){
				char w = (char)('a'+Math.random()*('z'-'a'+1));
				Name = Name + w;
				if(j==num-1){
					int a = (int)(Math.random()*100);
					int b = (int)(Math.random()*100);
					int c = (int)(Math.random()*100);
					int d = (int)(Math.random()*100);
					int[] sc = {a,b,c,d};
					s[i] = new Student(Name,ID,sc);
				}
			}
		}
		//获得平均成绩最高同学的下标
		int xb = 0;
		double  max = 0;
		for(int k = 0;k < 30;k++){
			if(max < s[k].averageScore()){
				max = s[k].averageScore();
				xb = k;
			}
		}
		//获得全班同学的平均成绩
		double sum = 0;
		for(int j = 0;j < 30;j ++){
			sum = sum + s[j].averageScore();
		}
		double ave = (sum + n.averageScore())/31;
		System.out.println(name+"(ID:"+id+") 平均分："+n.averageScore()+" 最高分："+n.max());
		//新同学的平均分分为三种情况：低于全班平均分，高于全班平均分，平均分全班最高，并将结果输出
		
		//判断新生平均分是否小于全班平均值
		if (n.averageScore()<=ave){
			System.out.println(s[xb].studentName+"(ID:"+s[xb].studentID+") 的最高平均分："+s[xb].averageScore()+" 最高分："+s[xb].max());
			System.out.println(n.studentName+"的平均分低于全班平均分");
		}
		//判断新生平均分是否高于全班平均分并低于全班平均分最高的学生
		else if (n.averageScore()>ave&&n.averageScore()<s[xb].averageScore()){
			System.out.println(s[xb].studentName+"(ID:"+s[xb].studentID+") 的最高平均分："+s[xb].averageScore()+" 最高分："+s[xb].max());
		   System.out.println(n.studentName+"的平均分高于全班平均分");
		   }
		//新生的成绩是否最高
		else{
			System.out.println(n.studentName+"的成绩是全班最好的");
		 System.out.println(n.studentName+"的平均分高于全班平均分");
		}
	}

}
