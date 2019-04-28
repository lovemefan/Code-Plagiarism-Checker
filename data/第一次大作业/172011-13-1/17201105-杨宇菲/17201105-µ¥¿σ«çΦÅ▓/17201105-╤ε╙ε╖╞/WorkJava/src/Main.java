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
					char op;//���������
					int level;//����������ȼ�
					public OPNode(String op){
						this.op=op.charAt(0);//�������λ��
						if(op.equals("+")||op.equals("-")) {
							this.level=1;//���㼶Ϊ1
						}
						else if(op.equals("*")||op.equals("/")){
							this.level=2;//���㼶Ϊ2
						}
						else if(op.equals("(")){
							this.level=-3;//���㼶Ϊ-3
						}
						else{
							this.level=-1;//���㼶Ϊ-1
						}
					}
				}
			
				public class   Main {
					public static void main(String[] args) throws IOException {//д���ļ�
						java.io.File file=new java.io.File("C:\\Users\\�����\\Desktop" + File.separator + "test1.txt");
	
						Reader reader = new FileReader(file);
	
						char cs[] = new char[(int) file.length()];
						reader.read(cs, 0, (int) file.length());
						//System.out.println(cs);
						
						String s = "";
						List<String> expList = new ArrayList<String>();
						
						for(int i=0;i<cs.length;i++){//��ȡ
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
						for(int i=0;i<expList.size();i++)//�жϱ��ʽ����ȷ����Լ�������Ϣ
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
						while(m.find()) {//��ȡ����
							String nodeString=expression.substring(m.start(),m.end());
							//System.out.println("flag"+nodeString);
							if(nodeString.matches("[0-9].*")){//�������ֵ ֱ�������б�
								list.add(Double.valueOf(nodeString));
							}
							else{
								OPNode opn=new OPNode(nodeString);//���������� ���ݲ�ͬ�������
								int peekLevel=(stack.peek()==null)?0:((OPNode)stack.peek()).level;
								if(opn.level>peekLevel){
									stack.push(opn);//���������ջ����������ȼ��ߣ�����ջ
								}
								else{
									if(opn.level==-1){//���Ϊ���������������ջ��ֱ������������
										OPNode tempOpn=(OPNode)stack.pop();
										while(tempOpn.level!=-3){
											list.add(tempOpn);//��ջ���������ӵ��б�
											tempOpn=(OPNode)stack.pop();
										}
									}
									else if(opn.level==-3){
										stack.push(opn);//���Ϊ��������ֱ����ջ
									}
									else
									{
										OPNode tempOpn=(OPNode)stack.pop();//������������ջ����������ȼ��� 
										//��һֱ��ջֱ��ջΪ�ջ������������ջ����������ȼ���
										while(tempOpn.level>=opn.level)
										{
											list.add(tempOpn);
											if(stack.isEmpty())
											{
												break;
											}
											tempOpn=(OPNode)stack.pop();
										}
										stack.push(opn);//�·�����ջ
									}
								}
							}
						}
						
						OPNode tempOpn=null;
						while(!stack.isEmpty()){//ջ��ʣ�������������б�
							tempOpn=(OPNode)stack.pop();
							list.add(tempOpn);
						}
						stack.clear();
						for(Object o:list){//�������ʽ����
							if(o instanceof Double){
								stack.push(o);//��Ϊ��ֱֵ����ջ
							}
							else{//���Ϊ���������ȡ��ջ�е�������ֵ���㣬���������ջ
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
						String str=expression+"="+stack.pop();//��ӡ������
						
						Output op=new Output();
						op.outPut(str);
						
						//System.out.println(expression+"="+stack.pop());
					}
				}
			}
