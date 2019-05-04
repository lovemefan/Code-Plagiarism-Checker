#!/usr/bin/python3
# -*- coding: utf-8 -*-
# @Author :lovemefan
# @Datetime:2019/5/3 下午12:38
# @Version: Ubuntu 18.04.2 LTS + python3.6
# @Software: PyCharm
import tensorflow as tf
# 参数 params
# tf.flags.DEFINE_float
import data_loader
from cpoc_model import CPOC

tf.flags.DEFINE_string('positive_data_dir','/home/lovemefan/PycharmProjects/Plagiarism Checker/data/172071大作业1','正例')
tf.flags.DEFINE_string('original_data_dir','/home/lovemefan/PycharmProjects/Plagiarism Checker/data/172072大作业1/15207213-李标','原文')
tf.flags.DEFINE_string('negetive_data_dir','/home/lovemefan/PycharmProjects/Plagiarism Checker/data/172073大作业1/15042216-赵冠慧','负例')

tf.flags.DEFINE_integer('embedding',1200,'')
tf.flags.DEFINE_integer('num_filter',512,'filter数量')
tf.flags.DEFINE_integer('filter_size',3, 'filter的大小')
tf.flags.DEFINE_float('dropout',0.5,'dropout')
tf.flags.DEFINE_float('L2_reg_lambda',0.0,'L2')
# Misc Parameters
tf.flags.DEFINE_boolean("allow_soft_placement", True, "Allow device soft device placement")
tf.flags.DEFINE_boolean("log_device_placement", False, "Log placement of ops on devices")
# 训练参数

# batch size
tf.flags.DEFINE_integer('batch_size', 64 ,'batch_size')
# 迭代选项
tf.flags.DEFINE_integer('num_epochs', 200 ,'Number of epochs')
# 评估参数 每迭代几次打印结果
tf.flags.DEFINE_integer('evaluate_every', 100 ,'evaluate_every')
# 每迭代几次保存模型
tf.flags.DEFINE_integer('checkpoint', 1000 ,'saving model... ')

FLAGS = tf.flags.FLAGS
FLAGS.flag_values_dict()

data_loader = data_loader.Data_Loader()
embedding_document,embedding_positive,embedding_negetive = data_loader.load_data(FLAGS.positive_data_dir, FLAGS.original_data_dir, FLAGS.negetive_data_dir)

print("\nParameters:")
for attr, value in sorted(FLAGS.__flags.items()):
    print("{}={}".format(attr.upper(), value))
print("")

# Training
# ==================================================

with tf.Graph().as_default():
    session_conf = tf.ConfigProto(
        allow_soft_placement=FLAGS.allow_soft_placement,
        log_device_placement=FLAGS.log_device_placement)
    sess = tf.Session(config=session_conf)
    with sess.as_default():
        cpoc = CPOC(
            sequence_length= embedding_document.shape[1],
            vocab_size=data_loader.word_index.__len__(),
            embedding_size=embedding_document.shape[2],
            filter_size=FLAGS.filter_size,
            num_filters=FLAGS.num_filter,
            l2_reg_lambda=FLAGS.L2_reg_lambda)