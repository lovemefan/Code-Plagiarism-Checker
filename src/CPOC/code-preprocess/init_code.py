# -*- coding: utf-8 -*-
# @Time    : 2019/4/26 上午11:29
# @Author  : lovemefan
# @File    : init_code.py
# @Software: PyCharm
import os
import queue
import sys
import codecs


# 代码去除注释，空格
from itertools import islice

import kwargs as kwargs
import pygments.lexers


def init_code(code):
    code = code
    import re
    # 去掉import
    # code = re.sub(r'import .*?;', '', code)
    # 去除行注释
    code = re.sub(r'^\s+|#.*|//.*', '', code, flags=re.M)
    # 去除块注释
    code = re.sub(r'/\*.*\*/', '', code, flags=re.DOTALL)
    # 去除空白行
    code = re.sub(r'\s*\n+\s*', '\n', code)
    # 去除开头换行
    code = re.sub(r'^\n', '', code)

    lexer = pygments.lexers.guess_lexer_for_filename('code.java', code)
    tokens = lexer.get_tokens(code)
    tokens = list(tokens)
    result = ""
    # 用一定的规则处理代码文本
    for i in tokens:
        # 将变量替换为V
        if i[0] == pygments.token.Name:
            result += 'V'
        # 将数字为N
        elif i[0] == pygments.token.Literal.Number.Integer:
            result += 'N'
        # 将字符串替换为S
        elif i[0] == pygments.token.Literal.String:
            result += 'S'
        # 将函数名替换为F
        elif i[0] == pygments.token.Name.Function:
            result += 'F'
        # 将类名替换为C
        elif i[0] == pygments.token.Name.Class:
            result += 'C'
        # 将包名替换为P
        elif i[0] == pygments.token.Name.Namespace:
            result += 'P'
        else :
            result += i[1]
    return result

# 作业里的不同编码格式真让人不省心
def readFile(filename):
    try:
        data = open(filename,'r',encoding='utf-8')
        return data.read()
    except UnicodeDecodeError:
        data = open(filename,'r',encoding='gbk')
        return data.read()



# 删除无用文件和文件夹
def cleanUpfile():
    rootdir = '/home/lovemefan/PycharmProjects/Plagiarism Checker/data'
    for root, dirs, files in os.walk(rootdir, topdown=False):
        for file in files:
            # 删掉非源码文件
            if file.find('.java') == -1:
                print("正在删除%s  ..."%file)
                os.remove("%s/%s"%(root, file))

        if not files and not dirs:
            # 删除空文件夹
            print("删除空文件夹  %s..."%root)
            os.rmdir(root)

# 生成字典
def load_w2c_textcn_dataset(text):
    word_list_all=[]
    codes = text.split('\n')
    for line in codes:
        word_list=line.strip().split()
        for idx, word in enumerate(word_list):
            word_list[idx] = word_list[idx]
            #print word_list[idx]
            word_list_all.append(word_list[idx])
    return word_list_all


def test_init_code():
    code =  readFile('/home/lovemefan/PycharmProjects/Plagiarism Checker/data/172071大作业1/14207108-邹坤/test6/test6/src/test6/Checkout.java')
    print(init_code(code))
    # dist = load_w2c_textcn_dataset(init_code(code))
    # for i in dist:
    #     print(i)

if __name__ == '__main__':
    test_init_code()