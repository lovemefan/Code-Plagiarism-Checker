����   6 ;  第二次作业/Stock  java/lang/Object symbol Ljava/lang/String; name previousClosingPrice D currentPrice <init> '(Ljava/lang/String;Ljava/lang/String;)V Code
     ()V	    java/lang/System   out Ljava/io/PrintStream;  java/lang/StringBuilder  
symbol is 
     (Ljava/lang/String;)V
     ! append -(Ljava/lang/String;)Ljava/lang/StringBuilder; # 
, name is  % .
  ' ( ) toString ()Ljava/lang/String;
 + - , java/io/PrintStream .  println LineNumberTable LocalVariableTable this L第二次作业/Stock; getChangePercent ()D	  6 
 		  8  	 
SourceFile 
Stock.java !                     	     
 	            o     )*� � � Y� +� "� ,� $� � &� *�    /          ( 	 0        ) 1 2     )      )      3 4     4     
*� 5*� 7o�    /        0       
 1 2    9    :