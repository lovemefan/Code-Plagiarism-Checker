����   6 X  第二次作业/Exercises3_29  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this L第二次作业/Exercises3_29; main ([Ljava/lang/String;)V  java/util/Scanner	    java/lang/System   in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V	     out Ljava/io/PrintStream;   3Enter circle1's center x-,y-coordinates,and radius:
 " $ # java/io/PrintStream % & println (Ljava/lang/String;)V
  ( ) * 
nextDouble ()D , 3Enter circle2's center x-,y-coordinates,and radius:
  . / 0 distance (DDDD)D
 2 4 3 java/lang/Math 5 6 abs (D)D 8 circle2 is inside circle1 : circle2 overlaps circle1 <  circle2 does not overlap circle1
  > ?  close args [Ljava/lang/String; scan Ljava/util/Scanner; t1 [D t2 d D StackMapTable A E?�      
 2 O P Q pow (DD)D x1 y1 x2 y2 
SourceFile Exercises3_29.java !               /     *� �    
                    	      Z     �� Y� � L� � !�M,+� 'R,+� 'R,+� 'R� +� !�N-+� 'R-+� 'R-+� 'R,1,1-1-1� -9,1-1g� 1�� � 7� !� #,1-1c�� � 9� !� � ;� !+� =�    
   R            	 % 
 ,  4  8  ?  F  M  ^  n  v  �  �  �  �  �     4    � @ A    � B C   � D E  8 f F E  ^ @ G H  I    � y  J  K K   	 / 0     {  
   !9&g&gk(g(gkc L� N9�    
               4    ! R H     ! S H    ! T H    ! U H    G H   V    W