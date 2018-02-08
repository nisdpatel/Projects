#Name: Nisha Patel
#File: maxSubArray.py
#Decription: Implementation of Max Sub Array on a random numbers
#Date: 10/11/17

import sys
from random import randint
MAX_INF = -99999999

n =sys.argv[1]
A = []
for item in range(0,int(n)):
    A.append(randint(-500,1000))
    



def find_max_crossing_subArray(A, low, mid, high):
    left_sum = MAX_INF
    maxLeft = 0
    sum = 0
    for i in range(mid, low-1, -1):
        sum = sum + A[i]
        if sum > left_sum:
            left_sum = sum
            maxLeft = i
            
    right_sum = MAX_INF
    maxRight = 0
    sum = 0
    for j in range(mid+1, high+1):
        sum = sum + A[j]
        if sum > right_sum:
            right_sum = sum
            maxRight = j
    return (maxLeft, maxRight, left_sum+right_sum)


def find_max_subArray(A, low, high):
    if high == low:
        return (low, high, A[low])
    else:
        mid = int((low + high)/2)
        (left_Low, left_High, left_Sum) = find_max_subArray(A, low, mid)
        (right_Low, right_High, right_Sum) = find_max_subArray(A, mid+1, high)
        (cross_Low, cross_High, cross_Sum) = find_max_crossing_subArray(A, low, mid, high)
        if left_Sum >= right_Sum & left_Sum >= cross_Sum:
            return left_Low, left_High, left_Sum
        elif right_Sum >= left_Sum & right_Sum >= cross_Sum:
            return right_Low, right_High, right_Sum
        else:
            return cross_Low, cross_High, cross_Sum



print(A)
x, y, z = find_max_subArray(A, 0, len(A)-1)
tup =(x,y,z)
print("\n", (tup))

