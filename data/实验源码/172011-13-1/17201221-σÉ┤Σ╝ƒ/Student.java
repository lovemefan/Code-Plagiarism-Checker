
public class Student {
	int studentID;
	String studentName;
	int[] scores;
	public int getID(){
		return studentID;
	}
	
	public Student(String studentName,int studentID,int[] scores){
		this.studentName=studentName;
		this.studentID=studentID;
		this.scores=scores;
	}
	
	//���ؼ��������ƽ��ֵ
		public double averageScore(){
			return ((scores[0]+scores[1]+scores[2]+scores[3])/4);
		}
	
	//����ѧ������
	public String getName(){
		return studentName;
	}
	
	//�������ſ�Ŀ���������ֵ
	public int max(){
		int max=0; 
		for (int i=0;i<4;i++){
			if (max<scores[i])
				max=scores[i];
		}
		return max;
	}
	

}
