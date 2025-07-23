# 1011. Fly me to the Alpha Centauri

# IMPORTATION
from sys import stdin
input = stdin.readline

# TEST CASE INPUT
tc = int(input())

# TEST
maximum = 0; rate = 2
time_arr = [0]

for _ in range(tc):
    # INPUT
    x, y = map(int, input().split())
    distance = y - x

    # SOLUTION
    while distance > maximum:
        maximum += rate//2; time_arr.append(maximum); rate += 1

    ans = 1
    while distance > time_arr[ans]:
        ans += 1
    
    # OUTPUT
    print(ans)