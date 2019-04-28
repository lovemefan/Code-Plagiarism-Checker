package Hellowworld;

import java.util.Scanner;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Calculator extends JFrame implements ActionListener {
private final String[] KEYS = { "7", "8", "9", "/", "4", "5", "6", "*",
"1", "2", "3", "-", "0", "+/-", ".", "+", "1/x", "%", "sqrt", "=" };
Scanner input=new Scanner(System.in);
private final String[] COMMAND = { "Backspace", "C" };
private JButton keys[] = new JButton[KEYS.length];
private JButton commands[] = new JButton[COMMAND.length];
private JTextField resultText = new JTextField("0");
private JMenuBar mb = new JMenuBar();
private JMenu mu = new JMenu("编辑（E）");
JMenuItem j1, j2;


// 标志用户按的是否是整个表达式的第一个数字,或者是运算符后的第一个数字
private boolean firstDigit = true;
// 计算的中间结果。
private double resultNum = 0.0;
// 当前运算的运算符
private String operator = "=";
// 操作是否合法
private boolean operateValidFlag = true;


public Calculator() {
super();
// 初始化计算器
init();
this.setTitle("计算器");
this.setLocation(500, 300);
this.setResizable(false);
this.pack();
}


/**
* 初始化计算器
*/
private void init() {
resultText.setBackground(Color.WHITE);


// 初始化计算器上键的按钮，将键放在一个画板内
JPanel calckeysPanel = new JPanel();
calckeysPanel.setLayout(new GridLayout(5, 4, 3, 3));
for (int i = 0; i < KEYS.length; i++) {
keys[i] = new JButton(KEYS[i]);
calckeysPanel.add(keys[i]);
}


// 初始化功能键，都用红色标示。将功能键放在一个画板内
JPanel commandsPanel = new JPanel();
commandsPanel.setLayout(new GridLayout(1, 2, 3, 3));
for (int i = 0; i < COMMAND.length; i++) {
commands[i] = new JButton(COMMAND[i]);
commandsPanel.add(commands[i]);
}


JPanel panel1 = new JPanel();
panel1.setLayout(new BorderLayout(3, 3));
panel1.add("North", commandsPanel);
panel1.add("Center", calckeysPanel);


JPanel top = new JPanel();
top.setLayout(new BorderLayout());
top.add("Center", resultText);


getContentPane().setLayout(new BorderLayout(3, 5));
getContentPane().add("North", top);
getContentPane().add("Center", panel1);
for (int i = 0; i < KEYS.length; i++) {
keys[i].addActionListener(this);
}
for (int i = 0; i < COMMAND.length; i++) {
commands[i].addActionListener(this);
}

//给编辑菜单栏两个功能

j1 = new JMenuItem("复制");
mu.add(j1);
j2 = new JMenuItem("粘贴");
mu.add(j2);
mb.add(mu);
setJMenuBar(mb);
j1.addActionListener(this);
j2.addActionListener(this);
}


public void actionPerformed(ActionEvent e) {
// 获取事件源的标签
String label = e.getActionCommand();
if (e.getSource() == j1)
resultText.copy();
else if (e.getSource() == j2)
resultText.paste();
else if (label.equals(COMMAND[0])) {
// 用户按了"Backspace"键
handleBackspace();
} else if (label.equals(COMMAND[1])) {
// 用户按了"C"键
handleC();
} else if ("0123456789.".indexOf(label) >= 0) {
// 用户按了数字键或者小数点键
handleNumber(label);
} else {
// 用户按了运算符键
handleOperator(label);
}
}


private void handleBackspace() {
String text = resultText.getText();
int i = text.length();
if (i > 0) {
// 退格，将文本最后一个字符去掉
text = text.substring(0, i - 1);
if (text.length() == 0) {
// 如果文本没有了内容，则初始化计算器的各种值
resultText.setText("0");
firstDigit = true;
operator = "=";
} else {
// 显示新的文本
resultText.setText(text);
}
}
}


/**
* 处理数字键被按下的事件
*
* @param key
*/
private void handleNumber(String key) {
if (firstDigit) {
// 输入的第一个数字
resultText.setText(key);
} else if ((key.equals(".")) && (resultText.getText().indexOf(".") < 0)) {
// 输入的是小数点，并且之前没有小数点，则将小数点附在结果文本框的后面
resultText.setText(resultText.getText() + ".");
} else if (!key.equals(".")) {
// 如果输入的不是小数点，则将数字附在结果文本框的后面
resultText.setText(resultText.getText() + key);
}
// 以后输入的肯定不是第一个数字了
firstDigit = false;
}


/**
* 处理C键被按下的事件
*/
private void handleC() {
// 初始化计算器的各种值
resultText.setText("0");
firstDigit = true;
operator = "=";
}


/**
* 处理运算符键被按下的事件
*
* @param key
*/
private void handleOperator(String key) {
if (operator.equals("/")) {
// 除法运算
// 如果当前结果文本框中的值等于0
if (getNumberFromText() == 0.0) {
// 操作不合法
operateValidFlag = false;
resultText.setText("除数不能为零");
} else {
resultNum /= getNumberFromText();
}
} else if (operator.equals("1/x")) {
// 倒数运算
if (resultNum == 0.0) {
// 操作不合法
operateValidFlag = false;
resultText.setText("零没有倒数");
} else {
resultNum = 1 / resultNum;
}
} else if (operator.equals("+")) {
// 加法运算
resultNum += getNumberFromText();
} else if (operator.equals("-")) {
// 减法运算
resultNum -= getNumberFromText();
} else if (operator.equals("*")) {
// 乘法运算
resultNum *= getNumberFromText();
} else if (operator.equals("sqrt")) {
// 平方根运算
resultNum = Math.sqrt(resultNum);
} else if (operator.equals("%")) {
// 百分号运算，除以100
resultNum = resultNum / 100;
} else if (operator.equals("=")) {
// 赋值运算
resultNum = getNumberFromText();
}
if (operateValidFlag) {
// 双精度浮点数的运算
long t1;
double t2;
t1 = (long) resultNum;
t2 = resultNum - t1;
if (t2 == 0) {
resultText.setText(String.valueOf(t1));
} else {
resultText.setText(String.valueOf(resultNum));
}
}
// 运算符等于用户按的按钮
operator = key;
firstDigit = true;
operateValidFlag = true;
}


/**
* 从结果文本框中获取数字
*
* @return
*/
private double getNumberFromText() {
double result = 0;
try {
result = Double.valueOf(resultText.getText()).doubleValue();
} catch (NumberFormatException e) {
}
return result;
}


public static void main(String args[]) {
Calculator calculator1 = new Calculator();
calculator1.setVisible(true);
calculator1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
}