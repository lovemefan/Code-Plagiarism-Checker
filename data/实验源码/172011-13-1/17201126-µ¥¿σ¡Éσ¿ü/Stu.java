package Zuoye;

public class Stu {

		String id;
		String name;
		double[] grades = new double[4];
		double max;
		double averGrade;

		
		public Stu(String id1, String name1, double[] grades1, int max1, double averGrade1) {
			id = id1;
			name = name1;
			grades = grades1;
			max = max1;
			averGrade = averGrade1;
		}
		
		public String getId() {
			return id;
		}
		
		public void setId(String id) {
			this.id = id;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public double[] getGrades() {
			return grades;
		}
		
		public void setGrades(double[] grades) {
			this.grades = grades;
		}
		
		public double getMax() {
			return max;
		}
		
		public void setMax(double max) {
			this.max = max;
		}
		
		public double getAverGrade() {
			return averGrade;
		}
		
		public void setAverGrade(double averGrade) {
			this.averGrade = averGrade;
		}
		
		public static Stu getStu(){
			Stu stu = new Stu();
			String id = "";
			String name = "";
			double grades[] = new double[4];
			double max=0;
			double sum=0;
			for(int i=1;i<=6;i++)
			{
				if(i==1)
					id += (char)('1'+Math.random()*9);
				else
					id += (char)('0'+Math.random()*10);
			}
			stu.id = id;
			for(int i=1;i<=Math.random()*6;i++)
			{
				name += (char)('a'+Math.random()*26);
			}
			stu.name = name;
			for(int i=0;i<4;i++)
			{
				grades[i] = (int)(Math.random()*10000)/100.0;
				sum += grades[i];
				if(grades[i] > max)
					max = grades[i];
			}
			stu.max = max;
			stu.grades = grades;
			stu.averGrade = sum/4;
			return stu;
		}
	}



}
