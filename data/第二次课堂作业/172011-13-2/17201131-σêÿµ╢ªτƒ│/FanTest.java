����   6 U  第二次作业/FanTest  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this L第二次作业/FanTest; main ([Ljava/lang/String;)V  第二次作业/Fan
  	
     setSpeed (I)I@$      
     	setRadius (D)D  yellow
    ! " setColor &(Ljava/lang/String;)Ljava/lang/String;
  $ % & setOn ()Z@      
  * + , getColor ()Ljava/lang/String;
  . / & isOn
  1 2 3 toString )(ZILjava/lang/String;D)Ljava/lang/String;	 5 7 6 java/lang/System 8 9 out Ljava/io/PrintStream;
 ; = < java/io/PrintStream > ? println (Ljava/lang/String;)V args [Ljava/lang/String; f1 L第二次作业/Fan; f2 s1 I r1 D c1 Ljava/lang/String; o1 Z s2 r2 c2 o2 p1 p2 
SourceFile FanTest.java !               /     *� �    
                    	      O     u� Y� L� Y� M+� >+ � 9+� :+� #6,� 6, '� 9	,� ):,� -6+� 0:+	� 0:� 4� :� 4� :�    
   >             ' 	 - 
 4  =  C  I  V  d  l  t     �    u @ A    m B C   e D C   _ E F   V G H  ' N I J  - H K L  4 A M F  = 8 N H 	 C 2 O J  I , P L  V  Q J  d  R J   S    T