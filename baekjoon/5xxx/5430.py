# 5430. AC

# IMPORTATION
from sys import stdin
input = stdin.readline
from collections import deque

# TEST CASE INPUT
tc = int(input())

# TEST
for _ in range(tc):
    # INPUT
    inst = (input().split('\n'))[0] # instruments : D or R
    length = int(input()) # length of array
    arr = deque(input().split(',')) # raw array
    if length != 0:
        arr[0] = arr[0][1:]; arr[length-1] = arr[length-1][:len(arr[length-1])-2]
    else:
        arr = []

    # SOLUTION
    reversed = -1
    for cur in inst:
        if cur == 'R':
            reversed *= -1
        elif len(arr) != 0:
            if reversed == -1:
                arr.popleft()
            else:
                arr.pop()
        else:
            reversed = 0
            break

    if reversed == 1:
        size = len(arr)
        for i in range(size//2):
            arr[i], arr[size-i-1] = arr[size-i-1], arr[i]

    # OUTPUT
    if reversed == 0:
        print('error')
    else:
        size = len(arr)
        if size != 0:
            print('[', end='')
            for i in range(size-1):
                print(arr[i] + ',', end='')
            print(arr[size-1] + ']')
        else:
            print('[]')