//学生类
public class Student {	
	String studentID;// 学生学号	
	String studentName;// 学生姓名	
	int[] scores = new int[4];// 学生成绩		
	double average = 0;//学生平均分		
	int max = 0;	

	// 获得学生姓名	
	public String getName() {		
		return this.studentName;	
	}	

	// 获得学生学号	
	public String getID() {		
		return this.studentID;	
	}	
	
	// 学生类的构造方法	
	// (学生id,学生名字，学生分数)	
	public Student(String studentID, String studentName, int[] scores) {
		this.studentID = studentID;
		this.studentName = studentName;
		for (int i = 0; i < 4; i++) {
			this.scores[i] = scores[i];
		}
	}
	//学生类的构造方法	public Student(){			
	}
	// 获得学生成绩中的最大值
	public int max() {
		int max = 0;
		for (int i = 0; i < 4; i++) {
			if (this.scores[i] > max) {
				max = this.scores[i];	
		}
	}
	return max;	
}

	// 获得学生成绩的平均值
	public double average() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += this.scores[i];
		}
		return sum / 4;
	}
	//获得学生总平均分
	//学生对象
	public double sumAverage(Student[] student){
		double sum = 0;
		for (int i = 0; i < 30; i ++){
			sum +=student[i].average();
		}	
	return sum /30;
	}
	//设置学生姓名
	//学生姓名
	public void setName(String name){
		this.studentName = name;
	}	
	//设置学生学号
	//学生学号
	public void setID(String id){
		this.studentID = id;
	}	
	//设置学生分数
	//分数
	public void setScores(int[] scores){	
		for (int i = 0; i < 4; i ++){
			this.scores[i] = scores[i];
		}
	}	
	//设置学生最高分
	//最高分
	public void setMax(int max){
		this.max = max;
	}	
	//设置学生平均分
	//平均分
	public void setAverage(double average){
		this.average = average;
	}
}