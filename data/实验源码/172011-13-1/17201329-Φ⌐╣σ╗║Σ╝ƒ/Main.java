
public class Main {
	//����
	public static void main(String[] args) {
		// ����30��ѧ������
		Student[] student = new Student[30];
		// ����һ��ѧ������
		Student student1;
		student1 = new Student();
		// ����1���������
		Proceed Deel = new Proceed();
		// ��ʼ��30��ѧ������
		Deel.initialize(student);
		//������ͬѧ������
		if (Deel.input(student1) == 1){
			return;
		}
		//�����ͬѧ����
		Deel.output(student1);
		// ������ͬѧ��ƽ���ɼ�����߷�
		Deel.judge(student1,student);
		
	}
}
