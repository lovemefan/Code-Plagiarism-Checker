package calculat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class calculat {
    void read(File f,String[] exp) {  //��ȡ�ļ��еı��ʽ�����浽������
        int i=0;
        try (Scanner input = new Scanner(f);){
            while(input.hasNextLine()) {
                exp[i] = input.nextLine();//��ʽ��д��
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
        
    
    boolean match(String exp) {// ������Ų�ƥ�䣬�򷵻� true;���򷵻�false
        int len = exp.length();
        LinkedList<Character> stack = new LinkedList<Character>();
        // ѭ�������ַ���
        for (int i = 0; i < len; i++) {
            // ���������������ջ
            char  ch = (char) exp.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                // �����������
            } else if (ch == ')') {
                // ջ�գ���������û��ƥ��������ţ��򷵻�false
                if (stack.isEmpty()) {
                    return true;
                    // ջ���գ����ջ���Ƚ�
                } else if (stack.peek().equals(ch)) {
                    return true;
                } else {
                    stack.pop();
                }
            }
        }
        // ѭ��������ջ�ձ�ʾƥ�����ˣ����ձ�ʾ����������
        if (stack.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }
    
    boolean judge(String exp) { //ͨ��������ʽ�жϱ��ʽ�Ƿ���Ϲ���
        String regex1 = " ";//���ַ�
        String regex2 = "\\(\\)";//������
        String regex3 = "[\\~!/@#$%^&*\\\\-_=+\\\\|[{}];:\\'\\\",<.>/?]+";//�Ƿ��ַ�
        String regex4 = ".[\\/\\*\\-\\+]{2,}.";//���������
        String regex5 = "^[\\+\\-\\*\\/\\)].*";//�����ǰ��������
        String regex6 = ".*[\\(\\+\\/\\*\\-]";//���������������
        String regex7 = ".*\\d\\(.*";//����ǰ�������,�����Ų��ǵ�һ��
        String regex8 = ".*\\)\\d.*";//���ź��������
        if(exp!=null) {
        if (exp.matches(regex1) == true )
        {
            System.out.println("���ʽΪ: ��"+exp);
            System.out.println( "#ERROR");
            System.out.println("�ǿ��ַ�����");
            System.out.println("����������");
            System.out.println(" ");
            return false;
            
        }
        else if (exp.matches(regex2) == true ) {
            System.out.println("���ʽΪ: "+exp);
            System.out.println("#ERROR");
            System.out.println("���ʽ���п����� ");
            System.out.println("����������");
            System.out.println(" ");
            return false;
        }
        else if ( exp.matches(regex3) == true ) {
            System.out.println("���ʽΪ: "+exp);
            System.out.println("#ERROR ");
            System.out.println("���ʽ�зǷ��ַ� ");
            System.out.println("����������");
            System.out.println(" ");
            return false;
        }
        else if ( match(exp) == true ) {
            System.out.println("���ʽΪ: "+exp);
            System.out.println("#ERROR ");
            System.out.println("���Ų�ƥ�� ");
            System.out.println("����������");
            System.out.println(" ");
            return false;
        }
        else if ( exp.matches(regex4) == true ) {
            System.out.println("���ʽΪ: "+exp);
            System.out.println("#ERROR ");
            System.out.println("���������");
            System.out.println("����������");
            System.out.println(" ");
            return false;
        }
        else if ( exp.matches(regex5) == true ) {
            System.out.println("���ʽΪ: "+exp);
            System.out.println("#ERROR ");
            System.out.println("�����ǰ��������"); 
            System.out.println("����������");
            System.out.println(" ");
            return false;
        }
        else if ( exp.matches(regex6) == true ) {
            System.out.println("���ʽΪ: "+exp);
            System.out.println("#ERROR ");
            System.out.println("���������������");
            System.out.println("����������");
            System.out.println(" ");
            return false;
        }
        else if ( exp.matches(regex7) == true ) {
            System.out.println("���ʽΪ: "+exp);
            System.out.println("#ERROR ");
            System.out.println("���ŷǵ�һ���ַ���֮ǰ�������");
            System.out.println("����������");
            System.out.println(" ");
            return false;

        }
        else if (exp.matches(regex8) == true ) {
            System.out.println("���ʽΪ: "+exp);
            System.out.println("#ERROR ");
            System.out.println("С���ź�������������ŷ����һ���ַ�");
            System.out.println("����������");
            System.out.println(" ");
            return false;
        }
        else 
        {
            return true;
        }
        }
        else
            return false;
    }
    
    public void write(File f,String[] exp) throws FileNotFoundException { //�����д���ļ�
        int i=0;
      try(  PrintWriter output=new PrintWriter(f))
      {
        for(i=0;i<exp.length-1;i++){
            if(!judge(exp[i])) {
              System.out.println("");
            }
            else {
                output.print("���ʽΪ: "+exp[i]+" = ");             
                nmsl x=new nmsl(exp[i]);     
                int re=x.jisuan();
                
                output.println(re);
            }
        }
      }
    }
    
    
    public static void main(String[] args) throws FileNotFoundException {
        String[] exp=new String[17];
        File f1=new File("src/input");
        File f2=new File("src/output");
        calculat x=new calculat();
        x.read(f1, exp);
        x.write(f2, exp);
        //x.output(f2);
    }
}
