#!/usr/bin/python3
# -*- coding: utf-8 -*-
# author:lovemefan
# datetime:2019/4/30 下午5:06
# software: PyCharm


#coding = utf-8
# 为了将作业统一编码
import os
import chardet
import codecs

def load_file(filename):
    #使用encoding来表示打开文件的格式
    try:
        with open(filename, 'r', encoding='gbk') as fr:
            doc = fr.read()

        print('gbk ' + filename)
    except:
        with open(filename, 'r', encoding='utf-8') as fr:
            doc = fr.read()
        print('utf-8 ' + filename)

    with open(filename, 'w', encoding='utf-8') as fw:
        fw.write(doc)

def change_dir(path):
    for foldername, subfolders, filenames in os.walk(path):
        for filename in filenames:
            path = foldername + '/' + filename
            load_file(path)


def WriteFile(filePath, u, encoding="utf-8"):
    with codecs.open(filePath, "w", encoding) as f:
        f.write(u)


def GBK_2_UTF8(src, dst):
    #     检测编码，coding可能检测不到编码，有异常
    f = open(src, "rb")
    coding = chardet.detect(f.read())["encoding"]
    f.close()
    if coding != "utf-8":
        with codecs.open(src, "r", coding) as f:
            try:
                WriteFile(dst, f.read(), encoding="utf-8")
                try:
                    print(src + "  " + coding + " to utf-8  converted!")
                except Exception as e:
                    print("print error")
                    print(e)
            except Exception:
                print(src +"  "+ coding+ "  read error")

# 把目录中的*.java编码由gbk转换为utf-8
def ReadDirectoryFile(rootdir):
    for parent, dirnames, filenames in os.walk(rootdir):
        for dirname in dirnames:
            #递归函数，遍历所有子文件夹
            ReadDirectoryFile(dirname)
        for filename in filenames:
            if filename.endswith(".java"):
                GBK_2_UTF8(os.path.join(parent, filename),
                           os.path.join(parent, filename))
if __name__ == '__main__':
    #输入此目录下相应的文件夹
    ReadDirectoryFile('/home/lovemefan/PycharmProjects/Plagiarism Checker/data')