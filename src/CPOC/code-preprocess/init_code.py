# -*- coding: utf-8 -*-
# @Time    : 2019/4/26 上午11:29
# @Author  : lovemefan
# @File    : init_code.py
# @Software: PyCharm
import os

import pygments
from pygments import lexer

# 代码去除注释，空格
def init_code(code):
    c = code
    c = c.replace('{', '\n{\n').replace('}', '\n}\n')
    import re
    # 去除行注释
    c = re.sub(r'^\s+|#.*|//.*', '', c, flags=re.M)
    # 去除块注释
    c = re.sub(r'/\*.*\*/', '', c, flags=re.DOTALL)
    # 去除空白字符
    c = re.sub(r'\s*\n+\s*', '\n', c)
    # 去除开头换行
    c = re.sub(r'^\n', '', c)
    tokens = lexer.get_tokens(c)
    tokens = list(tokens)
    result = []
    lenT = len(tokens)
    # 起始位置
    start = 0
    # 结束位置
    end = 0
    # 在源码中标记内容
    for i in range(lenT):
        if tokens[i][0] == pygments.token.Name and not i == lenT - 1 and not tokens[i + 1][1] == '(':
            # 所有变量统一被标记为N
            result.append(('N', start, end))
            end += 1
        elif tokens[i][0] in pygments.token.Literal.String:
            # 所有字符串标记为S
            result.append(('S', start, end))
            end += 1
        elif tokens[i][0] in pygments.token.Name.Function:
            # 所有函数标记为F
            result.append(('F', start, end))
            end += 1
        elif tokens[i][0] == pygments.token.Text or tokens[i][0] in pygments.token.Comment:
            # 去掉空格和注释
            pass
        else:
            result.append((tokens[i][1], start, end))
            end += len(tokens[i][1])
        start += len(tokens[i][1])

    return result


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

if __name__ == '__main__':
    cleanUpfile()
