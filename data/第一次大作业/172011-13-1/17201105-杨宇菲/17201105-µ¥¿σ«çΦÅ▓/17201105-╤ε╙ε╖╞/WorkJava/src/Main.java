	import java.util.*;
	import java.util.regex.*;
	import java.io.File;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.io.Reader;
	import java.io.Writer;
				class OPNode
				{
					char op;//运算符符号
					int level;//运算符的优先级
					public OPNode(String op){
						this.op=op.charAt(0);//运算符的位置
						if(op.equals("+")||op.equals("-")) {
							this.level=1;//运算级为1
						}
						else if(op.equals("*")||op.equals("/")){
							this.level=2;//运算级为2
						}
						else if(op.equals("(")){
							this.level=-3;//运算级为-3
						}
						else{
							this.level=-1;//运算级为-1
						}
					}
				}
			
				public class   Main {
					public static void main(String[] args) throws IOException {//写入文件
						java.io.File file=new java.io.File("C:\\Users\\杨宇菲\\Desktop" + File.separator + "test1.txt");
	
						Reader reader = new FileReader(file);
	
						char cs[] = new char[(int) file.length()];
						reader.read(cs, 0, (int) file.length());
						//System.out.println(cs);
						
						String s = "";
						List<String> expList = new ArrayList<String>();
						
						for(int i=0;i<cs.length;i++){//读取
							if(cs[i]!='\r'){
								if(cs[i]!=' '&&cs[i]!='\n'){
									s+=cs[i];
								}
							}
							else {
								i++;
								expList.add(s);
								s="";
							}
						}
						/*for(int i=0;i<expList.size();i++){
							System.out.println(expList.get(i));
						}*/
						for(int i=0;i<expList.size();i++)//判断表达式的正确与否以及错误信息
						{
						Check check=new Check();
						String expression=expList.get(i);
						//System.out.println(expression);
									
						if(check.check1(expression)!="true"){
							//System.out.println(check.check1(expression));
							String str="ERROR\r\n#"+check.check1(expression);
							Output op=new Output();
							op.outPut(str);
							continue;
						}
						
						else if(check.check2(expression)!="true"){
							//System.out.println(check.check2(expression));
							String str = "ERROR\r\n#"+check.check2(expression);
                            Output op = new Output();
							op.outPut(str);
							continue;
						}
					 
						
						Pattern entryOfExpression=Pattern.compile("[0-9]+(\\.[0-9]+)?|\\(|\\)|\\+|-|\\*|/");
						//Pattern entryOfExpression=Pattern.compile("[0-9]+|\\(|\\)|\\+|-|\\*|/");
						Matcher m=entryOfExpression.matcher(expression);
						LinkedList<Object> stack=new LinkedList<Object>();
						List<Object> list=new LinkedList<Object>();
						while(m.find()) {//读取语素
							String nodeString=expression.substring(m.start(),m.end());
							//System.out.println("flag"+nodeString);
							if(nodeString.matches("[0-9].*")){//如果是数值 直接送入列表
								list.add(Double.valueOf(nodeString));
							}
							else{
								OPNode opn=new OPNode(nodeString);//如果是运算符 根据不同情况处理
								int peekLevel=(stack.peek()==null)?0:((OPNode)stack.peek()).level;
								if(opn.level>peekLevel){
									stack.push(opn);//新运算符比栈顶运算符优先级高，则入栈
								}
								else{
									if(opn.level==-1){//如果为‘（’则将运算符出栈，直到遇到‘）’
										OPNode tempOpn=(OPNode)stack.pop();
										while(tempOpn.level!=-3){
											list.add(tempOpn);//出栈的运算符添加到列表
											tempOpn=(OPNode)stack.pop();
										}
									}
									else if(opn.level==-3){
										stack.push(opn);//如果为‘（’则直接入栈
									}
									else
									{
										OPNode tempOpn=(OPNode)stack.pop();//如果新运算符比栈顶运算符优先级低 
										//则一直出栈直到栈为空或者新运算符比栈顶运算符优先级高
										while(tempOpn.level>=opn.level)
										{
											list.add(tempOpn);
											if(stack.isEmpty())
											{
												break;
											}
											tempOpn=(OPNode)stack.pop();
										}
										stack.push(opn);//新符号入栈
									}
								}
							}
						}
						
						OPNode tempOpn=null;
						while(!stack.isEmpty()){//栈中剩余的运算符送入列表
							tempOpn=(OPNode)stack.pop();
							list.add(tempOpn);
						}
						stack.clear();
						for(Object o:list){//后续表达式计算
							if(o instanceof Double){
								stack.push(o);//如为数值直接入栈
							}
							else{//如果为运算符号则取出栈中的两个数值计算，并将结果入栈
								double opd2=((Double)stack.pop()).doubleValue();
								double opd1=((Double)stack.pop()).doubleValue();
								switch(((OPNode)o).op){
								case '+':
									stack.push(opd1+opd2);
									break;
								case '-':
									stack.push(opd1-opd2);
									break;
								case '*':
									stack.push(opd1*opd2);
									break;
								case '/':
									stack.push(opd1/opd2);
									break;
								}
							}
						}
						String str=expression+"="+stack.pop();//打印运算结果
						
						Output op=new Output();
						op.outPut(str);
						
						//System.out.println(expression+"="+stack.pop());
					}
				}
			}
