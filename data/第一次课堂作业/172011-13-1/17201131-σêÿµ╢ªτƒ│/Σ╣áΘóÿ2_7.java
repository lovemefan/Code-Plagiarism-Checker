����   6 X  课堂作业/习题2_7  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this L课堂作业/习题2_7; main ([Ljava/lang/String;)V  java/util/Scanner	    java/lang/System   in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V	     out Ljava/io/PrintStream;   Enter the number of minutes:
 " $ # java/io/PrintStream % & println (Ljava/lang/String;)V
  ( ) * nextInt ()I   - java/lang/StringBuilder
 / 1 0 java/lang/String 2 3 valueOf (I)Ljava/lang/String;
 , 5  & 7  minutes is approximately 
 , 9 : ; append -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 , = : > (I)Ljava/lang/StringBuilder; @  years and  B  days
 , D E F toString ()Ljava/lang/String; H ) minutes is approximately less than a day
  J K  close args [Ljava/lang/String; scan Ljava/util/Scanner; t I years days StackMapTable M 
SourceFile 习题2_7.java !               /     *� �    
                    	      d     �� Y� � L� � !+� '=>6+� A+l>+p�l6� � ,Y� .� 46� 8� <?� 8� <A� 8� C� !� Y+� :�� 3+p�l6� � ,Y� .� 46� 8� <A� 8� C� !� � � ,Y� .� 4G� 8� C� !+� I�    
   B            	  
 #  (  2  ^  n  x  �  �  �  �     4    � L M    � N O   � P Q   � R Q   � S Q  T    � a  U   <  V    W