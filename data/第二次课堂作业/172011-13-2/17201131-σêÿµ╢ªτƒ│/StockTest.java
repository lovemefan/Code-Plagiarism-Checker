����   6 P  第二次作业/StockTest  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this L第二次作业/StockTest; main ([Ljava/lang/String;)V  第二次作业/Stock  ORCL  Oracle Corporation
     '(Ljava/lang/String;Ljava/lang/String;)V@A@     	     previousClosingPrice D@A,�����	  " #  currentPrice
  % & ' getChangePercent ()D	 ) + * java/lang/System , - out Ljava/io/PrintStream; / java/lang/StringBuilder 1 previousClosingPrice is 
 . 3  4 (Ljava/lang/String;)V
 . 6 7 8 append (D)Ljava/lang/StringBuilder; : ,currentPrice is 
 . < 7 = -(Ljava/lang/String;)Ljava/lang/StringBuilder; ? , changePercent is 
 . A B C toString ()Ljava/lang/String;
 E G F java/io/PrintStream H 4 println args [Ljava/lang/String; sto L第二次作业/Stock; percent 
SourceFile StockTest.java !               /     *� �    
                    	       �     N� Y� L+ � + � !+� $I� (� .Y0� 2+� � 59� ;+� !� 5>� ;(� 5� @� D�    
                M 	         N I J    B K L   / M    N    O