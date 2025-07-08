# 1874. 스택 수열

# IMPORTATION
from sys import stdin
input = stdin.readline
from collections import deque

# INPUT
length = int(input())
seq = deque()
for _ in range(length): seq.append(int(input()))

# SOLUTION
stack = [1]; prp = ['+']; tmp = 1; cnt = 0

while tmp <= length:
    if len(stack) != 0:
        if stack[len(stack)-1] != seq[0]:
            tmp += 1
            stack.append(tmp); prp.append('+')
        else:
            stack.pop(); seq.popleft(); prp.append('-')
            cnt += 1
    elif tmp < length:
        tmp += 1
        stack.append(tmp); prp.append('+')
    else:
        break

# OUTPUT
if cnt == length:
    for el in prp:
        print(el)
else:
    print('NO')