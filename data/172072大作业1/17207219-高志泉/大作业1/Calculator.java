
package ����ҵ1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Calculator {

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        Scanner s = new Scanner(System.in);
        System.out.println("��������Ҫ����ʽ��(����end�˳�������)��");
        Double result;
        while (s.hasNextLine()) {
            String str = s.nextLine();
            if ("end".equals(str)) {
                System.out.println("ллʹ��!");
                break;
            }
            // ���㴦��
            result = calc.prepareParam(str);
            if (result != null) {
                // ����������ӡ
                System.out.println(
                        MyUtils.formatResult(String.format("%." + MyUtils.RESULT_DECIMAL_MAX_LENGTH + "f", result)));
            }
        }

    }

    public Double prepareParam(String str) {
        // ��ֵУ��
        if (null == str || "".equals(str)) {
            return null;
        }
        // ����У��
        if (str.length() > MyUtils.FORMAT_MAX_LENGTH) {
            System.out.println("���ʽ������");
            return null;
        }
        // Ԥ����
        str = str.replaceAll(" ", "");// ȥ�ո�
        if ('-' == str.charAt(0)) {// ��ͷΪ��������-1����Ϊ0-1
            str = 0 + str;
        }
        // У���ʽ
        if (!MyUtils.checkFormat(str)) {
            System.out.println("���ʽ����");
            return null;
        }
        // ������ʽ����Ϊ��׼���ʽ
        str = MyUtils.change2StandardFormat(str);
        // ����ַ�������
        String[] nums = str.split("[^.0-9]");
        List<Double> numLst = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (!"".equals(nums[i])) {
                numLst.add(Double.parseDouble(nums[i]));
            }
        }
        String symStr = str.replaceAll("[.0-9]", "");
        return doCalculate(symStr, numLst);
    }

    
    public Double doCalculate(String symStr, List<Double> numLst) {
        LinkedList<Character> symStack = new LinkedList<>();// ����ջ
        LinkedList<Double> numStack = new LinkedList<>();// ����ջ
        double result = 0;
        int i = 0;// numLst�ı�־λ
        int j = 0;// symStr�ı�־λ
        char sym;// ����
        double num1, num2;// ����ǰ��������
        while (symStack.isEmpty() || !(symStack.getLast() == '=' && symStr.charAt(j) == '=')) {// ���磺
                                                                                                // =8=
                                                                                                // ���˳�ѭ�������Ϊ8
            if (symStack.isEmpty()) {
                symStack.add('=');
                numStack.add(numLst.get(i++));
            }
            if (MyUtils.symLvMap.get(symStr.charAt(j)) > MyUtils.symLvMap.get(symStack.getLast())) {// �ȽϷ������ȼ�������ǰ�������ȼ�����ǰһ����ѹջ
                if (symStr.charAt(j) == '(') {
                    symStack.add(symStr.charAt(j++));
                    continue;
                }
                numStack.add(numLst.get(i++));
                symStack.add(symStr.charAt(j++));
            } else {// ��ǰ�������ȼ�С�ڵ���ǰһ�� ���ŵ����ȼ�
                if (symStr.charAt(j) == ')' && symStack.getLast() == '(') {// ������֮��û�з��ţ��򡰣�����ջ
                    j++;
                    symStack.removeLast();
                    continue;
                }
                if (symStack.getLast() == '(') {// ������ֱ��ѹջ
                    numStack.add(numLst.get(i++));
                    symStack.add(symStr.charAt(j++));
                    continue;
                }
                num2 = numStack.removeLast();
                num1 = numStack.removeLast();
                sym = symStack.removeLast();
                switch (sym) {
                case '+':
                    numStack.add(MyUtils.plus(num1, num2));
                    break;
                case '-':
                    numStack.add(MyUtils.reduce(num1, num2));
                    break;
                case '*':
                    numStack.add(MyUtils.multiply(num1, num2));
                    break;
                case '/':
                    if (num2 == 0) {// ����Ϊ0
                        System.out.println("���ڳ���Ϊ0");
                        return null;
                    }
                    numStack.add(MyUtils.divide(num1, num2));
                    break;
                }
            }
        }
        return numStack.removeLast();
    }

}
