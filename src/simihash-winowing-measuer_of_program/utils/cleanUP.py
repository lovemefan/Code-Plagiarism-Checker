import pygments.token
import pygments.lexers

# 初步处理源代码，删除空格，注释标记内容
def tokenize(filename):
    file = open(filename, "r")
    text = file.read()
    file.close()
    lexer = pygments.lexers.guess_lexer_for_filename(filename, text)
    tokens = lexer.get_tokens(text)
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

def toText(arr):
    cleanText = ''.join(str(x[0]) for x in arr)
    return cleanText

