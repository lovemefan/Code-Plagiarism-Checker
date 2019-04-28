# -*- coding: utf-8 -*-
# @Time    : 2019/4/16 下午8:35
# @Author  : lovemefan
# @File    : measure_of_program.py
# @Software: PyCharm


import re

import pygments.lexers


def properties(code):
    result = []
    # 去除行注释
    code = re.sub(r'^\s+|#.*|//.*', '', code, flags=re.M)
    # 去除块注释
    code = re.sub(r'/\*.*\*/', '', code, flags=re.DOTALL)
    # 去除空白字符
    code = re.sub(r'\s*\n+\s*', '\n', code)
    # 总行数
    totle_line = code.count('\n')
    result.append(totle_line)

    lexer = pygments.lexers.guess_lexer_for_filename('Checkout.java',code)
    tokens = lexer.get_tokens(code)
    tokens = list(tokens)
    # 操作符总数量
    operater_count = 0
    # 相同操作符数量
    operater_same_count = 0
    # 变量总数量
    name_count = 0
    # 声明并使用过的变量个数
    name_used_count = 0
    # 函数个数
    fuction_count = 0
    for i in tokens:
        count = 0
        if i[0] == pygments.token.Operator:
            operater_count += 1
            count = re.findall(turn(i[1]),code).__len__()
            if count > 1:
                operater_same_count += 1
        count = 0
        if i[0] == pygments.token.Name:
            name_count += 1
            # 查找当前变量个数
            count = re.findall(i[1],code).__len__()
            # 声明并使用过的变量
            if count > 1:
                name_used_count += 1

        if i[0] == pygments.token.Name.Function:
            fuction_count += 1
    # 操作符总数量
    result.append(operater_count)
    # 相同操作符个数
    result.append(operater_same_count)
    # 不同操作符个数
    result.append(operater_count - operater_same_count)
    # 变量总数量
    result.append(name_count)
    # 声明并使用过的变量个数
    result.append(name_used_count)
    # 声明并未使用过的变量个数
    result.append(name_count - name_used_count)
    # 函数总个数
    result.append(fuction_count)

    # 循环控制数量
    loop_count = re.findall('for',code).__len__() + re.findall('while',code).__len__()
    result.append(loop_count)

    # 条件控制数量
    condition_count = re.findall('if',code).__len__()
    result.append(condition_count)


    return result

# 转义操作符
def turn(str):
    str = str.replace('{', '\{')
    str = str.replace('}', '\}')
    str = str.replace('(', '\(')
    str = str.replace(')', '\)')
    str = str.replace(';', '\;')
    str = str.replace('[', '\[')
    str = str.replace(']', '\]')
    str = str.replace('+', '\+')
    str = str.replace('*', '\*')
    return str

if __name__ == '__main__':
    code =  open('/home/lovemefan/PycharmProjects/Plagiarism Checker/data/172071大作业1/14207108-邹坤/test6/test6/src/test6/Checkout.java', "r", encoding='utf-8').read()
    print(properties(code))