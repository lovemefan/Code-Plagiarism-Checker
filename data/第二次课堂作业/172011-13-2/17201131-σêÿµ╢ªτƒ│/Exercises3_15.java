����   6 \  第二次作业/Exercises3_15  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this L第二次作业/Exercises3_15; main ([Ljava/lang/String;)V  java/util/Scanner	    java/lang/System   in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V
    java/lang/Math    random ()D@�      @Y      	  & ' ( out Ljava/io/PrintStream; * java/lang/StringBuilder , winning num is 
 ) .  / (Ljava/lang/String;)V
 ) 1 2 3 append (I)Ljava/lang/StringBuilder;
 ) 5 6 7 toString ()Ljava/lang/String;
 9 ; : java/io/PrintStream < / println > %Enter a three digit positive integer:
  @ A B nextInt ()I D &Congratulations and a prize of $10000! F %Congratulations and a prize of $3000! H %Congratulations and a prize of $1000! J #I'm sorry you didn't win the prize!
  L M  close args [Ljava/lang/String; scan Ljava/util/Scanner; winning I input num [I StackMapTable O V 
SourceFile Exercises3_15.java !               /     *� �    
                    	      5    k� Y� � L�  !k #c�=� %� )Y+� -� 0� 4� 8� %=� 8+� ?>�
:dlO
l
pO
pOdlO
l
pO
pO..� $..� ..� � %C� 8� �..� ..� $..� ..� ..� ..� � %E� 8� y..� [..� P..� E..� :..� /..� $..� ..� ..� � %G� 8� � %I� 8+� K�    
   Z         .  6 	 ; 
 A  I  T  \  d  o  w  �  �  �  � S [ ^ f j     4   k N O   ` P Q  S R S  ;0 T S  A* U V  W    	� �  X  Y  


� b
  Z    [