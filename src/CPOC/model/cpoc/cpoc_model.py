#!/usr/bin/python3
# -*- coding: utf-8 -*-
# @Author :lovemefan
# @Datetime:2019/5/1 下午12:03
# @Version: Ubuntu 18.04.2 LTS + python3.6
# @Software: PyCharm
import os

import logging
import tensorflow as tf

from tensorflow.contrib.layers import fully_connected

from init_code import init_code


class CPOC(object):
    '''
    cpoc模型
    sequence_length 词向量长度
    vocab_size 文本向量长度 1000
    embedding_size
    filter_sizes filter的大小
    l2_reg_lambda 默认为0
    '''
    def __init__(
        self, sequence_length, vocab_size,
        embedding_size, filter_size, num_filters, l2_reg_lambda=0.0):
        print('sequence_length:{}'.format(sequence_length))
        print('vocab_size:{}'.format(vocab_size))
        print('embedding_size:{}'.format(embedding_size))
        print('filter_sizes:{}'.format(filter_size))
        print('num_filters:{}'.format(num_filters))

        # Placeholders for input, output and dropout
        self.sequence_length = sequence_length
        self.vocab_size = vocab_size
        self.embedding_size = embedding_size
        self.filter_size = filter_size

        self.input_pos = tf.placeholder(tf.int32, [None, sequence_length], name="input_poc")
        self.input_doc = tf.placeholder(tf.int32, [None, sequence_length], name="input_doc")
        self.input_neg = tf.placeholder(tf.int32, [None, sequence_length], name="input_neg")
        self.input_measure_of_code = tf.placeholder(tf.int32, [10], name="input_neg")

        self.dropout_keep_prob = tf.placeholder(tf.float32, name="dropout_keep_prob")
        self.logits = []
        # Keeping track of l2 regularization loss (optional)
        l2_loss = tf.constant(0.0)



        # Embedding 层
        with tf.name_scope("embedding_pos"):
            # embedding 层的权重 W1
            self.embedding_W1 = tf.Variable(
                tf.random_uniform([vocab_size, embedding_size], -1.0, 1.0),
                name="W1")
            self.embedded_chars_pos = tf.nn.embedding_lookup(self.embedding_W1, self.input_pos)
            self.embeadded_chars_expanded_pos = tf.expand_dims(self.embedded_chars_pos, -1)
        with tf.name_scope("embedding_doc"):
            # embedding 层的权重 W2
            self.embedding_W2 = tf.Variable(
                tf.random_uniform([vocab_size, embedding_size], -1.0, 1.0),
                name="W2")
            self.embedded_chars_doc = tf.nn.embedding_lookup(self.embedding_W2, self.input_doc)
            self.embeadded_chars_expanded_doc = tf.expand_dims(self.embedded_chars_doc, -1)
        with tf.name_scope("embedding_neg"):
            # embedding 层的权重 W3
            self.embedding_W3 = tf.Variable(
                tf.random_uniform([vocab_size, embedding_size], -1.0, 1.0),
                name="W3")
            self.embedded_chars_neg = tf.nn.embedding_lookup(self.embedding_W3, self.input_neg)
            self.embeadded_chars_expanded_neg = tf.expand_dims(self.embedded_chars_neg, -1)

        self.cpoc_conv_pool_dnn(self.embeadded_chars_expanded_doc,'doc')
        self.cpoc_conv_pool_dnn(self.embeadded_chars_expanded_pos,'pos')
        self.cpoc_conv_pool_dnn(self.embeadded_chars_expanded_neg,'neg')

        with tf.name_scope('output'):
            delta = self.cos_distance(self.logits[0], self.logits[1]) - self.cos_distance(self.logits[0], self.logits[2])

        with tf.name_scope('loss'):
            self.loss = delta



    def cos_distance(self,x1,x2):
        #求模
        x1_norm = tf.sqrt(tf.reduce_sum(tf.square(x1), axis=2))
        x2_norm = tf.sqrt(tf.reduce_sum(tf.square(x2), axis=2))
        #内积
        x1_x2 = tf.reduce_sum(tf.multiply(x1, x2), axis=2)
        cosin = x1_x2 / (x1_norm * x2_norm)
        return cosin

    def cpoc_conv_pool_dnn(self,embeadded_chars_expanded,label):
        #第一层卷积
        with tf.name_scope("conv1_%s"%label):
            # 单词数量 ， onehot矩阵长度
            filter_shape = [self.filter_size, self.embedding_size,1, 16]
            # 高斯初始化
            filter_W1 = tf.Variable(tf.truncated_normal(filter_shape,stddev=0.1,name='W1_%s'%label))
            filter_b1 = tf.Variable(tf.constant(0.1,shape=[16]),name='b1_%s'%label)
            print('embeadded_chars_expanded:{}'.format(embeadded_chars_expanded))
            print('filter_W1:{}'.format(filter_W1))
            print('filter_b1:{}'.format(filter_b1))
            conv1 = tf.nn.conv2d(
                embeadded_chars_expanded,
                filter_W1 ,
                strides=[1, 1, 1, 1],
                padding="VALID",
                name='conv1_%s'%label
            )
            relu1  = tf.nn.relu(tf.nn.bias_add(conv1 ,filter_b1), name='relu_%s'%label)
        # 第二层卷积
        with tf.name_scope("conv2_%s"%label):
            # 单词数量 ， onehot矩阵长度
            filter_shape = [self.filter_size,1,16, 64]
            # 高斯初始化
            filter_W2  = tf.Variable(tf.truncated_normal(filter_shape,stddev=0.1,name='W2_%s'%label))
            filter_b2 = tf.Variable(tf.constant(0.1,shape=[64]),name='b2_%s'%label)
            print('relu1{}'.format(relu1))

            conv2  = tf.nn.conv2d(
                relu1 ,
                filter_W2 ,
                strides=[1, 1, 1, 1],
                padding="VALID",
                name='conv2_%s'%label
            )
            relu2  = tf.nn.relu(tf.nn.bias_add(conv2 ,filter_b2), name='relu2_%s'%label)
        # 池化层
        with tf.name_scope("Max_pool1_%s"%label):
            pooled1 = tf.nn.max_pool(
                relu2 ,
                ksize=[1, self.sequence_length - self.filter_size + 1, 1, 1],
                strides=[1, 1, 1, 1],
                padding='VALID',
                name="pool")
            print('Pooled:{}'.format(pooled1))
        #第三层卷积
        with tf.name_scope("conv3_%s"%label):
            # 单词数量 ， onehot矩阵长度
            filter_shape = [self.filter_size,1,64, 256]
            # 高斯初始化
            filter_W3  = tf.Variable(tf.truncated_normal(filter_shape,stddev=0.1,name='W3 %s'%label))
            filter_b3 = tf.Variable(tf.constant(0.1,shape=[256]),name='b3 ')
            conv3  = tf.nn.conv2d(
                pooled1 ,
                filter_W3 ,
                strides=[1, 1, 1, 1],
                padding="VALID",
                name='conv3_%s'%label
            )
            relu3  = tf.nn.relu(tf.nn.bias_add(conv3 ,filter_b3), name='relu_%s'%label)
        # 第四层卷积
        with tf.name_scope("conv4_%s"%label):
            # 单词数量 ， onehot矩阵长度
            filter_shape = [self.filter_size,1,256, 512]
            # 高斯初始化
            filter_W4  = tf.Variable(tf.truncated_normal(filter_shape,stddev=0.1,name='W4_%s'%label))
            filter_b4 = tf.Variable(tf.constant(0.1,shape=[512]),name='b4_%s'%label)
            conv4  = tf.nn.conv2d(
                relu1 ,
                filter_W4 ,
                strides=[1, 1, 1, 1],
                padding="VALID",
                name='conv4_%s'%label
            )
            relu4  = tf.nn.relu(tf.nn.bias_add(conv4 ,filter_b4), name='relu4_%s'%label)
        # 第二层池化层
        with tf.name_scope("Max_pool2_%s"%label):
            pooled2 = tf.nn.max_pool(
                relu4 ,
                ksize=[1, self.sequence_length - self.filter_size + 1, 1, 1],
                strides=[1, 1, 1, 1],
                padding='VALID',
                name="pool2")
            print('Pooled2:{}'.format(pooled2))


        # self.h_pool = np.concatenate((pooled2.T,self.input_measure_of_code.T).T,axis=0)
        self.h_pool = tf.concat(pooled2,self.input_measure_of_code)
        self.h_pool_flat = tf.reshape(self.h_pool, [-1,512])
        print('h_pool_flat:{}'.format(self.h_pool_flat))

        # drop层
        with tf.name_scope("dropout"):
            self.h_drop = tf.nn.dropout(self.h_pool_flat,self.dropout_keep_prob)

        # 两层DNN层
        with tf.name_scope("dnn"):
            # tensorflow使用这个函数帮助我们使用合适的初始化w和b的策略，默认使用ReLU激活函数
            hidden1 = fully_connected(self.h_drop, 512, scope="hidden1")#构建第一层隐藏层 全连接
            hidden2 = fully_connected(hidden1, 512, scope="hidden2")#构建第二层隐藏层 全连接
            logits1 = fully_connected(hidden2, 512, scope="outputs", activation_fn=None)#构建输出层 #注意输出层激活函数不需要

        with tf.name_scope("dnn"):
            # tensorflow使用这个函数帮助我们使用合适的初始化w和b的策略，默认使用ReLU激活函数
            hidden3 = fully_connected(logits1, 512, scope="hidden1")
            hidden4 = fully_connected(hidden3, 512, scope="hidden2")
            logits2 = fully_connected(hidden4, 512, scope="outputs", activation_fn=None)#构建输出层 #注意输出层激活函数不需要
        self.logits.append(logits2)




