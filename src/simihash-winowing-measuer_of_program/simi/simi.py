from simhash import Simhash
from utils.cleanUP import tokenize, toText
from winowing.winnowing import plagiarismCheck


def simi(file1, file2, k=17, w=6, w1=0.4, w2=0.6) :
    f1 = open(file1, "r")
    # tokenize 和为cleanUP中代码预处理的方法
    token1 = tokenize(file1)
    str1 = toText(token1)
    token2 = tokenize(file2)
    str2 = toText(token2)
    simhash1 = Simhash(str1)
    simhash2 = Simhash(str2)
    print(simhash1.value)
    # simhash距离和winnowing相似度
    simhash_distance = simhash1.distance(simhash2)
    winnowing = plagiarismCheck(file1, file2, k=k, w=w)
    print(winnowing)
    simi = w1 / (1 + simhash_distance) + winnowing * w2
    print('w1(%f)/(1+simhash_distance(%f)) + winnowing(%f) * w2(%f) = simi(%f)'%(w1,simhash_distance, winnowing, w2, simi))


    return simi

if __name__ == '__main__':
    # fn1 = input("输入文件一的路径: ")
    # fn2 = input("输入文件二的路径: ")
    fn1 ='/home/lovemefan/文档/a.java'
    fn2 ='/home/lovemefan/文档/b.java'
    simi_value = simi(fn1, fn2)
    print("simhash 和 winnowing 加权结果：%f"%simi_value)







