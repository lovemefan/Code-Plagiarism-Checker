package ʵ��һ;
public class Student {
	int studentID;             //ѧ��
	String studentName;        //����
	int[] scores = new int[4]; //�ĸ�����
	int getStudentID() {       //�õ�ѧ�ŷ���
		return studentID;
	}
	String getStudentName() {  //�õ���������
		return studentName;
	}
	Student(){                 //�޲ι��췽��
		
	}
	Student(int studentID,String studentName,int a,int b,int c,int d){//���ι��췽��
		this.studentID = studentID;     //����ֵ
		this.studentName = studentName;
		this.scores[0] = a;
		this.scores[1] = b;
		this.scores[2] = c;
		this.scores[3] = d;
		
	}
	int max() {//�ҳ������
		int t = 0;
		for(int i = 0;i < scores.length;i ++) {
			if(t < scores[i]) {
				t = scores[i];
			}
		}
		return t;
	}
	
	double averageScore() {//��ƽ����
		double t = 0;
		t = (double)(this.scores[0] + this.scores[1] + this.scores[2] + this.scores[3]) / scores.length;
		return t;
	}
}
