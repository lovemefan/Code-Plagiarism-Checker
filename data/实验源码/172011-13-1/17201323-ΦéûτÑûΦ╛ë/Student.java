package work;

public class Student { //学生属性
	String studentID;
	String studentName;
	int []scores;
	public String getID(){//字符学生ID
		return studentID;
	}
	public String getName(){//字符学生名字
		return studentName;
	}
	public Student(String studentName,String studentID,int []scores){
		this.studentName = studentName;
		this.studentID = studentID;
		this.scores = scores;
	}
	public int max(){//最大值
		int max = scores[0];
		for(int x = 1;x < scores.length;x++){
			if (scores[x] > max){
				max = scores[x];//比较取得最大值
			}
		}
		return max;//返回值
	}
	public double averageScore(){//平均分
		double average = 0;//初始化
		double sum = 0;
		for(int y = 0;y < scores.length;y++){
			sum = sum + scores[y];
		}
		 average = sum/4;//求得平均值
		 return average;//返回值
	}

}
