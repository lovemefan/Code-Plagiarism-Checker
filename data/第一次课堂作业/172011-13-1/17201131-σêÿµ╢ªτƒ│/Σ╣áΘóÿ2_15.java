����   6 R  课堂作业/习题2_15  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this L课堂作业/习题2_15; main ([Ljava/lang/String;)V  java/util/Scanner	    java/lang/System   in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V	     out Ljava/io/PrintStream;   Enter x1 and y1:
 " $ # java/io/PrintStream % & println (Ljava/lang/String;)V
  ( ) * 
nextDouble ()D , Enter x2 and y2: . java/lang/StringBuilder 0 'The distance between the two points is 
 - 2  &?�      
 6 8 7 java/lang/Math 9 : pow (DD)D
 - < = > append (D)Ljava/lang/StringBuilder;
 - @ A B toString ()Ljava/lang/String;
  D E  close args [Ljava/lang/String; scan Ljava/util/Scanner; x1 D y1 x2 y2 t 
SourceFile 习题2_15.java !               /     *� �    
                    	       �     k� Y� � L� � !+� 'I+� '9� +� !+� '9+� '9(g(gkggkc9
� � -Y/� 1
 3� 5� ;� ?� !+� C�    
   .            	 & 
 ,  2  I  f  j     H    k F G    ` H I   S J K   M L K  , ? M K  2 9 N K  I " O K 
  P    Q