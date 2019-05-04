#!/usr/bin/python3
# -*- coding: utf-8 -*-
# @Author :lovemefan
# @Datetime:2019/5/3 上午9:28
# @Version: Ubuntu 18.04.2 LTS + python3.6
# @Software: PyCharm

from keras.preprocessing.text import Tokenizer


def text2one_hot_result(samples):

    # i创建一个分词器（tokenizer），设置为只考虑前1000个最常见的单词,足够
    tokenizer = Tokenizer(num_words=128)

    tokenizer.fit_on_texts(samples)   # 构建索引单词

    # sequences = tokenizer.texts_to_sequences(samples)   # 将字符串转换为整数索引组成的列表

    one_hot_results = tokenizer.texts_to_matrix(samples, mode='binary')  #可以直接得到one-hot二进制表示。这个分词器也支持除

    # one-hot编码外其他向量化模
    word_index = tokenizer.word_index  # 得到单词索引
    print(word_index)
    return one_hot_results


if __name__ == '__main__':
    samples = ['The cat cat sat on the mat.', 'The dog ate my homework.']
    print(text2one_hot_result(samples))
    print(text2one_hot_result(samples).shape)