����   6 a  第二次作业/Exercises3_1  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this L第二次作业/Exercises3_1; main ([Ljava/lang/String;)V  java/util/Scanner	    java/lang/System   in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V	     out Ljava/io/PrintStream;   Enter a,b,c:
 " $ # java/io/PrintStream % & println (Ljava/lang/String;)V
  ( ) * 
nextDouble ()D@      ?�      
 0 2 1 java/lang/Math 3 4 pow (DD)D@        8 java/lang/StringBuilder : The equation has two roots 
 7 <  &
 7 > ? @ append (D)Ljava/lang/StringBuilder; B and
 7 D ? E -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 7 G H I toString ()Ljava/lang/String; K The equation has one root  M The equation has no real roots 
  O P  close args [Ljava/lang/String; scan Ljava/util/Scanner; input [D i I t D roots StackMapTable V R 
SourceFile Exercises3_1.java !               /     *� �    
                    	      �     ޻ Y� � L�M� � !>� ,+� 'R�,����,1,1k +,1k,1kg -� /J�:)�� O,1w)c 5,1koR,1w)g 5,1koR� � 7Y9� ;1� =A� C1� =� F� !� ?)�� 1,1w)c 5,1koR� � 7YJ� ;1� =� F� !� � L� !+� N�    
   N            	 #  ,  F  K  Q  c  u  �  �  �  �  �  �  �     >    � Q R    � S T   � U V    W X  F � Y Z  K � [ V  \   # �   ]	� v  ^  ] ]  3  _    `