����   6 a  "第二次作业/RegularPolygonTest  java/lang/Object <init> ()V Code
  	   LineNumberTable LocalVariableTable this $L第二次作业/RegularPolygonTest; main ([Ljava/lang/String;)V  第二次作业/RegularPolygon
  	@      
     (ID)V@ffffff@333333
     (IDDD)V
    ! " getPrimeter ()D
  $ ! % (ID)D
  ' ( " getArea
  * ( %	 , . - java/lang/System / 0 out Ljava/io/PrintStream; 2 java/lang/StringBuilder 4 'The perimeter of the first polygin is: 
 1 6  7 (Ljava/lang/String;)V
 1 9 : ; append (D)Ljava/lang/StringBuilder; = ' and The area of the first polygin is: 
 1 ? : @ -(Ljava/lang/String;)Ljava/lang/StringBuilder;
 1 B C D toString ()Ljava/lang/String;
 F H G java/io/PrintStream I 7 println K (The perimeter of the second polygin is:  M ( and The area of the second polygin is:  O 'The perimeter of the third polygin is:  Q ' and The area of the third polygin is:  args [Ljava/lang/String; r1  L第二次作业/RegularPolygon; r2 r3 p1 D p2 p3 a1 a2 a3 
SourceFile RegularPolygonTest.java !               /     *� �    
                    	      x 	    Ļ Y� L� Y � M� Y
   � N+� 9, � #9-
 � #9+� &9
, � )9-
 � )9� +� 1Y3� 5� 8<� >
� 8� A� E� +� 1YJ� 5� 8L� >� 8� A� E� +� 1YN� 5� 8P� >� 8� A� E�    
   6         (  .  9 	 D 
 J  U  `  �  �  �     f 
   � R S    � T U   � V U  ( � W U  . � X Y  9 � Z Y  D � [ Y  J z \ Y 
 U o ] Y  ` d ^ Y   _    `