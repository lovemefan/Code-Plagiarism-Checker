package ����ҵ;
/**
 * ���ڷָ�ʱ�����ж��Ƿ�Ϊ��λ�������ÿո����
 * @author ����ʯ
 *
 */
public class Insertion {
	String infix = "";
	
	void longNum(String infix) {
        for (int i = 0; i < infix.length() - 1; i++) {//�����ַ���
            char temp1 = infix.charAt(i);
            char temp2 = infix.charAt(i + 1);
            if (isNum(temp1) && isNum(temp2)) {
                this.infix += temp1;//��������ʱ
            } else {
                this.infix += temp1 + " ";//���ֲ������ˣ����ӿո�
            }
        }
        this.infix += infix.charAt(infix.length() - 1); // �����һ��Ԫ����ӽ�ȥ
    }
	
	boolean isNum(char ch){//���������
    	 if (ch >= '0' && ch <= '9')
             return true;
         else
             return false;
    }
}
