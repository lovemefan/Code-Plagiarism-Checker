import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) throws IOException {
        //��д��������в���
    	Calc calc = new Calc();
        Scanner in = new Scanner(System.in);
        FileExpression fo = new FileExpression();
        ArrayList<String> list = new ArrayList<>();
        ArrayList newlist = new ArrayList();
        //��ȡ����
        list = fo.Reader();
        //����У����
        IsLegal legal = new IsLegal();
        //������ͬ����
        newlist = getSingle(list);
        //�����������
        list.clear();
        for (int i = 0; i < newlist.size() ; i++) {
            list.add((String)newlist.get(i));
        }
        //���������ܶ����Ļ���
        if (list.get(list.size()-1).equals("")&&list.size()!=0){
        list.remove(list.size()-1);
        }
        //��������������������뵽���.txt��
        ArrayList<String> list1  = new ArrayList<>();
        list1 = legal.judge(list);
        String []list2 = new String[list1.size()];
        for (int i = 0; i <list1.size() ; i++) {
            list2[i] = list1.get(i);
        }
        //����д��
        fo.Writer(list2);
    }

    public static ArrayList getSingle(ArrayList list) {
        ArrayList tempList = new ArrayList();                    //1,�����¼���
        Iterator it = list.iterator();
        //2,���ݴ���ļ���(�ϼ���)��ȡ������
        while(it.hasNext()) {                                    //3,�����ϼ���
            Object obj = it.next();                                //��¼סÿһ��Ԫ��
            if(!tempList.contains(obj)) {                        //����¼����в������ϼ����е�Ԫ��
                tempList.add(obj);                                //����Ԫ�����
            }
        }
        return tempList;
    }
}
