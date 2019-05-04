#!/usr/bin/python3
# -*- coding: utf-8 -*-
# @Author :lovemefan
# @Datetime:2019/5/4 下午9:50
# @Version: Ubuntu 18.04.2 LTS + python3.6
# @Software: PyCharm
import os
import logging
import numpy as np
from keras.preprocessing.text import Tokenizer
from keras.utils import to_categorical
from keras_preprocessing.sequence import pad_sequences

from init_code import init_code

logging.basicConfig(filename='log.log',filemode='a' ,level=logging.DEBUG,format='%(asctime)s %(filename)s[line:%(lineno)d] %(message)s',datefmt='%Y-%m-%d %X')



class Data_Loader():
    def __init__(self):
        self.samples_all = []
        root = '/home/lovemefan/PycharmProjects/Plagiarism Checker/data'

        print('读取文件中...')
        logging.info('读取文件中...')
        for root, dirs, files in os.walk(root):
            for file in files:
                contend = open("%s/%s"%(root, file)).read()

                self.samples_all.append(init_code(contend))
        logging.info("读取{}成功".format(root))
        print("读取{}成功".format(root))
        # 通过读取文件，其中所有代码单词种类为1141（预处理过），这里暂定1200
        self.num_words = 1200
        # 通过读取文件，其中单个文件单词数量最大长度为586，这里暂定600
        self.MAX_SEQUENCE_LENGTH = 600
        print("MAX_SEQUENCE_LENGTH:{}".format(self.MAX_SEQUENCE_LENGTH))
        # i创建一个分词器（tokenizer），设置为只考虑前1000个最常见的单词,足够
        self.tokenizer = Tokenizer(num_words=self.num_words)

        self.tokenizer.fit_on_texts(self.samples_all)   # 构建索引单词
    def text2one_hot_result(self,samples):

        sequences = self.tokenizer.texts_to_sequences(samples)   # 将字符串转换为整数索引组成的列表

        sequences = pad_sequences(sequences, maxlen=self.MAX_SEQUENCE_LENGTH,padding='post')
        # print("sequences:{}".format(sequences))
        # print("sequences_size:{}".format(sequences.shape))
        # print("document_count:{}".format(tokenizer.document_count))
        one_hot = to_categorical(np.asarray(sequences),self.num_words)
        # one-hot编码外其他向量化模
        self.word_index = self.tokenizer.word_index  # 得到单词索引
        # print("单词数量为：{}".format(word_index.__len__()))
        # logging.info(t)
        # for i in range(sequences.__len__()):
        #     item = np.zeros([sum(sequences[i]), 1000])
        # item[i, for j in sequences[i]]
        # one_hot_results = tokenizer.texts_to_matrix(samples, mode='binary')  #可以直接得到one-hot二进制表示。这个分词器也支持除


        # print(word_index)
        return one_hot


    def embedding(self,codes):
        # samples = []
        # for code in  codes:
        #     samples.append(code)
        return self.text2one_hot_result(codes)

    def load_data(self,positive_data_dir, document_data_dir, negative_data_dir):

        samples_positive =[]
        samples_document =[]
        samples_negetive =[]

        for root, dirs, files in os.walk(positive_data_dir):
            for file in files:
                contend = open("%s/%s"%(root, file)).read()

                samples_positive.append(init_code(contend))
        logging.info("读取{}成功".format(positive_data_dir))
        print("读取{}成功".format(positive_data_dir))
        for root, dirs, files in os.walk(document_data_dir):
            for file in files:
                contend = open("%s/%s"%(root, file)).read()

                samples_document.append(init_code(contend))
        logging.info("读取{}成功".format(document_data_dir))
        print("读取{}成功".format(document_data_dir))
        for root, dirs, files in os.walk(negative_data_dir):
            for file in files:
                contend = open("%s/%s"%(root, file)).read()

                samples_negetive.append(init_code(contend))
        logging.info("读取{}成功".format(negative_data_dir))
        print("读取{}成功".format(negative_data_dir))
        embedding_positive = self.embedding(samples_positive)
        embedding_document = self.embedding(samples_document)
        embedding_negetive = self.embedding(samples_negetive)

        # print(embedding_positive.shape)
        # print(embedding_document.shape)
        # print(embedding_negetive.shape)
        return embedding_document,embedding_positive,embedding_negetive



        # logging.info('读取完毕')
        # for i in embedding(samples_positive):
        #     logging.info(i.shape)
        #     for j in i:
        #         logging.info(j.T.shape)
        #         logging.info(j.T)


# if __name__ == '__main__':

    # positive_data_dir = '/home/lovemefan/PycharmProjects/Plagiarism Checker/data/172071大作业1'
    # document_data_dir = '/home/lovemefan/PycharmProjects/Plagiarism Checker/data/172072大作业1/15207213-李标'
    # negative_data_dir = '/home/lovemefan/PycharmProjects/Plagiarism Checker/data/172073大作业1/15042216-赵冠慧'
    # load_data_and_labels(positive_data_dir, document_data_dir, negative_data_dir)