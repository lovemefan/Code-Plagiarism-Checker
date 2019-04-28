import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculater {
	private String s;
	
	Calculater(String s){//���췽��
		this.s=s;
	}
	
	//��λ������������
	public double doubleCal(double a1, double a2, char operator) throws Exception {
        switch (operator) {
        case '+':
            return a1 + a2;
        case '-':
            return a1 - a2;
        case '*':
            return a1 * a2;
        case '/':
            return a1 / a2;
        }
        throw new Exception("illegal operator!");
    }
	
	//����������ȼ�
	public int getPriority(String str)throws Exception   {
        if(str==null) return 0;
        switch(str) {
        case "(":return 1;
        case "+":
        case "-":return 2;
        case "*":
        case "/":return 3;
        }
        throw new Exception("illegal operator!");
    }
	
	//����׺���ʽת���ɺ�׺���ʽ
	public String toSufExpr() throws Exception {
        StringBuffer sufExpr = new StringBuffer();
        Stack<String> operator = new Stack<String>();/*ʢ���������ջ*/
        operator.push(null);//��ջ��ѹ��һ��null������������ȼ����������������ж�
        /* �����ʽ��ɢ��ɢ��������������� */
        Pattern p = Pattern.compile("(?<!\\d)-?\\d+(\\.\\d+)?|[+\\-*/()]");//�������Ϊƥ����ʽ�е����ֻ������
        Matcher m = p.matcher(s);
        while (m.find()) {
            String temp = m.group();
            if (temp.matches("[+\\-*/()]")) { //�������
                if (temp.equals("(")) { //���������ţ�ֱ��ѹջ
                    operator.push(temp);
                } else if (temp.equals(")")) { //���������ţ���ջ���ֱ�����������ţ������Ų������
                    String topItem = null;
                    while (!(topItem =operator.pop()).equals("(")) {
                        sufExpr.append(topItem+" ");
                    }
                } else {//������������Ƚ�ջ�����ţ�������������ȼ�����ջ����ֱ��ѹջ����С��ջ������ջ���ֱ������ջ����Ȼ�󽫸������ѹջ��
                    while(getPriority(temp) <= getPriority(operator.peek())) {
                        sufExpr.append(operator.pop()+" ");
                    }
                    operator.push(temp);
                }
            }else {//��������ֱ�����
                sufExpr.append(temp+" ");
            }
        }
        String topItem = null;//��󽫷���ջ��ջ�����
        while(null != (topItem =operator.pop())) {
            sufExpr.append(topItem+" ");
        }
        return sufExpr.toString();
    }
	
	//���ݺ�׺���ʽ������
	public String getResult() throws Exception {
        String sufExpr = toSufExpr();// תΪ��׺���ʽ
        Stack<Double> number = new Stack<Double>(); /* ʢ������ջ */
        /* �������ƥ��ÿ�����ֺͷ��� */
        Pattern p = Pattern.compile("-?\\d+(\\.\\d+)?|[+\\-*/]");
        Matcher m = p.matcher(sufExpr);
        while (m.find()) {
            String temp = m.group();
            if (temp.matches("[+\\-*/]")) {// ������������������������ȡ�������и����㣬������ٷ�������
                double a1 = number.pop();
                double a2 = number.pop();
                double res = doubleCal(a2, a1, temp.charAt(0));
                number.push(res);
            } else {// ��������ֱ�ӷ�������
                number.push(Double.valueOf(temp));
            }
        }
       return s+"="+number.pop();
    }
	
}
