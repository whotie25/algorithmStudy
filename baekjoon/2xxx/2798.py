# 2798. 블랙잭

# IMPORTATION
from sys import stdin
input = stdin.readline

# INPUT
cnt, trg = map(int, input().split())
card = list(map(int, input().split()))

# SOLUTION (COMBINATION)
tmp = 0
for i in range(cnt-2):
    for j in range(i+1, cnt-1):
        for k in range(j+1, cnt):
            if tmp < (card[i] + card[j] + card[k]) <= trg: tmp = card[i] + card[j] + card[k]

# OUPUT
print(tmp)