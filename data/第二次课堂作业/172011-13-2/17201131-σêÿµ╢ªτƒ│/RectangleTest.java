����   6 ]  第二次作业/RectangleTest  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this L第二次作业/RectangleTest; main ([Ljava/lang/String;)V  java/util/Scanner	    java/lang/System   in Ljava/io/InputStream;
     (Ljava/io/InputStream;)V  第二次作业/Rectangle@      @D      
  "  # (DD)V
  % & ' getArea ()D
  ) * ' getPerimeter	  , - . out Ljava/io/PrintStream; 0 java/lang/StringBuilder 2 area is 
 / 4  5 (Ljava/lang/String;)V
 / 7 8 9 append (D)Ljava/lang/StringBuilder; ;  ,perimeter is 
 / = 8 > -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 / @ A B toString ()Ljava/lang/String;
 D F E java/io/PrintStream G 5 println@      @A�33333
  M N  close args [Ljava/lang/String; scan Ljava/util/Scanner; rec1 L第二次作业/Rectangle; area1 D 
perimeter1 rec2 area2 
perimeter2 
SourceFile RectangleTest.java !               /     *� �    
                    	           �� Y� � L� Y  � !M,� $J,� (9� +� /Y1� 3)� 6:� <� 6� ?� C� Y H J� !:� $9� (9
� +� /Y1� 3� 6:� <
� 6� ?� C+� L�    
   .           $ 	 D 
 S  Z  a  �  �     R    � O P    | Q R   n S T   i U V  $ c W V  S 4 X T  Z - Y V  a & Z V 
  [    \