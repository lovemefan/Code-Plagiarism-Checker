����   6 Z  课堂作业/习题2_19  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this L课堂作业/习题2_19; main ([Ljava/lang/String;)V  java/util/Scanner	    java/lang/System   in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V	     out Ljava/io/PrintStream;   "Enter three points for a triangle:
 " $ # java/io/PrintStream % & println (Ljava/lang/String;)V ( ps:(x1,y1,x2,y2,x3,y3)
  * + , 
nextDouble ()D?�      
 0 2 1 java/lang/Math 3 4 pow (DD)D@        8 java/lang/StringBuilder : The area of the triangle is 
 7 <  &
 7 > ? @ append (D)Ljava/lang/StringBuilder;
 7 B C D toString ()Ljava/lang/String;
  F G  close args [Ljava/lang/String; scan Ljava/util/Scanner; points [D i I t d s D n StackMapTable M I 
SourceFile 习题2_19.java !               /     *� �    
                    	       
 	  � Y� � L� � !� '� !�M>� ,+� )R�,�����N-,1,1g,1,1gk,1,1g,1,1gkcR-,1,1g,1,1gk,1,1g,1,1gkcR-,1,1g,1,1gk,1,1g,1,1gkcR�:6� -1 -� /R�����11c1c 5o91gk1gk1gk9� � 7Y9� ; -� /� =� A� !+� E�    
   R             	 % 
 , 	 5  9  [  }  �  �  �  �  �  �  �       \ 	   H I    J K    � L M  "  N O  9 � P M  � r Q M  �  N O  � > R S  � " T S  U   % � %  V	� z  W  V V V    X    Y