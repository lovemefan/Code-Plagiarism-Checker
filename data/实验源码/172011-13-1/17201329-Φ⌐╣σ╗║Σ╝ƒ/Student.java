//ѧ����
public class Student {	
	String studentID;// ѧ��ѧ��	
	String studentName;// ѧ������	
	int[] scores = new int[4];// ѧ���ɼ�		
	double average = 0;//ѧ��ƽ����		
	int max = 0;	

	// ���ѧ������	
	public String getName() {		
		return this.studentName;	
	}	

	// ���ѧ��ѧ��	
	public String getID() {		
		return this.studentID;	
	}	
	
	// ѧ����Ĺ��췽��	
	// (ѧ��id,ѧ�����֣�ѧ������)	
	public Student(String studentID, String studentName, int[] scores) {
		this.studentID = studentID;
		this.studentName = studentName;
		for (int i = 0; i < 4; i++) {
			this.scores[i] = scores[i];
		}
	}
	//ѧ����Ĺ��췽��	public Student(){			
	}
	// ���ѧ���ɼ��е����ֵ
	public int max() {
		int max = 0;
		for (int i = 0; i < 4; i++) {
			if (this.scores[i] > max) {
				max = this.scores[i];	
		}
	}
	return max;	
}

	// ���ѧ���ɼ���ƽ��ֵ
	public double average() {
		int sum = 0;
		for (int i = 0; i < 4; i++) {
			sum += this.scores[i];
		}
		return sum / 4;
	}
	//���ѧ����ƽ����
	//ѧ������
	public double sumAverage(Student[] student){
		double sum = 0;
		for (int i = 0; i < 30; i ++){
			sum +=student[i].average();
		}	
	return sum /30;
	}
	//����ѧ������
	//ѧ������
	public void setName(String name){
		this.studentName = name;
	}	
	//����ѧ��ѧ��
	//ѧ��ѧ��
	public void setID(String id){
		this.studentID = id;
	}	
	//����ѧ������
	//����
	public void setScores(int[] scores){	
		for (int i = 0; i < 4; i ++){
			this.scores[i] = scores[i];
		}
	}	
	//����ѧ����߷�
	//��߷�
	public void setMax(int max){
		this.max = max;
	}	
	//����ѧ��ƽ����
	//ƽ����
	public void setAverage(double average){
		this.average = average;
	}
}