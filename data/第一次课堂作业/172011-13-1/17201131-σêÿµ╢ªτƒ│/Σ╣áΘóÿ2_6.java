����   6 L  课堂作业/习题2_6  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this L课堂作业/习题2_6; main ([Ljava/lang/String;)V  java/util/Scanner	    java/lang/System   in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V	     out Ljava/io/PrintStream;   %Enter a number between 0 and 1000 ：
 " $ # java/io/PrintStream % & println (Ljava/lang/String;)V
  ( ) * nextInt ()I , ERROR . Input out of range! 0 Again: 2 java/lang/StringBuilder 4 The sum of the digits is：
 1 6  &
 1 8 9 : append (I)Ljava/lang/StringBuilder;
 1 < = > toString ()Ljava/lang/String;
  @ A  close args [Ljava/lang/String; scan Ljava/util/Scanner; t I add StackMapTable 
SourceFile 习题2_6.java !               /     *� �    
                    	      <     �� Y� � L� � !+� '=�  � +� !� -� !� /� !+� '=�������>
� >� .
� d� 
l
p`>� dl
l
p`
p`>� � 1Y3� 5� 7� ;� !+� ?�    
   N            	 # 
 +  3  8  C  E  K  M  \  f  i  {  �  �     *    � B C    � D E   ~ F G  E Q H G  I    �  �   J    K