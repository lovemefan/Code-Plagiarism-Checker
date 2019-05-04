#!/usr/bin/python3
# -*- coding: utf-8 -*-
# author:lovemefan
# datetime:2019/4/30 下午3:02
# software: PyCharm
import os

from simi.simi import simi

def getfilesList(dir):
    dist = []
    # 格式为[(file,file_path)..]
    for root, dirs, files in os.walk(dir):
        for file in files:
            dist.append((file,'%s/%s'%(root,file)))
    return dist

# 某一目录下代码两两比较
def check(dir):
    f = open('codetest.txt', 'w')
    dist = getfilesList(dir)
    dist_len = dist.__len__()
    print("一共有%d份源代码"%dist_len)
    #
    for i in range(dist_len):
        for j in range(i+1,dist_len):
            print("%s -- %s"%(dist[i][1], dist[j][1]))
            simi_value = simi(dist[i][1], dist[j][1])
            # dist[i][0] 为文件名 dist[i][1] 为文件路径
            result_line = "%s %s %s %s %f\n"%(dist[i][0], dist[j][0], dist[i][1], dist[j][1], simi_value)
            f.write(result_line)
            print("%s %s  %f\n\n"%(dist[i][0], dist[j][0],simi_value))


    f.close()
if __name__ == '__main__':

    # fn1 ='/home/lovemefan/文档/a.java'
    # fn2 ='/home/lovemefan/文档/b.java'
    # simi_value = simi(fn1, fn2)
    # print("simhash 和 winnowing 和属性加权结果：%f"%simi_value)
    check('/home/lovemefan/PycharmProjects/data_test')

