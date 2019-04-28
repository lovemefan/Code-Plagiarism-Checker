from difflib import SequenceMatcher

from utils.cleanUP import tokenize, toText

# 抄袭率
def plagerised_ratio(filename1, filename2):
    # 清除代码
    tokens1 = tokenize(filename1)
    file1 = toText(tokens1)
    tokens2 = tokenize(filename2)
    file2 = toText(tokens2)
    SM = SequenceMatcher(None, file1, file2)
    # 抄袭内容抄袭率
    similarity_ratio = SM.ratio()
    print(similarity_ratio)
    blocks = list(SM.get_matching_blocks()) #elements  of blocks[] - (start-file1, start-file2, length)
    # 去掉最后一个元素
    blocks = blocks[: -1]
    f1 = open(filename1, "r")

    for i in blocks:
        flag = 0
        print(i)
        start = end = 0
        for j in range(len(tokens1)):
            if tokens1[j][2] == i[0]:
                start = tokens1[j][1]
                flag = 1
            if tokens1[j][2] == (i[0] + i[2] - 1):
                end = tokens1[j][1]
                break
        if not flag == 0 and (end - start) > 100:
            f1.seek(start, 0)
            print(f1.read(end - start))

fn1 = input("Enter the path/name of program 1: ")
fn2 = input("Enter the path/name of program 2: ")
plagerised_ratio(fn1, fn2)
