# 1002. 터렛

# TEST CASE INPUT
tc = int(input())

# TEST
for _ in range(tc):
    # INPUT
    x_1, y_1, r_1, x_2, y_2, r_2 = map(int, input().split()) # P(x1, y1), r1, Q(x2, y2), r2

    # FLOATING POINT
    EPS = 0.00001

    def isSame(num_1, num_2):
        tmp = num_1 - num_2
        if tmp < 0: tmp *= -1
        if tmp < EPS: return True
        else: return False

    def solvComp(rad_1, rad_2):
        inSame = isSame(rad_2, rad_1 - sq_dist)
        outSame = isSame(rad_2, rad_1 + sq_dist)

        if inSame or outSame: print(1)
        elif rad_2 < rad_1 - sq_dist or rad_2 > rad_1 + sq_dist: print(0)
        else: print(2)

    # SOLUTION
    dist = (x_1 - x_2)**2 + (y_1 - y_2)**2
    sq_dist = dist**0.5
    
    if dist == 0:
        if r_1 == r_2: print(-1)
        else: print(0)
    elif dist > r_1**2 and dist > r_2**2:
        if dist > (r_1 + r_2)**2: print(0)
        elif dist == (r_1 + r_2)**2: print(1)
        else: print(2)
    elif dist <= r_1:
        solvComp(r_1, r_2)
    else:
        solvComp(r_2, r_1)