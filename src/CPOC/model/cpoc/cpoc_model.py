#!/usr/bin/python3
# -*- coding: utf-8 -*-
# @Author :lovemefan
# @Datetime:2019/5/1 下午12:03
# @Version: Ubuntu 18.04.2 LTS + python3.6
# @Software: PyCharm
import os

import numpy as np
import tensorflow as tf
import keras.preprocessing.text as T
from keras.preprocessing.text import Tokenizer
from keras.utils import to_categorical
from keras_preprocessing.sequence import pad_sequences

from init_code import init_code



def text2one_hot_result(samples):
    num_words = 1000
    MAX_SEQUENCE_LENGTH = 100
    # i创建一个分词器（tokenizer），设置为只考虑前1000个最常见的单词,足够
    tokenizer = Tokenizer(num_words=num_words)

    tokenizer.fit_on_texts(samples)   # 构建索引单词

    sequences = tokenizer.texts_to_sequences(samples)   # 将字符串转换为整数索引组成的列表

    sequences = pad_sequences(sequences, maxlen=MAX_SEQUENCE_LENGTH)
    one_hot = to_categorical(np.asarray(sequences))
    # one-hot编码外其他向量化模
    word_index = tokenizer.word_index  # 得到单词索引
    print("单词数量为：{}".format(word_index.__len__()))
    # print(t)
    # for i in range(sequences.__len__()):
    #     item = np.zeros([sum(sequences[i]), 1000])
        # item[i, for j in sequences[i]]
    # one_hot_results = tokenizer.texts_to_matrix(samples, mode='binary')  #可以直接得到one-hot二进制表示。这个分词器也支持除


    print(word_index)
    return one_hot

def embedding(codes):
    # samples = []
    # for code in  codes:
    #     samples.append(code)
    return text2one_hot_result(codes)

def weight_variable(shape):
    initial = tf.truncated_normal(shape,stddev=0.1)
    return tf.Variable(initial)

def bias_variavle(shape):
    initial = tf.constant(0.1,shape=shape)
    return tf.Variable(initial)

def conv2d(x,W):
    return tf.nn.conv2d(x, W, strides=[1,1,1,1], padding='SAME')

def max_pool_2x2(x):
    return tf.nn.max_pool(x,ksize=[1,2,2,1], strides=[1,2,2,1],padding='SAME')


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
        # Placeholders for input, output and dropout
        self.input_pos = tf.placeholder(tf.int32, [None, sequence_length], name="input_poc")
        self.input_doc = tf.placeholder(tf.int32, [None, sequence_length], name="input_doc")
        self.input_neg = tf.placeholder(tf.int32, [None, sequence_length], name="input_neg")
        self.dropout_keep_prob = tf.placeholder(tf.float32, name="dropout_keep_prob")

        # Keeping track of l2 regularization loss (optional)
        l2_loss = tf.constant(0.0)



        # Embedding 层
        with tf.name_scope("embedding pos"):
            # embedding 层的权重 W1
            self.embedding_W1 = tf.Variable(
                tf.random_uniform([vocab_size, embedding_size], -1.0, 1.0),
                name="W1")
            self.embedded_chars_pos = tf.nn.embedding_lookup(self.embedding_W1, self.input_pos)
            self.embeadded_chars_expanded_pos = tf.expand_dims(self.embedded_chars_pos, -1)
        with tf.name_scope("embedding doc"):
            # embedding 层的权重 W2
            self.embedding_W2 = tf.Variable(
                tf.random_uniform([vocab_size, embedding_size], -1.0, 1.0),
                name="W2")
            self.embedded_chars_doc = tf.nn.embedding_lookup(self.embedding_W2, self.input_doc)
            self.embeadded_chars_expanded_doc = tf.expand_dims(self.embedded_chars_doc, -1)
        with tf.name_scope("embedding neg"):
            # embedding 层的权重 W3
            self.embedding_W3 = tf.Variable(
                tf.random_uniform([vocab_size, embedding_size], -1.0, 1.0),
                name="W3")
            self.embedded_chars_neg = tf.nn.embedding_lookup(self.embedding_W3, self.input_neg)
            self.embeadded_chars_expanded_neg = tf.expand_dims(self.embedded_chars_neg, -1)




        #第一层卷积
        with tf.name_scope("conv1 pos"):
            # 单词数量 ， onehot矩阵长度
            filter_shape = [filter_size, embedding_size,1, 16]
            # 高斯初始化
            filter_W1_pos = tf.Variable(tf.truncated_normal(filter_shape,stddev=0.1,name='W1_pos'))
            filter_b1 = tf.Variable(tf.constant(0.1),shape=[num_filters],name='b1_pos')
            conv1_pos = tf.nn.conv2d(
                self.embeadded_chars_expanded_pos,
                filter_W1_pos,
                strides='VALID',
                name='conv1 pos'
            )
            relu1_pos = tf.nn.relu(tf.nn.bias_add(conv1_pos,filter_b1), name='relu pos')
        # 第二层卷积
        with tf.name_scope("conv2 pos"):
            # 单词数量 ， onehot矩阵长度
            filter_shape = [filter_size,embedding_size,16, 64]
            # 高斯初始化
            filter_W2_pos = tf.Variable(tf.truncated_normal(filter_shape,stddev=0.1,name='W2_pos'))
            filter_b2 = tf.Variable(tf.constant(0.1),shape=[num_filters],name='b2_pos')
            conv2_pos = tf.nn.conv2d(
                relu1_pos,
                filter_W2_pos,
                strides='VALID',
                name='conv2 pos'
            )
            relu2_pos = tf.nn.relu(tf.nn.bias_add(conv2_pos,filter_b2), name='relu2 pos')
        # 池化层
        with tf.name_scope("Max pool1 pos"):
            pooled = tf.nn.max_pool(
                relu2_pos,
                ksize=[1, sequence_length - filter_size + 1, 1, 1],
                strides=[1, 1, 1, 1],
                padding='VALID',
                name="pool")
            print('Pooled:{}'.format(pooled))

if __name__ == '__main__':
    root_dir = '/home/lovemefan/PycharmProjects/data_test/第一次大作业/'
    samples =[]
    for root, dirs, files in os.walk(root_dir):
        for file in files:
            contend = open("%s/%s"%(root, file)).read()

            samples.append(init_code(contend))

    print('读取完毕')
    for i in  embedding(samples):
        print(i)
    #     for j in i:
    #         print(j.tolist())



