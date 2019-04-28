import random

import matplotlib.pyplot as plt
import numpy as np
from simi.simi import simi

plt.rcParams['font.sans-serif']=['SimHei'] # 用来正常显示中文标签

#   尝试K值的最适合值
from winowing.winnowing import plagiarismCheck


def k_value(file1,file2):

    f1 = open(file1, "r").read().__len__()
    print(f1)
    k = range(6,20)
    w = range(2,10)
    for i in k:
        winnowing = []
        for j in w:
            winnowing.append(plagiarismCheck(file1, file2, k=i, w=j))
        plt.plot(w, winnowing, color=randomcolor(), label="K=%d"%i)
        plt.text(w[5], winnowing[5], r'K=%d'%i)

    plt.xlabel('windows_size')
    plt.ylabel('similar_rate')
    plt.savefig('./K,W.jpg')
    plt.show()


def W1_W2(file1,file2):

    f1 = open(file1, "r").read().__len__()
    w1 = np.linspace(0.1, 1, 100)
    w2 = 1 - w1
    simi_values = []
    for i in w1:
        simi_values.append(simi(file1, file2, w1=i, w2=1-i, k=20, w=4))

    plt.plot(w1, simi_values, color=randomcolor(), label="W1=%f"%i)
    plt.text(w1[5], simi_values[5], r'W1=%f'%i)

    plt.xlabel('W1')
    plt.ylabel('similar_rate')
    plt.savefig('./W1,W2.jpg')
    plt.show()

# 生成随机颜色
def randomcolor():
    colorArr = ['1','2','3','4','5','6','7','8','9','A','B','C','D','E','F']
    color = ""
    for i in range(6):
        color += colorArr[random.randint(0,14)]
    return "#"+color

if __name__ == '__main__':
    fn1 = '/home/lovemefan/文档/a.java'
    fn2 = '/home/lovemefan/文档/b.java'
    # k_value(fn1, fn2)

    W1_W2(fn1, fn2)