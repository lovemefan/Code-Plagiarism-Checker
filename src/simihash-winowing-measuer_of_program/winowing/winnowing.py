import hashlib

from utils.cleanUP import tokenize, toText

# 生成hash值
def hash(text):
    hashval = hashlib.sha1(text.encode('utf-8'))
    hashval = hashval.hexdigest()[-4 :]
    # 使用sha-1加密的最后16bits
    hashval = int(hashval, 16)
    return hashval

#生成k-grams字符串序列
def kgrams(text, k = 5):
    tokenList = list(text)
    n = len(tokenList)
    kgrams = []
    for i in range(n - k + 1):
        kgram = ''.join(tokenList[i : i + k])
        hv = hash(kgram)
        kgrams.append((kgram, hv, i, i + k))
    return kgrams

#返回最小值的下标
def minIndex(arr):
    minI = 0
    minV = arr[0]
    n = len(arr)
    for i in range(n):
        if arr[i] < minV:
            minV = arr[i]
            minI = i
    return minI

# 用最小hash生成文本指纹
def fingerprints(arr, winSize = 4):
    arrLen = len(arr)
    prevMin = 0
    currMin = 0
    windows = []
    fingerprintList = []
    for i in range(arrLen - winSize):
        # 滑动窗口
        win = arr[i: i + winSize]
        windows.append(win)
        currMin = i + minIndex(win)
        if not currMin == prevMin:
            fingerprintList.append(arr[currMin])
            prevMin = currMin
    return fingerprintList

#根据k-gram字符序列生成对应的hash序列
def hashList(arr):
    HL = []
    for i in arr:
        HL.append(i[1])

    return HL

# 检测抄袭
def plagiarismCheck(file1, file2,k=5, w=4):
    f1 = open(file1, "r")
    # tokenize 和为cleanUP中代码预处理的方法
    token1 = tokenize(file1)
    str1 = toText(token1)
    token2 = tokenize(file2)
    str2 = toText(token2)
    # kgram序列
    kGrams1 = kgrams(str1, k=k)
    kGrams2 = kgrams(str2, k=k)
    # kgram hash序列
    HL1 = hashList(kGrams1)
    HL2 = hashList(kGrams2)
    fpList1 = fingerprints(HL1, winSize=w)
    print('-----figprint----')
    print(fpList1)
    print(fpList1.__len__())
    fpList2 = fingerprints(HL2, winSize=w)
    # 原代码
    code = f1.read()
    points = []
    for i in fpList1:
        for j in fpList2:
            # 匹配文本指纹
            if i == j:
                flag = 0
                # 文本指纹在hash序列中的位置
                match = HL1.index(i)
                # 起始位置
                newStart = kGrams1[match][2]
                # 结束位置
                newEnd = kGrams1[match][3]
                for k in token1:
                    if k[2] == newStart:
                        startx = k[1]
                        flag = 1
                    if k[2] == newEnd:
                        endx = k[1]
                if flag == 1:
                    points.append([startx, endx])
    points.sort(key = lambda x: x[0])
    points = points[1:]
    mergedPoints = []
    mergedPoints.append(points[0])
    for i in range(1, len(points)):
        last = mergedPoints[len(mergedPoints) - 1]
        if points[i][0] >= last[0] and points[i][0] <= last[1]:
            if points[i][1] > last[1]:
                mergedPoints = mergedPoints[: len(mergedPoints)-1]
                mergedPoints.append([last[0], points[i][1]])
            else:
                pass
        else:
            mergedPoints.append(points[i])
    newCode = code[: mergedPoints[0][0]]
    plagCount = 0
    for i in range(len(mergedPoints)):
        if mergedPoints[i][1] > mergedPoints[i][0]:
            plagCount += mergedPoints[i][1] - mergedPoints[i][0]
            newCode = newCode + '\x1b[6;30;42m' + code[mergedPoints[i][0] : mergedPoints[i][1]] + '\x1b[0m'
            if i < len(mergedPoints) - 1:
                newCode = newCode + code[mergedPoints[i][1]: mergedPoints[i+1][0]]
            else:
                newCode = newCode + code[mergedPoints[i][1]:]
    print("代码相似率大约为: ", (plagCount/len(code)))
    # print(newCode)
    return plagCount/len(code)


# fn1 = input("输入文件一的路径: ")
# fn2 = input("输入文件二的路径: ")
# plagiarismCheck(fn1, fn2)
